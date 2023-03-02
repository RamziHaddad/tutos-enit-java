package analyseurs;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Compteur3 implements AnalyseurTexte{

	@Override
	public Map<String, Long> occurrencesParMot(List<String> mots) {
		return mots.parallelStream().collect(groupingByConcurrent(m->m, counting()));
	}

}
