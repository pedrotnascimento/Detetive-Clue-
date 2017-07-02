package menu;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import detetive.Main;

public class Suggest extends JFrame{
	public JButton enviar;
	JComboBox<String> cbWeapons;
	JComboBox<String> cbWho;
	JComboBox<String> cbWhere;
	
	public Suggest(boolean isAcusation){

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		
		JLabel lWho = new JLabel("Quem?");
		lWho.setAlignmentX(CENTER_ALIGNMENT);
		cbWho = new JComboBox<String>();
		for(String item: Main.players){
			cbWho.addItem(item);
		}
		if(isAcusation){
			JLabel lWhere = new JLabel("Onde?");
			lWhere.setAlignmentX(CENTER_ALIGNMENT);
			cbWhere = new JComboBox<String>();
			for(String item: Main.rooms){
				cbWhere.addItem(item);
			}
			p.add(lWhere);
			p.add(cbWhere);
			setTitle("Faça sua acusação");
			
		}
		else{
		setTitle("Dê o seu palpite");
		}
		
		JLabel lWeapons = new JLabel("Como?");
		lWeapons.setAlignmentX(CENTER_ALIGNMENT);
		cbWeapons= new JComboBox<String>();
		for(String item: Main.weapons){
			cbWeapons.addItem(item);
		}
		
		enviar = new JButton("Enviar");
		enviar.setAlignmentX(CENTER_ALIGNMENT);
		/////////////////////
		p.add(lWho);
		p.add(cbWho);
		
		
		p.add(lWeapons);
		p.add(cbWeapons);
		p.add(enviar);
		add(p);		
		
//		setBounds(200,200,800,800);
		setBounds(1000,0, 200,200);
		setVisible(true);
	}
	
	public  String getWho(){
		return (String) cbWho.getSelectedItem();
	}
		
	public  String getWhere(){
		return (String) cbWhere.getSelectedItem();
			
	}
	
	public  String getWeapon(){
		return (String) cbWeapons.getSelectedItem();
	}
}
