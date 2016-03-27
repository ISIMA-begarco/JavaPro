package fr.isima.myant;

public class MainAnt {
	public static void main(String[] args) {
		Project p;	// creation du nouveau projet
		try {
			p = new Project("BestEver", args[0]);	// utilisation du premier argument comme fichier de configuration
			for(int i = 1 ; i < args.length ; i++) { // parcours des cible à exécuter
				p.addTargetToExecute(args[i]);	// ajout à l'execution
			}
			p.execute();	// execution de toutes les cibles

		} catch (Exception e) {
			System.err.println(e.getMessage());	// afficher un petit message d'erreur en cas d'errreur
		}
	}

}
