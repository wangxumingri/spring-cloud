package com.wxss.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigFile;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // 设置Environment
        System.setProperty("env", "DEV");

        // 设置集群
        System.setProperty("apollo.cluster", "LOCAL");



        // 获取配置
        Config appConfig = ConfigService.getAppConfig();
        String timeout = appConfig.getProperty("timeout", "100");
        System.out.println(timeout);
        String status = appConfig.getProperty("server.port", "off");
        System.out.println(status);

        // 获取公共NameSpace
        String somePublicNamespace = "TEST1.publicNameSpace2";

        Config publicConfig = ConfigService.getConfig(somePublicNamespace);
        String property = publicConfig.getProperty("content", "JoJo");

        System.out.println(property);

        // 获取非 yaml/yml 和 properties 格式的 NameSpace
        String JSONNamespace = "JsonNameSpace";
        ConfigFile configFile = ConfigService.getConfigFile(JSONNamespace, ConfigFileFormat.JSON);
        String content = configFile.getContent();

        System.out.println(content);




        // 监听属性变化
        appConfig.addChangeListener(configChangeEvent -> {
            System.out.println("发生变化的 【namespace】 为" + configChangeEvent.getNamespace());
            for (String changedKey : configChangeEvent.changedKeys()) {
                ConfigChange change = configChangeEvent.getChange(changedKey);
                System.out.println("配置 key: " + change.getPropertyName() +"\t变更类型: " + change.getChangeType()+ "\t原值: " + change.getOldValue() +"\t新值 :" + change.getNewValue());
            }
        });

        System.in.read();
    }
}
