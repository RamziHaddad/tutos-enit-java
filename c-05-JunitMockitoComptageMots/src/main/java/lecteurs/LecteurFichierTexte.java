package lecteurs;

import java.io.IOException;
import java.util.List;

public interface LecteurFichierTexte {
	
	List<String> getMots(String chemin) throws IOException;
}
