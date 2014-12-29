package ie.tom.connectfour.disk;

import java.awt.Color;
import java.awt.Graphics2D;

public class DiskBlank {
	private static final int DIAMETER = 30;
	private int x = 10;
	private int y = 10;

	public DiskBlank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void paint(Graphics2D g2d) {
		g2d.fillOval(x, y, DIAMETER, DIAMETER);
		g2d.setColor(Color.WHITE);
	}
}