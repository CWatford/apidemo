package apitask.config;


import java.util.ArrayList;
import java.util.Set;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.google.common.collect.Sets;

@Configuration
public class EmbeddedTomcatConfiguration {

	@Value("${server.port}")
	private String serverPort;

	@Value("${management.port}")
	private String managementPort;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		Connector[] additionalConnectors = this.additionalConnector();
		if (additionalConnectors != null && additionalConnectors.length > 0) {
			tomcat.addAdditionalTomcatConnectors(additionalConnectors);
		}
		return tomcat;
	}

	private Connector[] additionalConnector() {
		java.util.List<Connector> result = new ArrayList<>();
		//result.add(configureConnector(this.serverPort));
		result.add(configureConnector(this.managementPort));		
		return result.toArray(new Connector[] {});
	}
	
	private Connector configureConnector(String port) {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");		
		connector.setPort(Integer.valueOf(port));				
		return connector;
	}
	
}