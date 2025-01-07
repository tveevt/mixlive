# 简介
mixLive 是一个聚合B站和斗鱼直播内容的后台服务,提供分区信息获取、直播间搜索以及直播流获取功能

## 代码结构
- **src/**: 主源代码
    - **com.example.mixlive**: 根包
        - **client**: Bilibili 和 Douyu 的API客户端
        - **config**: 全局配置和异常处理
        - **jpa**: JPA 实体和存储层
        - **model**: 数据模型
        - **platform**:  Bilibili 和 Douyu 的controller层和service层

## 技术栈
- 基础框架: Spring Boot
- 数据访问: Spring Data JPA
- 数据库: MySQL
- 缓存: Caffeine
- 工具库:
    - Apache HttpClient: HTTP请求
    - Hutool: 通用工具集
    - StreamEx: 流处理增强
    - Lombok: 代码简化

## 环境要求
- JDK 1.8+
- MySQL 5.7+

## API文档
- 分区信息获取
- 直播间搜索
- 直播流获取

## 改进方向
- API完善
- 更多平台支持

## 参考项目
[JustLive-Api](https://github.com/guyijie1211/JustLive-Api)

