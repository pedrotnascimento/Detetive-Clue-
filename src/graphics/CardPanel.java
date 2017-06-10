package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CardPanel extends JPanel{
	String filename = "";
	public CardPanel(String img){
		filename = img;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		BufferedImage img=null;

		try {
		   img=ImageIO.read(new File("cards/"+ filename + ".jpg"));
//		   int width = img.getWidth()/2;
//		   int height = img.getHeight()/2;
//		   setSize(width, height);
		}
		catch(IOException e) {
		   System.out.println(e.getMessage() +  filename);
		   System.exit(1);
		}
		g.drawImage(img,0,0,null);
	}
}
