package gge.model;

import java.awt.event.MouseEvent;

public class CrtanjeStanja extends StanjeAplikacije {

	public CrtanjeStanja() {
		super();
	}

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
		this.aplikacija.dodajNovoStanje(dokument, e.getX(), e.getY());
		this.aplikacija.promeniStanje(new CrtanjeStanja());
	}

	@Override
	public void minusButtonPressedEvent() {
	}

	@Override
	public void minusButtonReleasedEvent() {
	}

	@Override
	public void plusButtonPressedEvent() {
	}

	@Override
	public void plusButtonReleasedEvent() {
	}

	@Override
	public void entry() {
	}

	@Override
	public void kliknutoNaZnakPregleda() {
		this.aplikacija.promeniStanje(new Pregled());
	}

	@Override
	public void kliknutoNaZnakBrisanja() {
	}

	@Override
	public void kliknutoNaZnakCrtanjaStanja() {
	}

	@Override
	public void kliknutoNaZnakCrtanjaTranzicije() {
	}

}
