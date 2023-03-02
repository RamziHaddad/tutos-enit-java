import java.util.List;

public class Main {

	public static void main(String[] args) {
		LecteurFichierTexte l = new Lecteur1();
		List<String> mots = l.getMots("testDocuments/t1.verne.txt");
		System.out.println("Nombre de mots total = "+mots.size());
		AnalyseurTexte c1 = new Compteur1();
		AnalyseurTexte c2 = new Compteur2();
		AnalyseurTexte c3 = new Compteur3();
		System.out.println(c1.occurrencesParMot(mots));
		System.out.println(c2.occurrencesParMot(mots));
		System.out.println(c3.occurrencesParMot(mots));
	}

}
