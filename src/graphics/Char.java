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
		this.x = x;
		this.y = y;
		this.nome = nome;
		System.out.printf("%d %d", x,y);
		
	}
	
	public void setCards(){
		
	}
	public boolean move(int dir){
		if(!(dir>=0 && dir<=3)){
			System.out.println("Direcao nao reconhecida");
			return false;
		}
		switch(dir){
		case UP:
			y-=1;
			setPosition(x, y);
			break;
		case RIGHT:
			x+=1;
			setPosition(x, y);
			break;
		case DOWN:
			y+=1;
			setPosition(x, y);
			break;
		case LEFT:
			x-=1;
			setPosition(x, y);
			break;
		}
		System.out.println(y);
		
		return true;
	}
	
	public void setMove(int moves){
		
	}
	
	
	
}
