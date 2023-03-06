package lecteurs;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Lecteur3 implements LecteurFichierTexte{

	private static final Pattern COMPILE = Pattern.compile("\\W");

	@Override
	public List<String> getMots(String chemin) throws IOException {
		Path path = Paths.get(chemin);
		List<String> mots = Files.lines(path).flatMap(l->COMPILE.splitAsStream(l)).collect(Collectors.toList());
		return mots;		
	}

}
