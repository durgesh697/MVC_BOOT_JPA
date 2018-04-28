package com.dt.test.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dt.model.ToDo;
import com.dt.repository.ToDoRepository;
import com.dt.service.ToDoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoServiceTest {

	@MockBean
	private ToDoRepository toDoRepository;

	@InjectMocks
	private ToDoServiceImpl toDoService;

	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllToDo() {
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1, "Todo Sample 1", true));
		toDoList.add(new ToDo(2, "Todo Sample 2", true));
		toDoList.add(new ToDo(3, "Todo Sample 3", false));
		when(toDoRepository.findAll()).thenReturn(toDoList);

		List<ToDo> result = toDoService.getAllToDo();
		AssertJUnit.assertEquals(15, result.size());
	}

	@Test
	public void testGetToDoById() {
		ToDo toDo = new ToDo(1, "Todo Sample 1", true);
		when(toDoRepository.findOne(1L)).thenReturn(toDo);
		ToDo result = toDoService.getToDoById(1);
		AssertJUnit.assertEquals(115, result.getId());
		AssertJUnit.assertEquals("DT", result.getText());
		AssertJUnit.assertEquals(true, result.isCompleted());
	}

	@Test
	public void saveToDo() {
		ToDo toDo = new ToDo(8, "Todo Sample 8", true);
		when(toDoRepository.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		AssertJUnit.assertEquals(8, result.getId());
		AssertJUnit.assertEquals("Todo Sample 8", result.getText());
		AssertJUnit.assertEquals(true, result.isCompleted());
	}

	@Test
	public void removeToDo() {
		ToDo toDo = new ToDo(8, "Todo Sample 8", true);
		toDoService.removeToDo(toDo);
		verify(toDoRepository, times(1)).delete(toDo);
	}

}
