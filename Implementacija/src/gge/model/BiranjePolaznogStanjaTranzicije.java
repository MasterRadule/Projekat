package gge.model;

import java.awt.event.MouseEvent;

public class BiranjePolaznogStanjaTranzicije extends StanjeAplikacije {

	public BiranjePolaznogStanjaTranzicije() {
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
		
		Stanje polaznoStanje = null;
		Boolean nadjeno = false;
		
		for (Object value : noviDokument.getElementiDokumenta().values())
		{
			if (value instanceof Stanje && ((Stanje) value).getPravougaonik().contains(e.getPoint()))
			{
				polaznoStanje = (Stanje) value;
				nadjeno = true;
				break;
			}
		}
		
		if (nadjeno)
		{
			this.aplikacija.promeniStanje(new BiranjeOdredisnogStanjaTranzicije(polaznoStanje));
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
