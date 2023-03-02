import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX2_Streams {
	public static void main(String[] args) {
		UnaryOperator<Integer> carre = x->x*x;
		Function<Integer,Double> doubler = x->2d*x;

		BinaryOperator<Integer> add = (x,y)->x+y;
		Consumer<Object> afficher = s->System.out.println(s);
		//Supplier<Double> rnd = ()->Math.random();
		DoubleSupplier rnd = ()->Math.random();
		
		System.out.println("-------------------------");
		Stream.of(1,2,3,4,5).map(carre).map(doubler).forEach(afficher);

		System.out.println("-------------------------");
		Stream.iterate(0,i->i+1).map(carre).limit(5).forEach(afficher);
		
		System.out.println("-------------------------");
		Stream.iterate(0,i->i+1).map(carre).filter(i->i>100).limit(2).forEach(afficher);
		
		System.out.println("-------------------------");
		Stream.iterate(0,i->i+1).map(carre).filter(i->i>100).filter(i->i%2!=0).limit(2).forEach(System.out::println);

		System.out.println("-------------------------");
		Stream.iterate(1,i->i+1).limit(10).map(i->rnd.getAsDouble()).sorted().forEach(System.out::println);

		System.out.println("-------------------------");
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		streamBuilder.forEach(afficher);
		
		System.out.println("-------------------------");
		Stream.generate(() -> rnd.getAsDouble()).limit(3).forEach(afficher);
		
		System.out.println("-------------------------");
		new Random().doubles(3).forEach(System.out::println);
		
		System.out.println("-------------------------");
		IntStream.range(1, 20).forEach(System.out::println);
		

	}
}
