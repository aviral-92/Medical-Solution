package com.medical.solution.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Configuration
public class PropertiesHolder extends PropertyPlaceholderConfigurer {

	private static Map<String, String> propertiesMap;

	private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

	@Override
	public void setSystemPropertiesMode(int systemPropertiesMode) {
		super.setSystemPropertiesMode(systemPropertiesMode);
		springSystemPropertiesMode = systemPropertiesMode;
	}

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);

		propertiesMap = new HashMap<>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
			propertiesMap.put(keyStr, valueStr);
		}
	}

	public String getProperty(String name) {
		return propertiesMap.get(name).toString();
	}
}
