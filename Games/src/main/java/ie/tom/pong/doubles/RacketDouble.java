package ie.tom.pong.doubles;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import ie.tom.pong.Racket;

public class RacketDouble implements Racket {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	
	private PongDoubleImpl pongDouble;
	private int x = 0;
	private int xa = 0;

	public RacketDouble(PongDoubleImpl pongDouble) {
		this.pongDouble = pongDouble;
	}
	public void moveRacket() {
		if(x + xa > 0 && x + xa < pongDouble.getWidth() - WIDTH) {
			x = x + xa;
		}
	}
	public void paint(Graphics2D g2d) {
		g2d.fillRect(x, Y, WIDTH, HEIGHT);
	}
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -pongDouble.speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = pongDouble.speed;
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);		
	}
	public int getTopY() {
		return Y;
	}
}