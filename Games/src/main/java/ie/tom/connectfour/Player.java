package ie.tom.connectfour;

import java.awt.Color;

public class Player {
	@SuppressWarnings("unused")
	private String name;
	private Color color;

	public Player(String name) {
		this.name = name;
		chooseColor();
	}
	private void chooseColor() {
		System.out.println("What color:");
		color = Color.RED;
	}
	public Color getColor() {
		return color;		
	}
}