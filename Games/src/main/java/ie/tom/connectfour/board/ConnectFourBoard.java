package ie.tom.connectfour.board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConnectFourBoard extends JFrame implements Board {
	private String name;
	private JFrame board;
	private int col1stack = 0;
	private JButton col1, col2, col3, col4, col5, col6, col7;

	public ConnectFourBoard(String name) {
		this.name = name;	
	}
	public void drawBoard() {
		board = new JFrame(name);
		board.setSize(1000, 1000);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setVisible(true);
		
		col1 = new JButton("Add");
		col1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCol1();
			}
		});
		col2 = new JButton("Add");
		col2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		col3 = new JButton("Add");
		col3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		col4 = new JButton("Add");
		col4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
	}
	protected void addCol1() {
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