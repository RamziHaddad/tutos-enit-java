package analyseurs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import lecteurs.LecteurFichierTexte;

import static org.mockito.Mockito.*;

class CompteursWithMockedLecteurTest {
	private static LecteurFichierTexte lecteur;
	private static String chemin="azkczezcez";
	private static List<String> mots;
	private static AnalyseurTexte compteur;
	private static Map<String,Long> expected;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		expected = new HashMap<>();
		expected.put("a", 2L);
		expected.put("b", 2L);
		expected.put("c", 1L);
		lecteur = mock(LecteurFichierTexte.class);
		when(lecteur.getMots(anyString())).thenReturn(Arrays.asList("a","b","b","c","a"));
		mots = lecteur.getMots(chemin);
	}

	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur1_thenResultIsCorrect() {
		compteur = new Compteur1();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
		assertEquals(expected, comptage);
	}
	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur2_thenResultIsCorrect() {
		compteur = new Compteur2();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
		assertEquals(expected, comptage);
	}
	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur3_thenResultIsCorrect() {
		compteur = new Compteur3();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
		assertEquals(expected, comptage);
	}
	@RepeatedTest(5)
	void givenAReaderAndNonEmptyList_whenCountingCompteur4_thenResultIsCorrect() {
		compteur = new Compteur4();
		Map<String, Long> comptage = compteur.occurrencesParMot(mots);
		assertNotNull(comptage);
		assertFalse(comptage.isEmpty());
		assertEquals(expected, comptage);
	}
	@Test
	void givenAReaderAndNonEmptyList_whenCountingCompteur4_thenResultIsCorrectAndTriCalled() {
		Compteur4 compteur = spy(Compteur4.class);
		compteur.occurrencesParMot(mots);
		verify(compteur).tri(anyList());
		verify(compteur).tri(mots);
		verify(compteur,times(1)).tri(mots);
		verify(compteur,atLeastOnce()).tri(mots);
	}

	

}
