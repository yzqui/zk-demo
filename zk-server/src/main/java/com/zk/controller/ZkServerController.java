package com.zk.controller;

import com.utils.zk.ZkUtil;
import com.zk.pojo.ZkNode;
import com.zk.service.ZkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ZkServerController {

	@Autowired
	private ZkService zkService;

	@GetMapping("index")
	public String index(Map<String, Object> model) throws Exception {
		model.put("config", zkService.getAllConfigs());
		return "index";
	}

	/**
	 * 创建配置
	 *
	 * @param configName  配置名称
	 * @param configValue 配置值
	 */
	@GetMapping("/create")
	public String create(Map<String, Object> model, String configName, String configValue) throws Exception {
		zkService.insertConfig(configName, configValue);
		return "index";
	}

	/**
	 * 修改配置
	 *
	 * @param configName  配置名称
	 * @param configValue 配置值
	 */
	@GetMapping("/edit")
	public String edit(Map<String, Object> model, String configName, String configValue) throws Exception {
		zkService.updateConfig(configName, configValue);
		return "index";
	}

	/**
	 * 删除配置
	 *
	 * @param configName 配置名称
	 */
	@GetMapping("/delete")
	public String delete(Map<String, Object> model, String configName) throws Exception {
		zkService.deleteConfig(configName);
		return "index";
	}

}
