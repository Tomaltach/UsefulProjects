package ie.tom.daysprojector.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.joda.time.LocalDate;

import net.java.dev.designgridlayout.DesignGridLayout;

public class TopPanel {
	private JLabel displayDate;

	public JPanel build(JPanel top) {
		top = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(top);
		
		JLabel lblDays = new JLabel("Number of days");
		final JTextField txtDays = new JTextField("", 5);
		txtDays.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					checkDate(txtDays.getText());
			    }
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		displayDate = new JLabel("Waiting...");
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDate.setText(checkDate(txtDays.getText()));
			}
		});
		
		layout.row().grid().add(lblDays).add(txtDays);
		layout.row().grid().add(displayDate).empty().add(btnCheck);
		layout.row().grid().add(new JSeparator(), 2);
				
		return top;
	}
	private String checkDate(String days) {
		String date = processDate(days);
		return date;
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
}