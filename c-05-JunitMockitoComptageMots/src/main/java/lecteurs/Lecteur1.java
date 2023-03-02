package lecteurs;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lecteur1 implements LecteurFichierTexte{

	@Override
	public List<String> getMots(String chemin) throws IOException {
		Path path = Paths.get(chemin);
		List<String> mots = Files.lines(path).flatMap(l->Pattern.compile("\\W").splitAsStream(l)).collect(Collectors.toList());
		return mots;		
	}

}
