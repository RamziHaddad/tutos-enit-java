import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		LecteurFichierTexte l = new Lecteur1();
		List<String> mots = l.getMots("testDocuments/t8.churchill.txt");
		System.out.println("Nombre de mots total = "+mots.size());
		AnalyseurTexte c = new Compteur4();
		long start = System.currentTimeMillis();
		Map<String, Long> occurrencesParMot = c.occurrencesParMot(mots);
		long stop = System.currentTimeMillis();
		System.out.println("fin du comptage en "+(stop-start)+"ms");
		//ce n'est pas une bonne façon de benchmarker (cf. JMH)
		System.out.println("Le fichier a "+occurrencesParMot.size()+" mots distincts");
	}

}
