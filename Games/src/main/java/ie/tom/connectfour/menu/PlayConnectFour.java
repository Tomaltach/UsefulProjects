package ie.tom.connectfour.menu;

import ie.tom.connectfour.board.ConnectFourBoard;

public class PlayConnectFour {

	public static void main(String[] args) {
		ConnectFourBoard c4 = new ConnectFourBoard("C4");
		c4.drawBoard();
	}
}