package com.jzxtech.web.controller;

import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.jzxtech.utils.JsonUtil;
import com.jzxtech.web.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginControllerTest extends BaseTest {

	private String baseUrl = "/login/";


	@Test
	public void test_1_login_empty() throws Exception {
		String url = baseUrl + "login";
		MvcResult mvcResult;
		String content;
		Map<String, ?> rst;
		System.out.println("asfd");
		Integer errorCode;
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();


		/* 空账号密码 */
		mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).params(params).accept(MediaType.APPLICATION_JSON)).andReturn();
		content = mvcResult.getResponse().getContentAsString();
		rst = JsonUtil.Parse2Map(content);
		errorCode = (Integer) rst.get("errorCode");
		Assert.assertTrue("预期结果不一致 ", errorCode == 3);

		/* 空密码 */
		params.clear();
		params.add("account", "huzhengwei");
		mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).params(params).accept(MediaType.APPLICATION_JSON)).andReturn();
		content = mvcResult.getResponse().getContentAsString();
		rst = JsonUtil.Parse2Map(content);
		errorCode = (Integer) rst.get("errorCode");
		Assert.assertTrue("预期结果不一致 ", errorCode == 3);

		/* 错误账号密码 */
		params.clear();
		params.add("account", "huzhengwei");
		params.add("password", "huzhengwei");
		mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).params(params).accept(MediaType.APPLICATION_JSON)).andReturn();
		content = mvcResult.getResponse().getContentAsString();
		rst = JsonUtil.Parse2Map(content);
		errorCode = (Integer) rst.get("errorCode");
		Assert.assertTrue("预期结果不一致 ", errorCode == 1);

		/* 正确登陆 */
		getLogin();
	}

	@Test
	public void test_2_logout() throws Exception {
		String url = baseUrl + "logout";
		MvcResult mvcResult;
		String content;
		Map<String, ?> rst;
		Integer errorCode;
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		/* 退出登陆 */
		params.clear();
		mvcResult = perform(url, params);
		content = mvcResult.getResponse().getContentAsString();
		rst = JsonUtil.Parse2Map(content);
		errorCode = (Integer) rst.get("errorCode");
		Assert.assertTrue("预期结果不一致 ", errorCode == 0);
	}

}
