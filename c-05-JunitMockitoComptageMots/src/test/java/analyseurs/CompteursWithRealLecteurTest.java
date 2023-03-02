package analyseurs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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

import static org.mockito.Mockito.*;

class CompteursWithRealLecteurTest {
	private static LecteurFichierTexte lecteur;
	private static String chemin="azkczezcez";
	private static List<String> mots;
	private static AnalyseurTexte compteur;
	private static Map<String,Long> expected;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		chemin = "testDocuments/t8.churchill.txt";
		lecteur = new Lecteur3();
		mots = lecteur.getMots(chemin);
	}

	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur1_thenResultIsCorrect() {
		compteur = new Compteur1();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
	}
	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur2_thenResultIsCorrect() {
		compteur = new Compteur2();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
	}
	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur3_thenResultIsCorrect() {
		compteur = new Compteur3();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
	}
	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur4_thenResultIsCorrect() {
		compteur = new Compteur4();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
	}
	
	

}
