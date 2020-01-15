package vaterpolo;

import vaterpolo.exception.VaterpoloException;

public class Vaterpolista {
	private String imePrezime;
	private String klub;
	private int poeni;
	
	public Vaterpolista(String imePrezime, String klub, int poeni) {
		super();
		this.imePrezime = imePrezime;
		this.klub = klub;
		this.poeni = poeni;
	}


	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		if (imePrezime == null || imePrezime.equals(""))
			throw new VaterpoloException("Ime i prezime nisu uneti");
		this.imePrezime = imePrezime;
	}

	public String getKlub() {
		return klub;
	}

	public void setKlub(String klub) {
		if (klub == null || klub.equals(""))
			throw new VaterpoloException("Klub nije unet");
		this.klub = klub;
	}

	public int getPoeni() {
		return poeni;
	}

	public void setPoeni(int poeni) {
		if (poeni < 0)
			throw new VaterpoloException("Broj poena je manji od 0");
		this.poeni = poeni;
	}

	@Override
	public String toString() {
		return "Ime i prezime: " + this.imePrezime + "; klub: " + this.klub + "; poeni: " + this.poeni;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vaterpolista))
			throw new VaterpoloException("Dati objekat nije instanca klase Vaterpolista");
		return ((Vaterpolista) obj).getImePrezime().equals(this.imePrezime)
				&& ((Vaterpolista) obj).getKlub().equals(this.klub);
	}

	
}
