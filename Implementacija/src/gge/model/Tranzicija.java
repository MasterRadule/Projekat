package gge.model;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Tranzicija extends ElementDokumenta {
	private Stanje polaznoStanje;
	private Stanje odredisnoStanje;

	private Line2D linija;
	private Ellipse2D krug;

	public Tranzicija() {
		super();
	}

	public Tranzicija(Stanje polaznoStanje, Stanje odredisnoStanje, Line2D linija, Ellipse2D krug) {
		super();
		this.polaznoStanje = polaznoStanje;
		this.odredisnoStanje = odredisnoStanje;
		this.linija = linija;
		this.krug = krug;
	}

	public Stanje getPolaznoStanje() {
		return polaznoStanje;
	}

	public void setPolaznoStanje(Stanje polaznoStanje) {
		this.polaznoStanje = polaznoStanje;
	}

	public Stanje getOdredisnoStanje() {
		return odredisnoStanje;
	}

	public void setOdredisnoStanje(Stanje odredisnoStanje) {
		this.odredisnoStanje = odredisnoStanje;
	}

	public Line2D getLinija() {
		return linija;
	}

	public void setLinija(Line2D linija) {
		this.linija = linija;
	}

	public Ellipse2D getKrug() {
		return krug;
	}

	public void setKrug(Ellipse2D krug) {
		this.krug = krug;
	}

}