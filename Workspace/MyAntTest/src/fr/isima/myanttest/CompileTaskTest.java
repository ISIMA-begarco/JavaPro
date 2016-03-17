package fr.isima.myanttest;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myextant.*;


public class CompileTaskTest {
	
	CompileTask task;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void before() {
		task = new CompileTask();
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
		task.setAtt2("rouge");
		assertEquals(task.getAtt2(), "rouge");		
	}

	@Test
	public void testEmpty() {
		task.setAtt1("");
		task.setAtt2("");
		assertEquals(task.getAtt1()+task.getAtt2(), "");		
	}
	
	@Test
	public void testExecute() {
		task = new CompileTask("test", "bleu");
		task.execute();
		assertEquals("Compilation de test bleu", outContent.toString().substring(0, outContent.toString().length()-2));		
	}
	
}
