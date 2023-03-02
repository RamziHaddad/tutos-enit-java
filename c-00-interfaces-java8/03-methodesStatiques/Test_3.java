import static pkg.MonInterface.mStatique;

import pkg.MaClasse;
import pkg.MonInterface;
public class Test_3 {

	public static void main(String[] args) {
		MonInterface a = new MaClasse();
		a.mAbstraite("Hello");
		MonInterface.mStatique("Hello");
		mStatique("world");

	}

}
