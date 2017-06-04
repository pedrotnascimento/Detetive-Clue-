package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		
		JPanel p =  new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JButton lancarDados = new JButton("DADOS");
		lancarDados.setAlignmentX(CENTER_ALIGNMENT);
		
		dadoViciadoLabel = new JLabel("Dado Viciado");
		dadoViciadoLabel.setAlignmentX(CENTER_ALIGNMENT);
		

		String[] dadosLis = {"1","2","3","4","5","6"};
		dadoViciado = new JComboBox<String>(dadosLis);
		dadoViciado.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JLabel jogadasLabel = new JLabel("Jogadas restantes: 0");
		jogadasLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		
		// COMUNICAO COM O JOGO
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
				System.out.println(2);
				JComboBox<String> m =(JComboBox<String>) e.getSource();
				String dadoValueStr =  (String) m.getSelectedItem();
				dadoValue = Integer.valueOf(dadoValueStr);
				jogadasLabel.setText("Jogadas restantes: "+ Integer.toString(dadoValue));
				p.revalidate();
				p.repaint();	
			}
		});
		
		p.add(lancarDados);
		p.add(dadoViciadoLabel);
		p.add(dadoViciado);
		p.add(jogadasLabel);
		
		add(p);
		setVisible(true);
		setBounds(800,0,120,300);
		
		gamePlay.setController(jogadasLabel);
	}
	
	public Integer getDadoValue(){
		return dadoValue;
	}
	
}
