package detetive;
import graphics.*;

import menu.PlayerInfo;
import menu.Suggest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
	

public class GamePlay extends JFrame implements KeyListener{
	static final int W = 800;
	static final int H = 750;
	public static String[] characters;
	static ArrayList<Card> cards = new ArrayList<Card>();
	static Confidential confidential;
	ArrayList<Player>playersChars = new ArrayList<Player>();
	Player currPlayer = null;
	int currPlayerInx = 0;
	JLabel currPlayerLabel;
	int qtJogadas;
	JLabel qtJogadasLabel;
	Room[] rooms;
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
	
	public GamePlay(){
		setSize(W,H);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Clue!!");
		
		loadGame();
		addKeyListener(this);
	}
 
	public void startGame(ArrayList<String> players) {
		
		board  = new Board();
		board.setLayout(null);
		path = new Path(board);
		rooms = path.getRooms();		
		getContentPane().add(board);

		if(players.contains(characters[0])){
			Player c = new Player (characters[0], 7, 24);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[1])){
			Player c = new Player (characters[1],  0, 17);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[2])){
			Player c = new Player (characters[2], 9, 0);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[3])){
			Player c = new Player (characters[3],14, 0 );
			board.setCell(c );
			playersChars.add(c);
		}
		if(players.contains(characters[4])){
			Player c = new Player (characters[4], 23, 6);
			board.setCell(c);
			playersChars.add(c);
		}
		if(players.contains(characters[5])){
			Player c = new Player (characters[5], 23, 19);
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
		setVisible(true);
		
		currPlayer = playersChars.get(currPlayerInx);
		playerInfo = new PlayerInfo();
		playerInfo.setPlayerInfo(currPlayer.getCards(), currPlayer.getNotes());

	}
	
	public void loadGame(){
		board  = new Board();
		board.setLayout(null);
		path = new Path(board);
		rooms = path.getRooms();		
		getContentPane().add(board);
		
		Scanner load=null;
		try{
			load = new Scanner(new FileReader("jogo_salvo.txt"));
			
		}
		catch(IOException FileNotFoundException){
			
			FileNotFoundException.printStackTrace();
			System.out.println("Não tem arquivo de jogo a ser carregado");
			System.exit(0);
		}
		
		//obtem o nome do jogador corrente
		String currentPlayerName = aux_loadGame(load.nextLine());
		
		//obtem qt de movimentos
		int currentPlayerQtMoves = Integer.parseInt(aux_loadGame(load.nextLine()));
		String Who = aux_loadGame(load.nextLine());
		String Where = aux_loadGame(load.nextLine());
		String Weapon = aux_loadGame(load.nextLine());
		confidential = new Confidential();
		confidential.setWho(Who);
		confidential.setWhere(Where);
		confidential.setWeapon(Weapon);
		load.nextLine();
		String current;
		Player p;
		while(load.hasNext()){
			current = load.nextLine();
			String[] line = current.split(";");
			p = new Player(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
			p.room = Integer.parseInt(line[3]);
			String[] notes = line[4].split("&");
			for(int  i =0 ; i < notes.length; i++){
				p.addNotes(notes[i]);
			}
			
			String[] cards = line[5].split("&");
			for(int  i =0 ; i < cards.length; i++){
				p.receiveCard(new Card(cards[i]));
			}
			
			
			board.setCell(p);
			playersChars.add(p);
		}
		
		for(int i =0; i< playersChars.size(); i++)
			if(playersChars.get(i).nome == currentPlayerName){
				currPlayerInx = i;
				break;
			}
				
		currPlayer = playersChars.get(currPlayerInx);
		playerInfo = new PlayerInfo();
		playerInfo.setPlayerInfo(currPlayer.getCards(), currPlayer.getNotes());
		setVisible(true);
		
	}
	
	
	
	static void configPlayers( String[] charactersIn){
		characters = charactersIn;
	}
	
	static void configCards( ArrayList<Card> cardsIn){
		cards = cardsIn;
	}
	
	static void configClue(Confidential confident){
		confidential = confident;
	}
	
	public void keyTyped(KeyEvent k){
		int key = k.getKeyChar();
		int dir = -1;
		final int KEY_SPACE = 32;
		//AS VEZES O CARACTER 'w' SAI COMO 87, mas deveria ser 119 
		// teste abaixo
		System.out.printf("key corrente %d ", key);
		if(qtJogadas>0){
			int currRoom;  
			switch(key){
			case 'w':
			case 'W':
				System.out.printf("UP\n");
				dir = 0;
				break;
			case 'd':
			case 'D':
				System.out.printf("R\n");
				dir = 1;
				break;
			case 's':
			case 'S':
				System.out.printf("D\n");
				dir = 2;
				break;
			case 'a':
			case 'A':
				System.out.printf("L\n");
				dir = 3;
				break;
			case '1':
			case '!':
				movePlayerOut(1);
				return;
			case '2':
			case '@':
				movePlayerOut(2);
				return;
			case '3':
			case '#':
				movePlayerOut(3);
				return;
			case '4':
			case '$':
				movePlayerOut(4);
				return;
			case KEY_SPACE:
				currRoom  =currPlayer.room;
				if(rooms[currRoom].hasSecret()==true){
					int x = rooms[currRoom].getSecretPosX();
					int y = rooms[currRoom].getSecretPosY();
					currPlayer.setPosition(x, y);
					board.remove(currPlayer);
					board.setCell(currPlayer);
					currPlayer.room = rooms[currRoom].getSecretRoom(); 
					qtJogadas=0;
					changePlayer();
				}
				
				return;
			}
			
			int tempx = currPlayer.x;
			int tempy = currPlayer.y;
			
			int currTerrainType = path.getPathType(tempx , tempy);
			int terrainType = path.getPathType(tempx,tempy,dir);
			
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
				System.out.println(terrainType + " " + rooms[terrainType]);
				rooms[terrainType].qt+=1;
				
				currPlayer.enterRoom(dir, rooms[terrainType].qt);
				board.remove(currPlayer);
				board.setCell(currPlayer);
				qtJogadas=0;
				qtJogadasLabel.setText("Jogadas restantes: " +String.valueOf(qtJogadas));
				currPlayer.room = terrainType;
				
				suggestionRoutine();
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
		currPlayerInx = (currPlayerInx+1)%playersChars.size();
		currPlayer = playersChars.get(currPlayerInx);
		currPlayerLabel.setText("Jogador: " + currPlayer.nome);
		playerInfo.setPlayerInfo(currPlayer.getCards(), currPlayer.getNotes());
	}
	
	void movePlayerOut(int exit_num){ 
		int currRoom =currPlayer.room;
		Room r = rooms[currRoom];	
		r.qt-=1;
		Exit exit = r.hasExit(exit_num);
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
	}
	
	void suggestionRoutine(){
		Suggest s = new Suggest();
		s.enviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("passou3");
				String who = s.getWho();
				String where = s.getWhere();
				String weapon = s.getWeapon();
				System.out.println(who + " "+  where + " " + weapon);
				boolean breaked = false;
				for(Player p : playersChars){
					if(p.nome!=currPlayer.nome){
						ArrayList<Card> cs = p.getCards();
						System.out.println("nome " +p.nome);
						for(int i =0 ; i<cs.size(); i++){
							Card c = cs.get(i);
							if(who==c.name){
								currPlayer.addNotes(who);
								breaked = true;
								break;
								
							}
							else if(where==c.name){
								currPlayer.addNotes(where);
								breaked = true;
								break;
							}
							else if(weapon==c.name){
								currPlayer.addNotes(weapon);
								breaked = true;
								break;
							}
							System.out.printf("%s ", c.name);
						}
						
						if(breaked) break;
					}
				}
				if(!breaked){
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(s, "Fará acusação?", "Ninguém se manisfestou", dialogButton);
					if(dialogResult == 0) {
					  System.out.println("Yes option, checando o clue");
						 if(confidential.isAccusationTrue(who, weapon, where)){
							 JOptionPane.showMessageDialog(s, "VOCÊ VENCEU!");
							 System.exit(0);
						 }
						 else{
							 System.out.println("Acusação FALSA!! Jogador perdeu!");
							 JOptionPane.showMessageDialog(s, "Acusação FALSA!! Jogador perdeu!");
							 playersChars.remove(currPlayer);
						 }
					 
					  
					} 
					else {
					  System.out.println("sem acusação, passa direto");
					} 
					
				}
				
				s.setVisible(false);
				changePlayer();
			}
		});
	}
	
	public String getFullReport(){
		String report = "@current:" + currPlayer.nome + "\n";
		report +=  "@move_qt:" + currPlayer.qtMoves + "\n";
		report += "@who:" + confidential.getWho() + "\n";
		report += "@where:" + confidential.getWhere() + "\n";
		report += "@weapon:" + confidential.getWeapon()+ "\n";
		report +="player;x;y;room;notes;cards\n";
		for(int i =0; i< playersChars.size(); i++){
			Player p = playersChars.get(i);
			report += p.nome + ";" + p.x + ";"+ p.y + ";" + p.room + ";";
			ArrayList<String> n = p.getNotes();
			for(int j = 0 ; j < n.size(); j++){
				report+= n.get(j);
				if(j < n.size() -1)
					report += "&";
				
			}
			
			report += ";";
			ArrayList<Card> a = p.getCards(); 
			for(int j = 0 ; j < a.size(); j++){
				report+= a.get(j).name;
				if(j < a.size() -1)
					report += "&";
				
			}   
			report += "\n";
			
			System.out.println("relatorio " + i + " " + report );
		}
		
		 
		return report;
	}
	
	private String aux_loadGame(String current){
		int inx = current.indexOf(':');
		return current.substring(inx+1);
		
	}

}
