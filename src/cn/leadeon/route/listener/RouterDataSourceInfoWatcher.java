/*
 * 文 件 名:  RouterDataSourceInfoWatcher.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年9月11日,  All rights reserved  
 */
package cn.leadeon.route.listener;

import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;


/**
 * 定义路由数据源信息抽象观察者角色（监听器）
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年9月11日]
 * @since  [data router]
 */
public interface RouterDataSourceInfoWatcher {
	/**
	 * 
	 * 更新路由数据源信息
	 * @param druidDatasources
	 */
	public void updateRouterDataSourceInfo(Map<String, DruidDataSource> druidDatasources);
}
