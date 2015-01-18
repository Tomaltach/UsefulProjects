package ie.tom.resultcalculator.gui;

import java.awt.BorderLayout;
import ie.tom.resultcalculator.gui.panel.CalcPanel;
import ie.tom.resultcalculator.gui.panel.InstructionsPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class ResultGUI extends JFrame {
	private CalcPanel calc = new CalcPanel();
	
	public ResultGUI() {
		super("Results Calculator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		build();

		pack();
		setSize(500, 520);
		setResizable(false);
		setVisible(true);
	}
	private void build() {
		JTabbedPane tab = new JTabbedPane();
		tab.add("Results", createResultsPanel());
		tab.add("Instructions", createInstructionsPanel());
		add(tab);
	}
	private JPanel createResultsPanel() {
		JPanel cPanel = new JPanel();
		cPanel.setLayout(new BorderLayout());
		cPanel.add(calc.buildTop(), BorderLayout.NORTH);
		cPanel.add(calc.buildBottom(), BorderLayout.CENTER);
		
		return cPanel;
	}
	private JPanel createInstructionsPanel() {
		JPanel cPanel = new JPanel();
		cPanel.add(InstructionsPanel.instructions());
		
		return cPanel;
	}
}