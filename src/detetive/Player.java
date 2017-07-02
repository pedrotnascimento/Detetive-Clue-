package detetive;

import java.util.ArrayList;

import graphics.Cell;

public class Player extends Cell{
	ArrayList<Card> cards = new ArrayList<Card>();  
	
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	public static final int FLOOR = 1;
	public String nome;
	public int room = FLOOR;
	public int accusedLastRound = -1;
	int qtMoves;

	private ArrayList<String> notes = new ArrayList<String>();
	
	public Player(String nome, int x, int y){
		super(nome, x, y);
		this.x = x;
		this.y = y;
		this.nome = nome;
		
	}
	
	
	public void setRoom(Room room){
		this.room = room.room;  
	}
	
	public boolean move(int dir){
		System.out.println("move " +  dir);
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
		
		return true;
	}
	
	public boolean enterRoom(int dir, int qt){
		System.out.println("REALLY?");
		if(!(dir>=0 && dir<=3)){
			System.out.println("Direcao nao reconhecida");
			return false;
		}
		switch(dir){
		case UP:
			y-=1+qt;
			break;
		case RIGHT:
			x+=1+qt;
			break;
		case DOWN:
			y+=1+qt;
			break;
		case LEFT:
			x-=1+qt;
			break;
		}
		
		return true;
	}
	
	public void receiveCard(Card c){
		cards.add(c);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public ArrayList<String> getNotes() {		
		return notes;
	}

	public void addNotes(String note) {
		this.notes.add(note);
	}
}
