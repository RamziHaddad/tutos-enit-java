import java.util.List;
import java.util.Map;

public interface AnalyseurTexte {
	
	Map<String,Long> occurrencesParMot(List<String> mots);

}
