package com.nayim.firstspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nayim.firstspring.service.TodoService;

public class AopExamRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		TodoService service = ac.getBean(TodoService.class);
		service.findTodo();
		service.addTodo();
	}

}
