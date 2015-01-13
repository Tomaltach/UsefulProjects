package ie.tom.timekeeper.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.java.dev.designgridlayout.DesignGridLayout;

public class ViewPanel implements Panel {
	private final static String[] TYPE = {"Walk", "Jog", "Run", "Sprint", "Cycle"};
	private final static String[] UNIT = {"Kilometer", "Mile"}; 
    
        @Override
	public JPanel createPanel() {
		final JComboBox<String> cmbType = new JComboBox<String>(TYPE);
		final JComboBox<String> cmbUnit = new JComboBox<String>(UNIT);
		JButton btnAddRecord = new JButton("View");
		final JTextArea taOutput = new JTextArea(20, 5);
		JScrollPane scrollOutput = new JScrollPane(taOutput);
		
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String record = "";
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
		layout.row().grid().add(cmbType).grid().add(cmbUnit).grid().add(btnAddRecord);
		layout.row().bar();
		layout.row().grid().add(scrollOutput);
		
		return panel;		
	}
}