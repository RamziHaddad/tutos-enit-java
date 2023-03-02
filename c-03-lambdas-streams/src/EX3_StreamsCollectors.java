import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EX3_StreamsCollectors {
	
	public static void main(String[] args) {
		List<Personne> l = Arrays.asList(new Personne("a",30,"V1"),new Personne("d",10,"V1"),new Personne("b",40,"V2"),new Personne("c",60,"V3"),new Personne("f",70,"V2"));
		
		System.out.println("\n---------------------");
		l.stream().sorted((p1,p2)->p1.age-p2.age).forEach(System.out::print);
		
		
		System.out.println("\n---------------------");
		l.stream().sorted((p1,p2)->p1.nom.compareTo(p2.nom)).forEach(System.out::print);
		
		System.out.println("\n---------------------");
		l.stream().filter(p->p.age<40).forEach(System.out::print);
		
		System.out.println("\n---------------------");
		List<Personne> jeunes = l.stream().filter(p->p.age<40).collect(Collectors.toList());
		System.out.println("jeunes "+jeunes);
		
		System.out.println("\n---------------------");
		Map<String, List<Personne>> parVille = l.stream().collect(Collectors.groupingBy(Personne::getVille));
		System.out.println(parVille);
		
		
		System.out.println("\n---------------------");
		Map<Boolean, List<Personne>> trancheAge = l.stream().collect(Collectors.groupingBy(p->p.age<40));
		System.out.println("tranche Age"+trancheAge);
		
		System.out.println("\n---------------------");
		//Function<Integer,String> classeur = a->{if(a<40) return "T1"; else return "T2";};
		Function<Integer,String> classeur = a->a<40?"T1":"T2";
		Map<String, List<Personne>> trancheAge2 = l.stream().collect(Collectors.groupingBy(p->classeur.apply(p.age)));
		System.out.println(trancheAge2);
		System.out.println("\n---------------------");
		Function<Personne,String> classeur3 = p->p.getAge()<40?"T1":"T2";
		Map<String, List<Personne>> trancheAge3 = l.stream().collect(Collectors.groupingBy(classeur3));
		System.out.println(trancheAge3);
		
		System.out.println("\n---------------------");
		Map<String, Double> moyenneParVille = l.stream().collect(Collectors.groupingBy(Personne::getVille, Collectors.averagingDouble(Personne::getAge)));
		System.out.println(moyenneParVille);
		
		System.out.println("\n---------------------");
		Map<String, IntSummaryStatistics> stats = l.stream().collect(Collectors.groupingBy(Personne::getVille, Collectors.summarizingInt(Personne::getAge)));
		System.out.println(stats);
		//ajouter une liste de voitures à la classe personne et faire des exercices (recours à flatMap) 
		l.stream().flatMap(p->p.getVoitures().stream()).forEach(System.out::println);

	}
}
class Personne{
	public String nom;
	public int age;
	public String ville;
	public List<Voiture> voitures = new ArrayList<>();
	public Personne(String nom, int age, String ville) {
		super();
		this.nom = nom;
		this.age = age;
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "[" + nom + "," + age + "," + ville + "]";
	}
	public String getNom() {
		return nom;
	}
	public int getAge() {
		return age;
	}
	public String getVille() {
		return ville;
	}
	public List<Voiture> getVoitures() {
		return voitures;
	}	
}

class Voiture {
	public String immatriculation;

	public String getImmatriculation() {
		return immatriculation;
	}

	@Override
	public String toString() {
		return "[immatriculation=" + immatriculation + "]";
	}
	
}

