package detetive;
import graphics.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;



public class GamePlay extends JFrame{
	static final int W = 800;
	static final int H = 750;
	public static String[] characters;
	
	public GamePlay(ArrayList<String>  players){
		setSize(W,H);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Clue!!");
		startGame(players);
	}
 
	public void startGame(ArrayList<String> players) {
		
		Board b  = new Board();
		
		b.setLayout(null);
		if(players.contains(characters[0])){
			Char c = new Char (characters[0], 7, 24);
			b.defineCell(c);
		}
		if(players.contains(characters[1])){
			Char c = new Char (characters[1],  0, 17);
			b.defineCell(c);
		}
		if(players.contains(characters[2])){
			Char c = new Char (characters[2], 9, 0);
			b.defineCell(c);
		}
		if(players.contains(characters[3])){
			Char c = new Char (characters[3],14, 0 );
			b.defineCell(c );
		}
		if(players.contains(characters[4])){
			Char c = new Char (characters[4], 23, 6);
			b.defineCell(c);
		}
		if(players.contains(characters[5])){
			Char c = new Char (characters[5], 23, 19);
			b.defineCell(c);
		}
		
		Porta p1 = new Porta (Porta.UP,"cozinha", 4,7); 
		b.defineCell(p1);
//		new Path(b);
		getContentPane().add(b);
		setVisible(true);
	}
	
	static void setPlayers( String[] charactersIn){
		characters = charactersIn;
	}

}
