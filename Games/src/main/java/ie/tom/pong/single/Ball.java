package ie.tom.pong.single;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	
	private PongSingleImpl pong;
	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
	
	
	public Ball(PongSingleImpl pong) {
		this.pong = pong;
	}
	public void moveBall() {
		if(x + xa < 0) {
			xa = pong.speed;
		}
		if(x + xa > pong.getWidth() - DIAMETER) {
			xa = -pong.speed;
		}
		if(y + ya < 0) {
			ya = pong.speed;
		}
		if(y + ya > pong.getHeight() - DIAMETER) {
			pong.gameOver();
		}
		if(collision()) {
			ya = -pong.speed;
			y = pong.racket.getTop() - DIAMETER;
			pong.speed++;
		}
		x = x + xa;
		y = y + ya;
	}
	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
	}
	private boolean collision() {
		return pong.racket.getBounds().intersects(getBounds());
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}