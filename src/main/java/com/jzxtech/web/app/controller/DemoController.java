package com.jzxtech.web.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jzxtech.web.app.entity.Demo;
import com.jzxtech.web.app.service.DemoSerivce;

import net.dexcoder.webservices.WsClient;
import net.dexcoder.ws.GetHospitalInfoService;
import net.dexcoder.ws.GetHospitalInfoServiceResponse;
import net.dexcoder.ws.ObjectFactory;

@Controller
@RequestMapping
public class DemoController {

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private DemoSerivce demoSerivce;

	/**
	 * 加载数据方法
	 * 所有用户权限可访问
	 * @param params
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public Object select(@RequestParam Map<String, Object> params) {
		List<Demo> demos = demoSerivce.select(params);
		return demos;
	}

	/**
	 * 新增数据访问
	 * 仅有ADMIN权限可访问
	 * @param demo
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public Object insert(Demo demo) {
		int ok = demoSerivce.insert(demo);
		Map<String, Object> result = new HashMap<>();
		result.put("success", ok);
		return result;
	}
	
	/**
	 *测试 webservices
	 * @return
	 */
	@RequestMapping
	@ResponseBody
	public Object get () {
		String xml = "<Request>" + "<MessageHeader>" + "<frontproviderId>CDTJ</frontproviderId>"
				+ "<inputCharset>UTF-8</inputCharset>" + "<signType>MD5</signType>"
				+ "<sign>wker4d22efba4kfjg5b18769779mesk5</sign>" + "</MessageHeader>" + "<OrderInfo>" + "</OrderInfo>"
				+ "</Request>";
		String re = new WsClient().getHospitalInfo(xml);
		

		System.err.println(re);
		
		/**测试git*/
		System.out.println("这是测试git");

		return re;
	}

}
