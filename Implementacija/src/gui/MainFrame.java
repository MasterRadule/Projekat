package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import gge.model.Aplikacija;
import gge.model.ElementDokumenta;
import gge.model.Pregled;
import gge.model.Stanje;
import gge.model.TipDokumenta;
import gge.model.TipNotifikacije;
import gge.view.ProzorIzmene;
import gge.view.Viewer;

public class MainFrame extends JFrame implements Observer{
	
	private static MainFrame instance = null;
	private MyMenu myMenu = new MyMenu();
	private JTabbedPane tabbedPane;
	private JToolBar toolBar;
	private String activeButton;
	private Boolean selected; 
	private ArrayList<JButton> buttons;
	private Viewer accessPermit;
	private Viewer switchOrder;
	private Viewer switchRequest;
	private Aplikacija model;
	
	public MainFrame(Aplikacija model){
		selected = false;
		buttons = new ArrayList<JButton>();
		this.model = model;
		
		// metoda da se view prijavi modelu da hoce da slusa izmene
		model.addObserver(this);
	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame(Aplikacija.getInstance());
			Aplikacija.getInstance().addObserver(instance);
			instance.initGUI();
		}
		return instance;
	}
	
	public void initGUI(){
		
		setJMenuBar(myMenu);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Aplikacija");
		
		accessPermit = new Viewer(this, Aplikacija.getInstance(), TipDokumenta.AccessPermit);
		switchOrder =  new Viewer(this, Aplikacija.getInstance(), TipDokumenta.SwitchOrder);
		switchRequest = new Viewer(this, Aplikacija.getInstance(), TipDokumenta.SwitchRequest);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("AccessPermit", accessPermit);
		tabbedPane.addTab("SwitchOrder", switchOrder);
		tabbedPane.addTab("SwitchRequest", switchRequest);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_2);
		this.add(tabbedPane, BorderLayout.CENTER);
		
		toolBar = new JToolBar("Toolbar");
		fillToolBar(toolBar);
		this.add(toolBar, BorderLayout.NORTH);
	}
	
	protected void fillToolBar(JToolBar toolBar) {
		ImageIcon icon;
		Image img;
		Image newimg;
		
		ActionListener buttonAL = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Aplikacija.getInstance().getCurrentState() instanceof Pregled)
				{
					((JButton) e.getSource()).setBorder(new LineBorder(Color.BLUE));
					activeButton = ((JButton) e.getSource()).getName();
					switch(activeButton)
					{
					case "state":
						Aplikacija.getInstance().kliknutoNaZnakCrtanjaStanja();
						break;
					case "transition":
						Aplikacija.getInstance().kliknutoNaZnakCrtanjaTranzicije();
						break;
					case "delete":
						Aplikacija.getInstance().kliknutoNaZnakBrisanja();
						break;
					}
					if (!(Aplikacija.getInstance().getCurrentState() instanceof Pregled))
					{
						for (JButton but : buttons)
						{
							if (but.getName().equals("select"))
							{
								but.setBorder(BorderFactory.createEmptyBorder());
							}
						}
					}
				}
				else if (((JButton) e.getSource()).getName().equals("select"))
				{
					activeButton = "";
					if (!(Aplikacija.getInstance().getCurrentState() instanceof Pregled))
					{
						for (JButton but : buttons)
						{
							if (but.getBorder() instanceof LineBorder)
							{
								but.setBorder(BorderFactory.createEmptyBorder());
	
							}
						}
					}
					((JButton) e.getSource()).setBorder(new LineBorder(Color.BLUE));
					Aplikacija.getInstance().kliknutoNaZnakPregleda();
				}
			}
		};
		
		icon = new ImageIcon(".\\src\\images\\select.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button = new JButton(icon);
		button.setName("select");
		button.setBorder(new LineBorder(Color.BLUE));
		button.setToolTipText("Select");
		button.addActionListener(buttonAL);
		buttons.add(button);
		toolBar.add(button);
		toolBar.addSeparator();
		
		icon = new ImageIcon(".\\src\\images\\state.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button2 = new JButton(icon);
		button2.setName("state");
		button2.setBorder(BorderFactory.createEmptyBorder());
		button2.setToolTipText("State");
		button2.addActionListener(buttonAL);
		buttons.add(button2);
		toolBar.add(button2);
		toolBar.addSeparator();

		icon = new ImageIcon(".\\src\\images\\transition.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button3 = new JButton(icon);
		button3.setName("transition");
		button3.setBorder(BorderFactory.createEmptyBorder());
		button3.setToolTipText("Transition");
		button3.addActionListener(buttonAL);
		toolBar.add(button3);
		buttons.add(button3);
		button3.setBorderPainted(true);
		toolBar.addSeparator();
		
		icon = new ImageIcon(".\\src\\images\\delete.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button4 = new JButton(icon);
		button4.setName("delete");
		button4.setBorder(BorderFactory.createEmptyBorder());
		button4.addActionListener(buttonAL);
		button4.setToolTipText("Delete");
		buttons.add(button4);
		toolBar.add(button4);
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(arg instanceof TipNotifikacije){
			TipNotifikacije notifikacija = (TipNotifikacije) arg;
			switch (notifikacija) {
			case promenaRadnePovrsine:
				accessPermit.repaint();
				switchOrder.repaint();
				switchRequest.repaint();
				break;
			default:
				break;
			}
		}
		else if(arg instanceof ElementDokumenta){
			ElementDokumenta element = (ElementDokumenta) arg;
			ProzorIzmene prozorIzmene = new ProzorIzmene(this, element);
			if(prozorIzmene.isConfirmed()){
				element.setEntityID(prozorIzmene.getEntityID());
				element.setLifecycleName(prozorIzmene.getLifecycleName());
				if(element instanceof Stanje){
					((Stanje) element).setDisplayName(prozorIzmene.getDisplayName());
					Aplikacija.getInstance().notifyAllObservers(TipNotifikacije.promenaRadnePovrsine);
				}
			}
		}
		
		
	}

}
