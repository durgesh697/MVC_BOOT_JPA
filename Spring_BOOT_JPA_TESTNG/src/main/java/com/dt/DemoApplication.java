package com.dt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dt.model.ToDo;
import com.dt.repository.ToDoRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		/*
		 * DT
		 * 
		 * This is like commandLine, as we have been using in Core Java. Without
		 * Using the "CommadLineRunner" Bean it will fetch the data from the
		 * DataBase.
		 * 
		 * Using the "CommandLineRunner" Bean, it will 1st place all the data
		 * into the dB then it will fetch it from there
		 */
	@Bean
	public CommandLineRunner setup(ToDoRepository toDoRepository) {
		return null;
		return (args) -> {
			toDoRepository.save(new ToDo("One", true));
			toDoRepository.save(new ToDo("Two", true));
			toDoRepository.save(new ToDo("Three", false));
			toDoRepository.save(new ToDo("Four", true));
			logger.info("The sample data has been generated");
		};

	}
}
