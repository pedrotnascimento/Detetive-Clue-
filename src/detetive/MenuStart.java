package detetive;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import detetive.GamePlay;

public class MenuStart extends JFrame{
	public MenuStart(){
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JButton startGame = new JButton("START");
		JButton loadGame = new JButton("LOAD");
		startGame.setAlignmentX(CENTER_ALIGNMENT);
		loadGame.setAlignmentX(CENTER_ALIGNMENT);
		
		startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Iniciar Jogo");
				new SelectPlayer();
			}
		});
		System.out.println(GamePlay.characters);
		loadGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jogo será carregado!");
				
			}
		});
		
		
		p.add(startGame);
		p.add(loadGame);
		add(p);
		setVisible(true);
		setSize(60, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}	
class SelectPlayer extends JFrame{
	public SelectPlayer(){
		JPanel p =  new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		String [] players = GamePlay.characters;
		
		List<JCheckBox>lis_cb = new ArrayList<JCheckBox>();
		
		for(int i=0 ;i< players.length; i++){
			JCheckBox cb = new JCheckBox(players[i], true);
			lis_cb.add(cb);
			p.add(cb);
		}
		JButton btnOK= new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jogadores selecionados, Iniciando Jogo");
				new GamePlay(getSelecteds(lis_cb));
//				(new GamePlay()).startGame(getSelecteds(lis_cb));
				System.out.println("Jogo iniciado");
			}
		});
		p.add(btnOK);
		
		add(p);
		setSize(90, 210);
		setVisible(true);
		
	}
	
	public ArrayList<String> getSelecteds(List<JCheckBox> players){
		ArrayList<String> selecteds = new ArrayList<String>();
		
		for(int i =0; i<players.size(); i++){
			JCheckBox cb = players.get(i);
			if(cb.isSelected())
				selecteds.add(cb.getText());
		}		
		return  selecteds;
	}
	
	
}