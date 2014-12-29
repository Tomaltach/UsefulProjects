package ie.tom.connectfour.board;

import ie.tom.connectfour.Player;
import ie.tom.connectfour.disk.DiskBlank;
import ie.tom.connectfour.disk.DiskImpl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConnectFourBoard extends JFrame implements Board {
	private DiskImpl disk;
	private Player p1 = new Player("P1");
	private Player p2 = new Player("P2");
	private String name;
	private JFrame board;
	private int col1stack = 0;
	private JButton col1, col2, col3, col4, col5, col6, col7;

	public ConnectFourBoard(String name) {
		this.name = name;
	}
	public void drawBoard() {
		setup();
		
		col1 = new JButton("Add");
		col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCol1();
			}
		});
		col2 = new JButton("Add");
		col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCol2();
			}
		});
		col3 = new JButton("Add");
		col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCol3();
			}
		});
		col4 = new JButton("Add");
		col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCol4();
			}
		});
		col5 = new JButton("Add");
		col6 = new JButton("Add");
		col7 = new JButton("Add");
		
		JPanel nextPanel = new JPanel();
		nextPanel.add(col1);
		nextPanel.add(col2);
		nextPanel.add(col3);
		nextPanel.add(col4);
		nextPanel.add(col5);
		nextPanel.add(col6);
		nextPanel.add(col7);
		
		board.add(nextPanel, BorderLayout.SOUTH);
		board.setSize(500, 500);
	}
	private void setup() {
		board = new JFrame(name);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.getContentPane().setBackground(Color.BLUE);
		board.setVisible(true);	
		
		DiskBlank disk;
		disk = new DiskBlank(10, 10);
		
	}
	private void addCol1() {
		if(col1stack < 6) {
			col1stack++;
			addDisk(1, col1stack);
		} else if(col1stack == 6) {
			col1.setEnabled(false);
			col1stack++;
		} else if(col1stack > 6) {
			System.out.println("Column Full");
		}
	}
	private void addCol2() {
		if(col1stack < 6) {
			col1stack++;
			addDisk(1, col1stack);
		} else if(col1stack == 6) {
			col1.setEnabled(false);
			col1stack++;
		} else if(col1stack > 6) {
			System.out.println("Column Full");
		}
	}
	private void addCol3() {
		if(col1stack < 6) {
			col1stack++;
			addDisk(1, col1stack);
		} else if(col1stack == 6) {
			col1.setEnabled(false);
			col1stack++;
		} else if(col1stack > 6) {
			System.out.println("Column Full");
		}
	}
	private void addCol4() {
		if(col1stack < 6) {
			col1stack++;
			addDisk(1, col1stack);
		} else if(col1stack == 6) {
			col1.setEnabled(false);
			col1stack++;
		} else if(col1stack > 6) {
			System.out.println("Column Full");
		}
	}
	private void addDisk(int col, int colstack) {
		switch(col) {
			case 1:
				System.out.println("Col 1 Add");
				disk = new DiskImpl(p1);
				disk.add(col1stack, 1);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("Something went wrong");
				break;
		}
	}
}