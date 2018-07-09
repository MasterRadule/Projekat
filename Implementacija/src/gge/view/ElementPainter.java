package gge.view;

import gge.model.*;

import java.awt.*;
import java.awt.geom.*;

public class ElementPainter {
   protected Shape shape;
   protected GraphElement element;

   public GraphElement getElement() {
      return element;
   }
   
   /** @param newGraphElement */
   public void setElement(GraphElement newGraphElement) {
      this.element = newGraphElement;
   }
   
   /** @param g */
   public void paint(Graphics2D g) {
	// TODO: implement
	   g.draw(shape); //u naslednicima
   }
   
   /** @param p */
   public boolean isElementAt(Point2D p) {
      // TODO: implement
      return false;
   }
   
   /** @param r */
   public boolean isElementIn(Rectangle2D r) {
      // TODO: implement
      return false;
   }
   
   public ElementPainter(GraphElement element) {
	   // TODO: implement
	   this.element = element;
   }
   
  

}