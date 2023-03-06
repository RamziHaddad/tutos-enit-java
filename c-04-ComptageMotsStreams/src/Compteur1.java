import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class Compteur1 implements AnalyseurTexte{

	@Override
	public Map<String, Long> occurrencesParMot(List<String> mots) {
		return mots.stream().collect(groupingBy(m->m, counting()));
	}

}
