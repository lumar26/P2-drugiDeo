package autobuska_stanica;

import java.util.ArrayList;
import java.util.List;

import autobuska_stanica.rezervacije.RezervacijaKarata;

public class AutobuskaStanica implements RezervacijaKarata {

	private List<Polazak> polasci = new ArrayList<Polazak>();

	@Override
	public void unesiPolazak(Polazak polazak) throws RuntimeException {
		if (polazak == null || postojiUListi(polazak))
			throw new RuntimeException("Polazak je null ili vec postoji u listi");
		else polasci.add(0, polazak);

	}

	@Override
	public boolean rezervisiKarte(String destinacija, int brojKarata) {
		for (Polazak polazak : polasci) {
			if(polazak.getDestinacija().equals(destinacija) && polazak.getBrojSlobodnihMesta() > 0) {
				polazak.setBrojSlobodnihMesta(polazak.getBrojSlobodnihMesta()-1);
				return true;
			}
		}
		return false;
	}

	public List<Polazak> getPolasci() {
		return polasci;
	}


	public boolean postojiUListi(Polazak p) {
		for (Polazak polazak : polasci) {
			if (p.equals(polazak))
				return true;
		}
		return false;
	}
}
