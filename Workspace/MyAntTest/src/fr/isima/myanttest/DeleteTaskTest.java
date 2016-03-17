package fr.isima.myanttest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myextant.DeleteTask;


public class DeleteTaskTest {
	
	DeleteTask task;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void before() {
		task = new DeleteTask();
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}	
	
	@After
	public void after() {
		task = null;
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testAtt() {
		task.setAtt("bleu");
		assertEquals(task.getAtt(), "bleu");		
	}

	@Test
	public void testEmpty() {
		task.setAtt("");
		assertEquals(task.getAtt(), "");		
	}
	
	@Test
	public void testExecute() {
		task = new DeleteTask("test");
		task.execute();
		assertEquals("Supression de test", outContent.toString().substring(0, outContent.toString().length()-2));		
	}
	
}
