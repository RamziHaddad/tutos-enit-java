import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX2_Streams {
	public static void main(String[] args) {
		UnaryOperator<Integer> carre = x->x*x;
		Function<Integer,Double> doubler = x->2d*x;

		BinaryOperator<Integer> add = (x,y)->x+y;
		System.out.println("add.apply(1,3) = "+add.apply(1,3));
		Consumer<Object> afficher = s->System.out.println(s);
		//Supplier<Double> rnd = ()->Math.random();
		DoubleSupplier rnd = ()->Math.random();
		
		System.out.println("----------- 2x² pour x in [1..3]--------------");
		Stream.of(1,2,3).map(carre).map(doubler).forEach(afficher);

		System.out.println("--------les carrés des 3 premiers entiers-----------------");
		Stream.iterate(0,i->i+1).map(carre).limit(3).forEach(afficher);
		
		System.out.println("-------les 3 premiers carrés > 100-----------");
		Stream.iterate(0,i->i+1).map(carre).filter(i->i>100).limit(3).forEach(afficher);
		
		System.out.println("-------les 3 premiers carr impairs > 100-----------");
		Stream.iterate(0,i->i+1).map(carre).filter(i->i>100).filter(i->i%2!=0).limit(3).forEach(System.out::println);

		System.out.println("--------trois doubles <1 aléatoires -----------------");
		Stream.generate(() -> rnd.getAsDouble()).limit(3).forEach(afficher);
						
		System.out.println("--------trois doubles <1 aléatoires -----------------");
		new Random().doubles(3).forEach(System.out::println);
		
		System.out.println("--------trois doubles <1 aléatoires triés et affichés-----------------");
		Stream.iterate(1,i->i+1).limit(3).map(i->rnd.getAsDouble()).sorted().forEach(System.out::println);

		System.out.println("-----------flux de tye String--------------");
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(afficher);

		System.out.println("----------flux des entiers de >=1 et <10---------------");
		IntStream.range(1, 10).forEach(System.out::println);
		

	}
}
