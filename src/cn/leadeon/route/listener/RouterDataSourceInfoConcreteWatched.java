/*
 * 文 件 名:  RouterDataSourceInfoConcreteWatched.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年9月12日,  All rights reserved  
 */
package cn.leadeon.route.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年9月12日]
 * @since  [data router]
 */
public class RouterDataSourceInfoConcreteWatched implements RouterDataSourceInfoWatched{

	private List<RouterDataSourceInfoWatcher> dsWatcherlist=new ArrayList<RouterDataSourceInfoWatcher>();
	/**
	 * 重载方法
	 * @param routerInfoWatcher
	 */
	@Override
	public void addRouterDSInfoWatcher(
			RouterDataSourceInfoWatcher routerInfoWatcher) {
		// TODO Auto-generated method stub
		dsWatcherlist.add(routerInfoWatcher);
		
	}

	/**
	 * 重载方法
	 * @param druidDatasources
	 */
	@Override
	public void notifyRouterDSInfoWather(
			Map<String, DruidDataSource> druidDatasources) {
		for(RouterDataSourceInfoWatcher dataSourceInfoWatcher:dsWatcherlist){
			dataSourceInfoWatcher.updateRouterDataSourceInfo(druidDatasources);
		}
		
	}

	/**
	 * 重载方法
	 * @param routerInfoWatcher
	 */
	@Override
	public void removeRouterDSInfoWatcher(
			RouterDataSourceInfoWatcher routerInfoWatcher) {
		dsWatcherlist.remove(routerInfoWatcher);
		
	}

}
