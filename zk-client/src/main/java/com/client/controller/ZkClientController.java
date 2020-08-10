package com.client.controller;

import com.client.config.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ZkClientController {

	@Autowired
	private BeanConfig beanConfig;

	@GetMapping("index")
	public String index(Map<String, Object> model) throws Exception {
		model.put("config", beanConfig.configs);
		return "index";
	}
}
