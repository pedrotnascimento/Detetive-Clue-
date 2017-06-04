package detetive;

import graphics.Board;
import graphics.Room;
public class Path {
	int[][] path;
	public static final int ESTAR = 4;
	public static final int JANTAR = 5;
	public static final int ENTRADA = 6;
	public static final int INVERNO = 7;
	public static final int FLOOR = 1;
	public static final int DOOR = 2;

	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	
	public Path(Board b, Room[] rooms){

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
		path[6][16]=2;
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
		path[6][18]=2;
		path[6][19]=rooms[ESTAR].room;//SALA DE ESTAR
	
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
	
	
}
