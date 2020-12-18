package io.codingexercises.rest.validateapi.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import io.codingexercises.rest.validateapi.util.IncomingValidator;



@RunWith(Parameterized.class)
public class IncomingValidatorTest {
	
	@Test
	public void testFindDuplicates() {
		//Positive test:
		assertEquals("Test for findDuplicates when duplicates are present: ", "s\ti\tp", IncomingValidator.findDuplicates("Mississippi"));
		
		//Negative test:
		assertEquals("Test when duplicates are not present: ", "", IncomingValidator.findDuplicates("Florida"));
	}
}
