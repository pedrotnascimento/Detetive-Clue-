package menu;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import detetive.Card;


public class PlayerInfo extends JFrame{
	JPanel p ;
	public PlayerInfo(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		add(p);
		setSize(140,140);
		setBounds(800,400, 500,300);
		setVisible(true);
	}
	
	public void setPlayerInfo(ArrayList<Card> cards,ArrayList<String> notes){
		p.removeAll();
		
//		String[] teste = {"Scarlet", "Revolver", "Biblioteca"};
		for(int i =0; i < cards.size(); i++)
			p.add(cards.get(i));
		
		JPanel notepad = new JPanel();
		notepad.setLayout(new BoxLayout(notepad, BoxLayout.Y_AXIS));
		JLabel noteLabel= new JLabel("Anotações");
		noteLabel.setVerticalTextPosition(JLabel.TOP);
		noteLabel.setAlignmentY(TOP_ALIGNMENT);
		Dimension d = cards.get(0).getSize();
		noteLabel.setBounds(0, 0, d.width, d.height);
		noteLabel.setSize(d);
		
		notepad.add(noteLabel);

		for(int i=0; i<notes.size(); i++){
			noteLabel= new JLabel(notes.get(i));
			notepad.add(noteLabel);
		}
		
		p.add(notepad);
		repaint();
		revalidate();
	}
	
	public void addNote(String note){
		JLabel noteLbl = new JLabel(note);
		p.add(noteLbl);
		System.out.println("adiciounou   " + note);
		repaint();
		revalidate();
	}
	
}
