package contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"contacts"})
@EnableConfigurationProperties(AppSettings.class)
public class Application /*extends WebSecurityConfigurerAdapter*/{
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Started ...");
		
	}
	
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//		  
//		  http.mvcMatcher("/**").authorizeRequests()
//		  .anyRequest().hasRole("ADMIN")
//	      .and()
//	      .httpBasic();
//	  }
//	  
//	  @Bean
//	  @Override
//	  public UserDetailsService userDetailsService() {
//	      UserDetails user =
//	          User.withDefaultPasswordEncoder()
//	              .username("nicola")
//	              .password("viola")
//	              .roles("ADMIN")
//	              .build();
//	      return new InMemoryUserDetailsManager(user);
//
//	  }
	
}
