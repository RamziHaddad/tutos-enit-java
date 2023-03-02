package analyseurs;
import java.util.List;
import java.util.Map;

public interface AnalyseurTexte {
	
	public Map<String,Long> occurrencesParMot(List<String> mots);

}
