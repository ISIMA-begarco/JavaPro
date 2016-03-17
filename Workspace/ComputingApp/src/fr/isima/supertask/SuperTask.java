package fr.isima.supertask;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.Echo;
import org.apache.tools.ant.taskdefs.Jar;
import org.apache.tools.ant.taskdefs.Java;
import org.apache.tools.ant.taskdefs.Javac;
import org.apache.tools.ant.taskdefs.Manifest;
import org.apache.tools.ant.taskdefs.Manifest.Attribute;
import org.apache.tools.ant.taskdefs.ManifestException;
import org.apache.tools.ant.taskdefs.Mkdir;
import org.apache.tools.ant.types.Path;

public class SuperTask extends Task {
	
	private String classpath;
	private String buildpath;
	private String sourcepath;
	private String mainclass;
	private String jarName;
	private String jarUri;
	
	public SuperTask() {
		super();
		setDescription("Permet de compiler, packager et exécuter une application Java.");
	}
	
	@Override
	public void execute() throws BuildException {
		
		if(classpath!=null && buildpath!=null && sourcepath!=null && mainclass!=null) {
			Echo echo = new Echo();
			/*******************************************************/
			echo.setMessage("Début de la SUPER tâche ...");
			echo.execute();
			/*******************************************************/
			echo.setMessage("Compilation ...");
			echo.execute();
			Javac javac = new Javac();
			javac.setProject(this.getProject());
			javac.setClasspath(new Path(this.getProject(), classpath));
			javac.setSrcdir(new Path(this.getProject(), sourcepath));
			javac.setDestdir(new File(buildpath));
			javac.setIncludeantruntime(true);
			
			javac.execute();
			/*******************************************************/
			echo.setMessage("Packaging ...");
			echo.execute();
			Mkdir mkdir = new Mkdir();
			mkdir.setProject(this.getProject());
			mkdir.setDir(new File(jarUri));
			mkdir.execute();
			Jar jar = new Jar();
			jar.setProject(this.getProject());
			jar.setBasedir(new File(this.buildpath));
			jar.setDestFile(new File(jarUri+jarName+".jar"));
			Manifest manifestFile = new Manifest();
			try {
				manifestFile.addConfiguredAttribute(new Attribute("Main-Class", this.classpath+"."+this.mainclass));
			} catch (ManifestException e1) {
				e1.printStackTrace();
			}
			try {
				jar.addConfiguredManifest(manifestFile);
			} catch (ManifestException e) {
				e.printStackTrace();
			}
			jar.execute();
			jar.setProject(this.getProject());
			/*******************************************************/
			echo.setMessage("Exécution ...\n");
			echo.execute();
			Java java = new Java();
			java.setProject(this.getProject());
			java.setJar(new File(jarUri+jarName+".jar"));
			java.setFork(true);
			java.execute();
			/*******************************************************/
			echo.setMessage("Fin de la SUPER tâche ...");
			echo.execute();
			/*******************************************************/
		} else {
			throw new BuildException("Attribut manquant.");
		}
	}

	public String getClasspath() {
		return classpath;
	}

	public void setClasspath(String classpath) {
		this.classpath = classpath;
	}

	public String getBuildpath() {
		return buildpath;
	}

	public void setBuildpath(String buildpath) {
		this.buildpath = buildpath;
	}

	public String getSourcepath() {
		return sourcepath;
	}

	public void setSourcepath(String sourcepath) {
		this.sourcepath = sourcepath;
	}

	public String getMainclass() {
		return mainclass;
	}

	public void setMainclass(String mainclass) {
		this.mainclass = mainclass;
	}

	public String getJarName() {
		return jarName;
	}

	public void setJarName(String jarName) {
		this.jarName = jarName;
	}

	public String getJarUri() {
		return jarUri;
	}

	public void setJarUri(String jarUri) {
		this.jarUri = jarUri;
	}
	
	
}
