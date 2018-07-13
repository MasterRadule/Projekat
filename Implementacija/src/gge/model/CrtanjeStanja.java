package gge.model;

import java.awt.event.MouseEvent;

public class CrtanjeStanja extends StanjeAplikacije {

	public CrtanjeStanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub

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
		return;
	}

	@Override
	public void plusButtonReleasedEvent() {
		return;
	}

	@Override
	public void entry() {
		return;
	}

	@Override
	public void kliknutoNaZnakPregleda() {
		// TODO Auto-generated method stub
		this.aplikacija.promeniStanje(new Pregled());
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
