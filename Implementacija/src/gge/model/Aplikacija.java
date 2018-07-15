package gge.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class Aplikacija extends Observable {

	private int counter = 0;

	private static Aplikacija instance = null;
	private int zoomFactor = 100;

	private StanjeAplikacije currentState;

	private Dokument accessPermit;
	private Dokument switchOrder;
	private Dokument switchRequest;

	private String putanjaDatoteke = null;

	private boolean izmenjenja = false;

	private Aplikacija() {
	}

	public static Aplikacija getInstance() {
		if (instance == null) {
			instance = new Aplikacija();
			instance.currentState = new Pregled();
			instance.accessPermit = new Dokument(TipDokumenta.AccessPermit);
			instance.switchOrder = new Dokument(TipDokumenta.SwitchOrder);
			instance.switchRequest = new Dokument(TipDokumenta.SwitchRequest);
		}

		return instance;
	}

	public void kliknutoNaZnakPregleda() {
		this.currentState.kliknutoNaZnakPregleda();
	}

	public void kliknutoNaZnakBrisanja() {
		this.currentState.kliknutoNaZnakBrisanja();
	}

	public void kliknutoNaZnakCrtanjaStanja() {
		this.currentState.kliknutoNaZnakCrtanjaStanja();
	}

	public void kliknutoNaZnakCrtanjaTranzicije() {
		this.currentState.kliknutoNaZnakCrtanjaTranzicije();
	}

	public void mouseEvent(MouseEvent e, TipDokumenta dokument) {
		this.currentState.mouseEvent(e, dokument);
	}

	public void minusButtonPressedEvent() {
	}

	public void minusButtonReleasedEvent() {
	}

	public void plusButtonPressedEvent() {
	}

	public void plusButtonReleasedEvent() {
	}

	public void dodajNovoStanje(TipDokumenta dokument, int tekstX, int tekstY) {
		Stanje novoStanje = new Stanje();
		novoStanje.setDisplayName("State" + this.counter);
		novoStanje.setEntityID(Integer.toString(this.counter));
		this.counter++;

		novoStanje.setTekstX(tekstX);
		novoStanje.setTesktY(tekstY);

		switch (dokument) {
		case AccessPermit:
			novoStanje.setDokument(this.accessPermit);
			this.accessPermit.getElementiDokumenta().put(Integer.parseInt(novoStanje.getEntityID()), novoStanje);
			break;
		case SwitchOrder:
			novoStanje.setDokument(this.switchOrder);
			this.switchOrder.getElementiDokumenta().put(Integer.parseInt(novoStanje.getEntityID()), novoStanje);
			break;
		case SwitchRequest:
			novoStanje.setDokument(this.switchRequest);
			this.switchRequest.getElementiDokumenta().put(Integer.parseInt(novoStanje.getEntityID()), novoStanje);
			break;
		}

		setChanged();
		notifyObservers(TipNotifikacije.promenaRadnePovrsine);
	}

	public void dodajNovuTranziciju(TipDokumenta dokument, Stanje polazno, Stanje odredisno) {
		Tranzicija novaTranzicija = new Tranzicija();
		novaTranzicija.setPolaznoStanje(polazno);
		novaTranzicija.setOdredisnoStanje(odredisno);

		novaTranzicija.setEntityID(Integer.toString(this.counter));
		this.counter++;

		Line2D linija = new Line2D.Double();

		double x1 = polazno.getPravougaonik().getX();
		double y1 = polazno.getPravougaonik().getY();

		double x2 = odredisno.getPravougaonik().getX() + odredisno.getPravougaonik().getWidth();
		double y2 = odredisno.getPravougaonik().getY();

		linija.setLine(x1, y1, x2, y2);
		linija.getBounds().height = 5;
		novaTranzicija.setLinija(linija);

		novaTranzicija.setPolaznoStanje(polazno);
		novaTranzicija.setOdredisnoStanje(odredisno);

		Ellipse2D.Double krug = new Ellipse2D.Double(x2, y2, 25, 25);

		novaTranzicija.setKrug(krug);

		switch (dokument) {
		case AccessPermit:
			this.accessPermit.getElementiDokumenta().put(Integer.parseInt(novaTranzicija.getEntityID()),
					novaTranzicija);
			break;
		case SwitchOrder:
			this.switchOrder.getElementiDokumenta().put(Integer.parseInt(novaTranzicija.getEntityID()), novaTranzicija);
			break;
		case SwitchRequest:
			this.switchRequest.getElementiDokumenta().put(Integer.parseInt(novaTranzicija.getEntityID()),
					novaTranzicija);
			break;
		}

		setChanged();
		notifyObservers(TipNotifikacije.promenaRadnePovrsine);
	}

	public void obrisiStanje(Stanje stanje, TipDokumenta dokument) {
		Dokument noviDokument = null;

		switch (dokument) {
		case AccessPermit:
			noviDokument = this.getAccessPermit();
			break;
		case SwitchOrder:
			noviDokument = this.getSwitchOrder();
			break;
		case SwitchRequest:
			noviDokument = this.getSwitchRequest();
			break;
		}

		Iterator it = noviDokument.getElementiDokumenta().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (noviDokument.getElementiDokumenta().get(pair.getKey()) instanceof Tranzicija) {
				if (((Tranzicija) noviDokument.getElementiDokumenta().get(pair.getKey())).getPolaznoStanje() == stanje
						|| ((Tranzicija) noviDokument.getElementiDokumenta().get(pair.getKey()))
								.getOdredisnoStanje() == stanje) {
					it.remove();
				}
			}
		}

		for (Object value : noviDokument.getElementiDokumenta().keySet()) {
			if (noviDokument.getElementiDokumenta().get(value) instanceof Stanje) {
				if (((Stanje) noviDokument.getElementiDokumenta().get(value)) == stanje) {
					noviDokument.getElementiDokumenta().remove(value);
					break;
				}
			}
		}

		setChanged();
		notifyObservers(TipNotifikacije.promenaRadnePovrsine);
	}

	public void obrisiTranziciju(Tranzicija tranzicija, TipDokumenta dokument) {
		Dokument noviDokument = null;

		switch (dokument) {
		case AccessPermit:
			noviDokument = this.getAccessPermit();
			break;
		case SwitchOrder:
			noviDokument = this.getSwitchOrder();
			break;
		case SwitchRequest:
			noviDokument = this.getSwitchRequest();
			break;
		}

		for (Object value : noviDokument.getElementiDokumenta().keySet()) {
			if (noviDokument.getElementiDokumenta().get(value) instanceof Tranzicija) {
				if (((Tranzicija) noviDokument.getElementiDokumenta().get(value)) == tranzicija) {
					noviDokument.getElementiDokumenta().remove(value);
					break;
				}
			}
		}

		setChanged();
		notifyObservers(TipNotifikacije.promenaRadnePovrsine);
	}

	public void otvoriProzorZaIzmenu(ElementDokumenta element) {
		setChanged();
		notifyObservers(element);

	}

	public void izmeniZoomFactor(int zaKoliko) {
		this.zoomFactor += zaKoliko;
	}

	public void promeniStanje(StanjeAplikacije novoStanje) {
		this.currentState = novoStanje;
		novoStanje.entry();
	}

	public void ucitajModel() {
	}

	public void snimiModel() {
	}

	public void postojeIzmene() {
	}

	public void nePostojeIzmene() {
	}

	public StanjeAplikacije getCurrentState() {
		return currentState;
	}

	public void setCurrentState(StanjeAplikacije currentState) {
		this.currentState = currentState;
	}

	public Dokument getAccessPermit() {
		return accessPermit;
	}

	public void setAccessPermit(Dokument accessPermit) {
		this.accessPermit = accessPermit;
	}

	public Dokument getSwitchOrder() {
		return switchOrder;
	}

	public void setSwitchOrder(Dokument switchOrder) {
		this.switchOrder = switchOrder;
	}

	public Dokument getSwitchRequest() {
		return switchRequest;
	}

	public void setSwitchRequest(Dokument switchRequest) {
		this.switchRequest = switchRequest;
	}

	public int getZoomFactor() {
		return zoomFactor;
	}

}
