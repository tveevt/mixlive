package com.example.mixlive;

import cn.hutool.crypto.SecureUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestSignMethodCall {

    public static void main(String[] args) {
        // 创建脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        // 获取Nashorn引擎
        ScriptEngine engine = manager.getEngineByName("nashorn");

        callUb9848234(engine);
        //callSign(engine);
    }

    private static void callSign(ScriptEngine engine) {
        try {
            engine.eval(new java.io.FileReader("src/test/java/com/example/mixlive/sign.js"));
            // 准备参数
            String md5Str = SecureUtil.md5("123220120240912");;
            System.out.println("md5Str = " + md5Str);
            // 调用JavaScript函数并传递参数
            String result = (String) engine.eval("sign('" + md5Str + "')");
            System.out.println(result);
        } catch (ScriptException | java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void callUb9848234(ScriptEngine engine) {
        try {
            engine.eval(new java.io.FileReader("src/test/java/com/example/mixlive/ub98484234.js"));
            // 准备参数
            Object v360b6c09f0 = "1";
            Object v360b6c09f1 = "2";
            Object v360b6c09f2 = "3";

            // 调用JavaScript函数并传递参数
            String result = (String) engine.eval("ub98484234(" +  v360b6c09f0 + ", " + v360b6c09f1 + ", " + v360b6c09f2 + ")");
            System.out.println(result);
        } catch (ScriptException | java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
