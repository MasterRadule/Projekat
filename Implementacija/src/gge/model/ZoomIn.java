package gge.model;

import java.awt.event.MouseEvent;

public class ZoomIn extends StanjeAplikacije {
	public ZoomIn() {
		super();
	}

	private final int ZOOM_FACTOR = 5;

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
	}

	@Override
	public void minusButtonPressedEvent() {
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
		this.aplikacija.promeniStanje(new Pregled());
	}

	@Override
	public void entry() {
		this.aplikacija.izmeniZoomFactor(this.ZOOM_FACTOR);
	}

	@Override
	public void kliknutoNaZnakPregleda() {
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
