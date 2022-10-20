package com.exam.todojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.repository.TodoRepository;
import com.exam.todojpa.domain.Todo;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepo;
	
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		System.out.println("#####getTodos(): start");
		List<Todo> result = todoRepo.findAll();
		System.out.println("#####getTodos(): " + result.size());
		return result;
	}

	@Transactional
	public Todo addTodo(String str) {
		Todo todo = new Todo();
		todo.setTodo(str);		
		return todoRepo.save(todo);
	}
	
	@Transactional
    public Todo updateTodo(Long id){

		Todo todo = null;
		
		try {
			todo = todoRepo.findById(id).orElseThrow();
			todo.setDone(!todo.isDone());
		} catch (Exception e) {
		} finally {			
		}
        //todoRepo.updateTodo(todo);

        return todo;
    }

	@Transactional
    public Todo changeTodo(Long id, String str){

        Todo todo = todoRepo.findById(id).orElseThrow();
        todo.setTodo(str);

        return todo;
    }

    @Transactional
    public void removeTodo(Long id){
    	Optional<Todo> result = todoRepo.findById(id);
    	
    	todoRepo.delete(result.get());
    }
    
    @Transactional(readOnly = true)
    public Todo getToto(Long id) {
        return todoRepo.findById(id).orElseThrow();
    }
}