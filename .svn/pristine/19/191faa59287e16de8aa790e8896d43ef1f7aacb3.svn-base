/*
 * 文 件 名:  ListenerTest.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年9月15日,  All rights reserved  
 */
package cn.leadeon.route.test;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;

import cn.leadeon.route.listener.RouterDataSourceInfoConcreteWatched;
import cn.leadeon.route.listener.RouterDataSourceInfoConcreteWatcher;
import cn.leadeon.route.listener.RouterDataSourceInfoWatched;
import cn.leadeon.route.listener.RouterDataSourceInfoWatcher;

/**
 * test watcher
 * 
 * @author liudongdong
 * @version [版本号, 2014年9月15日]
 * @since [产品/模块版本]
 */
public class ListenerTest {
	public static void main(String[] args) {
		//define watched
		RouterDataSourceInfoWatched routerDataSourceInfoWatched=new RouterDataSourceInfoConcreteWatched();
		
		//define watcher
		RouterDataSourceInfoWatcher routerInfoWatcher=new RouterDataSourceInfoConcreteWatcher();
		
		routerDataSourceInfoWatched.addRouterDSInfoWatcher(routerInfoWatcher);
		
		Map<String, DruidDataSource> druidDatasources=new HashMap<String, DruidDataSource>();
		druidDatasources.put("01", new DruidDataSource());
		
		routerDataSourceInfoWatched.notifyRouterDSInfoWather(druidDatasources);
		routerDataSourceInfoWatched.removeRouterDSInfoWatcher(routerInfoWatcher);
	}
}
