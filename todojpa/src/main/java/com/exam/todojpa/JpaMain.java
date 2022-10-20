package com.exam.todojpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;
import com.exam.todojpa.service.TodoService;

public class JpaMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TodoRepository todoRepo = ctx.getBean(TodoRepository.class);
		
		// 1. ����
//		Todo todo = new Todo();
//		todo.setTodo("drink water2");
//		todo.setDone(false);
		
//		for(int i=0;i<50;i++) {
//			Todo todo = new Todo();
//			todo.setTodo("hello" + i);
//			todoRepo.save(todo);
//		}
//
//		todo = todoRepo.save(todo);
//		System.out.println(todo);
		
		//2. ��ȸ
//		Todo findTodo = todoRepo.findById(3L).orElseThrow();
//		System.out.println(findTodo);
		
		//3.����
//		TodoService todoService = ctx.getBean(TodoService.class);
//		Todo resultTodo = todoService.updateTodo(3L);
		
		//4. ����
//		todoService.removeTodo(3L);
		
		//5. ��� ��ȸ
//		List<Todo> todos = todoRepo.findAll();
//		System.out.println(todos.size());
//		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
//		Page<Todo> page = todoRepo.findAll(pageable);
//		List<Todo> todos2 = page.getContent();
//		System.out.println(todos2.size());
		
		//6. ��ȸ by todo
//		List<Todo> todos = todoRepo.findByTodo("hello0");
//		System.out.println(todos.size());
//		
//		List<Todo> todos2 = todoRepo.findByTodoStartingWith("he");
//		System.out.println(todos2.size());
		
		//7. jpql�� �̿��� ���
		List<Todo> result3 = todoRepo.findTodos("llo");
		System.out.println(result3.size());
		
	}

}
