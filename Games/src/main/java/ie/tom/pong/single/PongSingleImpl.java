package ie.tom.pong.single;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PongSingleImpl extends JPanel implements PongSingle {
	private static final long serialVersionUID = 395170916112772728L;
	
	public Ball ball = new Ball(this);
	public Racket racket = new Racket(this);
	public int speed = 1;
	
	public PongSingleImpl() {
		KeyListener controls = new Controls(racket);
		addKeyListener(controls);
		setFocusable(true);
	}	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racket.paint(g2d);
		
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}
	public void move() {
		ball.moveBall();
		racket.moveRacket();
	}
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Your score is: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	private int getScore() {
		return speed - 1;
	}
}