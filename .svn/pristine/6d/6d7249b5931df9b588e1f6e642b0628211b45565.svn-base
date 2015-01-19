/*
 * 文 件 名:  DruidJndiDataSourceLookup.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月25日,  All rights reserved  
 */
package cn.leadeon.route.datasource;

import javax.naming.NamingException;

import org.springframework.jndi.JndiLocatorSupport;

import cn.leadeon.route.exception.DataSourceLookupFailureException;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author  liudongdong
 * @version  [1.0, 2014年8月25日]
 * @since  [router datasource]
 */
public class DruidJndiDataSourceLookup extends JndiLocatorSupport implements DruidDataSourceLookup{

	public DruidJndiDataSourceLookup() {
		setResourceRef(true);
	}

	
	/**
	 * 重载方法
	 * @param dataSourceName
	 * @return
	 * @throws DataSourceLookupFailureException
	 */
	@Override
	public DruidDataSource getDataSource(String dataSourceName)
			throws DataSourceLookupFailureException {
		try {
			return lookup(dataSourceName, DruidDataSource.class);
		}
		catch (NamingException ex) {
			throw new DataSourceLookupFailureException(
					"Failed to look up JNDI DataSource with name '" + dataSourceName + "'", ex);
		}
	}

}
