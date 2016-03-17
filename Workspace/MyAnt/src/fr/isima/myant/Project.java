package fr.isima.myant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import fr.isima.myant.Target;

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
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings({ "rawtypes" })
	public Project(String pName, String pFilename) throws FileNotFoundException {
		super();
		toExecute = new ArrayList<String>();
		targets = new HashMap<String, Target>();
		name = pName;
		filename = pFilename;
		classes = new HashMap<String, Class>();
		classes.put("echo", EchoTask.class);
		classes.put("copy", CopyTask.class);
		classes.put("mkdir", MkdirTask.class);
		loadFromFile();
	}

	/**
	 * Add targets to execute.
	 */
	public void addTargetToExecute(String pTarget) {
		toExecute.add(pTarget);
	}

	/**
	 * Description of the method loadFromFile.
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	public void loadFromFile() throws FileNotFoundException {
		FileReader file = null;
		BufferedReader br = null;
		file = new FileReader(filename);
		br = new BufferedReader(file);


		Target current = null;
		String line = null;
		// lecture de la premiere ligne
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}


		while(line != null) {
			if(line.length() == 0 || line=="" || line.equals("\n")) {

			} else if(line.charAt(0) == '#') {

			} else if(line.startsWith("use ")) {
				String words[] = line.split(" ");
				try {
					classes.put(words[3], Class.forName(words[1]));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} else if(line.contains("[")) {
				String words[] = line.split("\\[|\\]|, ");
				@SuppressWarnings("rawtypes")
				Constructor c = null;
				try {
					c = classes.get(words[0]).getConstructor();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				Task t = null;
				try {
					t = (Task) c.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for(int i = 1 ; i < words.length ; ++i) {
					String param[] = words[i].split(":");
					if (param[0] != "") {
						try {
							param[0] = Character.toUpperCase(param[0].charAt(0)) + param[0].substring(1, param[0].length());
							Method m = classes.get(words[0]).getMethod("set"+param[0], String.class);
							m.invoke(t,param[1].split("\"")[1]);
						} catch (Exception e) {
							e.printStackTrace();
						}
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
			try {
				line = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
