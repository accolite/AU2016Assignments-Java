package com.acc.testPOJO;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.After;
import org.junit.Before;


import com.acc.model.Person;




public class TestPerson {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	@Test
	public void testPersonConstructor(){
		int id=10;
		String name="Monika";
		String email="monika.dangi@accoliteindia.com";
		Person testPerson= new Person(id,name,email);
		assertEquals(testPerson.getName(),name);
		assertEquals(testPerson.get_id(),id);
		assertEquals(testPerson.getEmail(),email);
	}
	
	
	
}
