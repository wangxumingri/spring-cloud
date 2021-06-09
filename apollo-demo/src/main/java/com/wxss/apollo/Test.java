package com.wxss.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        System.setProperty("env", "DEV");

        Config appConfig = ConfigService.getAppConfig();
        String timeout = appConfig.getProperty("timeout", "100");
        System.out.println(timeout);
        String status = appConfig.getProperty("status", "off");
        System.out.println(status);

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
