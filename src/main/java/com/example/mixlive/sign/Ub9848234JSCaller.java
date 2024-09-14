package com.example.mixlive.sign;

import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Slf4j
public class Ub9848234JSCaller {
    private ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    private final String script;

    public Ub9848234JSCaller(String script) {
        this.script = script;
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            log.error("初始化 ScriptEngine 失败 {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String call(Integer roomId, String did, long tt) {
        try {
            // 调用JavaScript函数并传递参数
            String result = (String) engine.eval("ub98484234(" + roomId + ", " + did + ", " + tt + ")");
            return result;
        } catch (ScriptException e) {
            log.error("调用 ub98484234 函数失败 {}", e.getMessage());
        }
        return "";
    }
}