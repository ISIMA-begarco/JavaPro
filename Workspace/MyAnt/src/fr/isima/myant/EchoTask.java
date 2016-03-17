package fr.isima.myant;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of EchoTask.
 * 
 * @author Benoît
 */
public class EchoTask extends Task {
	/**
	 * Description of the property message.
	 */
	private String message = "";

	// Start of user code (user defined attributes for EchoTask)

	// End of user code

	/**
	 * The constructor.
	 */
	public EchoTask() {
		// Start of user code constructor for EchoTask)
		this("");
		// End of user code
	}

	/**
	 * The constructor.
	 */
	public EchoTask(String newMessage) {
		// Start of user code constructor for EchoTask)
		super();
		this.setMessage(newMessage);
		// End of user code
	}

	// Start of user code (user defined methods for EchoTask)

	// End of user code
	/**
	 * Returns message.
	 * @return message 
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets a value to attribute message. 
	 * @param newMessage 
	 */
	public void setMessage(String newMessage) {
		this.message = newMessage;
	}

	@Override
	public void execute() {
		super.execute();
		System.out.println(getMessage());
	}

}
