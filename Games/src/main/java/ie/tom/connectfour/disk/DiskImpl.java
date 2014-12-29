package ie.tom.connectfour.disk;

import ie.tom.connectfour.Player;

import java.awt.Color;

public class DiskImpl implements Disk {
	private Player player;
	@SuppressWarnings("unused")
	private Color color;

	public DiskImpl(Player player) {
		this.player = player;
	}
	public void round() {
		
	}
	public void color() {
		color = player.getColor();
	}
	public void add(int diskNo, int colNo) {
		new DiskMovement(this, diskNo, colNo);
	}
}