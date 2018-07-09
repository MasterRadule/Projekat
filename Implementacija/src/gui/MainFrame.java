package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import gge.model.GGEModel;
import gge.view.GGEView;

public class MainFrame extends JFrame{
	
	private static MainFrame instance = null;
	private MyMenu myMenu = new MyMenu();
	private JTabbedPane tabbedPane;
	private JToolBar toolBar;
	private GGEModel model = new GGEModel();
	
	public MainFrame(){
	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
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

		GGEView view = new GGEView(model);
		/*MyEllipse elem = new MyEllipse(new Point2D.Double(100,200), new Dimension(140,50));
		MyEllipsePainter p = new MyEllipsePainter(elem);
		view.addElementPainters(p);
		model.addElements(elem);*/
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Radni zahtev", view);
		tabbedPane.addTab("Plan rada", new GGEView(MainFrame.getInstance().getModel()));
		tabbedPane.addTab("Sigurnosni dokument", new GGEView(MainFrame.getInstance().getModel()));
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
				if (((JButton) e.getSource()).getBorder() == BorderFactory.createEmptyBorder())
				{
					((JButton) e.getSource()).setBorder(new LineBorder(Color.BLUE));
				}
				else
				{
					((JButton) e.getSource()).setBorder(BorderFactory.createEmptyBorder());
				}
			}
		};
		
		icon = new ImageIcon(".\\src\\images\\select.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button = new JButton(icon);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setToolTipText("Select");
		button.addActionListener(buttonAL);
		toolBar.add(button);
		toolBar.addSeparator();
		
		icon = new ImageIcon(".\\src\\images\\state.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button2 = new JButton(icon);
		button2.setBorder(BorderFactory.createEmptyBorder());
		button2.setToolTipText("State");
		button2.addActionListener(buttonAL);
		toolBar.add(button2);
		toolBar.addSeparator();

		icon = new ImageIcon(".\\src\\images\\transition.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button3 = new JButton(icon);
		button3.setBorder(BorderFactory.createEmptyBorder());
		button3.setToolTipText("Transition");
		button3.addActionListener(buttonAL);
		toolBar.add(button3);
		button3.setBorderPainted(true);
		toolBar.addSeparator();
		
		icon = new ImageIcon(".\\src\\images\\delete.png");
		img = icon.getImage();
		newimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		JButton button4 = new JButton(icon);
		button4.setBorder(BorderFactory.createEmptyBorder());
		button4.addActionListener(buttonAL);
		button4.setToolTipText("Delete");
		toolBar.add(button4);
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	
	public GGEModel getModel() {
		return model;
	}

	public void setModel(GGEModel model) {
		this.model = model;
	}

}
