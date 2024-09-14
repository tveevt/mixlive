package com.example.mixlive.client.douyu;

import cn.hutool.json.JSONUtil;
import com.example.mixlive.client.douyu.catetab.CateTab;
import com.example.mixlive.client.douyu.mixlistv1.MixListV1Response;
import com.example.mixlive.client.douyu.newdirectory.NewDirectoryResponse;
import com.example.mixlive.client.douyu.search.SearchShowResponse;
import com.example.mixlive.client.douyu.streamurl.StreamUrlResponse;
import com.example.mixlive.sign.DouyuSignProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

@RequiredArgsConstructor
@Slf4j
public class DouyuClient {

    private final RestTemplate restTemplate;

    private final DouyuSignProcessor douyuSignProcessor;

    private static final String DEFAULT_DID = "10000000000000000000000000001501";

    public NewDirectoryResponse getNewDirectory() {
        //https://www.douyu.com/japi/weblist/apinc/newDirectory
        String url = "https://www.douyu.com/japi/weblist/apinc/newDirectory";
        return restTemplate.getForObject(url, NewDirectoryResponse.class);
    }

    public List<CateTab> getCateTabs(String url) {
        //https://www.douyu.com/g_LOL
        List<CateTab> cateTabs = new ArrayList<>();
        try {
            ResponseEntity<byte[]> response = restTemplate.getForEntity("https://www.douyu.com" + url, byte[].class);
            HttpHeaders headers = response.getHeaders();

            if (response.getStatusCode().is2xxSuccessful()) {
                if ("gzip".equalsIgnoreCase(headers.getFirst(HttpHeaders.CONTENT_ENCODING))) {
                    // Decompress GZIP data
                    try (InputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(response.getBody()));
                         Reader reader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8)) {
                        String html = new BufferedReader(reader).lines()
                                                                .collect(Collectors.joining(System.lineSeparator()));
                        cateTabs = extractCateTabs(html);
                    }
                } else {
                    // Handle non-GZIP response
                    String html = new String(response.getBody(), StandardCharsets.UTF_8);
                    cateTabs = extractCateTabs(html);
                }
            }

        } catch (Exception e) {
            log.error("获取 cateTabs 失败 {} url: {}", e.getMessage(), url);
        }
        log.info("获取 cateTabs 成功 cateTabs size: {} url: {}", cateTabs.size(), url);

        return cateTabs;
    }

    private List<CateTab> extractCateTabs(String html) {
        // 找到 "cateTabList" 的索引
        String cateTabList = "\"cateTabList\":[";
        int startIndex = html.indexOf(cateTabList);
        // 找到第一个 "]" 的索引
        int endIndex = html.indexOf("]", startIndex);

        // 截取内容
        if (startIndex != -1 && endIndex != -1) {
            String cateTabListContent = html.substring(startIndex + cateTabList.length() - 1, endIndex + 1);
            return JSONUtil.toList(cateTabListContent, CateTab.class);
        }
        return new ArrayList<>();
    }

    public MixListV1Response getMixListV1(String categoryLevelAndId, Integer page) {
        // https://www.douyu.com/gapi/rknc/directory/mixListV1/2_1/1?
        String baseUrl = "https://www.douyu.com/gapi/rknc/directory/mixListV1";
        String url = baseUrl + "/" + categoryLevelAndId + "/" + page;

        return restTemplate.getForObject(url, MixListV1Response.class);
    }

    public SearchShowResponse search(String keyWords, Integer page) {
        //https://www.douyu.com/japi/search/api/searchShow?kw=lol&page=1&pageSize=20
        String baseUrl = "https://www.douyu.com/japi/search/api/searchShow";
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                                         .queryParam("kw", keyWords)
                                         .queryParam("page", page)
                                         .queryParam("pageSize", 20)
                                         .toUriString();

        return restTemplate.getForObject(url, SearchShowResponse.class);
    }

    public String getRoomWebSourceById(Integer roomId) {
        //https://m.douyu.com/8094748
        String url = "https://m.douyu.com/" + roomId;
        return restTemplate.getForObject(url, String.class);
    }

    public StreamUrlResponse getStreamUrl(Integer roomId) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String roomWebSource = getRoomWebSourceById(roomId);
        long tt = Instant.now().getEpochSecond();

        String[] vAndSign = douyuSignProcessor.getVAndSign(roomWebSource, roomId, DEFAULT_DID, tt);

        // 创建表单数据
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("v", vAndSign[0]);
        formData.add("did", DEFAULT_DID);
        formData.add("tt", String.valueOf(tt));
        formData.add("sign", vAndSign[1]);
        formData.add("ver", "22011191");
        formData.add("rid", String.valueOf(roomId));
        formData.add("rate", "-1");//画质 2=高清 3=超清 0=蓝光(APP专享)

        // 创建请求实体
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        // 发送 POST 请求
        String url = "https://m.douyu.com/hgapi/livenc/room/getStreamUrl";
        ResponseEntity<StreamUrlResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, StreamUrlResponse.class);

        return response.getBody();
    }

    public static void main(String[] args) {
        DouyuClient douyuClient = new DouyuClient(new RestTemplate(), new DouyuSignProcessor());
/*        List<CateTab> cateTabs = douyuClient.getCateTabs("/g_LOL");
        System.out.println(cateTabs);*/
        StreamUrlResponse streamUrl = douyuClient.getStreamUrl(4238637);
        System.out.println(streamUrl);

    }
}
