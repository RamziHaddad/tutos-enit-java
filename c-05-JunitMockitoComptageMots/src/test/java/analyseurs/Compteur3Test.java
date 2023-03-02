package analyseurs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import lecteurs.Lecteur3;
import lecteurs.LecteurFichierTexte;

class Compteur3Test {
	private static LecteurFichierTexte lecteur;
	private static String chemin;
	private static List<String> mots;
	private static AnalyseurTexte compteur;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		lecteur = new Lecteur3();
		chemin = "testDocuments/t7.onemillion.txt";
		mots = lecteur.getMots(chemin);
		compteur = new Compteur3();
	}

	@Test
	void givenAReaderAndNonEmptyList_whenCounting_thenResultIsCorrect() {
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
	}
	
	@RepeatedTest(3)
	void givenAReaderAndList_whenRepeatedCounting_thenResultIsCorrect() {
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
	}

}
