package ie.tom.daysprojector.gui;

import ie.tom.daysprojector.gui.panel.BottomPanel;
import ie.tom.daysprojector.gui.panel.CenterPanel;
import ie.tom.daysprojector.gui.panel.TopPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame { 
	private static final int WIDTH = 450;
	private static final int HEIGHT = 500;
	
	public GUI() {
		super("Day Projector");
		
		init();
		
		pack();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	private void init() {
		JPanel top = null;
		top = createTopPanel(top);
		JPanel center = null;
		center = createCenterPanel(center);
		JPanel bottom = null;
		bottom = createBottomPanel(bottom);
		
		this.add(top, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
	}
	private JPanel createTopPanel(JPanel top) {
		TopPanel panel = new TopPanel();
		top = panel.build(top);
		return top;
	}
	private JPanel createCenterPanel(JPanel center) {
		CenterPanel panel = new CenterPanel();
		center = panel.build(center);
		return center;
	}
	private JPanel createBottomPanel(JPanel bottom) {
		BottomPanel panel = new BottomPanel();
		bottom = panel.build(bottom);
		return bottom;
	}
}