package graphics;

import java.util.ArrayList;

public class Room {
	public final static String UP = "UP";
	public final static String RIGHT = "RIGHT";
	public final static String DOWN = "DOWN";
	public final static String LEFT = "LEFT";
	public int room;
	public int qt;
	Exit secret =null;
	
	ArrayList<Exit>exits= new ArrayList<Exit>();
	public Room(int room){
		this.room = room;
	}
	
	public void setExit(Exit exit){
		exits.add(exit);
	}
	
	public void setSecret(Exit exit){
		this.secret =exit;
	}
	
	public Exit hasExit(int exitId){
		System.out.println("oioi " + exitId);
		for(int i =0 ; i< exits.size(); i++){
			System.out.println(exits.get(i).id);
			if(exitId==exits.get(i).id){
				
				return exits.get(i);
			}
		}
		return null;		
	}
	
	public Exit getSecret(){
		return secret;
		
	}
	
}

