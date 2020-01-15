package klinika.osoblje;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Lekar implements Serializable {
	private String imePrezime = "nepoznato";
	private GregorianCalendar datumZaposlenja;
	private String specijalnost = "nepoznato";
	
	

	public Lekar(String imePrezime, GregorianCalendar datumZaposlenja, String specijalnost) {
		super();
		this.imePrezime = imePrezime;
		this.datumZaposlenja = datumZaposlenja;
		this.specijalnost = specijalnost;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		if (imePrezime == null || imePrezime.equals(""))
			throw new RuntimeException("Los format imena i prezimena");
		this.imePrezime = imePrezime;
	}

	public GregorianCalendar getDatumZaposlenja() {
		return datumZaposlenja;
	}

	public void setDatumZaposlenja(GregorianCalendar datumZaposlenja) {
		if (datumZaposlenja == null || datumZaposlenja.after(new GregorianCalendar()))
			throw new RuntimeException("Neodgovarajuci datum");
		this.datumZaposlenja = datumZaposlenja;
	}

	public String getSpecijalnost() {
		return specijalnost;
	}

	public void setSpecijalnost(String specijalnost) {
		if (specijalnost == null || specijalnost.length() < 3)
			throw new RuntimeException("Specijalnos ne ispunjava kriterijume");
		this.specijalnost = specijalnost;
	}

	@Override
	public String toString() {
		return "Ime i prezime: " + this.imePrezime + "; datum zaposlenja: " + this.datumZaposlenja.getTime()
				+ "; specijalnost: " + this.specijalnost;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Lekar) && ((Lekar) obj).getDatumZaposlenja().equals(this.datumZaposlenja)
				&& ((Lekar) obj).getImePrezime().equals(this.imePrezime)
				&& ((Lekar) obj).getSpecijalnost().equals(this.specijalnost);
	}

}
