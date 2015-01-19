/*
 * 文 件 名:  NestedExceptionUtils.java
 * 版    权:  Xi'An Leadeon Technologies Co., Ltd. Copyright 2014年8月26日,  All rights reserved  
 */
package cn.leadeon.route.exception;

/**
 * @author  liudongdong
 * @version  [1.0, 2014年8月26日]
 */
public abstract class NestedExceptionUtils {


	/**
	 * Build a message for the given base message and root cause.
	 * @param message the base message
	 * @param cause the root cause
	 * @return the full exception message
	 */
	public static String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			StringBuilder sb = new StringBuilder();
			if (message != null) {
				sb.append(message).append("; ");
			}
			sb.append("nested exception is ").append(cause);
			return sb.toString();
		}
		else {
			return message;
		}
	}



}
