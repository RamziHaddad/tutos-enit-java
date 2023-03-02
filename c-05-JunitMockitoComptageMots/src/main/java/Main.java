import java.io.IOException;
import java.util.List;

import analyseurs.AnalyseurTexte;
import analyseurs.Compteur1;
import analyseurs.Compteur2;
import analyseurs.Compteur3;
import lecteurs.Lecteur1;
import lecteurs.LecteurFichierTexte;

public class Main {

	public static void main(String[] args) throws IOException {
		LecteurFichierTexte l = new Lecteur1();
		List<String> mots = l.getMots("tn,b,nbnb");
		System.out.println("Nombre de mots total = "+mots.size());
		AnalyseurTexte c1 = new Compteur1();
		AnalyseurTexte c2 = new Compteur2();
		AnalyseurTexte c3 = new Compteur3();
		System.out.println(c1.occurrencesParMot(mots));
		System.out.println(c2.occurrencesParMot(mots));
		System.out.println(c3.occurrencesParMot(mots));
	}

}
