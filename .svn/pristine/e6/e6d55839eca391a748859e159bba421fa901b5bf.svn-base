/*
 * 文 件 名:  DbContextHolder.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年4月3日,  All rights reserved  
 */
package cn.leadeon.route.datasource;

import org.springframework.util.Assert;


/**
 * locate the datasource by rule field
 * @author  liudongdong
 * @version  [1.0, 2014年4月3日]
 * @since [routing datasource]
 */
public class DbContextHolder {
	private static final ThreadLocal<String> contextHolder=new ThreadLocal<String>();
	public static void  setDbType(String ruleField){
		Assert.notNull(ruleField, "ruleField cannot be null");
		contextHolder.set(ruleField);
	}
	public static String getDbType(){
		return contextHolder.get();
	}
	
	public static void clearDbType(){
		contextHolder.remove();
	}
}

