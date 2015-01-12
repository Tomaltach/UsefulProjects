package ie.tom.timekeeper.gui.panel;

import ie.tom.timekeeper.gui.panel.feature.PromptTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.joda.time.LocalDate;

import net.java.dev.designgridlayout.DesignGridLayout;

public class AddPanel implements Panel {
	private final static String[] TYPE = {"Walk", "Jog", "Run", "Sprint"};
	private final static String[] UNIT = {"Kilometer", "Mile"}; 

	@Override
	public JPanel createPanel() {
		JLabel lblDate = new JLabel("Date");
		final JTextField txtDate = new JTextField(processDate(), 20);
		JLabel lblTime = new JLabel("Time");
		final PromptTextField txtTime = new PromptTextField("hh:mm:ss:ms");
		JLabel lblDistance = new JLabel("Distance");
		final JTextField txtDistance = new JTextField(20);
		final JComboBox<String> cmbType = new JComboBox<String>(TYPE);
		final JComboBox<String> cmbUnit = new JComboBox<String>(UNIT);
		JButton btnAddRecord = new JButton("Add");
		final JTextArea taOutput = new JTextArea(20, 5);
		JScrollPane scrollOutput = new JScrollPane(taOutput);
		
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String record = "";
				record += txtDate.getText() + ", ";
				record += txtTime.getText() + ", ";
				record += txtDistance.getText() + ", ";
				record += cmbType.getSelectedItem() + ", ";
				record += cmbUnit.getSelectedItem();
				
				taOutput.append(record);
				System.out.println(record);
			}
		});
		taOutput.setEditable(false);
		cmbType.setSelectedIndex(1);
		
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);
		layout.row().grid(lblDate).add(txtDate).grid(lblTime).add(txtTime).grid(lblDistance).add(txtDistance).grid().add(cmbType).grid().add(cmbUnit).grid().add(btnAddRecord);
		layout.row().bar();
		layout.row().grid().add(scrollOutput);
		
		return panel;		
	}
	private String processDate() {
		String date = "";
		LocalDate today;
		try {
			today = LocalDate.now();
			
		} catch(Exception e) {
			return "Number!";
		}
		date = today.getDayOfMonth() + "/" + today.getMonthOfYear() + "/" + today.getYear();
		return date;
	}
}