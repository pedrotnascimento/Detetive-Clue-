package detetive;
import graphics.Floor;
import graphics.Board;
public class Path {
	int[][] path;
	public static final int ROOM = 0;
	public static final int FLOOR = 1;
	public static final int DOOR = 2;
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	
	public Path(Board b){
//		Floor f = new Floor(7,23);
//		b.setCell(f);
//		f = new Floor(8,23);
//		b.setCell(f);
		path = new int[23][24];
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
	
	
}
