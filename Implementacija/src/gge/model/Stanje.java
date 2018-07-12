package gge.model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Stanje extends ElementDokumenta {
	private String displayName;
	private Rectangle2D pravougaonik;
	private int tekstX;
	private int tesktY;

	private ArrayList<OsobinePolja> polja;
	private ArrayList<StateSemantic> semantike;

	public Stanje() {
	}

	public Stanje(String displayName, Rectangle2D pravougaonik, int tekstX, int tesktY, ArrayList<OsobinePolja> polja,
			ArrayList<StateSemantic> semantike) {
		super();
		this.displayName = displayName;
		this.pravougaonik = pravougaonik;
		this.tekstX = tekstX;
		this.tesktY = tesktY;
		this.polja = polja;
		this.semantike = semantike;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Rectangle2D getPravougaonik() {
		return pravougaonik;
	}

	public void setPravougaonik(Rectangle2D pravougaonik) {
		this.pravougaonik = pravougaonik;
	}

	public int getTekstX() {
		return tekstX;
	}

	public void setTekstX(int tekstX) {
		this.tekstX = tekstX;
	}

	public int getTesktY() {
		return tesktY;
	}

	public void setTesktY(int tesktY) {
		this.tesktY = tesktY;
	}

	public ArrayList<OsobinePolja> getPolja() {
		return polja;
	}

	public void setPolja(ArrayList<OsobinePolja> polja) {
		this.polja = polja;
	}

	public ArrayList<StateSemantic> getSemantike() {
		return semantike;
	}

	public void setSemantike(ArrayList<StateSemantic> semantike) {
		this.semantike = semantike;
	}

}
