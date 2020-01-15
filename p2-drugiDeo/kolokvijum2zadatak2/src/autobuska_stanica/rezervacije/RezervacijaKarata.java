package autobuska_stanica.rezervacije;

import autobuska_stanica.Polazak;

public interface RezervacijaKarata {
	public void unesiPolazak(Polazak polazak) throws RuntimeException;
	public boolean rezervisiKarte(String destinacija, int brojKarata);
}
