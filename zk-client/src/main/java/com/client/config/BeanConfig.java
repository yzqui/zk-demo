package com.client.config;

import com.utils.zk.ZkUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanConfig {

    public ZkUtil zkUtil;

    @Bean
    public void getZkClient() {
        zkUtil = new ZkUtil("127.0.0.1:2181", "/a");
    }

    public Map<String, String> configs;

    @Bean(name = "getAllConfigs")
    public Map<String, String> getAllConfigs() throws Exception {
        configs = zkUtil.getAllConfigs();
        zkUtil.autoUpdateConfigs(configs);
        return configs;
    }

}
