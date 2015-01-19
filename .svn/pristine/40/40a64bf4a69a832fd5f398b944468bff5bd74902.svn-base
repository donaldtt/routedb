/*
 * 文 件 名:  DbMappingRelation.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月18日,  All rights reserved  
 */
package cn.leadeon.route.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.leadeon.route.utils.PropertiesReader;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * aquire the kv(dbid datasource) mapping relation
 * 
 * @author liudongdong
 * @version [1.0, 2014年8月18日]
 * @since [router datasource]
 */
public class DbMappingRelation{

	private static Logger LOGGER = LoggerFactory
			.getLogger(DbMappingRelation.class);

	private final static String driverClass = PropertiesReader
			.getString("driverClass");
	private final static String url = PropertiesReader.getString("url");
	private final static String username = PropertiesReader
			.getString("username");
	private final static String pwd = PropertiesReader.getString("password");
	
	private final static String datasourceInfo_sql = PropertiesReader
			.getString("datasourceInfo_sql");
	
	
	// 创建静态全局变量
	static Connection conn;

	static Statement st;
	static ResultSet rs;

	public static Connection getConnection() {
		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(url, username, pwd);// 创建数据连接

		} catch (Exception e) {
			LOGGER.error("database builds connection failure,exception:"
					+ e.getMessage());
			System.exit(0);
		}
		return conn; // 返回所建立的数据库连接
	}

	/**
	 * datasourceConfig 获取druid数据源配置信息列表
	 * 
	 * @return
	 */
	public HashMap<String, DruidDataSource> getDatasourceConfigList()
			throws Exception {
		Connection conn = getConnection();
		HashMap<String, DruidDataSource> datasourcesList = new HashMap<String, DruidDataSource>();
		DruidDataSource druidDataSource;
		try {
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(datasourceInfo_sql);

			while (rs.next()) {

				druidDataSource = new DruidDataSource();

				String rule_value = rs.getString("rule_value");

				druidDataSource.setDriverClassName(rs
						.getString("driverclassname"));
				druidDataSource.setUrl(rs.getString("url"));
				druidDataSource.setUsername(rs.getString("user"));
				druidDataSource.setPassword(rs.getString("password"));
				druidDataSource.setInitialSize(rs.getInt("initialSize"));
				druidDataSource.setMinIdle(rs.getInt("minIdle"));
				druidDataSource.setMaxActive(rs.getInt("maxActive"));
				druidDataSource.setMaxWait(rs.getInt("maxWait"));
				druidDataSource.setTimeBetweenEvictionRunsMillis(rs
						.getInt("timeBetweenEvictionRunsMillis"));
				druidDataSource.setMinEvictableIdleTimeMillis(rs
						.getInt("minEvictableIdleTimeMillis"));
				druidDataSource.setValidationQuery(rs
						.getString("validationQuery"));
				druidDataSource
						.setTestWhileIdle(rs.getBoolean("testWhileIdle"));
				druidDataSource.setTestOnBorrow(rs.getBoolean("testWhileIdle"));
				druidDataSource.setTestOnReturn(rs.getBoolean("testOnBorrow"));
				druidDataSource.setRemoveAbandoned(rs
						.getBoolean("removeAbandoned"));
				druidDataSource.setRemoveAbandonedTimeout(rs
						.getInt("removeAbandonedTimeout"));
				druidDataSource.setLogAbandoned(rs.getBoolean("logAbandoned"));
				druidDataSource.setPoolPreparedStatements(rs
						.getBoolean("poolPreparedStatements"));
				druidDataSource.setFilters(rs.getString("filters"));
				druidDataSource.setConnectionProperties(rs
						.getString("connectionProperties"));
				LOGGER.debug("getDatasourceConfigList()：rule_value="+rule_value+",druidDataSource="+druidDataSource);
				datasourcesList.put(rule_value, druidDataSource);

			}
			return datasourcesList;
		} finally {// 关闭数据库连接

			rs.close();
			st.close();
			conn.close();

		}

	}

	
}
