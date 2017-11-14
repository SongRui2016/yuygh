package com.jzxtech.web.app.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginSerivce {

	/**
	 * 登陆
	 * @param account 账号
	 * @param password 密码
	 * @return 错误代码
	 */
	int login(String account, String password);

	/**
	 * 登出
	 * @param response 
	 * @param request 
	 * @return 错误代码
	 */
	int logout(HttpServletRequest request, HttpServletResponse response);

}
