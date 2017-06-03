package graphics;

public class Char extends Cell{
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	public String nome;
	int qtMoves;
	public Char(String nome, int x, int y){
		super(nome, x, y);
		
	}
	
	public void setCards(){
		
	}
	public boolean move(int dir){
		if(!(dir>=0 && dir<=3)){
			System.out.println("Direcao nao reconhecida");
			return false;
		}
		int curr_x = this.x;
		int curr_y = this.y;
		switch(dir){
		case UP:
			setPosition(curr_y+1, curr_x);
			break;
		case RIGHT:
			setPosition(curr_y, curr_x+1);
			break;
		case DOWN:
			setPosition(curr_y-1, curr_x);
			break;
		case LEFT:
			setPosition(curr_y, curr_x-1);
			break;
		}
		
		return true;
	}
	
	public void setMove(int moves){
		
	}
	
	
	
}
