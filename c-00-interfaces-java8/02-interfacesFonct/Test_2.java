public class Test_2 {

	public static void main(String[] args) {
		Imprimante a = new ImprimanteLente();
		a.imprimer("Hello World");
		System.out.println("\n------");
		Imprimante b = s->System.out.println(s);
		b.imprimer("Hello World");
	}

}
