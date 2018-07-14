package gge.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Brisanje extends StanjeAplikacije {

	public Brisanje() {
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

		ElementDokumenta elementZaBrisanje = null;

		for (Object value : noviDokument.getElementiDokumenta().keySet()) {
			if (noviDokument.getElementiDokumenta().get(value) instanceof Stanje
					&& ((Stanje) noviDokument.getElementiDokumenta().get(value)).getPravougaonik()
							.contains(e.getPoint())) {
				elementZaBrisanje = (Stanje) noviDokument.getElementiDokumenta().get(value);
				this.aplikacija.obrisiStanje((Stanje) elementZaBrisanje, dokument);
				return;
			}
		}
		Rectangle2D rec = new Rectangle2D.Double(e.getPoint().getX() - 2, e.getPoint().getY() - 2, 4, 4);
		for (Object value : noviDokument.getElementiDokumenta().keySet()) {
			if (noviDokument.getElementiDokumenta().get(value) instanceof Tranzicija) {
				if (((Tranzicija) noviDokument.getElementiDokumenta().get(value)).getLinija().intersects(rec)
						|| ((Tranzicija) noviDokument.getElementiDokumenta().get(value)).getKrug().intersects(rec)) {
					elementZaBrisanje = (Tranzicija) noviDokument.getElementiDokumenta().get(value);
					this.aplikacija.obrisiTranziciju((Tranzicija) elementZaBrisanje, dokument);
					return;
				}
			}
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
