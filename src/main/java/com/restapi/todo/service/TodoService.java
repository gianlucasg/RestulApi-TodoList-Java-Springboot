package com.restapi.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.todo.model.Todo;
import com.restapi.todo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepo;
	
	public Todo createTask(Todo todo) {
		return todoRepo.save(todo);
	}
	
	public List<Todo> allTodos(){
		return todoRepo.findAll();
	}
	
	public String deleteTask(Long id) {
		todoRepo.deleteById(id);
		return "Tarea Eliminada: " + id;
	}
	
	public Todo updateTask(Todo nuevo) {
		Todo todo = todoRepo.findById(nuevo.getId()).orElse(null);
		todo.setId(nuevo.getId());
		todo.setName(nuevo.getName());
		todo.setDone(nuevo.getDone());
		return todoRepo.save(todo);
		
	}
}
