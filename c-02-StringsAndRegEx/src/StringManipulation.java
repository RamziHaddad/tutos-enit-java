import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringManipulation {

	public static void main(String[] args) {

		String mot="abc";
		mot+="CDE";
		System.out.println(mot);

		StringBuilder s = new StringBuilder();
		s.append("chaine1");
		s.append("chaine2");
		s.append("chaine3");

		mot = s.toString();
		System.out.println(s.toString());
		
		
		String myString = String.format("%s %s %.2f %s %s, %s...", "I", "ate", 2.5056302, "blueberry", "pies", "oops");
		System.out.println(myString);
		
		String[] tokens = myString.split("\\W");
		System.out.println(Arrays.asList(tokens));
		
		System.out.println(mot.contains("chaine"));
		System.out.println(mot.startsWith("ch"));
		
		String[] strings = {"I'm", "running", "out", "of", "pangrams!"}; 
		myString = String.join(" ", strings);
		System.out.println(myString);
		
		StringJoiner fruitJoiner = new StringJoiner(", "); 
		fruitJoiner.add("Apples"); 
		fruitJoiner.add("Oranges"); 
		fruitJoiner.add("Bananas");
		
		
		List<String> awesomeAnimals = Arrays.asList("Shark", "Panda", "Armadillo"); 
		String animalString = awesomeAnimals.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println(animalString);
		
		
	}
	/*
	public static void stringConcatenation() {
		string += "some more data";
	}

	public static void stringConcatConcatenation() {
		stringConcat = stringConcat.concat("some more data");
	}

	public static void stringBuilderConcatenation() {
		stringBuilder.append("some more data");
	}

	public static void stringBufferConcatenation() {
		stringBuffer.append("some more data");
	}
	*/
}
