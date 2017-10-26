package com.mistytech.util;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mistytech.user.bean.User;


/**
 * 
 *TODO
 * @author huangaho
 *2015-4-30上午11:11:38
 */
public final class SessionUtils {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String SESSION_USER = "session_user";

	/**
	  * 设置session的�??
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static void setAttr(HttpServletRequest request,String key,Object value){
		 request.getSession(true).setAttribute(key, value);
	 }
	 
	 
	 /**
	  * 获取session的�??
	  * @param request
	  * @param key
	  * @param value
	  */
	 public static Object getAttr(HttpServletRequest request,String key){
		 return request.getSession(true).getAttribute(key);
	 }
	 
	 /**
	  * 删除Session�?
	  * @param request
	  * @param key
	  */
	 public static void removeAttr(HttpServletRequest request,String key){
		 request.getSession(true).removeAttribute(key);
	 }
	 
	 /**
	  * 设置用户信息 到session
	  * 
	  * @param request
	  * @param loginUser
	  */
	 public static void setUser(HttpServletRequest request,User loginUser){
		 request.getSession(true).setAttribute(SESSION_USER, loginUser);
	 }
	 
	 
	 /**
	  * 从session中获取用户信�?
	  * 
	  * @param request
	  * @return
	  */
	 public static User getUser(HttpServletRequest request){
		return (User)request.getSession(true).getAttribute(SESSION_USER);
	 }
	 
	 
	/**
	 * 从session中删除用户信�?
	 * 
	 * @param request
	 */
	 public static void removeUser(HttpServletRequest request){
		removeAttr(request, SESSION_USER);
	 }
	 
}