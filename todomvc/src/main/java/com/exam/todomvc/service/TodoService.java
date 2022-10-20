package com.exam.todomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

@Service
public class TodoService {
	@Autowired
	private TodoDao todoDao;
	
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		return todoDao.getTodos();
	}
	@Transactional
	public Todo addTodo(String todo) {
		return todoDao.addTodo(todo);
	}
	
	@Transactional
    public Todo updateTodo(Long id){

        Todo todo = todoDao.getTodo(id);
        todo.setDone(!todo.isDone());
        todoDao.updateTodo(todo);

        return todo;
    }

	@Transactional
    public Todo changeTodo(Long id, String str){

        Todo todo = todoDao.getTodo(id);
        todoDao.changeTodo(todo, str);

        return todo;
    }

    @Transactional
    public void removeTodo(Long id){
        todoDao.deleteTodo(id);
    }
    
    @Transactional(readOnly = true)
    public Todo getToto(Long id) {
        return todoDao.getTodo(id);
    }
}