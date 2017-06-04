package detetive;
import graphics.*;
import menu.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GamePlay extends JFrame implements KeyListener{
	static final int W = 800;
	static final int H = 750;
	Char currPlayer = null;
	int currPlayerInx = 0;
	JLabel currPlayerLabel;
	public static String[] characters;
	int qtJogadas;
	JLabel qtJogadasLabel;
	
	Board board;
	Path path;
	
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
		
		board  = new Board();
		
		board.setLayout(null);
		if(players.contains(characters[0])){
			Char c = new Char (characters[0], 7, 24);
			board.setCell(c);
			playersChars.add(c);
			
		}
		if(players.contains(characters[1])){
			Char c = new Char (characters[1],  0, 17);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[2])){
			Char c = new Char (characters[2], 9, 0);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[3])){
			Char c = new Char (characters[3],14, 0 );
			board.setCell(c );
			playersChars.add(c);
		}
		if(players.contains(characters[4])){
			Char c = new Char (characters[4], 23, 6);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[5])){
			Char c = new Char (characters[5], 23, 19);
			board.setCell(c);
			playersChars.add(c);
		}
		
		path = new Path(board);
		
		Porta p1 = new Porta (Porta.UP,"cozinha", 4,7); 
		board.setCell(p1);
		
		
		getContentPane().add(board);
		setVisible(true);
		
		currPlayer = playersChars.get(currPlayerInx);
	}
	
	static void setPlayers( String[] charactersIn){
		characters = charactersIn;
	}
	
	public void keyTyped(KeyEvent k){
		int key = k.getKeyChar();
		int dir = -1;
		if(qtJogadas>0){
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
			int tempx = currPlayer.x;
			int tempy = currPlayer.y;
			int terrainType = path.isPath(tempx,tempy,dir);
			
			if(dir!=-1 && terrainType==Path.FLOOR){
				currPlayer.move(dir);
				board.remove(currPlayer);
				board.setCell(currPlayer);
				qtJogadas-=1;
				System.out.println(qtJogadas);
				qtJogadasLabel.setText("Jogadas restantes: " +String.valueOf(qtJogadas));
				if(qtJogadas==0){
					currPlayerInx = (currPlayerInx+1)%playersChars.size();
					currPlayer = playersChars.get(currPlayerInx);
					currPlayerLabel.setText("Jogador: " + currPlayer.nome);
					
				}
				revalidate();
				repaint();
			}
		} 
	}
	
	public void keyPressed(KeyEvent k){
//		System.out.println(k);
	}
	
	public void keyReleased(KeyEvent k){
//		System.out.println(k);
	}
	
	public void setJogadas(int qt){
		qtJogadas = qt;
	}
	
	public void setQtJogadasLabel(JLabel label){
		this.qtJogadasLabel = label;
	}
	public void setCurrPlayerLabel(JLabel label){
		this.currPlayerLabel = label;
		System.out.println(currPlayer.nome);
		this.currPlayerLabel.setText("Jogador: " + currPlayer.nome);
	}

}
