package com.zk.service;

import com.utils.zk.ZkUtil;

import java.util.Map;

public interface ZkService {

	ZkUtil getZkUtil() throws Exception;

	Map<String, String> getAllConfigs() throws Exception;

	void insertConfig(String configName, String value) throws Exception;

	void updateConfig(String configName, String value) throws Exception;

	void deleteConfig(String configName) throws Exception;

}
