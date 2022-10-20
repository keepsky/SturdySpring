package com.nayim.firstspring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nayim.firstspring.dao.TodoDAO;
import com.nayim.firstspring.dao.TodoDAOImpl;
import com.nayim.firstspring.ioc.UserBean;
import com.nayim.firstspring.service.TodoService;

@Configuration
@ComponentScan(basePackages = {"com.nayim.firstspring"})
public class AppConfig {

//	@Bean
//	public UserBean userBean() {
//		return new UserBean();
//	}
//	
//	@Bean
//	public TodoDAO todoDao() {
//		return new TodoDAOImpl();
//	}
//	
//	@Bean
//	public TodoService todoService() {
//		return new TodoService(todoDao());
//	}
}
