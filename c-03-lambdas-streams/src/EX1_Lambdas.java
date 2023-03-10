import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class EX1_Lambdas {
	public static void main(String[] args) {
		System.out.println("-------------------------");
		UnaryOperator<Double> carre = x->x*x;
		UnaryOperator<Double> racine = x->Math.sqrt(x);
		System.out.println("2² = "+carre.apply(2d));
		System.out.println("racine(2) = "+racine.apply(2d));
		
		System.out.println("-------------------------");
		BinaryOperator<Integer> add = (x,y)->x+y;
		BinaryOperator<Integer> mult = (x,y)->x*y;
		System.out.println("2+3="+add.apply(2,3));
		System.out.println("2*3="+mult.apply(2,3));
		
		System.out.println("-------------------------");
		Consumer<Object> afficher = s->System.out.println(s);
		afficher.accept("Hello world");
		
		System.out.println("-------------------------");
		System.out.println("calculer(add,20,2)="+calculer(add,20,2));
		System.out.println("calculer(mult,20,2)="+calculer(mult,20,2));
		
		System.out.println("-------------------------");
		BiConsumer<UnaryOperator<Double>, Double> calcul = (op,x)->System.out.println(op.apply(x));
		calcul.accept(racine, 5d);
		calcul.accept(carre, 5d);

	}
	private static int calculer(BinaryOperator<Integer> op, int a, int b) {
		return op.apply(a, b);
	}
}
