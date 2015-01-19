/*
 * 文 件 名:  ConfigDSInInfoManage.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年9月15日,  All rights reserved  
 */
package cn.leadeon.route.mange;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.leadeon.route.datasource.DbMappingRelation;
import cn.leadeon.route.listener.RouterDataSourceInfoConcreteWatched;
import cn.leadeon.route.listener.RouterDataSourceInfoConcreteWatcher;
import cn.leadeon.route.listener.RouterDataSourceInfoWatched;
import cn.leadeon.route.listener.RouterDataSourceInfoWatcher;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 手动更新数据源路由信息列表
 * 
 * @author liudongdong
 * @version [1.0, 2014年9月15日]
 * @since [产品/模块版本]
 */
public class ConfigDSInInfoManage extends HttpServlet {
	/**
	 * 重载方法
	 * 
	 * @throws ServletException
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * 重载方法
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, DruidDataSource> dsList=null;
		try {
			dsList = new DbMappingRelation().getDatasourceConfigList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter pw=resp.getWriter();
		pw.println("<html><head><title>update route datasource info</title></head><body>");  
		pw.println("<font color='red'>数据路由与规则信息显示如下：</font>");
		if(!dsList.isEmpty()){
			
			//register watcher
			RouterDataSourceInfoWatched routerDataSourceInfoWatched=new RouterDataSourceInfoConcreteWatched();
			RouterDataSourceInfoWatcher routerInfoWatcher=new RouterDataSourceInfoConcreteWatcher();
			routerDataSourceInfoWatched.addRouterDSInfoWatcher(routerInfoWatcher);
			routerDataSourceInfoWatched.notifyRouterDSInfoWather(dsList);
			routerDataSourceInfoWatched.removeRouterDSInfoWatcher(routerInfoWatcher);
			
			pw.print("<table width='100%' height='80%'><tr><td>规则</td><td>数据源信息</td></tr>");
			 Iterator<Entry<String, DruidDataSource>> iterator=dsList.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, DruidDataSource> entry=iterator.next();
				String key=entry.getKey();
				DruidDataSource value=entry.getValue();
				pw.println("<tr><td>"
						+key+ "</td><td>"
								+value+ "</td></tr>");
			}
		     
			pw.println("</table>");
		}else {
			pw.print("<table width='100%' height='80%'><tr><td>规则</td><td>数据源信息</td></tr>");
			pw.print("<tr><td colspan='2'>数据路由与规则信息为空！</td></tr></table");
		}
		 pw.println("</body></html>");  
	     pw.close();  
		
	}

	/**
	 * 重载方法
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	/**
	 * 重载方法
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
