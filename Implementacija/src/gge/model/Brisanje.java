package gge.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Brisanje extends StanjeAplikacije {

	public Brisanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
		// TODO Auto-generated method stub
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
		Boolean stanje = false;
		Boolean tranzicija = false;
		
		for (Object value : noviDokument.getElementiDokumenta().keySet())
		{
			if (noviDokument.getElementiDokumenta().get(value) instanceof Stanje &&
					((Stanje) noviDokument.getElementiDokumenta().get(value)).getPravougaonik().contains(e.getPoint()))
			{
				elementZaBrisanje = (Stanje) noviDokument.getElementiDokumenta().get(value);
				stanje = true;
				break;
			}
			else if (noviDokument.getElementiDokumenta().get(value) instanceof Tranzicija)
			{
				Rectangle2D rec = new Rectangle2D.Double(e.getPoint().getX() - 2, e.getPoint().getY() - 2, 4, 4);
				if (((Tranzicija) noviDokument.getElementiDokumenta().get(value)).getLinija().intersects(rec) ||
						((Tranzicija) noviDokument.getElementiDokumenta().get(value)).getKrug().intersects(rec))
				{
					elementZaBrisanje = (Tranzicija) noviDokument.getElementiDokumenta().get(value);
					tranzicija = true;
					break;
				}
			}
		}
		
		if (stanje)
		{
			this.aplikacija.obrisiStanje((Stanje) elementZaBrisanje, dokument);
		}
		else if (tranzicija)
		{
			this.aplikacija.obrisiTranziciju((Tranzicija) elementZaBrisanje, dokument);
		}
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
