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
			Cell c = new Cell (characters[0]);
			b.defineCell(c, 7, 24);
		}
		if(players.contains(characters[1])){
			Cell c = new Cell (characters[1]);
			b.defineCell(c, 0, 17);
		}
		if(players.contains(characters[2])){
			Cell c = new Cell (characters[2]);
			b.defineCell(c, 9, 0);
		}
		if(players.contains(characters[3])){
			Cell c = new Cell (characters[3]);
			b.defineCell(c, 14, 0 );
		}
		if(players.contains(characters[4])){
			Cell c = new Cell (characters[4]);
			b.defineCell(c, 23, 6);
		}
		if(players.contains(characters[5])){
			Cell c = new Cell (characters[5]);
			b.defineCell(c, 23, 19);
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
