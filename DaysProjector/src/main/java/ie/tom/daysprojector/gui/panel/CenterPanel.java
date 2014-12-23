package ie.tom.daysprojector.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.joda.time.LocalDate;

import net.java.dev.designgridlayout.DesignGridLayout;

public class CenterPanel {
	private JLabel lblKillDate;

	public JPanel build(JPanel center) {		
		center = new JPanel();
		DesignGridLayout layout = new DesignGridLayout(center);
		
		JRadioButton kill = new JRadioButton("From Kill");
		JRadioButton pack = new JRadioButton("From Pack");
		ButtonGroup group = new ButtonGroup();
		group.add(kill);
		group.add(pack);
		
		JLabel lblDate = new JLabel("Date");
		JTextField txtDate = new JTextField(checkDate("0"));
		JLabel lblKill = new JLabel("Kill: ");
		final JTextField txtKill = new JTextField("", 5);
		txtKill.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					checkDate(txtKill.getText());
			    }
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		lblKillDate = new JLabel("Waiting...");
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblKillDate.setText(checkDate(txtKill.getText()));
			}
		});

		layout.row().grid().add(kill).add(pack);
		layout.row().grid().add(lblDate).add(txtDate);
		layout.row().grid().add(lblKill).add(txtKill);
		layout.row().grid().add(lblKillDate).empty().add(btnCheck);
		
		return center;
	}
	private String checkDate(String days) {
		return processDate(days);
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