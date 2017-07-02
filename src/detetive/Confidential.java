package detetive;

import java.util.ArrayList;

public class Confidential {
	String who;
	String weapon;
	String where;
	ArrayList<String> Strings = new ArrayList<String>();
	
	public Confidential(){
		 
	}
	
	public boolean isAccusationTrue(String acusWho, String acusWhich, String acusWhere){
		System.out.println("confi::" + who + " " + where + " " + weapon);
		System.out.println("entrda::" + acusWho + " " + acusWhere + " " + acusWhich);
		System.out.println(acusWho.equals(who));
				System.out.println( acusWhere.equals(where));
		System.out.println(acusWhich.equals(weapon));
		if(!acusWho.equals(who) ||
		   !acusWhich.equals(weapon) ||
		   !acusWhere.equals(where)){
			return false;
		}
		return true;
	}
	
	public void setWho(String c){
		who = c;
	}
	public void setWeapon(String c){
		weapon = c;
	}
	public void setWhere(String c){
		where = c;
	}
	
	public String getWho(){
		return who;
	}
	
	public String getWhere(){
		return  where;
	}
	
	public String getWeapon(){
		return  weapon;
	}
	
}
