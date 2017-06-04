package menu;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit.Parser;

import detetive.Dados;

public class Controller extends JFrame{
	int dadoValue;
	JPanel dadoImage = null;
	Dados dados = new Dados();
	public Controller(){
		
		JPanel p =  new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JButton lancarDados = new JButton("DADOS");
		lancarDados.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel dadoViciadoLabel = new JLabel("Dado Viciado");
		dadoViciadoLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel jogadasLabel = new JLabel("Jogadas restantes: 0");
		jogadasLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		
		
		String[] dadosLis = {"1","2","3","4","5","6"};
		JComboBox dadoViciado = new JComboBox(dadosLis);
		dadoViciado.setAlignmentX(CENTER_ALIGNMENT);
		
		
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
				JComboBox m =(JComboBox) e.getSource();
				String dadoValueStr =  (String) m.getSelectedItem();
				dadoValue = Integer.valueOf(dadoValueStr);
			}
		});
		
		p.add(lancarDados);
		p.add(dadoViciadoLabel);
		p.add(dadoViciado);
		p.add(jogadasLabel);
		
		add(p);
		setVisible(true);
		setBounds(800,0,120,300);
		
	}	
	
}
