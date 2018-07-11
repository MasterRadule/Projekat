package gge.model;

import java.awt.event.MouseEvent;

public abstract class StanjeAplikacije {
	public Aplikacija aplikacija;

	public abstract void mouseEvent(MouseEvent e);

	public abstract void minusButtonPressedEvent();

	public abstract void minusButtonReleasedEvent();

	public abstract void plusButtonPressedEvent();

	public abstract void plusButtonReleasedEvent();

	public abstract void entry();

}