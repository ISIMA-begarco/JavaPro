package fr.isima.myanttest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myant.CopyTask;


public class CopyTaskTest {
	
	CopyTask task;
	
	@Before
	public void before() {
		task = new CopyTask();
	}	
	
	@After
	public void after() {
		task = null;
	}

	@Test
	public void testFrom() {
		task.setFrom("bleu");
		assertEquals(task.getFrom(), "bleu");		
	}

	@Test
	public void testTo() {
		task.setTo("rouge");
		assertEquals(task.getTo(), "rouge");		
	}

	@Test
	public void testEmpty() {
		task.setFrom("");
		task.setTo("");
		assertEquals(task.getFrom()+task.getTo(), "");		
	}
	
}
