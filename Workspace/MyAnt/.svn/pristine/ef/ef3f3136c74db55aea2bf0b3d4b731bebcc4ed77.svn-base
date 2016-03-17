package fr.isima.myant;

import java.util.ArrayList;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Target.
 *
 * @author Benoît
 */
public class Target {
	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property .
	 */
	public ArrayList<Target> dependencies = new ArrayList<Target>();

	/**
	 * Description of the property tasks.
	 */
	public ArrayList<Task> tasks = new ArrayList<Task>();

	// Start of user code (user defined attributes for Target)

	// End of user code

	/**
	 * The constructor.
	 */
	public Target(String pname) {
		super();
		name = pname;
	}

	/**
	 * Description of the method execute.
	 */
	public void execute() {
		for (Target tg : dependencies) {
			if(tg != null)
				tg.execute();
		}

		for (Task task : tasks) {
			task.execute();
		}
	}

	// Start of user code (user defined methods for Target)

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
	 * Returns .
	 * @return
	 */
	public ArrayList<Target> getDependencies() {
		return this.dependencies;
	}

	/**
	 * Returns tasks.
	 * @return tasks
	 */
	public ArrayList<Task> getTasks() {
		return this.tasks;
	}

}
