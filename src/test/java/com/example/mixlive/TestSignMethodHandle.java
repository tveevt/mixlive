package com.example.mixlive;

public class TestSignMethodHandle {
    private static String input = "     v[0] ^= 0x30319ddc;\n" +
            "                var strc = \"\";\n" +
            "                for (var i = 0; i < v.length; i++) {\n" +
            "                    strc += String.fromCharCode(v[i] & 0xff, v[i] >>> 8 & 0xff, v[i] >>> 16 & 0xff, v[i] >>> 24 & 0xff);\n" +
            "                }\n" +
            "                return eval(strc)(wf18g3e975b3568cf2640, wf18g3e975b3568cf2641, wf18g3e975b3568cf2642, k);\n" +
            "            }\n" +
            "            function ub98484234(s246b64d9190, s246b64d9191, s246b64d9192) {\n" +
            "                var rk = [11, 20, 25, 40, 17, 21, 20, 36, 10, 11, 20, 25, 40];\n" +
            "                var k2 = [0x22d6813c, 0x5d59e9eb];\n" +
            "                var lk = [0x22d6813c, 0x5d59e9eb];\n" +
            "        }\n" +
            "                return eval(strc)(v360b6c09f0, v360b6c09f1, v360b6c09f2);\n" +
            "            }\n" +
            "            var v360b6c09f = [0xef25ebf7, 0xa7205107];\n" +
            "            function k927cea2d4369(p167j96139ce40, p167j96139ce41, p167j96139ce42, p167j96139ce43) {\n" +
            "         ";

    private static String input2 = "(function (xx0,xx1,xx2){var cb=xx0+xx1+xx2+\"250120240913\";var rb=CryptoJS.MD5(cb).toString();var re=[];for(var i=0;i<rb.length/8;i++)re[i]=(parseInt(rb.substr(i*8,2),16)&0xff)|((parseInt(rb.substr(i*8+2,2),16)<<8)&0xff00)|((parseInt(rb.substr(i*8+4,2),16)<<24)>>>8)|(parseInt(rb.substr(i*8+6,2),16)<<24);var k2=[0x1af74af4,0x4c838c15,0x4c1f60,0x77b95dcb];for(var I=0;I<2;I++){var v0=re[I*2],v1=re[I*2+1],sum=0,i=0;var delta=0x9e3779b9;for(i=0;i<32;i++){sum+=delta;v0+=((v1<<4)+k2[0])^(v1+sum)^((v1>>>5)+k2[1]);v1+=((v0<<4)+k2[2])^(v0+sum)^((v0>>>5)+k2[3]);}re[I*2]=v0;re[I*2+1]=v1;}re[0]^=k2[0];re[0]=(re[0]<<(k2[2]%16))|(re[0]>>>(32-(k2[2]%16)));re[0]+=k2[2];re[1]+=k2[1];re[1]=(re[1]>>>(k2[3]%16))|(re[1]<<(32-(k2[3]%16)));re[1]=(re[1]>>>(k2[1]%16))|(re[1]<<(32-(k2[1]%16)));re[1]=(re[1]>>>(k2[3]%16))|(re[1]<<(32-(k2[3]%16)));re[2]=(re[2]>>>(k2[0]%16))|(re[2]<<(32-(k2[0]%16)));re[2]=(re[2]<<(k2[2]%16))|(re[2]>>>(32-(k2[2]%16)));re[2]=(re[2]<<(k2[0]%16))|(re[2]>>>(32-(k2[0]%16)));re[2]-=k2[2];re[3]^=k2[1];re[3]-=k2[3];re[3]=(re[3]>>>(k2[3]%16))|(re[3]<<(32-(k2[3]%16)));re[0]=(re[0]>>>(k2[0]%16))|(re[0]<<(32-(k2[0]%16)));re[0]=(re[0]>>>(k2[2]%16))|(re[0]<<(32-(k2[2]%16)));re[0]=(re[0]>>>(k2[0]%16))|(re[0]<<(32-(k2[0]%16)));re[0]-=k2[2];re[1]=(re[1]<<(k2[1]%16))|(re[1]>>>(32-(k2[1]%16)));re[1]-=k2[3];re[1]+=k2[3];re[2]+=k2[0];re[2]=(re[2]>>>(k2[2]%16))|(re[2]<<(32-(k2[2]%16)));re[2]=(re[2]>>>(k2[0]%16))|(re[2]<<(32-(k2[0]%16)));re[2]=(re[2]>>>(k2[2]%16))|(re[2]<<(32-(k2[2]%16)));re[3]+=k2[1];re[3]-=k2[3];re[3]+=k2[3];{var hc='0123456789abcdef'.split('');for(var i=0;i<re.length;i++){var j=0,s='';for(;j<4;j++)s+=hc[(re[i]>>(j*8+4))&15]+hc[(re[i]>>(j*8))&15];re[i]=s;}re=re.join('');}var rt=\"v=250120240913\"+\"&did=\"+xx1+\"&tt=\"+xx2+\"&sign=\"+re;return rt;})";

    public static void main(String[] args) {
        extractUb98484234();

        System.out.println(ExtractParamV(input2));

        String signMethodString = convertToSignMethodString(input2);
        System.out.println(signMethodString);
    }

    private static String ExtractParamV(String input) {
        int startIndex = input.indexOf("\"") + 1;
        int endIndex = input.indexOf("\"", startIndex );

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            return input.substring(startIndex, endIndex);
        }
        return "";
    }

    private static String convertToSignMethodString(String input) {
        String startChar = "(function";
        String endChar = ".toString();";
        String replacement = "function sign(rb){";
        input = replaceBetween(input, startChar, endChar, replacement);

        input = replaceBetween(input, "var rt", "return rt;", "return re;");
        //input = input.replace("return rt;});", "return rt;}");

        int errorEnd = input.lastIndexOf(")");
        if (errorEnd != -1) {
            input = input.substring(0, errorEnd);
        }

        return input;
    }

    private static void extractUb98484234() {
        // 查找函数的起始位置
        String functionName = "function ub98484234";
        int startIndex = input.indexOf(functionName);

        String end = "function k927cea2d4369";
        int endIndex = input.indexOf(end);

        // 如果找到起始和结束位置
        if (startIndex != -1 && endIndex != -1) {
            // 截取从函数开始到变量定义的部分
            String extractedFunction = input.substring(startIndex, endIndex);
            System.out.println("Extracted Function:\n" + extractedFunction);
            String funStr = replaceEvalWithStrc(extractedFunction);
            System.out.println(funStr);
        } else {
            System.out.println("Function or variable not found.");
        }
    }

    private static String replaceEvalWithStrc(String str) {
        String returnStatement = "return eval(strc)(";
        String endStatement = ");";

        return replaceBetween(str, returnStatement, endStatement, "return strc;");
    }

    public static String replaceBetween(String input, String startChar, String endChar, String replacement) {
        int startIndex = input.indexOf(startChar);
        int endIndex = input.indexOf(endChar, startIndex);

        if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
            endIndex += endChar.length();
            String fullReturnStatement = input.substring(startIndex, endIndex);
            return input.replace(fullReturnStatement, replacement);
        }

        return input;
    }
}
