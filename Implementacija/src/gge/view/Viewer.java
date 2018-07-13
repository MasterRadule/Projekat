package gge.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import gge.model.Aplikacija;
import gge.model.Dokument;
import gge.model.GraphElement;
import gge.model.Stanje;
import gge.model.TipDokumenta;
import gge.model.Tranzicija;

@SuppressWarnings("serial")
public class Viewer extends JPanel implements Observer {
	protected Aplikacija model;
	protected TipDokumenta dokument;
	protected Map<GraphElement, ElementPainter> elementPainters;

	public Viewer(Aplikacija model, TipDokumenta dok) {
		// TODO: implement
		this.dokument = dok;
		this.model = model;
		elementPainters = new HashMap<GraphElement, ElementPainter>();
		Controller controler = new Controller();
		addMouseListener(controler); // view je panel, i prosledimo mu kontroler

		// metoda da se view prijavi modelu da hoce da slusa izmene
		model.addObserver(this);
	}

	/**
	 * @param g
	 */
	protected void paintComponent(Graphics g) {
		// TODO: implement
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Dokument noviDokument = null;

		switch (this.dokument) {
		case AccessPermit:
			noviDokument = this.model.getAccessPermit();
			break;
		case SwitchOrder:
			noviDokument = this.model.getSwitchOrder();
			break;
		case SwitchRequest:
			noviDokument = this.model.getSwitchRequest();
			break;
		}

		/*
		 * int w = this.getWidth(); int h = this.getHeight();
		 * 
		 * Font font = g2.getFont().deriveFont(16f); g2.setFont(font);
		 * 
		 * FontRenderContext frc = g2.getFontRenderContext();
		 * 
		 * int textWidth; int textHeight; LineMetrics lm;
		 * 
		 * int rectX; int rectY;
		 * 
		 * int rectW; int rectH;
		 */
		for (Object value : noviDokument.getElementiDokumenta().values()) {
			if (value instanceof Stanje) {
				g2.draw(((Stanje) value).getPravougaonik());
			} else {
				g2.draw(((Tranzicija) value).getLinija());
				g2.draw(((Tranzicija) value).getKrug());
			}
		}
		/*
		 * if (value instanceof Stanje && ((Stanje) value).getPravougaonik() ==
		 * null) { textWidth = (int) font.getStringBounds(((Stanje)
		 * value).getDisplayName(), frc).getWidth(); lm =
		 * font.getLineMetrics(((Stanje) value).getDisplayName(), frc);
		 * textHeight = (int) (lm.getAscent() + lm.getDescent());
		 * 
		 * rectX = ((Stanje) value).getTekstX() - 10; rectY = ((Stanje)
		 * value).getTesktY() - 10;
		 * 
		 * rectW = textWidth + 10; rectH = textHeight + 10;
		 * 
		 * MyRectangle elem = new MyRectangle(new Point2D.Double(rectX, rectY),
		 * new Dimension(rectW, rectH));
		 * 
		 * MyRectPainter p = new MyRectPainter(elem); p.paint(g2);
		 * g.drawString(((Stanje) value).getDisplayName(), ((Stanje)
		 * value).getTekstX(), ((Stanje) value).getTesktY());
		 * 
		 * ((Stanje) value).setPravougaonik((Rectangle2D) p.shape); } }
		 */

		/*
		for (ElementPainter painter : elementPainters.values()) {
			painter.paint(g2);
		}*/
		// repaint();
		// ovu metodu poziva sistem
		// ako hocemo da kazemo sistemu da treba da se pozove pozovemo
		// repaint();
	}

	public Aplikacija getModel() {
		return model;
	}

	/**
	 * @param newGGEModel
	 */
	public void setModel(Aplikacija newModel) {
		this.model = newModel;
	}

	public List<ElementPainter> getElementPainters() { // obrisati ovu metodu!
		/*
		 * if (elementPainters == null) elementPainters = new
		 * ArrayList<ElementPainter>(); return elementPainters;
		 */
		return null;
	}

	public Iterator<ElementPainter> getIteratorElementPainters() {
		if (elementPainters == null)
			elementPainters = new HashMap<GraphElement, ElementPainter>();
		return elementPainters.values().iterator();
	}

	/**
	 * @param newElementPainter
	 */
	public void addElementPainters(ElementPainter newElementPainter) {
		if (newElementPainter == null)
			return;
		if (this.elementPainters == null)
			this.elementPainters = new HashMap<GraphElement, ElementPainter>();
		if (!this.elementPainters.containsKey(newElementPainter.getElement()))
			this.elementPainters.put(newElementPainter.getElement(), newElementPainter);
	}

	/**
	 * @param oldElementPainter
	 */
	public void removeElementPainters(ElementPainter oldElementPainter) {
		if (oldElementPainter == null)
			return;
		if (this.elementPainters != null)
			if (this.elementPainters.containsKey(oldElementPainter.getElement()))
				this.elementPainters.remove(oldElementPainter.getElement());
	}

	public void removeAllElementPainters() {
		if (elementPainters != null)
			elementPainters.clear();
	}

	public class Controller implements MouseListener {
		public void mousePressed(MouseEvent e) {
			/*
			 * MyRectangle elem = new MyRectangle(new
			 * Point2D.Double(e.getX(),e.getY()), new Dimension(140,50));
			 * MyRectPainter p = new MyRectPainter(elem); addElementPainters(p);
			 * //model.addElements(elem);
			 */
			Aplikacija.getInstance().mouseEvent(e, dokument);
		}

		public void mouseReleased(MouseEvent e) {
			// TODO: implement
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		repaint();
	}

	public TipDokumenta getDokument() {
		return dokument;
	}

	public void setDokument(TipDokumenta dokument) {
		this.dokument = dokument;
	}

}