package ie.tom.resultcalculator.gui.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionsPanel {
	
	public static JPanel instructions() {
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel lblCreated = new JLabel("Created By: Thomas Donegan");
		JLabel lblBlank = new JLabel(" ");
		JLabel lblPoint1 = new JLabel("1. Overall so far is the overall percent that you have obtained for the module.");
		JLabel lblPoint21 = new JLabel("2. What you need is the deciding factor for showing the result you have to get in the");
		JLabel lblPoint22 = new JLabel("    exam for that grade.");
		JLabel lblPoint3 = new JLabel("3. Overall worth is how much the current exam is worth overall e.g. 20% of class 100%.");
		JLabel lblPoint4 = new JLabel("4. What you got is what you got in that exam e.g. 67% out of 100%.");
		JLabel lblPoint51 = new JLabel("5. If you have not done the exam yet, you can enter 0 into the what you got box. This");
		JLabel lblPoint52 = new JLabel("    will allow you the see what you need to get in your next exam to get the overall");
		JLabel lblPoint53 = new JLabel("    grade you want.");
		
		panel.add(lblCreated);
		panel.add(lblBlank);
		panel.add(lblPoint1);
		panel.add(lblPoint21);
		panel.add(lblPoint22);
		panel.add(lblPoint3);
		panel.add(lblPoint4);
		panel.add(lblPoint51);
		panel.add(lblPoint52);
		panel.add(lblPoint53);
		
		return panel;
	}
}
