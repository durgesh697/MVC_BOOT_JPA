package com.dt.service;

import java.util.List;

import com.dt.model.ToDo;

public interface ToDoService {
	public List<ToDo> getAllToDo();
	public ToDo getToDoById(long id);
	public ToDo saveToDo(ToDo todo);
	public void removeToDo(ToDo todo);
}
