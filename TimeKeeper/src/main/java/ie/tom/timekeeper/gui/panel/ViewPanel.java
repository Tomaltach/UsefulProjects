package ie.tom.timekeeper.gui.panel;

import ie.tom.timekeeper.database.handlers.RecordDao;
import ie.tom.timekeeper.entity.Record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.java.dev.designgridlayout.DesignGridLayout;

public class ViewPanel implements Panel {
	private final static String[] MONTH = {"All", "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private final static String[] YEAR = {"All", "2014"};
	private final static String[] TYPE = {"All", "Walk", "Jog", "Run", "Sprint", "Cycle"};
	private final static String[] UNIT = {"All", "Kilometer", "Mile"}; 
	
	private Record record;
	private RecordDao update;
    
	public ViewPanel(RecordDao update) {
		this.update = update;
	}

	@Override
	public JPanel createPanel() {
		final JComboBox<String> cmbMonth = new JComboBox<String>(MONTH);
		final JComboBox<String> cmbYear = new JComboBox<String>(YEAR);             
		final JComboBox<String> cmbType = new JComboBox<String>(TYPE);
		final JComboBox<String> cmbUnit = new JComboBox<String>(UNIT);
		JButton btnViewRecords = new JButton("View");
		JButton btnViewAllRecords = new JButton("View");
		final JTextArea taOutput = new JTextArea(20, 5);
		JScrollPane scrollOutput = new JScrollPane(taOutput);
		
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				output += cmbMonth.getSelectedItem() + ", ";
				output += cmbYear.getSelectedItem() + ", ";
				output += cmbType.getSelectedItem() + ", ";
				output += cmbUnit.getSelectedItem();
				
				taOutput.append(output);
				System.out.println(output);
			}
		});
		btnViewAllRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				
				taOutput.append(output);
				System.out.println(output);
			}
		});
		taOutput.setEditable(false);
		
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);
		layout.row().grid().add(cmbMonth).grid().add(cmbYear).grid().add(cmbType).grid().add(cmbUnit).grid().add(btnViewRecords).grid().add(btnViewAllRecords);
		layout.row().bar();
		layout.row().grid().add(scrollOutput);
		
		return panel;		
	}
}