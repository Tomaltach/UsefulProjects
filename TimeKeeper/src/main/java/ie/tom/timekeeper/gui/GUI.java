package ie.tom.timekeeper.gui;

import java.awt.BorderLayout;

import ie.tom.timekeeper.gui.panel.AddPanel;
import ie.tom.timekeeper.gui.panel.Panel;
import ie.tom.timekeeper.gui.panel.ViewPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	@SuppressWarnings("unused")
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
		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BorderLayout());
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.addTab("Add", buildAddPanel());
		tabbed.addTab("View", buildViewPanel());

		cPanel.add(tabbed);
		add(cPanel);
	}
	private JPanel buildAddPanel() {
		Panel addPanel = new AddPanel();
		return addPanel.createPanel();		
	}
	private JPanel buildViewPanel() {
		Panel viewPanel = new ViewPanel();
		return viewPanel.createPanel();		
	}
}