package autobuska_stanica;

public class Polazak {
	private String destinacija;
	private int sat, minut;
	private int brojSlobodnihMesta;
	
	public Polazak(String destinacija, int brojSlobodnihMesta) {
		super();
		this.destinacija = destinacija;
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		if (destinacija == null || destinacija.equals(""))
			throw new RuntimeException("Destinacija nije uneta ybog nedozvoljenih vrednosti null ili \"\"");
		this.destinacija = destinacija;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		if (sat < 1 || sat > 24)
			throw new RuntimeException("Sat polaska nije u granicama");
		this.sat = sat;
	}

	public int getMinut() {
		return minut;
	}

	public void setMinut(int minut) {
		if (minut < 0 || minut > 59)
			throw new RuntimeException("Minut polaska nije u granicama");
		this.minut = minut;
	}

	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Polazak))
			return false;
		return ((Polazak) obj).getDestinacija().equals(this.destinacija) && ((Polazak) obj).getMinut() == this.minut
				&& ((Polazak) obj).getSat() == this.sat;
	}

	
}
