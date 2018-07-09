package gge.view;

import java.awt.geom.Rectangle2D;

import gge.model.GraphElement;

public class MyRectPainter extends ElementPainter {

	public MyRectPainter(GraphElement element) {
		super(element);
		shape = new Rectangle2D.Double(element.getPosition().getX(), element
				.getPosition().getY(), element.getSize().getWidth(), element
				.getSize().getHeight());
	}
}