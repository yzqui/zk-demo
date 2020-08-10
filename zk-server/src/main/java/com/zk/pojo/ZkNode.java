package com.zk.pojo;

public class ZkNode {

	private String configName;

	private String configValue;

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	@Override
	public String toString() {
		return "ZkNode{" +
				"configName='" + configName + '\'' +
				", configValue='" + configValue + '\'' +
				'}';
	}
}
