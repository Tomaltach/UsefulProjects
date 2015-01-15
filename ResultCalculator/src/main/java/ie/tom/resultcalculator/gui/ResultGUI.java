package ie.tom.resultcalculator.gui;

import java.awt.BorderLayout;

import ie.tom.resultcalculator.gui.panel.CalcPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ResultGUI extends JFrame {
	private CalcPanel calc = new CalcPanel();
	
	public ResultGUI() {
		super("Results Calculator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		build();

		pack();
		setSize(500, 500);
		setVisible(true);
	}
	private void build() {
		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BorderLayout());
		cPanel.add(calc.buildTop(), BorderLayout.NORTH);
		cPanel.add(calc.buildBottom(), BorderLayout.CENTER);
		add(cPanel);
	}
}