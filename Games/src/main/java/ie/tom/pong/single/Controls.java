package ie.tom.pong.single;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
	private Racket racket;

	public Controls(Racket racket) {
		this.racket = racket;
	}
	public void keyPressed(KeyEvent arg0) {
		racket.keyPressed(arg0);
	}
	public void keyReleased(KeyEvent e) {
		racket.keyReleased(e);
	}
	public void keyTyped(KeyEvent e) {
		System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
	}
}