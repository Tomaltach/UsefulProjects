package ie.tom.timekeeper.gui.panel;

import ie.tom.timekeeper.database.handlers.RecordDao;
import ie.tom.timekeeper.entity.Record;
import ie.tom.timekeeper.gui.panel.feature.PromptTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import net.java.dev.designgridlayout.DesignGridLayout;
import net.sourceforge.jcalendarbutton.JCalendarButton;

@SuppressWarnings("deprecation")
public class AddPanel implements Panel {
	private final static String[] TYPE = {"Walk", "Jog", "Run", "Sprint", "Cycle"};
	private final static String[] UNIT = {"Kilometer", "Mile"}; 
	private final static String DATE_PATTERN = "dd/MM/yyyy";
	public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
	
	private JTextField txtDate;
	private JCalendarButton btnCalendar;
	private JTextArea taOutput;
	private Record record;
	private RecordDao update;
	
	public AddPanel(RecordDao update) {
		this.update = update;
	}
	public JPanel createPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createTop(), BorderLayout.NORTH);
		panel.add(createBottom(), BorderLayout.CENTER);
		
		return panel;
	}
	private JPanel createTop(){
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
		
		btnCalendar.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
            	dateOnlyPopupChanged(evt);
            }
        });
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				if(txtDate.getText().equals("") || checkDate(txtDate.getText()) == false) {
					output += "Fill in date!\n";
				}
				if(txtTime.getText().equals("hh:mm:ss:ms")) {
					output += "Fill in time!\n";
				}
				if(txtDistance.getText().equals("")) {
					output += "Fill in distance!\n";
				} 
				if(output.equals("")) {
					output += txtDate.getText() + ", ";
					output += txtTime.getText() + ", ";
					output += txtDistance.getText() + ", ";
					output += cmbType.getSelectedItem() + ", ";
					output += cmbUnit.getSelectedItem() + "\n";
					
					record = new Record();
					record.setDate(getDate(txtDate.getText()));
					record.setTime(txtTime.getText());
					record.setDistance(Double.parseDouble(txtDistance.getText()));
					record.setType(cmbType.getSelectedItem().toString());
					record.setUnit(cmbUnit.getSelectedItem().toString());
					
					update.insertRecord(record);
				}
				
				taOutput.append(output);
				System.out.println(output);
			}
		});
		txtDate.setEditable(false);
		cmbType.setSelectedIndex(1);
		
		JPanel panel = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(panel);
		layout.row().grid(lblDate).add(txtDate).add(btnCalendar).grid(lblTime).add(txtTime).grid(lblDistance).add(txtDistance);
		layout.row().grid().add(cmbType).grid().add(cmbUnit).grid().add(btnAddRecord);
		
		return panel;		
	}
	private JPanel createBottom() {
		JPanel panel = new JPanel();

		taOutput = new JTextArea(22, 65);
		JScrollPane scrollOutput = new JScrollPane(taOutput);

		taOutput.setEditable(false);
		
		panel.add(scrollOutput);
		
		return panel;
	}
	private java.sql.Date getDate(String dateIn) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date utilDate = null;
		java.sql.Date sqlDate = null;
		try {
			utilDate = df.parse(dateIn);
		    sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return sqlDate;
	}
	private String currentDate() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		
		return "" + df.format(d);
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