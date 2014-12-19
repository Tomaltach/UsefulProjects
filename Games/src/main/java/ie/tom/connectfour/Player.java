package ie.tom.connectfour;

import java.awt.Color;

public class Player {
	private Color color;

	public Player() {
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