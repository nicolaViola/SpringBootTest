package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfBean  implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>{
	
	@Value("${app.context}")
	private String contextPath;
	
	@Value("${app.port}")
	private int port;
	
//	@Autowired
//	private AppSettings appSettings;

	public void customize(ConfigurableServletWebServerFactory factory) {
//		factory.setContextPath(appSettings.getContext());
//		factory.setPort(appSettings.getPort());
		factory.setContextPath(contextPath);
		factory.setPort(port);
	}

}
