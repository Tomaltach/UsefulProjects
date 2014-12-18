package ie.tom.pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Ball {	
	public void moveBall();
	public void paint(Graphics2D g2d);
	public boolean collision();
	public Rectangle getBounds();
}