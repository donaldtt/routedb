/*
 * 文 件 名:  RouterDataSourceInfoConcreteWatcher.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年9月12日,  All rights reserved  
 */
package cn.leadeon.route.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.leadeon.route.datasource.MultiDataSourceRouter;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 更新数据源与路由规则信息到内存中
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年9月12日]
 * @since  [data router]
 */
public class RouterDataSourceInfoConcreteWatcher implements
		RouterDataSourceInfoWatcher {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(RouterDataSourceInfoConcreteWatcher.class);
	
	private MultiDataSourceRouter routeDataSource;
	
	/**
	 * 设置 routeDataSource
	 * @param 对routeDataSource进行赋值
	 */
	public void setRouteDataSource(MultiDataSourceRouter routeDataSource) {
		this.routeDataSource = routeDataSource;
	}
	/**
	 * 重载方法
	 * @param druidDatasources
	 */
	@Override
	public void updateRouterDataSourceInfo(
			Map<String, DruidDataSource> druidDatasources) {
		LOGGER.info("更新数据源与路由规则信息到内存中..");
		routeDataSource.setTargetDataSources(druidDatasources);
		// 备注目前更新内存数据与routerdatasource not ok 
		
	}

}
