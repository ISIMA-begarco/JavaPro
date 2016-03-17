package fr.isima.myextant;

public class CompileTask extends Task {
	
	protected String attr[];
	
	public CompileTask() {
		attr = new String[2];
	}
	
	public CompileTask(String a, String b) {
		attr = new String[2];
		attr[0] = a;
		attr[1] = b;
	}
	
	public void setAtt1(String s) {
		attr[0] = s;
	}
	
	public void setAtt2(String s) {
		attr[1] = s;
	}
	
	public String getAtt1() {
		return attr[0];
	}
	
	public String getAtt2() {
		return attr[1];
	}
	
	@Override
	public void execute() {
		System.out.println("Compilation de "+attr[0]+" "+attr[1]);
	}
}
