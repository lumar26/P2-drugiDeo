package ispravka_koda;

public class StringIspisivac3 {
	public static void ispisiKvadrat(String[] niz) {
		String prazno = "";
		int j = 0;
		while(j < niz[0].length()) {
			prazno = prazno + " ";
			j++;
		}
		System.out.println('*' + niz[0] + '*');
		for (int i = 0; i < niz[1].length(); i++) 
			System.out.println(niz[1].charAt(i) + prazno + niz[2].charAt(i));
		System.out.println('*' + niz[3] + '*');
	}
}
