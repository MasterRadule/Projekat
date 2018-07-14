package gge.model;

import java.awt.event.MouseEvent;

public abstract class StanjeAplikacije {
	public Aplikacija aplikacija;

	public StanjeAplikacije() {
		super();
		this.aplikacija = Aplikacija.getInstance();
	}

	public abstract void mouseEvent(MouseEvent e, TipDokumenta dokument);

	public abstract void kliknutoNaZnakPregleda();

	public abstract void kliknutoNaZnakBrisanja();

	public abstract void kliknutoNaZnakCrtanjaStanja();

	public abstract void kliknutoNaZnakCrtanjaTranzicije();

	public abstract void minusButtonPressedEvent();

	public abstract void minusButtonReleasedEvent();

	public abstract void plusButtonPressedEvent();

	public abstract void plusButtonReleasedEvent();

	public abstract void entry();

}
