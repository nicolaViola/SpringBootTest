package contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication(scanBasePackages = {"contacts"})
@EnableConfigurationProperties(AppSettings.class)
public class Application extends WebSecurityConfigurerAdapter{
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Started ...");
		
	}
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
		  http.mvcMatcher("/**").authorizeRequests()
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
	
}
