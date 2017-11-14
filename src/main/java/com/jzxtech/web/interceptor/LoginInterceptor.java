package com.jzxtech.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jzxtech.utils.Assert;
import com.jzxtech.web.app.entity.Employee;
import com.jzxtech.web.common.Common;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-control-Allow-Origin", "http://localhost:8080");
		response.setHeader("Access-control-Allow-Headers", "*");
		response.setHeader("Access-control-Allow-Methods", "*");
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute(Common.SESSION_KEY_USERINFO);
		Assert.assertTrue(0x9001, "还未登录，请先登陆。", employee != null);
		return super.preHandle(request, response, handler);
	}

}
