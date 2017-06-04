package graphics;

public class Exit extends Cell{
	int id;
	public int x;
	public int y;
	public int saidaX;
	public int saidaY;
	
	public Exit(int id, int x, int y){
		super(String.valueOf(id), x, y);
		this.id = id;
		if('x'==id)
			filename = "x";
	}
	
	
	public void setSaida(int x, int y){
		this.saidaX= x;
		this.saidaY = y;
		
	}
}
