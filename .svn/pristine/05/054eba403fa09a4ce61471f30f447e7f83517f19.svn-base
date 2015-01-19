/*
 * 文 件 名:  MultiDataSourceRouter.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年4月3日,  All rights reserved  
 */
package cn.leadeon.route.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cn.leadeon.route.strategy.RuleContext;
import cn.leadeon.route.strategy.RuleStrategy;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * MultiDataSourceRouter 
 * 
 * @author liudongdong
 * @version [1.0, 2014年4月3日]
 * @since [datasouce router]
 */

public class MultiDataSourceRouter extends AbstractDruidRoutingDataSource
		implements ApplicationContextAware {

	private static Logger LOGGER = LoggerFactory
			.getLogger(MultiDataSourceRouter.class);

	private static final DbMappingRelation mappingRelation = new DbMappingRelation();

	private HashMap<String, DruidDataSource> druidDataSources;
	private RuleContext ruleContext;
	private ApplicationContext appContext;

	private RuleStrategy strategy;// 设置规则
	private ReentrantLock lock = new ReentrantLock();

	@Override
	protected Object determineCurrentLookupKey() {
		lock.lock();
		try {
			String routerRuleField = DbContextHolder.getDbType(); // 获取路由规则字段
			ruleContext = new RuleContext(strategy);
			String routerRuleFieldSubffix = ruleContext
					.getRouterRuleAlgorithm(routerRuleField);
			LOGGER.info("MultiDataSourceRouter=>determineCurrentLookupKey(),routerRuleFieldSubffix=>"
					+ routerRuleFieldSubffix);
			if (druidDataSources.containsKey(routerRuleFieldSubffix)) {
				LOGGER.info("^^:" + routerRuleFieldSubffix);
				return routerRuleFieldSubffix;
			} else {
				try {
					throw new Exception("current look up key is null!");
				} catch (Exception e) {
					LOGGER.error("determineCurrentLookupKey(),exception:"
							+ e.getMessage());
				}
				return null;
			}
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 重载方法
	 * 
	 * @param dataSourceLookup
	 */
	@Override
	public void setDataSourceLookup(DruidDataSourceLookup dataSourceLookup) {
		super.setDataSourceLookup(dataSourceLookup);
	}


	/**
	 * 重载方法
	 * 
	 * @param targetDataSources
	 */
	@Override
	public void setTargetDataSources(
			Map<String, DruidDataSource> targetDataSources) {
		//add new code 2012/09/15
		//this.druidDataSources=(HashMap<String, DruidDataSource>) targetDataSources;
		// TODO Auto-generated method stub
		super.setTargetDataSources(targetDataSources);
	}

	/**
	 * 重载方法
	 * 
	 * @param arg0
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext aContext)
			throws BeansException {
		this.appContext = aContext;

	}

	/**
	 * 
	 *initail multi-datasouce and  rule field
	 */
	private void initailizeMutiDataSource() throws Exception {
		druidDataSources = mappingRelation.getDatasourceConfigList();
		setTargetDataSources(druidDataSources);
		LOGGER.debug("MultiDataSourceRouter=>initailizeMutiDataSource(),druidDataSources:"
				+ druidDataSources);
	}

	/**
	 * 重载方法
	 */
	@Override
	public void afterPropertiesSet() {
		LOGGER.info("initial multi-datasource");
		try {
			initailizeMutiDataSource();
		} catch (Exception e) {
			LOGGER.error("spring multi-datasource initials exception:"
					+ e.getMessage());
		}

		LOGGER.info("spring multi-datasource  initials successfully in jee container!");
		super.afterPropertiesSet();
	}

	/**
	 * 设置 strategy
	 * 
	 * @param 对strategy进行赋值
	 */
	public void setStrategy(RuleStrategy strategy) {
		this.strategy = strategy;
	}
}
