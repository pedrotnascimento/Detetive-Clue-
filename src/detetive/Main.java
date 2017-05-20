package detetive;

import javax.swing.JFrame;

public class Main {
	static final String [] players = {
			"Scarlet",
			"Mustard",
			"White",
			"Green",
			"Peacock",
			"Plum"
	};
	 

	public static void main(String[] args) {
		GamePlay.setPlayers(players);
		JFrame m = new MenuStart();
	}
}
