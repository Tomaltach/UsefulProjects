package ie.tom.pong.single;

import ie.tom.pong.Racket;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class RacketSingle implements Racket {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	
	private PongSingleImpl pongSingle;
	private int x = 0;
	private int xa = 0;

	public RacketSingle(PongSingleImpl pongSingle) {
		this.pongSingle = pongSingle;
	}
	public void moveRacket() {
		if(x + xa > 0 && x + xa < pongSingle.getWidth() - WIDTH) {
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
			xa = -pongSingle.speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = pongSingle.speed;
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);		
	}
	public int getTopY() {
		return Y;
	}
}