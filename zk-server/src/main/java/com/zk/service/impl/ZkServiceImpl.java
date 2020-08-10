package com.zk.service.impl;

import com.utils.zk.ZkUtil;
import com.zk.config.BeanConfig;
import com.zk.dao.ZkDao;
import com.zk.pojo.ZkNode;
import com.zk.service.ZkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ZkServiceImpl implements ZkService {

	private ZkUtil zkUtil;

	private ZkDao zkDao = new ZkDao();

	@Autowired
	private BeanConfig beanConfig;

	/**
	 * 初始化
	 */
	@Bean
	@Override
	public ZkUtil getZkUtil() throws Exception {
		zkUtil = new ZkUtil("127.0.0.1:2181", "/a");
		return zkUtil;
	}

	@Override
	public Map<String, String> getAllConfigs() throws Exception {
		return beanConfig.configs;
	}

	/**
	 * 新建配置
	 *
	 * @param configName 配置名称
	 * @param value      配置值
	 */
	@Override
	public void insertConfig(String configName, String value) throws Exception {
		int row = zkDao.insertZK(getZkNode(configName, value));
		if (row > 0) {
			zkUtil.insertConfig(configName, value);
		}
	}

	/**
	 * 更新配置
	 *
	 * @param configName 配置名称
	 * @param value      配置值
	 */
	@Override
	public void updateConfig(String configName, String value) throws Exception {
		int row = zkDao.updateZK(getZkNode(configName, value));
		if (row > 0) {
			zkUtil.updateConfig(configName, value);
		}
	}

	/**
	 * 删除配置
	 *
	 * @param configName 配置名称
	 */
	@Override
	public void deleteConfig(String configName) throws Exception {
		int row = zkDao.deleteZK(configName);
		if (row > 0) {
			zkUtil.deleteConfig(configName);
		}
	}

	private ZkNode getZkNode(String configName, String value) {
		ZkNode zkNode = new ZkNode();
		zkNode.setConfigName(configName);
		zkNode.setConfigValue(value);
		return zkNode;
	}
}
