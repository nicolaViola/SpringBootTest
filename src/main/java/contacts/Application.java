package contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"contacts"})
@EnableConfigurationProperties(AppSettings.class)
public class Application extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Started ...");
	}
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
	      .anyRequest().hasRole("ADMIN")
	      .and()
	      .httpBasic();
	  }
	  
	  @Bean

	  @Override

	  public UserDetailsService userDetailsService() {
	      UserDetails user =
	          User.withDefaultPasswordEncoder()
	              .username("nicola")
	              .password("viola")
	              .roles("ADMIN")
	              .build();
	      return new InMemoryUserDetailsManager(user);

	  }
	
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//	    return http.authorizeExchange()
//	      .pathMatchers("/actuator/**").permitAll()
//	      .anyExchange().authenticated()
//	      .and().build();
//	}
	
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
