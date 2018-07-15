package gge.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Pregled extends StanjeAplikacije {

	public Pregled() {
		super();
	}

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
		if(e.getClickCount() < 2) return;
		
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

		ElementDokumenta elementOdabran = null;

		for (Object value : noviDokument.getElementiDokumenta().keySet()) {
			if (noviDokument.getElementiDokumenta().get(value) instanceof Stanje
					&& ((Stanje) noviDokument.getElementiDokumenta().get(value)).getPravougaonik()
							.contains(e.getPoint())) {
				this.aplikacija.otvoriProzorZaIzmenu(noviDokument.getElementiDokumenta().get(value));
				return;
			}
		}
		Rectangle2D rec = new Rectangle2D.Double(e.getPoint().getX() - 2, e.getPoint().getY() - 2, 4, 4);
		for (Object value : noviDokument.getElementiDokumenta().keySet()) {
			if (noviDokument.getElementiDokumenta().get(value) instanceof Tranzicija) {
				if (((Tranzicija) noviDokument.getElementiDokumenta().get(value)).getLinija().intersects(rec)
						|| ((Tranzicija) noviDokument.getElementiDokumenta().get(value)).getKrug().intersects(rec)) {
					this.aplikacija.otvoriProzorZaIzmenu(noviDokument.getElementiDokumenta().get(value));
					return;
				}
			}
		}
	}

	@Override
	public void minusButtonPressedEvent() {
		this.aplikacija.promeniStanje(new ZoomOut());
	}

	@Override
	public void minusButtonReleasedEvent() {
	}

	@Override
	public void plusButtonPressedEvent() {
		this.aplikacija.promeniStanje(new ZoomIn());
	}

	@Override
	public void plusButtonReleasedEvent() {
	}

	@Override
	public void entry() {
	}

	@Override
	public void kliknutoNaZnakPregleda() {
	}

	@Override
	public void kliknutoNaZnakBrisanja() {
		this.aplikacija.promeniStanje(new Brisanje());
	}

	@Override
	public void kliknutoNaZnakCrtanjaStanja() {
		this.aplikacija.promeniStanje(new CrtanjeStanja());
	}

	@Override
	public void kliknutoNaZnakCrtanjaTranzicije() {
		this.aplikacija.promeniStanje(new BiranjePolaznogStanjaTranzicije());
	}

}
