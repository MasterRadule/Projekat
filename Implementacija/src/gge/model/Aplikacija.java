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

	private Aplikacija() {

	}

	public static Aplikacija getInstance() {
		if (instance == null)
			instance = new Aplikacija();

		return instance;
	}

	public void mouseEvent(MouseEvent e) {

	}

	public void minusButtonPressedEvent() {

	}

	public void minusButtonReleasedEvent() {

	}

	public void plusButtonPressedEvent() {

	}

	public void plusButtonReleasedEvent() {

	}

	public void dodajNovoStanje(int x, int y) {

	}

	public void dodajNovuTranziciju(Stanje polazno, Stanje odredisno) {

	}

	public void obrisiStanje(Stanje stanje) {

	}

	public void obrisiTranziciju(Tranzicija tranzicija) {

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

}
