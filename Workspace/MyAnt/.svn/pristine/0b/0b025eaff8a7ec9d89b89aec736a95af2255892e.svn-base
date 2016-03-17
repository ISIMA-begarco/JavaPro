package fr.isima.myant;

import java.io.FileNotFoundException;

public class MainAnt {

	public static void main(String[] args) {
		Project p;
		try {
			p = new Project("BestEver", args[0]);
			for(int i = 1 ; i < args.length ; i++) {
				p.addTargetToExecute(args[i]);
			}
			p.execute();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

}
