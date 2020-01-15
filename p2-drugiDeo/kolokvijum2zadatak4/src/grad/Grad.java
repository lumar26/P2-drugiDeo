package grad;

import java.io.Serializable;

import grad.exception.GradException;

public class Grad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String naziv = "nepoznat";
	private int brStanovnika = 0;
	
	

	public Grad(String naziv, int brStanovnika) {
		super();
		this.naziv = naziv;
		this.brStanovnika = brStanovnika;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.length() < 2)
			throw new GradException("Nije unet naziv ili je kraci od 2 slova!");

		this.naziv = naziv;
	}

	public int getBrStanovnika() {
		return brStanovnika;
	}

	public void setBrStanovnika(int brStanovnika) {
		if (brStanovnika < 1)
			throw new GradException("Broj stanovnika nije veci od nula");
		this.brStanovnika = brStanovnika;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Grad))
			throw new GradException("Objekat sa kojim se poredi grad nije instanca klase Grad");
		return ((Grad) obj).getNaziv().equals(this.naziv);
	}

}
