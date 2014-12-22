package ie.tom.daysprojector.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.joda.time.LocalDate;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private JLabel displayDate;
	
	public GUI() {
		super("Day Projector");
		
		init();
		
		pack();
		setSize(250,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	private void init() {
		JPanel top = null;
		top = createTopPanel(top);
		JPanel center = null;
		center = createCenterPanel(center);
		
		this.add(top, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
	}
	private JPanel createTopPanel(JPanel top) {
		top = new JPanel(new FlowLayout());
		
		JLabel lblDays = new JLabel("Number of days: ");
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
		JButton go = new JButton("Go");
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDate(txtDays.getText());
			}
		});
		
		top.add(lblDays);
		top.add(txtDays);
		top.add(go);
		
		return top;
	}
	private JPanel createCenterPanel(JPanel center) {
		center = new JPanel(new FlowLayout());		
		displayDate = new JLabel("Waiting...");
				
		center.add(displayDate);
		
		return center;
	}
	private void checkDate(String days) {
		String date = processDate(days);
		displayDate.setText(date);
	}
	private String processDate(String daysIn) {
		String date = "";
		int days = 0;
		LocalDate today;
		try {
			days = Integer.parseInt(daysIn);
			today = LocalDate.now().plusDays(days);
			
		} catch(Exception e) {
			return "Must enter a number!";
		}
		date = today.getDayOfMonth() + "/" + today.getMonthOfYear() + "/" + today.getYear();
		return date;
	}
}