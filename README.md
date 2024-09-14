# 简介
mixLive 是一个聚合B站和斗鱼直播内容的后台，提供获取分区信息、搜索直播间和获取直播流功能。

## 代码结构
- **src/**: 主源代码
    - **com.example.mixlive**: 根包
        - **client**: Bilibili 和 Douyu 客户端
        - **config**: 配置和异常处理
        - **controller**: 处理直播请求的控制器
        - **jpa**: JPA 实体和存储层
        - **model**: 分区、直播间信息和用户的模型类
        - **service**: 分区信息和直播服务
        - **sign**: 签名处理类

## 构建与依赖
- 使用 Maven 构建
- 采用 Spring Boot
- 依赖项：Spring Boot Starter Web、Spring Boot Starter Data JPA、MySQL Connector、Apache HttpClient、Lombok、Hutool、Caffeine、StreamEx
- Java 版本：1.8
- 数据库模式文件（`import.sql`、`schema.sql`）在 `resources` 目录中。

## 改进方向
所有功能的实现仍需优化和完善，目前方案较为基础。


## 参考项目
[JustLive-Api](https://github.com/guyijie1211/JustLive-Api)