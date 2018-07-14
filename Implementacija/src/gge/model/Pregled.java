package gge.model;

import java.awt.event.MouseEvent;

public class Pregled extends StanjeAplikacije {

	public Pregled() {
		super();
	}

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
	}

	@Override
	public void minusButtonPressedEvent() {
		this.aplikacija.promeniStanje(new ZoomOut());
	}

	@Override
	public void minusButtonReleasedEvent() {
	}

	@Override
	public void plusButtonPressedEvent() {
		this.aplikacija.promeniStanje(new ZoomIn());
	}

	@Override
	public void plusButtonReleasedEvent() {
	}

	@Override
	public void entry() {
	}

	@Override
	public void kliknutoNaZnakPregleda() {
	}

	@Override
	public void kliknutoNaZnakBrisanja() {
		this.aplikacija.promeniStanje(new Brisanje());
	}

	@Override
	public void kliknutoNaZnakCrtanjaStanja() {
		this.aplikacija.promeniStanje(new CrtanjeStanja());
	}

	@Override
	public void kliknutoNaZnakCrtanjaTranzicije() {
		this.aplikacija.promeniStanje(new BiranjePolaznogStanjaTranzicije());
	}

}
