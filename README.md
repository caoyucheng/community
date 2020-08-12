# 基于SpringBoot的开源社区

> 本项目参考 [码问社区](https://github.com/codedrinker/community) 实现，
>相关视频教程可在B站观看：[【Spring Boot 实战】论坛项目-第一季](https://www.bilibili.com/video/BV1r4411r7au)

# 功能列表
- 使用GitHub OAuth接口进行用户登录
- 支持富文本编辑
- 支持图片上传
- 支持问题评论
- 支持评论通知
- 支持问题搜索

# 技术栈
|  技术   | 用途 | 链接   |
| --- | --- |--- |
|  Spring Boot   | 项目框架| http://projects.spring.io/spring-boot/#quick-start |
|  MySQL  | 数据库 | https://dev.mysql.com/downloads/ |
|  MyBatis  | ORM框架 | https://mybatis.org/mybatis-3/zh/index.html |
|  MyBatis Generator | MyBatis代码生成工具 | http://mybatis.org/generator/ |
|  Flyway  | 数据库版本管理 | https://flywaydb.org/getstarted/firststeps/maven |
|  Lombok| 注解插件 | https://www.projectlombok.org |
|  Bootstrap|  前端框架 | https://v3.bootcss.com/getting-started/ |
|  Github OAuth| 第三方登录 | https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/ |
|  Tencent COS| 图片存储 | https://cloud.tencent.com/product/cos |

## 下载与运行
### 1. 前置环境要求  
- JDK 1.8+
- Maven 3.6.0+

### 2. 克隆代码到本地
```bash
git clone https://github.com/caoyucheng/community.git
````

### 3. 运行打包命令
```bash
mvn package
```

### 4. 数据库配置
- 本地环境配置好MySQL，将`application.properties`中数据库相关参数根据本地环境进行修改
- 运行 migrate 和 generator 的命令:
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```

### 4. 重新运行打包命令
```bash
mvn package
```

### 5. 运行项目  
```bash
java -jar target/community-0.0.1-SNAPSHOT.jar
```

### 6. 访问项目
```
http://localhost:8887
```
