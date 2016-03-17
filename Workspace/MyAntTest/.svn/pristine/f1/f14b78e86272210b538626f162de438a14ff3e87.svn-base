package fr.isima.myanttest;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myant.MainAnt;


public class MainAntTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void before() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}	
	
	@After
	public void after() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testMain() {
		String[] args = new String[3];
		args[0] = "mybuild.txt";
		args[1] = "default";
		args[2] = "compile";
		MainAnt.main(args);
		assertTrue(outContent.toString().contains("value1 value2"));
		assertTrue(outContent.toString().contains("blabla blabla blabla"));
		assertTrue(outContent.toString().contains("Completed!"));
		assertTrue(outContent.toString().contains("Compiling..."));		
	}

	@Test
	public void testFile() {
		String[] args = new String[1];
		args[0] = "md.txt";
		MainAnt.main(args);	
		assertTrue(errContent.toString().contains("md.txt (Le fichier spécifié est introuvable)"));	
	}
	
}
