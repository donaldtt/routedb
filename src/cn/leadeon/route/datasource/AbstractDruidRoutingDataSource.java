/*
 * 文 件 名:  AbstractDruidRoutingDataSource.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月25日,  All rights reserved  
 */
package cn.leadeon.route.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.alibaba.druid.pool.DruidDataSource;



/**
 * DruidDataSourceRouting
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年8月25日]
 * @since  [data routing]
 */
public abstract class AbstractDruidRoutingDataSource extends DruidAbstractDataSource implements InitializingBean {

		private final Logger LOGGER=LoggerFactory.getLogger(AbstractDruidRoutingDataSource.class);
		
		private Map<String, DruidDataSource> targetDataSources;

		private DruidDataSourceLookup dataSourceLookup = new DruidJndiDataSourceLookup();
		

		private Map<Object, DruidDataSource> resolvedDataSources;


		public void setTargetDataSources(Map<String, DruidDataSource> targetDataSources) {
			this.targetDataSources = targetDataSources;
		}

		public void setDataSourceLookup(DruidDataSourceLookup dataSourceLookup) {
			this.dataSourceLookup = (dataSourceLookup != null ? dataSourceLookup : new DruidJndiDataSourceLookup());
		}


		public void afterPropertiesSet() {
			if (this.targetDataSources == null) {
				throw new IllegalArgumentException("Property 'targetDataSources' is required");
			}
			this.resolvedDataSources = new HashMap<Object, DruidDataSource>(this.targetDataSources.size());
			for (Map.Entry entry : this.targetDataSources.entrySet()) {
				Object lookupKey = resolveSpecifiedLookupKey(entry.getKey());
				DruidDataSource dataSource = resolveSpecifiedDataSource(entry.getValue());
				this.resolvedDataSources.put(lookupKey, dataSource);
			}
		
		}

		
		protected DruidDataSource resolveSpecifiedDataSource(Object dataSource) throws IllegalArgumentException {
			if (dataSource instanceof DruidDataSource) {
				return (DruidDataSource) dataSource;
			}
			else if (dataSource instanceof String) {
				return (DruidDataSource)this.dataSourceLookup.getDataSource((String) dataSource);
			}
			else {
				throw new IllegalArgumentException(
						"Illegal data source value - only [javax.sql.DataSource] and String supported: " + dataSource);
			}
		}


		public Connection getConnection() throws SQLException {
			return determineTargetDataSource().getConnection();
		}

		public Connection getConnection(String username, String password) throws SQLException {
			return determineTargetDataSource().getConnection(username, password);
		}

	
		protected DruidDataSource determineTargetDataSource() throws SQLException {
			Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
			Object lookupKey = determineCurrentLookupKey();
			LOGGER.debug("AbstractDruidRoutingDataSource=>determineTargetDataSource(),lookupKey"+lookupKey);
			DruidDataSource dataSource = this.resolvedDataSources.get(lookupKey);
			if (dataSource == null) {
				throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
			}
			LOGGER.debug("AbstractDruidRoutingDataSource=>determineTargetDataSource(),dataSource:"+dataSource);
			return dataSource;
		}


		
		protected Object resolveSpecifiedLookupKey(Object lookupKey) {
			LOGGER.debug("AbstractDruidRoutingDataSource=>resolveSpecifiedLookupKey(),lookupKey:"+lookupKey);
			return lookupKey;
		}
		
/*		public void init() throws SQLException{
			DruidDataSource dataSource = determineTargetDataSource();
			if(dataSource!=null){
				dataSource.init();
			}
			
		}
		
		public void close() throws SQLException{
			DruidDataSource dataSource = determineTargetDataSource();
			if(dataSource!=null){
				dataSource.close();
			}
		}*/
		protected abstract Object determineCurrentLookupKey();

}
