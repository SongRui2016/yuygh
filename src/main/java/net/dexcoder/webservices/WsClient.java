package net.dexcoder.webservices;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import net.dexcoder.ws.GetDeptInfoService;
import net.dexcoder.ws.GetHospitalInfoService;
import net.dexcoder.ws.GetHospitalInfoServiceResponse;
import net.dexcoder.ws.GetOrderNumInfoService;
import net.dexcoder.ws.ObjectFactory;

/**
 * webservice 请求第三方服务 客户端
 * 
 * @author 夏鸿程
 *
 */
public class WsClient extends WebServiceGatewaySupport {

	private ObjectFactory objFactory = new ObjectFactory();

	/**
	 * 请求第三方服务的医院信息
	 * 
	 * @param xmlString
	 *            xml格式的字符串
	 * @return
	 */
	public String getHospitalInfo(String xmlString) {

		JAXBElement<String> element = objFactory.createGetHospitalInfoServiceXmlString(xmlString); // 把xml格式的字符串转为Element

		GetHospitalInfoService service = objFactory.createGetHospitalInfoService(); // 获取请求参数体
		service.setXmlString(element); // 设置请求参数

		/* 获取响应数据 */
		GetHospitalInfoServiceResponse response = (GetHospitalInfoServiceResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://125.70.9.141:8888/webServiceOrderRegCDS/services/BookingWebServiceImpl?wsdl", service);
		return response.getReturn().getValue(); // 把响应的数据字符串返回
	}

	/**
	 * 获取科室
	 * 
	 * @param xmlString
	 * 			请求获取医院科室的xml格式字符串参数
	 * @return xml 格式字符串诗句
	 */
	public String getHosDeptInfo(String xmlString) {
		JAXBElement<String> element = objFactory.createGetDeptInfoServiceXmlString(xmlString); // 把xml格式的字符串转为Element
		GetDeptInfoService service = objFactory.createGetDeptInfoService();
		service.setXmlString(element);
		/* 获取响应数据 */
		GetHospitalInfoServiceResponse response = (GetHospitalInfoServiceResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://125.70.9.141:8888/webServiceOrderRegCDS/services/BookingWebServiceImpl?wsdl", service);

		return response.getReturn().getValue();
	}

	/**
	 * 获取号源，获取医生也使用此接口
	 * @param xmlString
	 * @return
	 */
	public String getNumsource(String xmlString) {
		
		JAXBElement<String> element = objFactory.createGetOrderNumInfoServiceXmlString(xmlString);
		GetOrderNumInfoService service = objFactory.createGetOrderNumInfoService();
		service.setXmlString(element);
		/* 获取响应数据 */
		GetHospitalInfoServiceResponse response = (GetHospitalInfoServiceResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://125.70.9.141:8888/webServiceOrderRegCDS/services/BookingWebServiceImpl?wsdl", service);

		return response.getReturn().getValue();
	}
	
}
