package com.jzxtech.web;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.jzxtech.utils.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BaseTest {

	@Autowired
	protected MockMvc mvc;


	/**
	 * 带获取登陆的session
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MvcResult perform(String url, MultiValueMap<String, String> params) throws Exception {
		return mvc.perform(MockMvcRequestBuilders.post(url).params(params).session(getLogin()).accept(MediaType.APPLICATION_JSON)).andReturn();
	}

	/**
	 * 获取登陆session
	 * @return
	 * @throws Exception
	 */
	public MockHttpSession getLogin() throws Exception {
		String url = "/login/login";
		MvcResult mvcResult;
		String content;
		Map<String, ?> rst;
		Integer errorCode;
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		params.clear();
		params.add("account", "huzhengwei");
		params.add("password", "huzhengwei2");
		mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).params(params).accept(MediaType.APPLICATION_JSON)).andReturn();
		content = mvcResult.getResponse().getContentAsString();
		rst = JsonUtil.Parse2Map(content);
		errorCode = (Integer) rst.get("errorCode");
		String errorMessage = (String) rst.get("errorMessage");
		Assert.assertTrue("登陆失败: " + errorMessage, errorCode == 0);

		return (MockHttpSession) mvcResult.getRequest().getSession();
	}  

	@Before
	public void init() {
		// 在运行测试之前的业务代码
	}

	@After
	public void after() {
		// 在测试完成之后的业务代码
	}

}
