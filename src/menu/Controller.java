package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import detetive.Dados;
import detetive.GamePlay;

public class Controller extends JFrame{
	public Integer dadoValue;
	JPanel dadoImage = null;
	Dados dados = new Dados();
	public JLabel dadoViciadoLabel;
	public JComboBox<String> dadoViciado;
	
	public Controller(GamePlay gamePlay){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel currPlayer = new JLabel("Jogador: ");
		currPlayer.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JPanel p =  new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JButton saveGame = new JButton("SALVAR JOGO");
		saveGame.setAlignmentX(CENTER_ALIGNMENT);
		
		saveGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String report = gamePlay.getFullReport();
				try{
					PrintWriter out = new PrintWriter( "jogo_salvo.txt" );
					out.print(report);
					out.close();
					System.out.println("jogo salvo");
				}
				catch(IOException  FileNotFoundException){
					FileNotFoundException.printStackTrace();
					System.out.println("ERROR, arquivo de salvamento não encontrado");
				}
			
				
			}
		});
		
		JButton lancarDados = new JButton("DADOS");
		lancarDados.setAlignmentX(CENTER_ALIGNMENT);
		
		dadoViciadoLabel = new JLabel("Dado Viciado");
		dadoViciadoLabel.setAlignmentX(CENTER_ALIGNMENT);
		

		String[] dadosLis = {"1","2","3","4","5","6"};
		dadoViciado = new JComboBox<String>(dadosLis);
		dadoViciado.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JLabel jogadasLabel = new JLabel("Jogadas restantes: 0");
		jogadasLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		
		// COMUNICAO COM O JOGO (OBSERVER) DO GAMEPLAY AO CONTROLLER
		ActionListener aL = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePlay.setJogadas(getDadoValue());
			}
		};
		
		lancarDados.addActionListener(aL);
		dadoViciado.addActionListener(aL);
		
		lancarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dadoImage!= null){
					p.remove(dadoImage);
				}
				
				dadoValue = dados.roll();	
				dadoImage = dados.getDado();	
				dadoImage.setAlignmentX(CENTER_ALIGNMENT);
				p.add(dadoImage);
				jogadasLabel.setText("Jogadas restantes: "+ Integer.toString(dadoValue));
				p.revalidate();
				p.repaint();	
			}
		});
		
		
		dadoViciado.addActionListener(new ActionListener() {
			@Override	
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> m =(JComboBox<String>) e.getSource();
				String dadoValueStr =  (String) m.getSelectedItem();
				dadoValue = Integer.valueOf(dadoValueStr);
				jogadasLabel.setText("Jogadas restantes: "+ Integer.toString(dadoValue));
				p.revalidate();
				p.repaint();	
			}
		});
		p.add(saveGame);
		p.add(currPlayer);
		p.add(lancarDados);
		p.add(dadoViciadoLabel);
		p.add(dadoViciado);
		p.add(jogadasLabel);
		
		add(p);
		setVisible(true);
		setBounds(800,0,120,300);
		
		// OBSERVER: DO CONTROLLER EM RELAÇÃO AO GAMEPLAY
		if(gamePlay.qtJogadas >0){
			jogadasLabel.setText("Jogadas restantes: "+ gamePlay.qtJogadas);
		}
		
		gamePlay.setQtJogadasLabel(jogadasLabel);
		gamePlay.setCurrPlayerLabel(currPlayer);
	}
	
	public Integer getDadoValue(){
		return dadoValue;
	}
	 
	
}
