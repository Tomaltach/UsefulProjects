package ie.tom.pong.doubles;

import javax.swing.JFrame;

public class PlayPongDouble {

	public PlayPongDouble() throws InterruptedException {
		JFrame frame = new JFrame("Double Pong");
		PongDoubleImpl pong = new PongDoubleImpl();
		
		frame.add(pong);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			pong.move();
			frame.repaint();
			Thread.sleep(10);
		}
	}
}