package lecteurs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lecteur2 implements LecteurFichierTexte{

	@Override
	public List<String> getMots(String chemin) throws IOException {
		List<String> mots = new ArrayList<>();
		BufferedReader br = null;
		try {
			String currentLine;
			br = new BufferedReader(new FileReader(chemin));
			while ((currentLine = br.readLine()) != null) {
				String[] words = currentLine.split("\\W");
				mots.addAll(Arrays.asList(words));
			}
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return mots;
	}

}
