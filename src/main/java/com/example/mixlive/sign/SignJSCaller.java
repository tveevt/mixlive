package com.example.mixlive.sign;

import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Slf4j
public class SignJSCaller {
    private ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    private final String script;

    public SignJSCaller(String script) {
        this.script = script;
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            log.error("初始化 ScriptEngine 失败 {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String call(String md5Str) {
        try {
            return (String) engine.eval("sign('" + md5Str + "')");
        } catch (ScriptException e) {
            log.error("调用 douyuJSSign 函数失败 {}", e.getMessage());
        }
        return "";
    }
}