package ie.tom.daysprojector.gui;

import ie.tom.daysprojector.gui.panel.CenterPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.java.dev.designgridlayout.DesignGridLayout;

import org.joda.time.LocalDate;

@SuppressWarnings("serial")
public class GUI extends JFrame { 
	private static final int WIDTH = 270;
	private static final int HEIGHT = 400;
	private JLabel displayDate;
	
	public GUI() {
		super("Day Projector");
		
		init();
		
		pack();
		setSize(WIDTH, HEIGHT);
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
	private JPanel createCenterPanel(JPanel center) {
		CenterPanel panel = new CenterPanel();
		center = panel.build(center);
		return center;
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