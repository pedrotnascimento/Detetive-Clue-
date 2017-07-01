package detetive;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import menu.MainMenu;


public class Main {
	public static final String [] players = {
			"Scarlet",
			"Mustard",
			"White",
			"Green",
			"Peacock",
			"Plum"
	};
	
	public static final String [] weapons= {
			"Revolver",
			"Cano",
			"Castical",
			"Chave Inglesa",
			"Corda",
			"Faca"
	};
	//TODO?: usar dicionario para apontar para outras informações 
	public static final String [] rooms= {
			"Cozinha",
			"Sala de Musica",
			"Jardim de Inverno",
			"Sala de Jantar",
			"Salao de Jogos",
			"Biblioteca",
			"Sala de Estar",
			"Entrada",
			"Escritorio"
	};
	
	 
	 
	public static void main(String[] args) {
		GamePlay.configPlayers(players);

		ArrayList<Card> playersCards = new ArrayList<Card>();
		ArrayList<Card> weaponsCards = new ArrayList<Card>();
		ArrayList<Card> roomsCards = new ArrayList<Card>();
		for(int i =0 ; i<players.length; i++){
			Card c = new Card(players[i]);
			playersCards.add(c);
		}
		
		for(int i =0 ; i<weapons.length; i++){
			Card c = new Card(weapons[i]);
			weaponsCards.add(c);		
		}
		
		for(int i =0 ; i<rooms.length; i++){
			Card c = new Card(rooms[i]);
			roomsCards.add(c);
		}
		
		Collections.shuffle(playersCards);
		Collections.shuffle(weaponsCards);
		Collections.shuffle(roomsCards);
		
		Confidential confidential = new Confidential();
		
		confidential.setWho(playersCards.get(0).name);
		playersCards.remove(0);
		confidential.setWeapon(weaponsCards.get(0).name);
		weaponsCards.remove(0);
		confidential.setWhere(roomsCards.get(0).name);
		roomsCards.remove(0);
		
		ArrayList<Card> cards = new ArrayList<Card>();	
		cards.addAll(playersCards);
		cards.addAll(weaponsCards);
		cards.addAll(roomsCards);
		Collections.shuffle(cards);
		
		GamePlay.configCards(cards);
		GamePlay.configClue(confidential);
////		teste para player info
//		PlayerInfo p  = new PlayerInfo();
//		ArrayList<String> testeNotes = new ArrayList<String>();
//		testeNotes.add("maça");
//		testeNotes.add("pera");
//		testeNotes.add("uva");
//		p.setPlayerInfo(null, testeNotes);
//		p.addNote("açlskdjf");
		JFrame m = new MainMenu();
		

	}
}
