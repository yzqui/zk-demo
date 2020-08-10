package com.zk.config;

import com.utils.zk.ZkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanConfig {

	@Autowired
	private ZkUtil zkUtil;

	public Map<String, String> configs;

	@Bean(name = "getAllConfigs")
	public Map<String, String> getAllConfigs() throws Exception {
		configs = zkUtil.getAllConfigs();
		zkUtil.autoUpdateConfigs(configs);
		return configs;
	}
}
