package menu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import detetive.Dados;

public class Controller extends JFrame{
	
	public Controller(){
		JPanel p =  new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JButton lancarDados = new JButton("DADOS");
		lancarDados.setAlignmentX(CENTER_ALIGNMENT);
		lancarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Dados().roll();
			}
		});
		p.add(lancarDados);
		add(p);
		setSize(120,120);
		setVisible(true);
		
	}	
	
	
}
