package ie.tom.timekeeper;

import javax.swing.SwingUtilities;

import ie.tom.timekeeper.gui.GUI;
import ie.tom.timekeeper.gui.Login;

public class TimeKeeper {

	public static void main(String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Login login = new Login();
				new GUI(login.login());
			}			
		});
	}
}