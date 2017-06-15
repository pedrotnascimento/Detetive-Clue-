package detetive;

import java.util.ArrayList;

public class Confidential {
	Card who;
	Card weapon;
	Card where;
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Confidential(){
		
	}
	
	public boolean isAccusationTrue(String acusWho, String acusWhich, String acusWhere){
		if(acusWho!= who.name ||
		   acusWhich!= weapon.name ||
		   acusWhere!= where.name){
			return false;
		}
		return true;
	}
	
	public void setWho(Card c){
		who = c;
	}
	public void setWeapon(Card c){
		weapon = c;
	}
	public void setWhere(Card c){
		where = c;
	}
	
	public String getWho(){
		return who.name;
	}
	
	public String getWhere(){
		return  where.name;
	}
	
	public String getWeapon(){
		return  weapon.name;
	}
	
}
