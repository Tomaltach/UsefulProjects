package ie.tom.pong.doubles;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import ie.tom.pong.Ball;

public class BallDouble implements Ball {
	private static final int DIAMETER = 30;
	
	private PongDoubleImpl pongDouble;
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;	
	
	public BallDouble(PongDoubleImpl pongDouble) {
		this.pongDouble = pongDouble;
	}
	public void moveBall() {
		if(x + xa < 0) {
			xa = pongDouble.speed;
		}
		if(x + xa > pongDouble.getWidth() - DIAMETER) {
			xa = -pongDouble.speed;
		}
		if(y + ya < 0) {
			ya = pongDouble.speed;
		}
		if(y + ya > pongDouble.getHeight() - DIAMETER) {
			pongDouble.gameOver();
		}
		if(collision()) {
			ya = -pongDouble.speed;
			y = pongDouble.racket.getTopY() - DIAMETER;
			pongDouble.speed++;
		}
		x = x + xa;
		y = y + ya;
	}
	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
	}
	public boolean collision() {
		return pongDouble.racket.getBounds().intersects(getBounds());
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}