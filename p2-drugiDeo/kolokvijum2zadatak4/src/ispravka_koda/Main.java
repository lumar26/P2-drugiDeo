package ispravka_koda;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<String>();
		lista.add("Pera");
		lista.add("Mika");
		lista.add("Zika");
		lista.add("Pera");
		lista.add("Pera");
		
		StringOperacije.izbaciDuplikate(lista);
	}

}
