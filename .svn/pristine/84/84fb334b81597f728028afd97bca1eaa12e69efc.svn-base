/*
 * 文 件 名:  RouterDataSourceInfoWatched.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年9月11日,  All rights reserved  
 */
package cn.leadeon.route.listener;

import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 定义路由数据源信息被观察者角色（抽象主题角色）
 * 
 * @author liudongdong
 * @version [1.0, 2014年9月11日]
 * @since [data router]
 */
public interface RouterDataSourceInfoWatched {
	/**
	 * 
	 * 增加路由数据源信息观察者
	 * 
	 * @param routerInfoWatcher
	 */
	public void addRouterDSInfoWatcher(
			RouterDataSourceInfoWatcher routerInfoWatcher);
	
	/**
	 * 
	 * 删除路由数据源信息观察者
	 * @param routerInfoWatcher
	 */
	public void removeRouterDSInfoWatcher(
			RouterDataSourceInfoWatcher routerInfoWatcher);

	/**
	 * 通知路由数据源信息观察者
	 * 
	 * @param druidDatasources
	 */
	public void notifyRouterDSInfoWather(
			Map<String, DruidDataSource> druidDatasources);
}
