package detetive;

import graphics.Board;
import detetive.Main;
import graphics.Exit;

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
	int MAIN_OFFSET = 4; // offset do dicionario em relação a main
	
	public Path(Board b){
		Exit e1,e2,e3,e4;
		Room r; 
		//sala de estar
		r = new Room(ESTAR, Main.rooms[ESTAR-MAIN_OFFSET] );
		e1 = new Exit(1, 6, 19);
		e1.setSaida(6,18);
		e2 = new Exit('x',0,22, INVERNO);
		e2.setSaida(23, 4);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[ESTAR] = r;
		
		//sala de jantar
		r = new Room(JANTAR, Main.rooms[JANTAR-MAIN_OFFSET]);
		e1 = new Exit(1, 6, 15);
		e1.setSaida(6,16);
		e2 = new Exit(2, 7, 12);
		e2.setSaida(8,12);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setExit(e2);
		rooms[JANTAR] = r;
		
		//cozinha
		r = new Room(COZINHA, Main.rooms[COZINHA-MAIN_OFFSET]);
		e1 = new Exit(1, 4, 6);
		e1.setSaida(4,7);
		e2 = new Exit('x', 0, 2, ESCRITORIO);
		e2.setSaida(22,22);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[COZINHA] = r;
		
		//sala de música
		r = new Room(MUSICA, Main.rooms[MUSICA-MAIN_OFFSET]);
		e1 = new Exit(1, 8, 5);
		e1.setSaida(7,5);
		e2 = new Exit(2,9,7);
		e2.setSaida(9, 8);
		e3 = new Exit(3,14,7);
		e3.setSaida(14, 8);
		e4 = new Exit(4,15,5);
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
		r = new Room(INVERNO, Main.rooms[INVERNO-MAIN_OFFSET]);
		e1 = new Exit(1, 19, 5);
		e1.setSaida(18,5);
		e2 = new Exit('x',23,3, ESTAR);
		e2.setSaida(1, 22);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[INVERNO] = r;
		
		//sala de jogos
		r = new Room(JOGOS, Main.rooms[JOGOS-MAIN_OFFSET]);
		e1 = new Exit(1, 18, 9);
		e1.setSaida(17,9);
		e2 = new Exit(2, 22, 12);
		e2.setSaida(22,13);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setExit(e2);
		rooms[JOGOS] = r;
		
		//sala de biblioteca
		r = new Room(BIBLIOTECA, Main.rooms[BIBLIOTECA-MAIN_OFFSET]);
		e1 = new Exit(1, 20, 14);
		e1.setSaida(20,13);
		e2 = new Exit(2, 17, 16);
		e2.setSaida(16, 16);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setExit(e2);
		rooms[BIBLIOTECA] = r;
		
		//sala de escritorio
		r = new Room(ESCRITORIO, Main.rooms[ESCRITORIO-MAIN_OFFSET]);
		e1 = new Exit(1, 17, 21);
		e1.setSaida(17,20);
		e2 = new Exit('x', 23, 22, COZINHA);
		e2.setSaida(0,4);
		b.setCell(e1);
		b.setCell(e2);
		r.setExit(e1);
		r.setSecret(e2);
		rooms[ESCRITORIO] = r;
		
		//sala de entrada
		r = new Room(ENTRADA, Main.rooms[ENTRADA-MAIN_OFFSET]);
		e1 = new Exit(1, 11, 18);
		e1.setSaida(11, 17);
		e2 = new Exit(2, 12, 18);
		e2.setSaida(12, 17);
		e3 = new Exit(3, 14, 20);
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
		path[6][19]=ESTAR;//SALA DE ESTAR
		
	    path[9][16]=1;
	    path[9][15]=1;
	    path[9][14]=1;
	    path[9][13]=1;
	    path[9][12]=1;
	    path[9][11]=1;
	    path[9][10]=1;
	    path[9][9]=1;
	    path[9][8]=DOOR;
	    path[9][7]=MUSICA;
	    path[8][15]=1;
	    path[8][14]=1;
	    path[8][13]=DOOR;
	    path[7][13]=JANTAR;
	    path[8][12]=1;
	    path[8][11]=1;
	    path[8][10]=1;
	    path[8][9]=1;
	    path[8][8]=1;
	    path[7][9]=1;
	    path[6][9]=1;
	    path[5][9]=1;
	    path[7][8]=1;
	    path[6][8]=1;
	    path[5][8]=1;
	    path[4][8]=1;
	    path[3][8]=1;
	    path[2][8]=1;
	    path[1][8]=1;
	    path[0][7]=1;
	    path[1][7]=1;
	    path[2][7]=1;
	    path[3][7]=1;
	    path[4][7]=DOOR;
	    path[4][6]=COZINHA;
	    path[5][7]=1;
	    path[6][7]=1;
	    path[7][7]=1;
	    path[6][6]=1;
	    path[6][5]=1;
	    path[6][4]=1;
	    path[6][3]=1;
	    path[6][2]=1;
	    path[7][6]=1;
	    path[7][5]=DOOR;
	    path[8][5]=MUSICA;
	    path[7][4]=1;
	    path[7][3]=1;
	    path[7][2]=1;
	    path[7][1]=1;
	    path[8][1]=1;
	    path[9][1]=1;
	    path[9][0]=1;
	    path[10][9]=1;
	    path[11][9]=1;
	    path[12][9]=1;
	    path[13][9]=1;
	    path[14][9]=1;
	    path[15][9]=1;
	    path[16][9]=1;
	    path[17][9]=DOOR;
	    path[18][9]=JOGOS;	
	    path[10][8]=1;
	    path[11][8]=1;
	    path[12][8]=1;
	    path[13][8]=1;
	    path[14][8]=DOOR;
	    path[14][7]=MUSICA;
	    path[15][8]=1;
	    path[16][8]=1;
	    path[17][8]=1;
	    path[16][7]=1;
	    path[16][6]=1;
	    path[16][5]=DOOR;
	    path[15][5]=MUSICA;
	    path[16][4]=1;
	    path[16][3]=1;
	    path[16][2]=1;
	    path[16][1]=1;
	    path[17][7]=1;
	    path[17][6]=1;
	    path[17][5]=1;
	    path[17][4]=1;
	    path[17][3]=1;
	    path[17][2]=1;
	    path[15][1]=1;
	    path[14][1]=1;
	    path[14][0]=1;
	    path[18][5]=DOOR;
	    path[19][5]=INVERNO;
	    path[18][6]=1;
	    path[19][6]=1;
	    path[20][6]=1;
	    path[21][6]=1;
	    path[22][6]=1;
	    path[23][6]=1;
	    path[18][7]=1;
	    path[19][7]=1;
	    path[20][7]=1;
	    path[21][7]=1;
	    path[22][7]=1;
	    path[23][7]=1;
	    path[15][10]=1;
	    path[15][11]=1;
	    path[15][12]=1;
	    path[15][13]=1;
	    path[15][14]=1;
	    path[15][15]=1;
	    path[15][16]=1;
	    path[15][17]=1;
	    path[15][18]=1;
	    path[15][19]=1;
	    path[15][20]=DOOR;
	    path[14][20]=ENTRADA;
	    path[15][21]=1;
	    path[15][22]=1;
	    path[15][23]=1;
	    path[16][10]=1;
	    path[16][11]=1;
	    path[16][12]=1;
	    path[16][13]=1;
	    path[16][14]=1;
	    path[16][15]=1;
	    path[16][16]=DOOR;
	    path[16][17]=1;
	    path[17][16]=BIBLIOTECA;
	    path[16][18]=1;
	    path[16][19]=1;
	    path[16][20]=1;
	    path[16][21]=1;
	    path[16][22]=1;
	    path[16][23]=1;
	    path[16][24]=1;
	    path[17][10]=1;
	    path[17][11]=1;
	    path[17][12]=1;
	    path[17][13]=1;
	    path[17][14]=1;
	    path[17][18]=1;
	    path[17][19]=1;
	    path[17][20]=DOOR;
	    path[17][21]=ESCRITORIO;
	    path[18][13]=1;
	    path[19][13]=1;
	    path[20][13]=DOOR;
	    path[20][14]=BIBLIOTECA;
	    path[21][13]=1;
	    path[22][13]=DOOR;
	    path[22][12]=JOGOS;
	    path[18][19]=1;
	    path[19][19]=1;
	    path[20][19]=1;
	    path[21][19]=1;
	    path[22][19]=1;
	    path[23][19]=1;
	    path[18][20]=1;
	    path[19][20]=1;
	    path[20][20]=1;
	    path[21][20]=1;
	    path[22][20]=1;
		
        path[9][17]=1;
        path[10][17]=1;
        path[11][17]=DOOR;
        path[11][18]=ENTRADA;
        path[12][17]=DOOR;
        path[12][18]=ENTRADA;
        path[13][17]=1;
        path[14][17]=1;	
	}
	public int getPathType(int x,int y, int dir){
			System.out.printf("direcao: " + dir);
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
	
	public int getPathType(int x,int y){
		
		return path[x][y];				
	}
	
	public Room[] getRooms(){
		return rooms;
	}
	
}
