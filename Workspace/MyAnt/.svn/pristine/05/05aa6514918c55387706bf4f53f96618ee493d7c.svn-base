package fr.isima.myant;

public class MyNewTask1 extends Task {
	
	protected String attr[];
	
	public MyNewTask1() {
		attr = new String[2];
	}
	
	public MyNewTask1(String a, String b) {
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
		System.out.println(attr[0]+" "+attr[1]);
	}

}
