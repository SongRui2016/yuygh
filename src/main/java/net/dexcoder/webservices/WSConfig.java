package net.dexcoder.webservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("net.dexcoder.ws");
		return marshaller;
	}

	@Bean
	public WsClient wsClient(Jaxb2Marshaller marshaller) {
		WsClient client = new WsClient();
		client.setDefaultUri("http://125.70.9.141:8888/webServiceOrderRegCDS/services/BookingWebServiceImpl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
