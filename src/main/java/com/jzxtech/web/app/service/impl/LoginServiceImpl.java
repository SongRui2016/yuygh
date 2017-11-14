package com.jzxtech.web.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzxtech.utils.Assert;
import com.jzxtech.web.app.entity.Employee;
import com.jzxtech.web.app.mapper.EmployeeMapper;
import com.jzxtech.web.app.service.LoginSerivce;
import com.jzxtech.web.common.Common;

@Service
public class LoginServiceImpl implements LoginSerivce {

	@Autowired
	protected HttpSession session;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public int login(String account, String password) {
		Assert.assertTrue(3, "账号密码为空", account != null && password != null);

		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		Employee employee = employeeMapper.selectOne(params);

		Assert.assertTrue(1, "账号或密码错误", employee != null);
		Assert.assertTrue(2, "离职账户不允许登陆", employee.getLeavedate() == null);
		Assert.assertTrue(1, "账号或密码错误", password.equals(employee.getPassword()));

		session.setAttribute(Common.SESSION_KEY_USERINFO, employee);
		return 0;
	}

	@Override
	public int logout(HttpServletRequest request, HttpServletResponse response) {
		session.removeAttribute(Common.SESSION_KEY_USERINFO);
		return 0;
	}

}
