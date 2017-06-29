package graphics;
//public static final int ESTAR = 4;
//public static final int JANTAR = 5;
//public static final int ENTRADA = 6;
//public static final int INVERNO = 7;
//public static final int FLOOR = 1;
//public static final int DOOR = 2;
public enum  PathEnum{
	ESTAR(4),
	JANTAR(5),
	ENTRADA(6),
	INVERNO(7),
	FLOOR(1),
	DOOR(2);
	
	private final int room;
	private PathEnum(int value){
		this.room = value; 
	}
	
	public int e(){
		return room;
	}
}
