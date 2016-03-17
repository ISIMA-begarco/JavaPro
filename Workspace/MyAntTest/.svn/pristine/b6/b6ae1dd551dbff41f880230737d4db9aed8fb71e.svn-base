package fr.isima.myanttest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myant.MyNewTask2;


public class MyNewTask2Test {
	
	MyNewTask2 task;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void before() {
		task = new MyNewTask2();
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
	public void testAtt1() {
		task.setAtt1("bleu");
		assertEquals(task.getAtt1(), "bleu");		
	}

	@Test
	public void testAtt2() {
		task.setAtt2("bleu");
		assertEquals(task.getAtt2(), "bleu");		
	}

	@Test
	public void testAtt3() {
		task.setAtt3("bleu");
		assertEquals(task.getAtt3(), "bleu");		
	}

	@Test
	public void testEmpty() {
		task.setAtt1("");
		task.setAtt2("");
		task.setAtt3("");
		assertEquals(task.getAtt1()+task.getAtt2()+task.getAtt3(), "");		
	}
	
	@Test
	public void testExecute() {
		task = new MyNewTask2("test", "bleu", "rouge");
		task.execute();
		assertEquals("test bleu rouge", outContent.toString().substring(0, outContent.toString().length()-2));		
	}
	
}
