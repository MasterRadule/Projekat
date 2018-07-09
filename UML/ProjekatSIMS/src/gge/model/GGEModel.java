package gge.model;

import java.util.*;

public class GGEModel {
   protected List<GraphElement> elements;
   
   
   /** @pdGenerated default iterator getter */
   public Iterator<GraphElement> getIteratorElements() {
      if (elements == null)
         elements = new ArrayList<GraphElement>();
      return elements.iterator();
   }
   
   /** @param newGraphElement */
   public void addElements(GraphElement newGraphElement) {
      if (newGraphElement == null)
         return;
      if (this.elements == null)
         this.elements = new ArrayList<GraphElement>();
      if (!this.elements.contains(newGraphElement))
         this.elements.add(newGraphElement);

   }
   
   /** @param oldGraphElement */
   public void removeElements(GraphElement oldGraphElement) {
      if (oldGraphElement == null)
         return;
      if (this.elements != null)
         if (this.elements.contains(oldGraphElement))
            this.elements.remove(oldGraphElement);
   }
   
   public void removeAllElements() {
      if (elements != null)
         elements.clear();
   }

   	
}