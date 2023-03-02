public class AfficheurImpl1 implements Afficheur{

	@Override
	public void afficher(String s) {
		System.out.println("Afficheur 1 : "+s);
	}

	@Override
	public void afficher(int i) {
		System.out.println("Afficheur 1 : "+i);
	}
	

}
