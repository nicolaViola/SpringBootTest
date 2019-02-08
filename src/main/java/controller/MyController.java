package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import contacts.Error;
import contacts.MyData;

@RestController
public class MyController {
	
		@Autowired
		private ApplicationContext applicationContext;
	
		@RequestMapping(path="/{i}")
		@GetMapping
		public String ccc(@PathVariable String i){
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
	
		//http://127.0.0.1:8080/test-boot/data/nicola?r=105
		@RequestMapping(path="/data/{i}")
		@GetMapping
		public Collection<MyData> /*ResponseEntity<?>*/ getData(@PathVariable String i, @RequestParam String r) throws Exception{
			
			Collection<MyData> data = new ArrayList<>();
			
			if("1".equals(r)){
				data.add(new MyData(i, "xxx1" + r));
				data.add(new MyData(i, "xxx2" + r));
				data.add(new MyData(i, "xxx3" + r));
				return data;//;new ResponseEntity<Collection<MyData>>(data, HttpStatus.OK);
			}else{
				throw new Exception("questa è la mia eccezione");
			}
		}
	
	
	
		//http://127.0.0.1:8080/test-boot/responseEntity
		@RequestMapping(path="/responseEntity")
		@GetMapping
		public @ResponseBody ResponseEntity<?> getResponseEntity() throws Exception{
			Collection<MyData> data = new ArrayList<>();
			data.add(new MyData("ww", "xxx1"));
			return new ResponseEntity<Collection<MyData>>(data, HttpStatus.NOT_FOUND);
		}
	
	
	
		//http://127.0.0.1:8080/test-boot/test
		@RequestMapping(path="/test")
		@GetMapping
		@ResponseStatus(HttpStatus.CREATED)
		public MyData getMyData() throws Exception{
			return new MyData("s", "xxx1");
			
		}

	
		@ExceptionHandler(Exception.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public  Error spittleNotFound(Exception e) {
			return new Error(4, e.getMessage());
		}
	
	
}
