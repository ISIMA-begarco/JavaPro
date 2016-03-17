package fr.isima.myanttest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProjectTest.class, EchoTaskTest.class, CopyTaskTest.class, MkdirTaskTest.class, CompileTaskTest.class, DeleteTaskTest.class, MyNewTask1Test.class, MyNewTask2Test.class, MainAntTest.class})
public class AllTests {

}