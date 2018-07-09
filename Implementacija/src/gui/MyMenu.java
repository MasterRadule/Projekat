package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuBar {
	
	private JMenu mnuFile;
	private JMenu mnuTools;
	
	private JMenuItem mniNew;
	private JMenuItem mniOpen;
	private JMenuItem mniSave;
	private JMenuItem mniOpt;
	
	public MyMenu(){
		
		mnuFile = new JMenu("File");
		mnuTools = new JMenu("Tools");
		add(mnuFile);
		add(mnuTools);
		
		mniNew = new JMenuItem("New");
		mnuFile.add(mniNew);
		mniOpen = new JMenuItem("Open");
		mnuFile.add(mniOpen);
		mniSave = new JMenuItem("Save");
		mnuFile.add(mniSave);
		mniOpt = new JMenuItem("Options");
		mnuTools.add(mniOpt);
		
		/*mniNoviTab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int brojTabova = MainFrame.getInstance().getBrojTabova();
				brojTabova++;
				MainFrame.getInstance().getTabbedPane().addTab("Dijagram " + brojTabova, new JPanel());
				MainFrame.getInstance().setBrojTabova(brojTabova);
			}
		});*/
	}
		
}
