package ie.tom.pong;

import java.awt.Graphics;

public interface Pong {
	public void paint(Graphics g);
	public void move();
	public void gameOver();
}