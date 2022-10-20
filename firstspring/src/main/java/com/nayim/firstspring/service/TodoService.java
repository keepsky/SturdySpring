package com.nayim.firstspring.service;

import org.springframework.stereotype.Service;

import com.nayim.firstspring.dao.TodoDAO;
import com.nayim.firstspring.domain.Todo;

@Service
public class TodoService {
	TodoDAO todoDao = null;

	public TodoService(TodoDAO todoDao) {
		this.todoDao = todoDao;
	}
	
//	public void setTodoDao(TodoDAO todoDao) {
//		this.todoDao = todoDao;
//	}
	
	public void findTodo() {
		todoDao.findTodo(1L);
		System.out.println("######## findTodo() is invoked");
	}
	
	public void addTodo() {
		todoDao.addTodo(new Todo("test"));
		System.out.println("######## addTodo() is invoked");
	}
}
