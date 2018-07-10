package gge.model;

public class Tranzicija extends ElementDokumenta {
	private Stanje polaznoStanje;
	private Stanje odredisnoStanje;

	public Tranzicija() {
		super();
	}

	public Tranzicija(Stanje polaznoStanje, Stanje odredisnoStanje) {
		super();
		this.polaznoStanje = polaznoStanje;
		this.odredisnoStanje = odredisnoStanje;
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

}
