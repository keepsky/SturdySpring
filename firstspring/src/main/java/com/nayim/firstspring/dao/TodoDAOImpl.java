package com.nayim.firstspring.dao;

import org.springframework.stereotype.Repository;

import com.nayim.firstspring.domain.Todo;

@Repository
public class TodoDAOImpl implements TodoDAO {

	@Override
	public Todo findTodo(Long id) {
		// TODO Auto-generated method stub
		System.out.println("find");
		Todo todo = new Todo("ioc");
		return todo;
	}

	@Override
	public void addTodo(Todo todo) {
		// TODO Auto-generated method stub
		System.out.println("save todo");
	}

}
