

# 普通 Java 项目

1. 引入 apollo 客户端依赖
```
        <dependency>
            <groupId>com.ctrip.framework.apollo</groupId>
            <artifactId>apollo-client</artifactId>
            <version>1.8.0</version>
        </dependency>
```

2. 配置 


这些信息包括 Meta Server、AppId 和 Environment。Cluster 可以不用指定，用默认即可。

在 META-INF 目录下创建 app.properties 文件，并配置 Meta Server 和 AppId

```
apollo.meta=http://localhost:8080
app.id=SampleApp
```
3. 编码获取属性

```java
public class Test {
    public static void main(String[] args) {
        System.setProperty("env", "DEV");

        Config appConfig = ConfigService.getAppConfig();
        String timeout = appConfig.getProperty("timeout", "100");
        System.out.println(timeout);
        String status = appConfig.getProperty("status", "off");
        System.out.println(status);
    }
}
```

4. 编码监听属性变化



