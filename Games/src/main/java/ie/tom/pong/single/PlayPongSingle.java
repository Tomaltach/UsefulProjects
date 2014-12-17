package ie.tom.pong.single;

import javax.swing.JFrame;

public class PlayPongSingle {

	public PlayPongSingle() throws InterruptedException {
		JFrame frame = new JFrame("Single Pong");
		PongSingleImpl pong = new PongSingleImpl();
		
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