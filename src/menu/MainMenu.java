package menu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import detetive.GamePlay;

public class MainMenu extends JFrame{
	/*
	 * menu com opções de ínicio e término de jogo
	 */
	public MainMenu(){
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
				new SelectPlayers();
				setVisible(false);
			}
		});
		
		loadGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jogo será carregado!");
				GamePlay gamePlay = new GamePlay();
				
				Controller ctrl = new Controller(gamePlay);
				System.out.println("Jogo iniciado");
				setVisible(false);
				
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


