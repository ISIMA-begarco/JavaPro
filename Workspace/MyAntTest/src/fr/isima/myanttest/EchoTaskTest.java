package fr.isima.myanttest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myant.EchoTask;


public class EchoTaskTest {
	
	EchoTask task;

	@Before
	public void before() {
		task = new EchoTask();
	}	
	
	@After
	public void after() {
		task = null;
	}

	@Test
	public void testMessage() {
		task.setMessage("rouge");
		assertEquals(task.getMessage(), "rouge");
	}
	
	@Test
	public void testEmpty() {
		task.setMessage("");
		assertEquals(task.getMessage(), "");
	}

}
