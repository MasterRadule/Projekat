package gge.model;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class GraphElement {
	protected Point2D position;
	protected Dimension2D size;
	
	public GraphElement(Point2D newPosition, Dimension2D newSize) {
		position = newPosition;
		size = newSize;
	}

	public Point2D getPosition() {
		return position;
	}

	/** @param newPosition */
	public void setPosition(Point2D newPosition) {
		position = newPosition;
	}

	public Dimension2D getSize() {
		return size;
	}

	/** @param newSize */
	public void setSize(Dimension2D newSize) {
		size = newSize;
	}

}