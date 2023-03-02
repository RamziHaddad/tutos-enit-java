public interface Afficheur {
	public abstract void afficher(String s);
	
	default void afficher(int i) {
		System.out.println("Affichage par defaut "+i);
	}
}
