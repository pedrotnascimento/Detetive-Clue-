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
	public Controller(){
		
		JPanel p =  new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JButton lancarDados = new JButton("DADOS");
		lancarDados.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel dadoViciadoLabel = new JLabel("Dado Viciado");
		dadoViciadoLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		String[] dados = {"1","2","3","4","5","6"};
		JComboBox dadoViciado = new JComboBox(dados);
		dadoViciado.setAlignmentX(CENTER_ALIGNMENT);
		
		
		lancarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dados D = new Dados();	
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
		
		add(p);
		Dimension d = getPreferredSize();
		
		setVisible(true);
		setBounds(750,0,120,120);
	}	
	
	
}
