package popis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import popis.izuzeci.StatistikaException;

public class Domacinstvo {
	private String mesto;
	private int brojOdraslih;
	private int brojDece;
	private double mesecnaPrimanja;

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		if (mesto == null || mesto.length() < 5 || mesto.length() > 13)
			throw new StatistikaException("Naziv mesta nije odgovarajuci!");
		else
			this.mesto = mesto;
	}

	public int getBrojOdraslih() {
		return brojOdraslih;
	}

	public void setBrojOdraslih(int brojOdraslih) {
		if (brojOdraslih < 0)
			throw new StatistikaException("Broj odraslih je manji od 0");
		else
			this.brojOdraslih = brojOdraslih;
	}

	public int getBrojDece() {
		return brojDece;
	}

	public void setBrojDece(int brojDece) {
		if (brojDece < 0)
			throw new StatistikaException("Broj dece je manji od 0");
		else
			this.brojDece = brojDece;
	}

	public double getMesecnaPrimanja() {
		return mesecnaPrimanja;
	}

	public void setMesecnaPrimanja(double mesecnaPrimanja) {
		if (mesecnaPrimanja < 0)
			throw new StatistikaException("Mesecna primanja su manja od 0");
		this.mesecnaPrimanja = mesecnaPrimanja;
	}

	@Override
	public String toString() {
		return "Naziv mesta: " + this.mesto + "\t Broj odraslih: " + this.brojOdraslih + "\t Broj dece: "
				+ this.brojDece + "\n Prosecna mesecna primanja po clanu: " + this.mesecnaPrimanja;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Domacinstvo))
			return false;

		return ((Domacinstvo) obj).getBrojDece() == this.brojDece
				&& ((Domacinstvo) obj).getBrojOdraslih() == this.brojOdraslih
				&& ((Domacinstvo) obj).getMesecnaPrimanja() == this.mesecnaPrimanja
				&& ((Domacinstvo) obj).getMesto().equals(this.mesto);
	}

}
