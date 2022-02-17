package com.restapi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restapi.todo.model.Todo;
import com.restapi.todo.service.TodoService;

import java.util.List;

@RestController
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@PostMapping("/add")
	public Todo addTask(@RequestBody Todo task) {
		return todoService.createTask(task);
	}
	
	@GetMapping("/all")
	public List<Todo> getTasks() {
		return todoService.allTodos();
	}
	
	@PutMapping("/update")
	public Todo update(@RequestBody Todo task) {
		return todoService.updateTask(task);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return todoService.deleteTask(id);
	}
	
	
}
