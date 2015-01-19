/*
 * 文 件 名:  RuleContext.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月26日,  All rights reserved  
 */
package cn.leadeon.route.strategy;

/**
 * define the context of the router rule
 * @author  liudongdong
 * @version  [1.0, 2014年8月26日]
 * @since  [datasource router]
 */
public class RuleContext {
	
private RuleStrategy strategy;

public RuleContext(RuleStrategy strategy){
	this.strategy=strategy;
}



/** 
 * 
 * @param ruleField
 * @return
 */
public String getRouterRuleAlgorithm(String ruleField){
	return strategy.getRouterRuleAlgorithm(ruleField);
}
}
