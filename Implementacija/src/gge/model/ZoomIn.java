package gge.model;

import java.awt.event.MouseEvent;

public class ZoomIn extends StanjeAplikacije {
	public ZoomIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final int ZOOM_FACTOR = 5;

	@Override
	public void mouseEvent(MouseEvent e) {
		return;
	}

	@Override
	public void minusButtonPressedEvent() {
		return;
	}

	@Override
	public void minusButtonReleasedEvent() {
		return;
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
