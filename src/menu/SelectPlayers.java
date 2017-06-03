package menu;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import detetive.GamePlay;

/*
 * Janela que permite a seleção dos jogadores
 * Como esta janela é extensão do ínicio do jogo, foi mantido no mesmo modulo
 */
public class SelectPlayers extends JFrame{
	public SelectPlayers(){
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
		
		//para retirar visibilidade ao escolher jogadores
		JFrame self = this;
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getNumSelected(lis_cb)<3){
					JOptionPane.showMessageDialog(self,
						    "Selecione pelo menos 3 jogadores",
						    "Poucos jogadores",
						    JOptionPane.PLAIN_MESSAGE);
				}
				else{
					System.out.println("Jogadores selecionados, Iniciando Jogo");
					new GamePlay(getSelecteds(lis_cb));
					self.setVisible(false);
					new Controller();
					System.out.println("Jogo iniciado");
				}
			}
		});
		p.add(btnOK);
		
		add(p);
		setSize(90, 210);
		setVisible(true);
	}
	
	/*
	 * obtém uma ArrayList de nomes dos jogadores
	 */
	public ArrayList<String> getSelecteds(List<JCheckBox> checkboxes){
		ArrayList<String> selecteds = new ArrayList<String>();
		
		for(int i =0; i<checkboxes.size(); i++){
			JCheckBox cb = checkboxes.get(i);
			if(cb.isSelected())
				selecteds.add(cb.getText());
		}		
		return  selecteds;
	}
	
	public int getNumSelected(List<JCheckBox> checkboxes){
		int num = 0;
		for(int i = 0; i < checkboxes.size(); i++)
			if(checkboxes.get(i).isSelected())
				num++;
				
		return num;
	}
}