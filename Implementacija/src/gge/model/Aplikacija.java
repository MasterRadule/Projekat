package gge.model;

import java.awt.event.MouseEvent;
import java.util.Observable;

public class Aplikacija extends Observable {

	private static Aplikacija instance = null;
	private int zoomFactor = 100;

	private StanjeAplikacije currentState;

	private Dokument radniZahtev;
	private Dokument planRada;
	private Dokument sigurnosniDokument;

	private String putanjaDatoteke = null;

	private boolean izmenjenja = false;

	private Aplikacija() {
		this.currentState = new Pregled();
	}

	public static Aplikacija getInstance() {
		if (instance == null)
			instance = new Aplikacija();

		return instance;
	}

	public void kliknutoNaZnakPregleda() {
		promeniStanje(new Pregled());
		System.out.println("Pregled");
	}

	public void kliknutoNaZnakBrisanja() {
		promeniStanje(new Brisanje());
		System.out.println("Brisanje");
	}

	public void kliknutoNaZnakCrtanjaStanja() {
		promeniStanje(new CrtanjeStanja());
		System.out.println("Stanje");
	}

	public void kliknutoNaZnakCrtanjaTranzicije() {
		promeniStanje(new BiranjePolaznogStanjaTranzicije());
		System.out.println("Tranzicija");
	}

	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {

	}

	public void minusButtonPressedEvent() {

	}

	public void minusButtonReleasedEvent() {

	}

	public void plusButtonPressedEvent() {

	}

	public void plusButtonReleasedEvent() {

	}

	public void dodajNovoStanje(TipDokumenta dokument, int tekstX, int tekstY) {
		setChanged();
		notifyObservers();
	}

	public void dodajNovuTranziciju(TipDokumenta dokument, Stanje polazno, Stanje odredisno) {
		setChanged();
		notifyObservers();
	}

	public void obrisiStanje(Stanje stanje) {
		setChanged();
		notifyObservers();
	}

	public void obrisiTranziciju(Tranzicija tranzicija) {
		setChanged();
		notifyObservers();
	}

	public void otvoriProzorZaIzmenuStanja() {

	}

	public void otvoriProzorZaIzmenuTranzicije() {

	}

	public void izmeniZoomFactor(int zaKoliko) {
		this.zoomFactor += zaKoliko;
	}

	public void promeniStanje(StanjeAplikacije novoStanje) {
		this.currentState = novoStanje;
		novoStanje.entry();
	}

	public void ucitajModel() {

	}

	public void snimiModel() {

	}

	public void postojeIzmene() {

	}

	public void nePostojeIzmene() {

	}

	public StanjeAplikacije getCurrentState() {
		return currentState;
	}

	public void setCurrentState(StanjeAplikacije currentState) {
		this.currentState = currentState;
	}
	

}
