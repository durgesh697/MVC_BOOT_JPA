package com.dt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dt.model.ToDo;

@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
