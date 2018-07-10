package gge.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dokument {
	private HashMap<Integer, ElementDokumenta> elementiDokumenta;
	private ArrayList<Polje> polja;
	private ArrayList<StateSemantic> semantika;

	public Dokument() {
		super();
	}

	public Dokument(HashMap<Integer, ElementDokumenta> elementiDokumenta, ArrayList<Polje> polja,
			ArrayList<StateSemantic> semantika) {
		super();
		this.elementiDokumenta = elementiDokumenta;
		this.polja = polja;
		this.semantika = semantika;
	}

}
