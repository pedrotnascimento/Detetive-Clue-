package detetive;
import graphics.*;
import menu.Controller;
import menu.PlayerInfo;

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
	public static String[] characters;
	static ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Char>playersChars= new ArrayList<Char>();
	Char currPlayer = null;
	int currPlayerInx = 0;
	JLabel currPlayerLabel;
	int qtJogadas;
	JLabel qtJogadasLabel;
	Room[] rooms = new Room[8];
	Board board;
	PlayerInfo playerInfo;
	Path path;
	
	
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
		
		{
			
			int i =0;
			int tam = playersChars.size();
			while(cards.size()>0){
				playersChars.get(i%tam).receiveCard(cards.get(0));
				cards.remove(0);
				i+=1;
			}
			
			// TESTE PARA VALIDAR CARTAS DISTRIBUIDAS
//			for(int i =0 ; i< playersChars.size() ;i++){
//			Char c = playersChars.get(i);
//			for(Card j : c.getCards()){
//				System.out.println(j.name);
//			}
//		}
		
		}
		

		
		
		Room r = new Room(4);
		SecretExit e1 = new SecretExit(1, 6, 19);
		e1.setSaida(6,18);
		SecretExit e2 = new SecretExit('x',0,22);
		e2.setSaida(23, 4);
		board.setCell(e1);
		board.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[4] = r;
		path = new Path(board, rooms);
		
		
		getContentPane().add(board);
		setVisible(true);
		
		currPlayer = playersChars.get(currPlayerInx);
		playerInfo = new PlayerInfo();
		playerInfo.setPlayerInfo(currPlayer.getCards(), currPlayer.getNotes());

	}
	
	static void configPlayers( String[] charactersIn){
		characters = charactersIn;
	}
	
	static void configCards( ArrayList<Card> cardsIn){
		cards = cardsIn;
	}
	
	public void keyTyped(KeyEvent k){
		int key = k.getKeyChar();
		int dir = -1;
		final int KEY_SPACE = 32;
		System.out.println(key);
		if(qtJogadas>0){
			int currRoom;  
			switch(key){
			case 'w':
//				System.out.println("UP");
				dir = 0;
				break;
			case 'd':
//				System.out.println("R");
				dir = 1;
				break;
			case 's':
//				System.out.println("D");
				dir = 2;
				break;
			case 'a':
//				System.out.println("L");
				dir = 3;
				break;
			case '1':
				currRoom =currPlayer.room;
				Room r = rooms[currRoom];	
				r.qt-=1;
				SecretExit exit = r.hasExit(1	);
				boolean hasPlayer = false;
				for( int i =0; i < playersChars.size(); i++){
					if(exit.saidaX == playersChars.get(i).x &&
						exit.saidaY ==playersChars.get(i).y )
							hasPlayer = true;
				}
				if(!hasPlayer){
					currPlayer.room = Path.FLOOR;
					currPlayer.setPosition(exit.saidaX, exit.saidaY);
					board.remove(currPlayer);
					board.setCell(currPlayer);
					changePlayer();
				}else{
					System.out.println("ja tem jogador");
				}
				
				revalidate();
				repaint();
				return;
			case KEY_SPACE:
				currRoom  =currPlayer.room;
				if(rooms[currRoom].getSecret()!=null){
					SecretExit secret = rooms[currRoom].getSecret();
					currPlayer.setPosition(secret.saidaX, secret.saidaY);
					board.remove(currPlayer);
					board.setCell(currPlayer);
					qtJogadas=0;
					changePlayer();
				}
				
				return;
			}
			
			int tempx = currPlayer.x;
			int tempy = currPlayer.y;
			int currTerrainType = path.isPath(tempx , tempy);
			int terrainType = path.isPath(tempx,tempy,dir);
			System.out.printf("prox %d   atual %d\n", terrainType, currTerrainType);
			if(dir!=-1 && (terrainType==Path.FLOOR || terrainType==Path.DOOR)
					&&(currTerrainType==Path.FLOOR || currTerrainType==Path.DOOR)){
				currPlayer.move(dir);
				currPlayer.room = currTerrainType;
				board.remove(currPlayer);
				board.setCell(currPlayer);
				qtJogadas-=1;
				qtJogadasLabel.setText("Jogadas restantes: " +String.valueOf(qtJogadas));
				if(qtJogadas==0){
					changePlayer();
				}
				revalidate();
				repaint();
			}
			else if(dir!=-1 && currTerrainType==Path.DOOR){
				rooms[terrainType].qt+=1;
				
				currPlayer.enterRoom(dir, rooms[terrainType].qt);
				board.remove(currPlayer);
				board.setCell(currPlayer);
				qtJogadas=0;
				currPlayer.room = terrainType;
				changePlayer();
				qtJogadasLabel.setText("Jogadas restantes: " +String.valueOf(qtJogadas));
				
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
	
	// usada para setar o primeiro jogador na classe controller
	public void setCurrPlayerLabel(JLabel label){
		this.currPlayerLabel = label;
		this.currPlayerLabel.setText("Jogador: " + currPlayer.nome);
	}
	
	void changePlayer(){
		currPlayerInx = (currPlayerInx+1)%2;
//		currPlayerInx = (currPlayerInx+1)%playersChars.size();
		currPlayer = playersChars.get(currPlayerInx);
		currPlayerLabel.setText("Jogador: " + currPlayer.nome);
		playerInfo.setPlayerInfo(currPlayer.getCards(), currPlayer.getNotes());
	}

}
