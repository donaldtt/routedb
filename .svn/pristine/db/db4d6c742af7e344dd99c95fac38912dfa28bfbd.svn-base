  动态数据源路由使用说明
             
  
            1.主要用于解决分库对应用的透明化，具有一个集中jdbc datasource配置管道中心，具备动态数据库配置等功能。
              
    
            2.使用说明范例：(本例是按照手机号码后2位字段进行路由的)
     
     
##############part1 jdbc datasource配置管理中心数据库###############

创建routedb数据库,并在该库中创建2张如下结构表:
     
     业务规则路由表（route_info）
     
DROP TABLE IF EXISTS `route_info`;
CREATE TABLE `route_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rule_id` int(11) NOT NULL,
  `rule_value` varchar(10) NOT NULL DEFAULT '',
  `dbid` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;




     
 	路由信息表（datasource_info）   
  
 DROP TABLE IF EXISTS `datasource_info`;
CREATE TABLE `datasource_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbid` int(11) NOT NULL,
  `host` varchar(20) NOT NULL DEFAULT '',
  `port` varchar(10) NOT NULL DEFAULT '',
  `dbname` varchar(20) NOT NULL DEFAULT '',
  `user` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `poolsize` int(11) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  `driverclassname` varchar(50) NOT NULL,
  `url` varchar(120) NOT NULL,
  `initialSize` int(10) NOT NULL,
  `minIdle` int(10) NOT NULL,
  `maxActive` int(10) NOT NULL,
  `maxWait` int(10) NOT NULL,
  `timeBetweenEvictionRunsMillis` int(10) NOT NULL,
  `minEvictableIdleTimeMillis` int(10) NOT NULL,
  `validationQuery` varchar(10) NOT NULL,
  `testWhileIdle` tinyint(1) NOT NULL DEFAULT '1',
  `testOnBorrow` tinyint(1) NOT NULL DEFAULT '0',
  `testOnReturn` tinyint(1) NOT NULL DEFAULT '0',
  `removeAbandoned` tinyint(1) NOT NULL DEFAULT '1',
  `removeAbandonedTimeout` int(10) NOT NULL,
  `logAbandoned` tinyint(1) NOT NULL DEFAULT '1',
  `poolPreparedStatements` tinyint(1) NOT NULL DEFAULT '0',
  `filters` varchar(10) NOT NULL,
  `connectionProperties` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
     
    
    插入如下基础数据到对应的表中，然后根据实际路由规则进行相关信息的变更
    
INSERT INTO `datasource_info` VALUES ('1', '1', '192.168.10.123', '3608', 'cmbh', 'cmbh', 'cmbh123456', null, '1', 'com.p6spy.engine.spy.P6SpyDriver', 'jdbc:mysql://192.168.10.123:3608/cmbh?useUnicode=true&amp;characterEncoding=utf-8;', '100', '100', '150', '60000', '60000', '300000', 'SELECT \'x\'', '1', '0', '0', '1', '1800', '1', '0', 'stat', 'druid.stat.slowSqlMillis=100');
INSERT INTO `datasource_info` VALUES ('2', '2', '192.168.10.124', '3708', 'cmbh', 'cmbh', 'cmbh123456', null, '1', 'com.p6spy.engine.spy.P6SpyDriver', 'jdbc:mysql://192.168.10.124:3708/cmbh?useUnicode=true&amp;characterEncoding=utf-8;', '100', '100', '150', '60000', '60000', '300000', 'SELECT \'x\'', '1', '0', '0', '1', '1800', '1', '0', 'stat', 'druid.stat.slowSqlMillis=100');
  
  
INSERT INTO `route_info` VALUES ('1', '1', '00', '1', '1');
INSERT INTO `route_info` VALUES ('2', '1', '01', '1', '1');
INSERT INTO `route_info` VALUES ('3', '1', '02', '1', '1');
INSERT INTO `route_info` VALUES ('4', '1', '03', '1', '1');
INSERT INTO `route_info` VALUES ('5', '1', '04', '1', '1');
INSERT INTO `route_info` VALUES ('6', '1', '05', '1', '1');
INSERT INTO `route_info` VALUES ('7', '1', '06', '1', '1');
INSERT INTO `route_info` VALUES ('8', '1', '07', '1', '1');
INSERT INTO `route_info` VALUES ('9', '1', '08', '1', '1');
INSERT INTO `route_info` VALUES ('10', '1', '09', '1', '1');
INSERT INTO `route_info` VALUES ('11', '1', '10', '1', '1');
INSERT INTO `route_info` VALUES ('12', '1', '11', '1', '1');
INSERT INTO `route_info` VALUES ('13', '1', '12', '1', '1');
INSERT INTO `route_info` VALUES ('14', '1', '13', '1', '1');
INSERT INTO `route_info` VALUES ('15', '1', '14', '1', '1');
INSERT INTO `route_info` VALUES ('16', '1', '15', '1', '1');
INSERT INTO `route_info` VALUES ('17', '1', '16', '1', '1');
INSERT INTO `route_info` VALUES ('18', '1', '17', '1', '1');
INSERT INTO `route_info` VALUES ('19', '1', '18', '1', '1');
INSERT INTO `route_info` VALUES ('20', '1', '19', '1', '1');
INSERT INTO `route_info` VALUES ('21', '1', '20', '1', '1');
INSERT INTO `route_info` VALUES ('22', '1', '21', '1', '1');
INSERT INTO `route_info` VALUES ('23', '1', '22', '1', '1');
INSERT INTO `route_info` VALUES ('24', '1', '23', '1', '1');
INSERT INTO `route_info` VALUES ('25', '1', '24', '1', '1');
INSERT INTO `route_info` VALUES ('26', '1', '25', '1', '1');
INSERT INTO `route_info` VALUES ('27', '1', '26', '1', '1');
INSERT INTO `route_info` VALUES ('28', '1', '27', '1', '1');
INSERT INTO `route_info` VALUES ('29', '1', '28', '1', '1');
INSERT INTO `route_info` VALUES ('30', '1', '29', '1', '1');
INSERT INTO `route_info` VALUES ('31', '1', '30', '1', '1');
INSERT INTO `route_info` VALUES ('32', '1', '31', '1', '1');
INSERT INTO `route_info` VALUES ('33', '1', '32', '1', '1');
INSERT INTO `route_info` VALUES ('34', '1', '33', '1', '1');
INSERT INTO `route_info` VALUES ('35', '1', '34', '1', '1');
INSERT INTO `route_info` VALUES ('36', '1', '35', '1', '1');
INSERT INTO `route_info` VALUES ('37', '1', '36', '1', '1');
INSERT INTO `route_info` VALUES ('38', '1', '37', '1', '1');
INSERT INTO `route_info` VALUES ('39', '1', '38', '1', '1');
INSERT INTO `route_info` VALUES ('40', '1', '39', '1', '1');
INSERT INTO `route_info` VALUES ('41', '1', '40', '1', '1');
INSERT INTO `route_info` VALUES ('42', '1', '41', '1', '1');
INSERT INTO `route_info` VALUES ('43', '1', '42', '1', '1');
INSERT INTO `route_info` VALUES ('44', '1', '43', '1', '1');
INSERT INTO `route_info` VALUES ('45', '1', '44', '1', '1');
INSERT INTO `route_info` VALUES ('46', '1', '45', '1', '1');
INSERT INTO `route_info` VALUES ('47', '1', '46', '1', '1');
INSERT INTO `route_info` VALUES ('48', '1', '47', '1', '1');
INSERT INTO `route_info` VALUES ('49', '1', '48', '1', '1');
INSERT INTO `route_info` VALUES ('50', '1', '49', '1', '1');
INSERT INTO `route_info` VALUES ('51', '1', '50', '2', '1');
INSERT INTO `route_info` VALUES ('52', '1', '51', '2', '1');
INSERT INTO `route_info` VALUES ('53', '1', '52', '2', '1');
INSERT INTO `route_info` VALUES ('54', '1', '53', '2', '1');
INSERT INTO `route_info` VALUES ('55', '1', '54', '2', '1');
INSERT INTO `route_info` VALUES ('56', '1', '55', '2', '1');
INSERT INTO `route_info` VALUES ('57', '1', '56', '2', '1');
INSERT INTO `route_info` VALUES ('58', '1', '57', '2', '1');
INSERT INTO `route_info` VALUES ('59', '1', '58', '2', '1');
INSERT INTO `route_info` VALUES ('60', '1', '59', '2', '1');
INSERT INTO `route_info` VALUES ('61', '1', '60', '2', '1');
INSERT INTO `route_info` VALUES ('62', '1', '61', '2', '1');
INSERT INTO `route_info` VALUES ('63', '1', '62', '2', '1');
INSERT INTO `route_info` VALUES ('64', '1', '63', '2', '1');
INSERT INTO `route_info` VALUES ('65', '1', '64', '2', '1');
INSERT INTO `route_info` VALUES ('66', '1', '65', '2', '1');
INSERT INTO `route_info` VALUES ('67', '1', '66', '2', '1');
INSERT INTO `route_info` VALUES ('68', '1', '67', '2', '1');
INSERT INTO `route_info` VALUES ('69', '1', '68', '2', '1');
INSERT INTO `route_info` VALUES ('70', '1', '69', '2', '1');
INSERT INTO `route_info` VALUES ('71', '1', '70', '2', '1');
INSERT INTO `route_info` VALUES ('72', '1', '71', '2', '1');
INSERT INTO `route_info` VALUES ('73', '1', '72', '2', '1');
INSERT INTO `route_info` VALUES ('74', '1', '73', '2', '1');
INSERT INTO `route_info` VALUES ('75', '1', '74', '2', '1');
INSERT INTO `route_info` VALUES ('76', '1', '75', '2', '1');
INSERT INTO `route_info` VALUES ('77', '1', '76', '2', '1');
INSERT INTO `route_info` VALUES ('78', '1', '77', '2', '1');
INSERT INTO `route_info` VALUES ('79', '1', '78', '2', '1');
INSERT INTO `route_info` VALUES ('80', '1', '79', '2', '1');
INSERT INTO `route_info` VALUES ('81', '1', '80', '2', '1');
INSERT INTO `route_info` VALUES ('82', '1', '81', '2', '1');
INSERT INTO `route_info` VALUES ('83', '1', '82', '2', '1');
INSERT INTO `route_info` VALUES ('84', '1', '83', '2', '1');
INSERT INTO `route_info` VALUES ('85', '1', '84', '2', '1');
INSERT INTO `route_info` VALUES ('86', '1', '85', '2', '1');
INSERT INTO `route_info` VALUES ('87', '1', '86', '2', '1');
INSERT INTO `route_info` VALUES ('88', '1', '87', '2', '1');
INSERT INTO `route_info` VALUES ('89', '1', '88', '2', '1');
INSERT INTO `route_info` VALUES ('90', '1', '89', '2', '1');
INSERT INTO `route_info` VALUES ('91', '1', '90', '2', '1');
INSERT INTO `route_info` VALUES ('92', '1', '91', '2', '1');
INSERT INTO `route_info` VALUES ('93', '1', '92', '2', '1');
INSERT INTO `route_info` VALUES ('94', '1', '93', '2', '1');
INSERT INTO `route_info` VALUES ('95', '1', '94', '2', '1');
INSERT INTO `route_info` VALUES ('96', '1', '95', '2', '1');
INSERT INTO `route_info` VALUES ('97', '1', '96', '2', '1');
INSERT INTO `route_info` VALUES ('98', '1', '97', '2', '1');
INSERT INTO `route_info` VALUES ('99', '1', '98', '2', '1');
INSERT INTO `route_info` VALUES ('100', '1', '99', '2', '1');


     
     
     
     
###################part2 修改leadeon-route.jar 中route_jdbc.properties配置文件中需要修改的如下参数修改#########################
    
    ##configure jdbc datasource配置管道中心 database connection address###
driverClass=com.mysql.jdbc.Driver
url=jdbc:mysql://192.168.10.111:4108/routedb
username=cmbh
password=cmbh123456

#k-v mapper sql#
datasourceInfo_sql=SELECT ds.dbid	,ds.host	,ds.port	,ds.dbname	,ds.user	,ds.password,ds.poolsize,ds.flag	,ds.driverclassname	,ds.url	,ds.initialSize	,ds.minIdle	,ds.maxActive,	ds.maxWait	,ds.timeBetweenEvictionRunsMillis,ds.minEvictableIdleTimeMillis	,ds.validationQuery	,ds.testWhileIdle	,ds.testOnBorrow	,ds.testOnReturn	,ds.removeAbandoned,	ds.removeAbandonedTimeout	,ds.logAbandoned	,ds.poolPreparedStatements	,ds.filters	,ds.connectionProperties,	rf.rule_value from datasource_info  ds,route_info rf WHERE ds.dbid=rf.dbid and rf.flag=1 and ds.flag=1

    
    
########################part3在自己工程中做如下工作############################################################# 
      
           
step1.实现路由规则算法，必须实现RuleStrategy接口中路由算法
              
     
package cn.leadeon.common.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.leadeon.route.strategy.RuleStrategy;

/**
 * 定义手机号码路由规则算法
 * 
 * @author  liudongdong
 * @version  [1.0 2014年8月26日]
 * @since  [中国移动手机营业厅BSS系统]
 */
public class PhoneNumberRule implements RuleStrategy {
	private final static Logger LOGGER=LoggerFactory.getLogger(PhoneNumberRule.class);
	/**
	 * 根据手机号后2位路由算法
	 * 重载方法
	 * @param ruleField
	 * @return
	 */
	@Override
	public String getRouterRuleAlgorithm(String ruleField){
		if(!com.alibaba.druid.util.StringUtils.isEmpty(ruleField.trim())){
			String routerRuleFieldSubffix = ruleField.substring(
					ruleField.length() - 2, ruleField.length());
			LOGGER.info("getRouterRuleAlgorithm,=>routerRuleFieldSubffix"+routerRuleFieldSubffix);
			return routerRuleFieldSubffix;
		}else {
			 return null;
		}
		
		
	}

}


step2.在spring配置文件中配置自定义的路由规则策略
    
    <!-- 定义自定义的规则策略 -->
	<bean id="phoneNumberRule" class="cn.leadeon.common.datasource.PhoneNumberRule"/>
	
step3.在spring中 配置动态数据路由类（MultiDataSourceRouter）,并引用自定义的规则策略
	<bean id="routeDataSource" class="cn.leadeon.route.datasource.MultiDataSourceRouter">
		<property name="strategy" ref="phoneNumberRule"/>
	</bean> 
    
    
step4.在需要路由的业务的控制层方法中或者业务层的需要路由的service方法中，第一行装载路由规则字段
    
       DbContextHolder.setDbType(tel_no);	
       
       
       
       
    
    

            