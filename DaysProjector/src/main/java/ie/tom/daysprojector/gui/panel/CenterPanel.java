package ie.tom.daysprojector.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import net.java.dev.designgridlayout.DesignGridLayout;

public class CenterPanel {
	private JRadioButton kill;
	private JRadioButton pack;
	private JLabel lblDate;
	private JTextField txtDate;
	private JLabel lblKill;
	private JTextField txtKill;
	private JLabel lblKillDate;
	private JLabel lblPack;
	private JTextField txtPack;
	private JLabel lblPackDate;
	private JLabel lblDNOB;
	private JTextField txtDNOB;
	private JLabel lblDNOBDate;
	private JLabel lblUseBy;
	private JTextField txtUseBy;
	private JLabel lblUseByDate;

	public JPanel build(JPanel center) {		
		center = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(center);
		
		kill = new JRadioButton("From Kill");
		kill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblKillDate.setText(txtDate.getText());
				txtKill.setText("");
				txtKill.setEditable(false);
				txtPack.setEditable(true);
				reset();
			}
		});
		pack = new JRadioButton("From Pack");
		pack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtKill.setEditable(true);
				lblPackDate.setText(txtDate.getText());
				txtPack.setText("");
				txtPack.setEditable(false);
				reset();
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(kill);
		group.add(pack);
		
		lblDate = new JLabel("Date");
		txtDate = new JTextField(checkDate("0"));
		
		lblKill = new JLabel("Kill: ");
		txtKill = new JTextField("", 5);
		lblKillDate = new JLabel("Waiting...");
		
		lblPack = new JLabel("Pack: ");
		txtPack = new JTextField("", 5);
		lblPackDate = new JLabel("Waiting...");
		
		lblDNOB = new JLabel("DNOB: ");
		txtDNOB = new JTextField("", 5);
		lblDNOBDate = new JLabel("Waiting...");

		lblUseBy = new JLabel("Use By: ");
		txtUseBy = new JTextField("", 5);
		lblUseByDate = new JLabel("Waiting...");
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}			
		});

		layout.row().grid().add(kill).add(pack);
		layout.row().grid().add(lblDate).add(txtDate);
		layout.row().grid().add(lblKill).add(txtKill).add(lblKillDate);
		layout.row().grid().add(lblPack).add(txtPack).add(lblPackDate);
		layout.row().grid().add(lblDNOB).add(txtDNOB).add(lblDNOBDate);
		layout.row().grid().add(lblUseBy).add(txtUseBy).add(lblUseByDate);
		layout.row().grid().empty(2).add(btnCheck);
		
		return center;
	}
	private String checkDate(String days) {
		return processDate(days);
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
		DateTime from;
		try {
			days = Integer.parseInt(daysIn);
			date = formatter.parse(fromDate);
			
			DateTimeFormatter format = DateTimeFormat.forPattern("dd/MM/yyyy");
			DateTime dt = format.parseDateTime(fromDate);
			
			from = dt.plusDays(days);
		} catch(Exception e) {
			return "Number!";
		}
		strDate = from.getDayOfMonth() + "/" + from.getMonthOfYear() + "/" + from.getYear();
		return strDate;
	}
	private void reset() {
		if(kill.isSelected() == true) {
			lblKillDate.setText(txtDate.getText());
			lblPackDate.setText(checkDates(txtDate.getText(), txtPack.getText()));
			lblDNOBDate.setText(checkDates(txtDate.getText(), txtDNOB.getText()));
			lblUseByDate.setText(checkDates(txtDate.getText(), txtUseBy.getText()));
		} else if(pack.isSelected() == true) {
			int days;
			String newdays = null;
			try {
				days = Integer.parseInt(txtKill.getText());
				newdays = "" + days * -1;
			} catch(Exception e) {}
			lblKillDate.setText(checkDates(txtDate.getText(), newdays));
			lblPackDate.setText(txtDate.getText());
			lblDNOBDate.setText(checkDates(txtDate.getText(), txtDNOB.getText()));
			lblUseByDate.setText(checkDates(txtDate.getText(), txtUseBy.getText()));
		} else {
			lblKillDate.setText(checkDates(txtDate.getText(), txtKill.getText()));
			lblPackDate.setText(checkDates(txtDate.getText(), txtPack.getText()));
			lblDNOBDate.setText(checkDates(txtDate.getText(), txtDNOB.getText()));
			lblUseByDate.setText(checkDates(txtDate.getText(), txtUseBy.getText()));
		}
	}
}