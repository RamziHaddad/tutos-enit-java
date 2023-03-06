import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Compteur2 implements AnalyseurTexte{

	@Override
	public Map<String, Long> occurrencesParMot(List<String> mots) {
		return mots.parallelStream().collect(groupingBy(m->m, counting()));
	}

}
