import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EX4_FilesStream {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("testDocuments/t1.verne.txt");
		//Files.lines(path).limit(50).flatMap(l->Pattern.compile("\\W").splitAsStream(l)).filter(s->!s.isEmpty()).forEach(System.out::println);
		long nbMots1 = Files.lines(path).flatMap(l->Arrays.stream(l.split("\\W"))).count();
		System.out.println("Nombre de mots dans le fichier = "+nbMots1);
		Map<String, Long> occurrencesParMot = Files.lines(path).flatMap(l->Arrays.stream(l.split("\\W"))).collect(Collectors.groupingBy(m->m,Collectors.counting()));
		System.out.println("Nombre d'occurrences par mot "+occurrencesParMot);
	}
}
