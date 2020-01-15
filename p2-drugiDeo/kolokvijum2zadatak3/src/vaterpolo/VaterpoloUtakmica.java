package vaterpolo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaterpoloUtakmica {
	private List<Vaterpolista> vaterpolisti = new ArrayList<Vaterpolista>();

	public void napraviIzvestaj() {
		try (BufferedWriter out = new BufferedWriter(new FileWriter("izvestaj.txt"))) {
			for (Vaterpolista vaterpolista : vaterpolisti) {
				if (vaterpolista.getPoeni() >= 2)
					out.write(vaterpolista.getImePrezime() + "#" + vaterpolista.getKlub() + "#"
							+ vaterpolista.getPoeni() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dodajVaterpolistu(String imePrezime, String klub, int poeni) {
		Vaterpolista v = new Vaterpolista(imePrezime, klub, poeni);
		if (!postojiVaterpolistaUListi(v))
			vaterpolisti.add(v);
		else {
			try (BufferedWriter out = new BufferedWriter(new FileWriter("greske.txt"))) {
				out.write(v.toString() + "\n Vec postoji u listi");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void unesiVaterpolisteSaTastature() {
		Scanner in = new Scanner(System.in);
		String ime, klub;
		int poeni;
		for (int i = 0; i < 22; i++) {
			try {
				System.out.println("Unesite ime i prezime Vaterpoliste u formatu IME PREZIME: ");
				ime = in.nextLine().trim();
				System.out.println("Unesite naziv kluba za koji nastupa vaterpolista: ");
				klub = in.nextLine().trim();
				System.out.println("Unesite broj golova postignut na utakmici: ");
				poeni = Integer.parseInt(in.nextLine().trim());
				System.out.println("--------------------------------------------------------");
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				continue;
			}
			dodajVaterpolistu(ime, klub, poeni);
		}

	}

	public boolean postojiVaterpolistaUListi(Vaterpolista v) {
		for (Vaterpolista vaterpolista : vaterpolisti) {
			if (v.equals(vaterpolista))
				return true;
		}
		return false;
	}

}
