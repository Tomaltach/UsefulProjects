package ie.tom.pong.single;

import ie.tom.pong.Ball;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BallSingle implements Ball {
	private static final int DIAMETER = 30;
	
	private PongSingleImpl pongSingle;
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;	
	
	public BallSingle(PongSingleImpl pongSingle) {
		this.pongSingle = pongSingle;
	}
	public void moveBall() {
		if(x + xa < 0) {
			xa = pongSingle.speed;
		}
		if(x + xa > pongSingle.getWidth() - DIAMETER) {
			xa = -pongSingle.speed;
		}
		if(y + ya < 0) {
			ya = pongSingle.speed;
		}
		if(y + ya > pongSingle.getHeight() - DIAMETER) {
			pongSingle.gameOver();
		}
		if(collision()) {
			ya = -pongSingle.speed;
			y = pongSingle.racket.getTopY() - DIAMETER;
			pongSingle.speed++;
		}
		x = x + xa;
		y = y + ya;
	}
	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
	}
	public boolean collision() {
		return pongSingle.racket.getBounds().intersects(getBounds());
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}