package ie.tom.connectfour;

import java.awt.Color;

public class DiskImpl implements Disk {
	private Player player;
	private Color color;

	public DiskImpl(Player player) {
		this.player = player;
	}
	public void round() {
		
	}
	public void color() {
		color = player.getColor();
	}
}