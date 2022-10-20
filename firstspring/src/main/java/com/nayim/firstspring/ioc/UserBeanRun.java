package com.nayim.firstspring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nayim.firstspring.ioc.config.AppConfig;
import com.nayim.firstspring.service.TodoService;

public class UserBeanRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserBean userBean = ac.getBean("userBean", UserBean.class);
		userBean.setName("park");
		System.out.println(userBean.getName());
		
		TodoService service = ac.getBean(TodoService.class);
		service.addTodo();
		
	}

}
