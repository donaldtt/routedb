/*
 * 文 件 名:  DruidAbstractDataSource.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月26日,  All rights reserved  
 */
package cn.leadeon.route.datasource;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;




/**
 * 
 * @author  liudongdong
 * @version  [1.0, 2014年8月26日]
 * @since  [router datasource]
 */
public abstract class DruidAbstractDataSource implements DataSource{


	/** Logger available to subclasses */
	protected final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * Returns 0, indicating the default system timeout is to be used.
	 */
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	/**
	 * Setting a login timeout is not supported.
	 */
	public void setLoginTimeout(int timeout) throws SQLException {
		throw new UnsupportedOperationException("setLoginTimeout");
	}

	/**
	 * LogWriter methods are not supported.
	 */
	public PrintWriter getLogWriter() {
		throw new UnsupportedOperationException("getLogWriter");
	}

	/**
	 * LogWriter methods are not supported.
	 */
	public void setLogWriter(PrintWriter pw) throws SQLException {
		throw new UnsupportedOperationException("setLogWriter");
	}



	@SuppressWarnings("unchecked")
	public <T> T  unwrap(Class<T> iface) throws SQLException {
		Assert.notNull(iface, "Interface argument must not be null");
		if (!DataSource.class.equals(iface)) {
			throw new SQLException("DataSource of type [" + getClass().getName() +
					"] can only be unwrapped as [javax.sql.DataSource], not as [" + iface.getName());
		}
		return (T) this;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return DataSource.class.equals(iface);
	}



	public Logger getParentLogger() {
		return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	}



}
