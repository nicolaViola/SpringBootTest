package contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"contacts"})
@EnableConfigurationProperties(AppSettings.class)
public class Application{
	
//	@Autowired
//	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Started ...");
	}
	
	
//	@RequestMapping(path="/")
//	@GetMapping
//	public String ccc(){
//		//return applicationContext.getBeanDefinitionNames();
//		
//		StringBuilder sb = new StringBuilder("<html><body>");
//		sb.append("Hello there dear developer, here are the beans you were looking for: </br>");
//		//method that returns all the bean names in the context of the application
//		String beanNames[] = applicationContext.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		
//		for (String beanName : beanNames) {
//			sb.append("</br>").append(beanName);
//		}
//		sb.append("</body></htm>");
//		return sb.toString();
//		
//	}
	
//	@Value("${app.context}")
//	private String contextPath;
//	
//	@Bean
//	public TomcatServletWebServerFactory containerFactory() {
//		TomcatServletWebServerFactory xc =  new TomcatServletWebServerFactory() {
//            protected void customizeConnector(Connector connector) {
//                int maxSize = 50000000;
//                super.customizeConnector(connector);
//                connector.setMaxPostSize(maxSize);
//                connector.setMaxSavePostSize(maxSize);
//                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
//
//                    ((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
//                    logger.info("Set MaxSwallowSize "+ maxSize);
//                }
//            }
//        };
//        xc.setContextPath(contextPath);
//        return xc;
//    }
	
	
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//	TomcatEmbeddedServletContainerFactory factory =
//	new TomcatEmbeddedServletContainerFactory();
//	factory.setPort(value);
//	factory.setSessionTimeout(10, TimeUnit.MINUTES);
//	factory.setContextPath(contextPath);
//	return factory;
//	}
	

	

}
