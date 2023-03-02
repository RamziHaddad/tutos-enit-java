public class ImprimanteLente implements Imprimante{

	@Override
	public void imprimer(String s) {
		for(int i=0;i<s.length();i++) {
			System.out.print(s.charAt(i));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
