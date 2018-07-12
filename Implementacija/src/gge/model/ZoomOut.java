package gge.model;

import java.awt.event.MouseEvent;

public class ZoomOut extends StanjeAplikacije {
	private final int ZOOM_FACTOR = 5;

	@Override
	public void mouseEvent(MouseEvent e) {
		return;
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
		return;
	}

	@Override
	public void plusButtonReleasedEvent() {
		return;
	}

	@Override
	public void entry() {
		this.aplikacija.izmeniZoomFactor(-this.ZOOM_FACTOR);
	}

	@Override
	public void kliknutoNaZnakPregleda() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kliknutoNaZnakBrisanja() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kliknutoNaZnakCrtanjaStanja() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kliknutoNaZnakCrtanjaTranzicije() {
		// TODO Auto-generated method stub

	}

}
