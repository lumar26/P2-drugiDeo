package ispravka_koda;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("BELO");
		lista.add("CRNO");
		
		lista.add("ZUTO");
		lista.add("SIVO");
		StringIspisivac4.ispisiParalelogram(lista);
	}

}
