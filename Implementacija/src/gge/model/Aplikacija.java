package gge.model;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
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
			instance.accessPermit = new Dokument();
			instance.switchOrder = new Dokument();
			instance.switchRequest = new Dokument();
		}

		return instance;
	}

	public void kliknutoNaZnakPregleda() {
		/*
		 * promeniStanje(new Pregled()); System.out.println("Pregled");
		 */
		this.currentState.kliknutoNaZnakPregleda();
	}

	public void kliknutoNaZnakBrisanja() {
		/*
		 * promeniStanje(new Brisanje()); System.out.println("Brisanje");
		 */
		this.currentState.kliknutoNaZnakBrisanja();
	}

	public void kliknutoNaZnakCrtanjaStanja() {
		/*
		 * promeniStanje(new CrtanjeStanja()); System.out.println("Stanje");
		 */
		this.currentState.kliknutoNaZnakCrtanjaStanja();
	}

	public void kliknutoNaZnakCrtanjaTranzicije() {
		/*
		 * promeniStanje(new BiranjePolaznogStanjaTranzicije());
		 * System.out.println("Tranzicija");
		 */
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

		Rectangle2D pravougaonik = new Rectangle2D.Double(tekstX - 10, tekstY - 10, 200, 150);
		novoStanje.setPravougaonik(pravougaonik);

		switch (dokument) {
		case AccessPermit:
			this.accessPermit.getElementiDokumenta().put(Integer.parseInt(novoStanje.getEntityID()), novoStanje);
			break;
		case SwitchOrder:
			this.switchOrder.getElementiDokumenta().put(Integer.parseInt(novoStanje.getEntityID()), novoStanje);
			break;
		case SwitchRequest:
			this.switchRequest.getElementiDokumenta().put(Integer.parseInt(novoStanje.getEntityID()), novoStanje);
			break;
		}

		setChanged();
		notifyObservers();
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

		double x2 = odredisno.getPravougaonik().getX();
		double y2 = odredisno.getPravougaonik().getY();

		linija.setLine(x1, y1, x2, y2);

		novaTranzicija.setLinija(linija);

		Ellipse2D krug = new Ellipse2D.Double(x2, y2, 25, 25);

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
		notifyObservers();
	}

	public void obrisiStanje(Stanje stanje) {
		setChanged();
		notifyObservers();
	}

	public void obrisiTranziciju(Tranzicija tranzicija) {
		setChanged();
		notifyObservers();
	}

	public void otvoriProzorZaIzmenuStanja() {

	}

	public void otvoriProzorZaIzmenuTranzicije() {

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

}
