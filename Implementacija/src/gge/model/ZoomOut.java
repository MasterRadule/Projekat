package gge.model;

import java.awt.event.MouseEvent;

public class ZoomOut extends StanjeAplikacije {
	public ZoomOut() {
		super();
	}

	private final int ZOOM_FACTOR = 5;

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
	}

	@Override
	public void minusButtonPressedEvent() {
		this.aplikacija.promeniStanje(new ZoomOut());
	}

	@Override
	public void minusButtonReleasedEvent() {
		this.aplikacija.promeniStanje(new Pregled());
	}

	@Override
	public void plusButtonPressedEvent() {
	}

	@Override
	public void plusButtonReleasedEvent() {
	}

	@Override
	public void entry() {
		this.aplikacija.izmeniZoomFactor(-this.ZOOM_FACTOR);
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
