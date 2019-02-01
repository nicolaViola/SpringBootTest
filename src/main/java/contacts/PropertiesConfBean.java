package contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfBean  implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>{
	
//	@Value("${app.context}")
//	private String contextPath;
	
	@Autowired
	private AppSettings appSettings;

	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setContextPath(appSettings.getContext());
	}

}
