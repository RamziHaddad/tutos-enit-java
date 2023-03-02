import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecteur0 implements LecteurFichierTexte{

	@Override
	public List<String> getMots(String path) {
		BufferedReader br = null;
		try {
			List<String> mots = new ArrayList<>();
			String currentLine;
			br = new BufferedReader(new FileReader(path));
			while ((currentLine = br.readLine()) != null) {
				String[] words = currentLine.split("\\W");
				mots.addAll(Arrays.asList(words));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return Collections.EMPTY_LIST;
	}

}
