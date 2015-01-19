/*
 * 文 件 名:  PropertiesReader.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年4月3日,  All rights reserved  
 */
package cn.leadeon.route.utils;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * 
 * @author liudongdong
 * @version [1.0, 2014年4月16日]
 * @since [中国移动手机营业厅BSS系统]
 */
public class PropertiesReader {
	protected static Logger logger=LoggerFactory.getLogger(PropertiesReader.class);
	
	
	static Properties p = new Properties();
	static {
		try {
			p.load(PropertiesReader.class.getClassLoader().getResourceAsStream(
					"route_jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
		}
	}

	/**
	 * 根据 key 获取 value
	 * 
	 * @param key
	 *            需要获取的 key 值
	 * @return
	 */
	public static String getString(String key) {

		return p.getProperty(key);
	}
	
}
