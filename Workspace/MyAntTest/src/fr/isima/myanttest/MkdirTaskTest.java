package fr.isima.myanttest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myant.MkdirTask;


public class MkdirTaskTest {

	MkdirTask task;

	@Before
	public void before() {
		task = new MkdirTask();
	}	
	
	@After
	public void after() {
		task = null;
	}

	@Test
	public void testDir() {
		task.setDir("rouge");
		assertEquals(task.getDir(), "rouge");
	}
	
	@Test
	public void testEmpty() {
		task.setDir("");
		assertEquals(task.getDir(), "");
	}

}
