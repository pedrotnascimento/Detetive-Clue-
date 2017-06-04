package detetive;
import graphics.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;



public class GamePlay extends JFrame implements KeyListener{
	static final int W = 800;
	static final int H = 750;
	Char curr_player = null;
	public static String[] characters;
	Board b;
	
	ArrayList<Char>playersChars= new ArrayList<Char>(); 
	{
		setFocusable(true);
	}
	@Override
	public synchronized void addKeyListener(KeyListener l) {
		// TODO Auto-generated method stub
		super.addKeyListener(this);
	}
	
	public GamePlay(ArrayList<String>  players){
		setSize(W,H);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Clue!!");
		startGame(players);
		addKeyListener(this);
	}
 
	public void startGame(ArrayList<String> players) {
		
		b  = new Board();
		
		b.setLayout(null);
		if(players.contains(characters[0])){
			Char c = new Char (characters[0], 7, 24);
			b.setCell(c);
			playersChars.add(c);
			
		}
		if(players.contains(characters[1])){
			Char c = new Char (characters[1],  0, 17);
			b.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[2])){
			Char c = new Char (characters[2], 9, 0);
			b.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[3])){
			Char c = new Char (characters[3],14, 0 );
			b.setCell(c );
			playersChars.add(c);
		}
		if(players.contains(characters[4])){
			Char c = new Char (characters[4], 23, 6);
			b.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[5])){
			Char c = new Char (characters[5], 23, 19);
			b.setCell(c);
			playersChars.add(c);
		}
		
		Porta p1 = new Porta (Porta.UP,"cozinha", 4,7); 
		b.setCell(p1);
		
		
		getContentPane().add(b);
		setVisible(true);
		
		curr_player = playersChars.get(0);
	}
	
	static void setPlayers( String[] charactersIn){
		characters = charactersIn;
	}
	
	public void keyTyped(KeyEvent k){
		int key = k.getKeyChar();
		int dir = -1;
		switch(key){
		case 'w':
			System.out.println("UP");
			dir = 0;
			break;
		case 'd':
			System.out.println("R");
			dir = 1;
			break;
		case 's':
			System.out.println("D");
			dir = 2;
			break;
		case 'a':
			System.out.println("L");
			dir = 3;
			break;
		}

		curr_player.move(dir);
		b.remove(curr_player);
		b.setCell(curr_player);
		revalidate();
		repaint();
		
	}
	
	public void keyPressed(KeyEvent k){
//		System.out.println(k);
	}
	
	public void keyReleased(KeyEvent k){
//		System.out.println(k);
	}

}
