package ie.tom.daysprojector.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class BottomPanel {
	private JLabel lblKill;
	private JTextField txtKill;
	private JLabel lblPack;
	private JTextField txtPack;
	private JLabel lblOpenBy;
	private JTextField txtOpenBy;
	private JLabel lblOpenByKill;
	private JLabel lblOpenByPack;
	private JLabel lblUseBy;
	private JTextField txtUseBy;
	private JLabel lblUseByKill;
	private JLabel lblUseByPack;
	
	public JPanel build(JPanel center) {		
		center = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(center);
		
		lblKill = new JLabel("Kill: ");
		txtKill = new JTextField(checkDate("0"), 5);
		
		lblPack = new JLabel("Pack: ");
		txtPack = new JTextField(checkDate("0"), 5);
		
		lblOpenBy = new JLabel("Open By: ");
		txtOpenBy = new JTextField(checkDate("0"), 5);
		lblOpenByKill = new JLabel("0");
		lblOpenByPack = new JLabel("0");

		lblUseBy = new JLabel("Use By: ");
		txtUseBy = new JTextField(checkDate("0"), 5);
		lblUseByKill = new JLabel("0");
		lblUseByPack = new JLabel("0");
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOpenByKill.setText(checkDates(txtKill.getText(), txtOpenBy.getText()));
				lblUseByKill.setText(checkDates(txtKill.getText(), txtUseBy.getText()));
				lblOpenByPack.setText(checkDates(txtPack.getText(), txtOpenBy.getText()));
				lblUseByPack.setText(checkDates(txtPack.getText(), txtUseBy.getText()));
			}			
		});

		layout.row().grid(new JLabel("DD/MM/YYYY")).grid(lblKill).add(txtKill).grid(lblPack).add(txtPack);
		layout.row().grid().add().grid().add(new JLabel("Kill")).grid().add(new JLabel("Pack"));
		layout.row().grid(lblOpenBy).add(txtOpenBy).grid().add(lblOpenByKill).grid().add(lblOpenByPack);
		layout.row().grid(lblUseBy).add(txtUseBy).grid().add(lblUseByKill).grid().add(lblUseByPack);
		layout.row().grid().empty(2).add(btnCheck);
		
		return center;
	}
	private String checkDate(String days) {
		String date = processDate(days);
		return date;
	}
	private String checkDates(String fromDate, String days) {
		return processDates(fromDate, days);
	}
	private String processDate(String daysIn) {
		String date = "";
		int days = 0;
		LocalDate today;
		try {
			days = Integer.parseInt(daysIn);
			today = LocalDate.now().plusDays(days);
			
		} catch(Exception e) {
			return "Number!";
		}
		date = today.getDayOfMonth() + "/" + today.getMonthOfYear() + "/" + today.getYear();
		return date;
	}
	private String processDates(String fromDate, String daysIn) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = "";
		int days = 0;
		@SuppressWarnings("unused")
		Date date;
		try {
			date = formatter.parse(fromDate);
			date = formatter.parse(daysIn);
			
			DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy");
			DateTime start = format.parseDateTime(fromDate);
			DateTime end = format.parseDateTime(daysIn);
			
			days = Days.daysBetween(start, end).getDays();
		} catch(Exception e) {
			return "Number!";
		}
		strDate = "" + days;
		return strDate;
	}
}