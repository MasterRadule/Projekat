package gge.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dokument {
	private HashMap<Integer, ElementDokumenta> elementiDokumenta;
	private ArrayList<Polje> polja;
	private ArrayList<StateSemantic> semantika;
	private TipDokumenta tip;

	public Dokument() {
	}

	public Dokument(TipDokumenta tip) {
		this.elementiDokumenta = new HashMap<Integer, ElementDokumenta>();
		this.polja = new ArrayList<Polje>();
		this.semantika = new ArrayList<StateSemantic>();
		this.tip = tip;
	}

	public HashMap<Integer, ElementDokumenta> getElementiDokumenta() {
		return elementiDokumenta;
	}

	public void setElementiDokumenta(HashMap<Integer, ElementDokumenta> elementiDokumenta) {
		this.elementiDokumenta = elementiDokumenta;
	}

	public ArrayList<Polje> getPolja() {
		return polja;
	}

	public void setPolja(ArrayList<Polje> polja) {
		this.polja = polja;
	}

	public ArrayList<StateSemantic> getSemantika() {
		return semantika;
	}

	public void setSemantika(ArrayList<StateSemantic> semantika) {
		this.semantika = semantika;
	}

	public TipDokumenta getTip() {
		return tip;
	}

	public void setTip(TipDokumenta tip) {
		this.tip = tip;
	}

}
