package ie.tom.pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public interface Racket {
	public void moveRacket();
	public void paint(Graphics2D g2d);
	public void keyReleased(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public Rectangle getBounds();
	public int getTopY();
}