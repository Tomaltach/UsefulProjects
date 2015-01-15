package ie.tom.resultcalculator.gui.panel;

import ie.tom.resultcalculator.logic.CalculateResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

public class CalcPanel {	
	private JTextArea taOutput;
	
	public JPanel buildTop() {
		JLabel lblTotal = new JLabel("Total");
		JLabel lblOverall = new JLabel("Overall % so far");
		final JTextField txtOverall = new JTextField("");
		JLabel lblNeed = new JLabel("What you need");
		final JTextField txtNeed = new JTextField();
		
		JLabel lblExam = new JLabel("Exam");
		JLabel lblWorth = new JLabel("Overall % worth");
		final JTextField txtWorth = new JTextField();
		JLabel lblGot = new JLabel("What you got");
		final JTextField txtGot = new JTextField();
		
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean err = false;
				String result = "";
				if(txtOverall.getText().equals("")) {
					result += "Enter Overall result so far!\n";
					err = true;
				}
				if(txtNeed.getText().equals("")) {
					result += "Enter Overall result needed!\n";
					err = true;
				}
				if(txtWorth.getText().equals("")) {
					result += "Enter Overall Worth of Exam!\n";
					err = true;
				} 
				if(txtGot.getText().equals("")) {
					result += "Enter what you Got in the Exam!\n";
					err = true;
				}
				if(err == true) {
					result += "#################################################################\n";
				}
				if(result.equals("")) {
					result += CalculateResult.runCalculation(txtOverall.getText(), txtNeed.getText(), txtWorth.getText(), txtGot.getText());
				}
				taOutput.append(result);
			}
		});
		
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);
		
		layout.row().grid(lblTotal).grid().grid(lblExam);
		layout.row().grid(lblOverall).add(txtOverall).grid().grid(lblWorth).add(txtWorth);
		layout.row().grid(lblNeed).add(txtNeed).grid().grid(lblGot).add(txtGot);
		layout.row().grid().grid().add(btnCalc).grid();
		
		return panel;		
	}
	public JPanel buildBottom() {
		taOutput = new JTextArea(20, 42);
		JScrollPane scroll = new JScrollPane(taOutput);
		taOutput.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.add(scroll);
		
		return panel;		
	}
}