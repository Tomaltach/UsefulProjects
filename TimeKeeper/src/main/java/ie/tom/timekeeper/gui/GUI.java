package ie.tom.timekeeper.gui;

import ie.tom.timekeeper.gui.panel.AddPanel;
import ie.tom.timekeeper.gui.panel.Panel;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private String user;

	public GUI(String user) {
		super("" + user + "'s Records");
		
		this.user = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		build();
		
		pack();
		setSize(750, 500);
		setVisible(true);
	}
	private void build() {
		buildAddPanel();		
	}
	private void buildAddPanel() {
		Panel addPanel = new AddPanel();
		add(addPanel.createPanel());		
	}
}