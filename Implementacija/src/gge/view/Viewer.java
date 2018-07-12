package gge.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import gge.model.Aplikacija;
import gge.model.GraphElement;
import gge.model.MyRectangle;

@SuppressWarnings("serial")
public class Viewer extends JPanel implements Observer {
	protected Aplikacija model;
	protected Map<GraphElement, ElementPainter> elementPainters;

	public Viewer(Aplikacija model) {
		// TODO: implement
		this.model = model;
		elementPainters = new HashMap<GraphElement, ElementPainter>();
		Controller controler = new Controller();
		addMouseListener(controler); //view je panel, i prosledimo mu kontroler
		
		//metoda da se view prijavi modelu da hoce da slusa izmene
		model.addObserver(this);
	}

	/** @param g */
	protected void paintComponent(Graphics g) {
		// TODO: implement
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(ElementPainter painter : elementPainters.values()){
			painter.paint(g2);
		}
		//repaint();
		//ovu metodu poziva sistem
		//ako hocemo da kazemo sistemu da treba da se pozove pozovemo repaint();
	}


	public Aplikacija getModel() {
		return model;
	}

	/** @param newGGEModel */
	public void setModel(Aplikacija newModel) {
		this.model = newModel;
	}

		
	public List<ElementPainter> getElementPainters() {   // obrisati ovu metodu!
		/*if (elementPainters == null)
			elementPainters = new ArrayList<ElementPainter>();
		return elementPainters;*/
		return null;
	}

	public Iterator<ElementPainter> getIteratorElementPainters() {
		if (elementPainters == null)
			elementPainters = new HashMap<GraphElement, ElementPainter>();
		return elementPainters.values().iterator();
	}

	/** @param newElementPainter */
	public void addElementPainters(ElementPainter newElementPainter) {
		if (newElementPainter == null)
			return;
		if (this.elementPainters == null)
			this.elementPainters = new HashMap<GraphElement, ElementPainter>();
		if (!this.elementPainters.containsKey(newElementPainter.getElement()))
			this.elementPainters.put(newElementPainter.getElement(), newElementPainter);
	}

	/** @param oldElementPainter */
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
		/** @param e */
		public void mousePressed(MouseEvent e) {
			MyRectangle elem = new MyRectangle(new Point2D.Double(e.getX(),e.getY()), new Dimension(140,50));
			MyRectPainter p = new MyRectPainter(elem);
			addElementPainters(p);
			//model.addElements(elem);
		}

		/** @param e */
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

}