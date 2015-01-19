/*
 * 文 件 名:  MapDruidDataSourceLookup.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月18日,  All rights reserved  
 */

package cn.leadeon.route.datasource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import cn.leadeon.route.exception.DataSourceLookupFailureException;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * druidDataSourceLookup
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年8月22日]
 * @since  [router datasource]
 */

public class MapDruidDataSourceLookup implements DruidDataSourceLookup {

	private final Map<String, DruidDataSource> dataSources = new HashMap<String, DruidDataSource>(4);


	
	public MapDruidDataSourceLookup() {
	}

	
	public MapDruidDataSourceLookup(Map<String, DruidDataSource> dataSources) {
		setDataSources(dataSources);
	}

	
	public MapDruidDataSourceLookup(String dataSourceName, DruidDataSource dataSource) {
		addDataSource(dataSourceName, dataSource);
	}



	public void setDataSources(Map<String, DruidDataSource> dataSources) {
		if (dataSources != null) {
			this.dataSources.putAll(dataSources);
		}
	}

	
	public Map<String, DruidDataSource> getDataSources() {
		return Collections.unmodifiableMap(this.dataSources);
	}

	
	public void addDataSource(String dataSourceName, DruidDataSource dataSource) {
		Assert.notNull(dataSourceName, "DataSource name must not be null");
		Assert.notNull(dataSource, "DataSource must not be null");
		this.dataSources.put(dataSourceName, dataSource);
	}

	public DruidDataSource getDataSource(String dataSourceName) throws DataSourceLookupFailureException {
		Assert.notNull(dataSourceName, "DataSource name must not be null");
		DruidDataSource dataSource = this.dataSources.get(dataSourceName);
		if (dataSource == null) {
			throw new DataSourceLookupFailureException(
					"No DataSource with name '" + dataSourceName + "' registered");
		}
		return dataSource;
	}

}
