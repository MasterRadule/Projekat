package gge.model;

import java.util.ArrayList;

public class Stanje extends ElementDokumenta {
	private String displayName;
	private ArrayList<OsobinePolja> polja;
	private ArrayList<StateSemantic> semantika;

	public Stanje() {
		super();
	}

	public Stanje(String displayName, ArrayList<OsobinePolja> polja, ArrayList<StateSemantic> semantika) {
		super();
		this.displayName = displayName;
		this.polja = polja;
		this.semantika = semantika;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public ArrayList<OsobinePolja> getPolja() {
		return polja;
	}

	public void setPolja(ArrayList<OsobinePolja> polja) {
		this.polja = polja;
	}

	public ArrayList<StateSemantic> getSemantika() {
		return semantika;
	}

	public void setSemantika(ArrayList<StateSemantic> semantika) {
		this.semantika = semantika;
	}

}
