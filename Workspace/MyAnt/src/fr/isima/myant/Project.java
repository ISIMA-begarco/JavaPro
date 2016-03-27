package fr.isima.myant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Project.
 *
 * @author Benoit
 */
public class Project {
	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property filename.
	 */
	private String filename = "";

	/**
	 * Description of the property filename.
	 */
	private ArrayList<String> toExecute;

	/**
	 * Description of the property targets.
	 */
	private Target defaultTarget = null;

	/**
	 * Description of the property targets.
	 */
	private HashMap<String, Target> targets;

	/**
	 * Description of the property classes.
	 */
	@SuppressWarnings("rawtypes")
	private HashMap<String,Class> classes;

	/**
	 * The constructor.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes" })
	public Project(String pName, String pFilename) throws IOException {
		super();
		toExecute = new ArrayList<String>();
		targets = new HashMap<String, Target>();
		name = pName;
		filename = pFilename;
		classes = new HashMap<String, Class>();
		classes.put("echo", EchoTask.class);
		classes.put("copy", CopyTask.class);
		classes.put("mkdir", MkdirTask.class);
		try {
			loadFromFile();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add targets to execute.
	 */
	public void addTargetToExecute(String pTarget) {
		toExecute.add(pTarget);
	}

	/**
	 * Description of the method loadFromFile.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public void loadFromFile() throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		FileReader file = null;
		BufferedReader br = null;
		file = new FileReader(filename);
		br = new BufferedReader(file);


		Target current = null;
		String line = null;
		// lecture de la premiere ligne
		line = br.readLine();

		while(line != null) {
			if(line.length() == 0 || line=="" || line.equals("\n") || line.charAt(0) == '#') {
				// ignore empty lines
				// ignore commentaries
			} else if(line.startsWith("use ")) {	/* les classes à importer */
				String words[] = line.split(" ");
				classes.put(words[3], Class.forName(words[1]));
			} else if(line.contains("[")) {	/* les taches à exécuter */
				String words[] = line.split("\\[|\\]|, ");
				@SuppressWarnings("rawtypes")
				Constructor c = null;
				c = classes.get(words[0]).getConstructor();
				Task t = null;
				t = (Task) c.newInstance();
				for(int i = 1 ; i < words.length ; ++i) {
					String param[] = words[i].split(":");
					if (param[0] != "") {
						param[0] = Character.toUpperCase(param[0].charAt(0)) + param[0].substring(1, param[0].length());
						Method m = classes.get(words[0]).getMethod("set"+param[0], String.class);
						m.invoke(t,param[1].split("\"")[1]);
					}
				}
				current.getTasks().add(t);
			} else if(line.contains(":")) {
				String words[] = line.trim().split(":|,| ");

				current = new Target(words[0]);
				targets.put(words[0], current);
				if(words[0].equals("default"))
					defaultTarget = current;
				for(int i = 1 ; i < words.length ; ++i) {
					if(!words[i].isEmpty()) {
						current.dependencies.add(targets.get(words[i]));
					}
				}
			}

			// ligne suivante
			line = br.readLine();
		}
	}

	/**
	 * Description of the method execute.
	 */
	public void execute() {
		// Start of user code for method execute
		if(toExecute.size() == 0) {
			defaultTarget.execute();
		} else {
			for(String s : toExecute) {
				if(targets.containsKey(s))
					targets.get(s).execute();
			}
		}
		// End of user code
	}

	// Start of user code (user defined methods for Project)

	// End of user code
	/**
	 * Returns name.
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a value to attribute name.
	 * @param newName
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Returns targets.
	 * @return targets
	 */
	public Target getDefaultTarget() {
		return this.defaultTarget;
	}

	/**
	 * Sets a value to attribute targets.
	 * @param newTargets
	 */
	public void setDefaultTarget(Target newTarget) {
		if (this.defaultTarget != null) {
			this.defaultTarget = null;
		}
		this.defaultTarget = newTarget;
	}

	/**
	 * Returns targets.
	 * @return targets
	 */
	public HashMap<String, Target> getTargets() {
		return this.targets;
	}

}
