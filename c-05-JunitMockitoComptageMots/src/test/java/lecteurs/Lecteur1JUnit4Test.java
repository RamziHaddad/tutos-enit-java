package lecteurs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import org.junit.Test;

public class Lecteur1JUnit4Test {
	static LecteurFichierTexte l = new Lecteur1();
	static String chemin = "aceaziecuaizeciu";
	
	@Test(expected = NoSuchFileException.class)
	public void givenInexistantFile_whenWordsAreDemanded_thenException() throws IOException {
		List<String> mots = l.getMots(chemin);
	}

}
