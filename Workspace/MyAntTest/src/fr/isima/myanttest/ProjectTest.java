package fr.isima.myanttest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.isima.myant.Project;
import fr.isima.myant.Target;


public class ProjectTest {
	
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
	public void testTargetsLoading() throws IOException {
		Project p = null;
		p = new Project("bleu", "mybuild.txt");
		assertEquals(p.getTargets().size(), 4);

		HashMap<String, Target> targets = p.getTargets();
		String[] keys = {"default", "clean", "compile", "package"};
		for(String t : keys) {
			assertThat(targets.get(t), is(not(nullValue())));
		}
		p.addTargetToExecute("package");
		p.execute();
	}
	
	@Test
	public void testLoading() throws IOException  {
		Project p = new Project("Test", "mybuild.txt");
		p.addTargetToExecute("default");
		p.execute();
		assertEquals("default", "default");
	}

	@Test(expected=FileNotFoundException.class)
	public void testInexistantFile() throws IOException {
		new Project("bleu", "inexistant.txt");
	}
	
	@Test
	public void testName() throws IOException {
		Project p = new Project("bleu", "mybuild.txt");
		assertEquals("bleu", p.getName());
		p.setName("rouge");
		assertEquals("rouge", p.getName());
	}
	
	@Test
	public void testDefault() throws IOException {
		Project p = new Project("bleu", "mybuild.txt");
		Target d = new Target("bob");
		d.setName("bib");
		p.setDefaultTarget(d);
		p.setDefaultTarget(d);
		assertEquals(d, p.getDefaultTarget());
		assertEquals("bib", p.getDefaultTarget().getName());
		p.setDefaultTarget(null);
		assertEquals(null, p.getDefaultTarget());
	}

}