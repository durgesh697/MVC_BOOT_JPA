package com.dt.test.util;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import com.dt.model.ToDo;
import com.dt.util.PayloadValidator;

public class PayloadValidatorTest {

	@Test
	public void validatePayLoad() {
		ToDo toDo = new ToDo(1, "Sample ToDo 1", true);
		assertEquals(false, PayloadValidator.validateCreatePayload(toDo));
	}
	
	@Test
	public void validateInvalidPayLoad() {
		ToDo toDo = new ToDo(0, "Sample ToDo 1", true);
		assertEquals(true, PayloadValidator.validateCreatePayload(toDo));
	}
	
	

}
