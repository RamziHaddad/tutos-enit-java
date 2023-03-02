public class Test_1 {

	public static void main(String[] args) {
		Afficheur a = new AfficheurImpl1();
		a.afficher("hello world");
		a.afficher(0);
		System.out.println("--------");
		Afficheur b = new AfficheurImpl2();
		b.afficher("hello world");
		b.afficher(0);
		System.out.println("--------");
		Afficheur c = new Afficheur() {
			@Override
			public void afficher(String s) {
				System.out.println("Afficheur anonyme : "+s);				
			}
			@Override
			public void afficher(int i) {
				System.out.println("Afficheur anonyme : "+i);				
			}
		};
		c.afficher("hello world");
		c.afficher(0);

	}

}
