package gge.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gge.model.ElementDokumenta;
import gge.model.Stanje;

public class ProzorIzmene extends JDialog {
	private JFrame parent;
	ElementDokumenta element;
	private TextField entityID;
	private TextField lifecycleName;
	private TextField displayName;
	private boolean confirmed = false;
	
	public ProzorIzmene(JFrame parent, ElementDokumenta element) {
		this.parent = parent;
		this.element = element;
	
		Dimension parentSize = parent.getSize(); 
		Point p = parent.getLocation(); 
		setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);

	    JPanel buttonPane = new JPanel();
	    JButton confirm = new JButton("Confirm"); 
	    JButton cancel = new JButton("Cancel"); 
	    buttonPane.add(confirm); 
	    buttonPane.add(cancel); 
	    confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmed = true;
				setVisible(false);
			}
		});;
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JPanel textPane = new JPanel();
		textPane.setLayout(new BoxLayout(textPane, BoxLayout.Y_AXIS));
		
		JPanel entityPane = new JPanel();
		entityID = new TextField(element.getEntityID());
		entityID.setEditable(false);
		entityPane.add(new JLabel("Entity ID:"));
		entityPane.add(entityID);
		textPane.add(entityPane);
		
		JPanel  lifecyclePane = new JPanel();
		lifecycleName = new TextField(element.getLifecycleName());
		lifecyclePane.add(new JLabel("Lifecycle name:"));
		lifecyclePane.add(lifecycleName);
		textPane.add(lifecyclePane);
		
		if(element instanceof Stanje){
			JPanel displayPane = new JPanel();
			displayName = new TextField(((Stanje)element).getDisplayName());
			displayPane.add(new JLabel("Display name:"));
			displayPane.add(displayName);
			textPane.add(displayPane);
		}
		
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    getContentPane().add(textPane, BorderLayout.CENTER);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack(); 
	    setModal(true);
	    setVisible(true);
	}

	public String getEntityID() {
		return entityID.getText();
	}


	public String getLifecycleName() {
		return lifecycleName.getText();
	}


	public String getDisplayName() {
		return displayName.getText();
	}

	public boolean isConfirmed() {
		return confirmed;
	}

}
