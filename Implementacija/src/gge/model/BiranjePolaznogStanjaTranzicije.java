package gge.model;

import java.awt.event.MouseEvent;

public class BiranjePolaznogStanjaTranzicije extends StanjeAplikacije {

	public BiranjePolaznogStanjaTranzicije() {
		super();
	}

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
		Dokument noviDokument = null;

		switch (dokument) {
		case AccessPermit:
			noviDokument = this.aplikacija.getAccessPermit();
			break;
		case SwitchOrder:
			noviDokument = this.aplikacija.getSwitchOrder();
			break;
		case SwitchRequest:
			noviDokument = this.aplikacija.getSwitchRequest();
			break;
		}

		Stanje polaznoStanje = null;
		Boolean nadjeno = false;

		for (Object value : noviDokument.getElementiDokumenta().values()) {
			if (value instanceof Stanje && ((Stanje) value).getPravougaonik().contains(e.getPoint())) {
				polaznoStanje = (Stanje) value;
				nadjeno = true;
				break;
			}
		}

		if (nadjeno) {
			this.aplikacija.promeniStanje(new BiranjeOdredisnogStanjaTranzicije(polaznoStanje));
		}
	}

	@Override
	public void minusButtonPressedEvent() {
	}

	@Override
	public void minusButtonReleasedEvent() {
	}

	@Override
	public void plusButtonPressedEvent() {
	}

	@Override
	public void plusButtonReleasedEvent() {
	}

	@Override
	public void entry() {
	}

	@Override
	public void kliknutoNaZnakPregleda() {
		this.aplikacija.promeniStanje(new Pregled());
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
