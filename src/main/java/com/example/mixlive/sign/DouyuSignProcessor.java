package com.example.mixlive.sign;

import cn.hutool.crypto.SecureUtil;
import com.example.mixlive.client.douyu.DouyuClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Arrays;

@Slf4j
public class DouyuSignProcessor {

    public String[] getVAndSign(String roomWebSource, Integer roomId, String did, long tt) {
        log.info("calculate v and sign for roomId {} did {} tt {}", roomId, did, tt);
        String ub9JSContent = extractUb98484234JSContent(roomWebSource);

        Ub9848234JSCaller ub9848234JSCaller = new Ub9848234JSCaller(ub9JSContent);
        String strc = ub9848234JSCaller.call(roomId, did, tt);

        String v = ExtractParamV(strc);
        String signJSContent = convertToDouyuJSSign(strc);

        SignJSCaller signJSCaller1 = new SignJSCaller(signJSContent);
        String md5 = generateMd5(roomId, did, tt, v);
        String sign = signJSCaller1.call(md5);
        log.info("calculate completed v {} sign {}", v, sign);
        return new String[]{v, sign};
    }

    private String generateMd5(Integer roomId, String did, long tt, String v) {
        return SecureUtil.md5(roomId + did + tt + v);
    }

    private String ExtractParamV(String strc) {
        int startIndex = strc.indexOf("\"") + 1;
        int endIndex = strc.indexOf("\"", startIndex);

        if (endIndex != -1 && endIndex > startIndex) {
            return strc.substring(startIndex, endIndex);
        }
        return "";
    }

    private String convertToDouyuJSSign(String strc) {
        String startChar = "(function";
        String endChar = ".toString();";
        String replacement = "function sign(rb){";
        strc = replaceBetween(strc, startChar, endChar, replacement);

        strc = replaceBetween(strc, "var rt", "return rt;", "return re;");
        //strc = strc.replace("return rt;});", "return rt;}");

        int lastIndex = strc.lastIndexOf(")");
        if (lastIndex != -1) {
            strc = strc.substring(0, lastIndex);
        }

        return strc;
    }

    private String extractUb98484234JSContent(String input) {
        // 查找函数的起始位置
        String functionName = "function ub98484234";
        int startIndex = input.indexOf(functionName);

        String end = "function k927cea2d4369";
        int endIndex = input.indexOf(end);

        // 如果找到起始和结束位置
        if (startIndex != -1 && endIndex != -1) {
            // 截取从函数开始到变量定义的部分
            String extractedFunction = input.substring(startIndex, endIndex);
            return replaceEvalWithStrc(extractedFunction);
        } else {
            System.out.println("Function or variable not found.");
        }
        return "";
    }

    private String replaceEvalWithStrc(String str) {
        String startStr = "return eval(strc)(";
        String endStr = ");";
        String replacement = "return strc;";
        return replaceBetween(str, startStr, endStr, replacement);
    }

    public String replaceBetween(String input, String startStr, String endStr, String replacement) {
        int startIndex = input.indexOf(startStr);
        int endIndex = input.indexOf(endStr, startIndex);

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            endIndex += endStr.length();
            String fullReturnStatement = input.substring(startIndex, endIndex);
            return input.replace(fullReturnStatement, replacement);
        }

        return input;
    }

    public static void main(String[] args) {
        DouyuClient douyuClient = new DouyuClient(new RestTemplate(), null);
        String roomWebSource = douyuClient.getRoomWebSourceById(8094748);

        String did = "10000000000000000000000000001501";
        long tt = Instant.now().getEpochSecond();

        DouyuSignProcessor douyuSignProcessor = new DouyuSignProcessor();
        String[] vAndSign = douyuSignProcessor.getVAndSign(roomWebSource, 8094748, did, tt);
        System.out.println(Arrays.toString(vAndSign));

    }

}
