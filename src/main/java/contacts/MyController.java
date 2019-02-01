package contacts;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@RequestMapping(path="/")
	@GetMapping
	public String ccc(){
		//return applicationContext.getBeanDefinitionNames();
		
		StringBuilder sb = new StringBuilder("<html><body>");
		sb.append("Hello there dear developer, here are the beans you were looking for: </br>");
		//method that returns all the bean names in the context of the application
		String beanNames[] = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for (String beanName : beanNames) {
			sb.append("</br>").append(beanName);
		}
		sb.append("</body></htm>");
		return sb.toString();
		
	}

}
