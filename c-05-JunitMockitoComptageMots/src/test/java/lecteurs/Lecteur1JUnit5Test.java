package lecteurs;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class Lecteur1JUnit5Test {
	static LecteurFichierTexte l;
	static String chemin;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		l = new Lecteur1();
		chemin = "testDocuments/t7.onemillion.txt";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void givenFile_whenWordsAreReturned_thenSizeIsCorrect() {
		try {
			List<String> mots = l.getMots(chemin);
			assertEquals(1_000_000,mots.size());
		} catch (IOException e) {
			fail("exception was thrown "+e);
		}
	}
	
	@RepeatedTest(3)
	void givenFile_whenFileIsReadMultipleTimes_thenSizeIsCorrect() {
		try {
			List<String> mots = l.getMots(chemin);
			assertEquals(1_000_000,mots.size());
		} catch (IOException e) {
			fail("exception was thrown "+e);
		}
	}
	
	@Test
	public void givenInexistantFile_whenWordsAreDemanded_thenException() {
		String cheminFictif = "zhecazhec";
		Exception exception = assertThrows(NoSuchFileException.class, ()-> l.getMots(cheminFictif));
		assertTrue(exception.getMessage().contains(cheminFictif));
	}
	
}
