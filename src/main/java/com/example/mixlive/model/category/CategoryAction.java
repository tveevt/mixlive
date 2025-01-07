package com.example.mixlive.model.category;

public enum CategoryAction {
    NONE,           // 不执行任何操作
    CREATE_DROP,     // 重新获取并保存最新数据
    SKIP_EXISTS // 已存在则跳过

}
