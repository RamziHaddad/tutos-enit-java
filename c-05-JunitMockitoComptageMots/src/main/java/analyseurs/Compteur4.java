package analyseurs;
import java.util.List;
import java.util.Map;

import java.util.Collections;
import java.util.HashMap;

public class Compteur4 implements AnalyseurTexte{

	@Override
	public Map<String, Long> occurrencesParMot(final List<String> mots) {
		Map<String, Long> counts = new HashMap<String,Long>();
		tri(mots);
		for(int i=0;i<mots.size();i++){
			String currentWord = mots.get(i);
			Long n = 1L;
			i++;
			while(i<mots.size() && mots.get(i).equals(currentWord)){
				n++;
				i++;
			}
			i--;
			counts.put(currentWord, n);
		}
		return counts;
	}

	public void tri(final List<String> mots) {
		Collections.sort(mots);
	}

}
