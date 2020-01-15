package ispravka_koda;

import java.util.List;

public class StringOperacije {
	public static void izbaciDuplikate(List<String> lista) {
		boolean imaDuplikata;
		do {
			imaDuplikata = false;
			for (int i = 0; i < lista.size(); i++)
				if (lista.lastIndexOf(lista.get(i)) != i) {
					lista.remove(lista.lastIndexOf(lista.get(i)));
					imaDuplikata = true;
				}
		} while (imaDuplikata);
		System.out.println(lista);
	}
}
