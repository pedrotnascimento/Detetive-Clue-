package detetive;

import graphics.Board;
import graphics.Room;
import graphics.SecretExit;
public class Path {
	int[][] path;
	public static final int ESTAR = 4;
	public static final int JANTAR = 5;
	public static final int COZINHA = 6;
	public static final int MUSICA = 7; 
	public static final int INVERNO = 8;
	public static final int JOGOS = 9;
	public static final int BIBLIOTECA = 10;
	public static final int ESCRITORIO = 11;
	public static final int ENTRADA = 12;
	public static final int FLOOR = 1;
	public static final int DOOR = 2;

	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	Room[] rooms = new Room[13];
	
	public Path(Board b){
		SecretExit e1,e2,e3,e4;
		Room r; 
		//sala de estar
		r = new Room(ESTAR);
		e1 = new SecretExit(1, 6, 19);
		e1.setSaida(6,18);
		e2 = new SecretExit('x',0,22);
		e2.setSaida(23, 4);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[ESTAR] = r;
		
		//sala de jantar
		r = new Room(JANTAR);
		e1 = new SecretExit(1, 6, 15);
		e1.setSaida(6,16);
		e2 = new SecretExit(2, 7, 12);
		e2.setSaida(8,12);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setExit(e2);
		rooms[JANTAR] = r;
		
		//cozinha
		r = new Room(COZINHA);
		e1 = new SecretExit(1, 4, 6);
		e1.setSaida(4,7);
		e2 = new SecretExit('x', 0, 2);
		e2.setSaida(22,22);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[COZINHA] = r;
		
		//sala de música
		r = new Room(MUSICA);
		e1 = new SecretExit(1, 8, 5);
		e1.setSaida(7,5);
		e2 = new SecretExit(2,9,7);
		e2.setSaida(9, 8);
		e3 = new SecretExit(3,14,7);
		e3.setSaida(14, 8);
		e4 = new SecretExit(4,15,5);
		e4.setSaida(16, 5);
		b.setCell(e1);
		b.setCell(e2);
		b.setCell(e3);
		b.setCell(e4);
		r.setExit(e1);
		r.setExit(e2);
		r.setExit(e3);
		r.setExit(e4);
		rooms[MUSICA] = r;
		
		//sala de inverno
		r = new Room(INVERNO);
		e1 = new SecretExit(1, 19, 5);
		e1.setSaida(18,5);
		e2 = new SecretExit('x',23,3);
		e2.setSaida(1, 22);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[INVERNO] = r;
		
		//sala de jogos
		r = new Room(JOGOS);
		e1 = new SecretExit(1, 18, 9);
		e1.setSaida(17,9);
		e2 = new SecretExit(2, 22, 12);
		e2.setSaida(22,13);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setExit(e2);
		rooms[JOGOS] = r;
		
		//sala de biblioteca
		r = new Room(BIBLIOTECA);
		e1 = new SecretExit(1, 18, 9);
		e1.setSaida(17,9);
		e2 = new SecretExit(2, 22, 12);
		e2.setSaida(22,13);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setExit(e2);
		rooms[BIBLIOTECA] = r;
		
		//sala de escritorio
		r = new Room(ESCRITORIO);
		e1 = new SecretExit(1, 17, 21);
		e1.setSaida(17,20);
		e2 = new SecretExit('x', 23, 22);
		e2.setSaida(0,4);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[ESCRITORIO] = r;
		
		//sala de biblioteca
		r = new Room(ENTRADA);
		e1 = new SecretExit(1, 11, 18);
		e1.setSaida(11, 17);
		e2 = new SecretExit(2, 12, 18);
		e2.setSaida(12, 17);
		e3 = new SecretExit(3, 14, 20);
		e3.setSaida(15,20);
		b.setCell(e1);
		b.setCell(e2);
		b.setCell(e3);
		r.setExit(e1);
		r.setExit(e2);
		r.setExit(e3);
		rooms[ENTRADA] = r;

		path = new int[25][26];
		
		path[7][24]=1;//Scarlet inicio
		path[7][23]=1;
		path[8][23]=1;
		path[7][22]=1;
		path[8][22]=1;
		path[7][21]=1;
		path[8][21]=1;
		path[7][20]=1;
		path[8][20]=1;
		path[7][19]=1;
		path[8][19]=1;
		path[7][18]=1;
		path[8][18]=1;
		path[7][17]=1;
		path[8][17]=1;
		path[7][16]=1;
		path[8][16]=1;
		
		
		//caminho inicial para mustard
		path[0][17]=1; //inicio mustard
		path[1][16]=1;
		path[2][16]=1;
		path[3][16]=1;
		path[4][16]=1;
		path[5][16]=1;
		path[6][16]=DOOR;
		path[6][15]=JANTAR;//SALA DE JANTAR
		path[1][17]=1;
		path[2][17]=1;
		path[3][17]=1;
		path[4][17]=1;
		path[5][17]=1;
		path[6][17]=1;
		path[1][18]=1;
		path[2][18]=1;
		path[3][18]=1;
		path[4][18]=1;
		path[5][18]=1;
		path[6][18]=DOOR;
		path[6][19]=rooms[ESTAR].room;//SALA DE ESTAR
		
		path[9][17]=1;
		path[10][17]=1;
		path[11][17]=DOOR;
		path[11][18]=DOOR;
		path[12][17]=DOOR;
		path[12][18]=DOOR;
		path[13][17]=1;
		path[14][17]=1;
		
	
	}
	public int isPath(int x,int y, int dir){
		
			if(!(dir>=0 && dir<=3)){
				System.out.println("Direcao nao reconhecida");
				return -1;
			}
			switch(dir){
			case UP:
				y-=1;
				break;
			case RIGHT:
				x+=1;
				break;
			case DOWN:
				y+=1;
				break;
			case LEFT:
				x-=1;
				break;
			}
			return path[x][y];				
	}
	
	public int isPath(int x,int y){
		
		return path[x][y];				
	}
	
	public Room[] getRooms(){
		return rooms;
	}
	
}
