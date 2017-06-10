package detetive;

import java.util.ArrayList;

public class Confidential {
	Card who;
	Card which;
	Card where;
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Confidential(){
		
	}
	
	public boolean isAccusationTrue(String acusWho, String acusWhich, String acusWhere){
		if(acusWho!= who.name ||
		   acusWhich!= which.name ||
		   acusWhere!= where.name){
			return false;
		}
		return true;
	}
	
	public void setWho(Card c){
		who = c;
	}
	public void setWhich(Card c){
		which = c;
	}
	public void setWhere(Card c){
		where = c;
	}
}
