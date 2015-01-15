package ie.tom.resultcalculator;

import ie.tom.resultcalculator.gui.ResultGUI;

import javax.swing.SwingUtilities;

public class ResultCalculator {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ResultGUI();
			}			
		});
	}
}