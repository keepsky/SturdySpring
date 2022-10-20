package com.nayim.firstspring.dao;

import com.nayim.firstspring.domain.Todo;

public interface TodoDAO {
	
	
	public Todo findTodo(Long id);
	public void addTodo(Todo todo);
	
}
