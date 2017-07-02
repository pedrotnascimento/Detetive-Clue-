package graphics;

public class Exit extends Cell{
	public int id;
	public int x;
	public int y;
	public int saidaX;
	public int saidaY;
	public int room;
	public Exit(int id, int x, int y){
		super(String.valueOf(id), x, y);
		this.id = id;
		if('x'==id)
			filename = "x";
	}
	
	public Exit(int id, int x, int y, int room){
		super(String.valueOf(id), x, y);
		this.id = id;
		this.room = room;
		if('x'==id)
			filename = "x";
	}
	
	
	public void setSaida(int x, int y){
		this.saidaX= x;
		this.saidaY = y;
		
	}
}
