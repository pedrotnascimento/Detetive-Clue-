package graphics;

public class Porta extends Cell {
	public final static String UP = "UP";
	public final static String RIGHT = "RIGHT";
	public final static String DOWN = "DOWN";
	public final static String LEFT = "LEFT";
	String direction;
	String room;
	
	public Porta(String direction, String room, int x, int y){
		super(direction, x, y);
		this.direction = direction;
		this.room = room;
		
			
	}

}
