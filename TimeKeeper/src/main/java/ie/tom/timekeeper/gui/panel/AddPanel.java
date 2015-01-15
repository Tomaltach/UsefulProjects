package ie.tom.timekeeper.gui.panel;

import ie.tom.timekeeper.gui.panel.feature.PromptTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.sourceforge.jcalendarbutton.JCalendarButton;

@SuppressWarnings("deprecation")
public class AddPanel implements Panel {
	private final static String[] TYPE = {"Walk", "Jog", "Run", "Sprint", "Cycle"};
	private final static String[] UNIT = {"Kilometer", "Mile"}; 
	private final static String DATE_PATTERN = "dd/MM/yyyy";
	public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
	
	private JTextField txtDate;
	private JCalendarButton btnCalendar;

	@Override
	public JPanel createPanel() {
		JLabel lblDate = new JLabel("Date");
		txtDate = new JTextField(currentDate(), 20);
		btnCalendar = new JCalendarButton();
		JLabel lblTime = new JLabel("Time");
		final PromptTextField txtTime = new PromptTextField("hh:mm:ss:ms");
		JLabel lblDistance = new JLabel("Distance");
		final JTextField txtDistance = new JTextField(20);
		final JComboBox<String> cmbType = new JComboBox<String>(TYPE);
		final JComboBox<String> cmbUnit = new JComboBox<String>(UNIT);
		JButton btnAddRecord = new JButton("Add");
		final JTextArea taOutput = new JTextArea(20, 5);
		JScrollPane scrollOutput = new JScrollPane(taOutput);
		
		txtDate.addMouseListener(new MouseListener() {
			@Override
		    public void mouseClicked(MouseEvent e) {

		    }
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		btnCalendar.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            	dateOnlyPopupChanged(evt);
            }
        });
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String record = "";
				if(txtDate.getText().equals("") || checkDate(txtDate.getText()) == false) {
					record += "Fill in date!\n";
				}
				if(txtTime.getText().equals("hh:mm:ss:ms")) {
					record += "Fill in time!\n";
				}
				if(txtDistance.getText().equals("")) {
					record += "Fill in distance!\n";
				} 
				if(record.equals("")) {
					record += txtDate.getText() + ", ";
					record += txtTime.getText() + ", ";
					record += txtDistance.getText() + ", ";
					record += cmbType.getSelectedItem() + ", ";
					record += cmbUnit.getSelectedItem();
				}
				
				taOutput.append(record);
				System.out.println(record);
			}
		});
		txtDate.setEditable(false);
		taOutput.setEditable(false);
		cmbType.setSelectedIndex(1);
		
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);
		layout.row().grid(lblDate).add(txtDate).grid(lblTime).add(txtTime).grid(lblDistance).add(txtDistance).grid().add(cmbType).grid().add(cmbUnit).grid().add(btnAddRecord);
		layout.row().bar();
		layout.row().grid().add(scrollOutput);
		
		return panel;		
	}
	private String currentDate() {
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
	private boolean checkDate(String date) {
		try {
			DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_PATTERN);
			dtf.parseDateTime(date);
			return true;
		} catch (IllegalArgumentException iae) {
			return false;
		}
	}
	private void dateOnlyPopupChanged(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof Date) {
			setDate((Date)evt.getNewValue());
		}
    }
	public void setDate(String dateString) {
		Date date = null;
		try {
			if((dateString != null) && (dateString.length() > 0)) {
				date = dateFormat.parse(dateString);
			}
		}
		catch(Exception e) {
			date = null;
		}
		this.setDate(date);
	}
	public void setDate(Date date){
		String dateString = "";
		if(date != null) {
			dateString = dateFormat.format(date);
		}
		txtDate.setText(dateString);
		btnCalendar.setTargetDate(date);
    }
}