package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Dado extends JPanel{
	String filename;
	
	public Dado (String dadoNumero){
		this.filename = dadoNumero;
	}
		int width;
		int height;
		
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			BufferedImage img=null;

			try {
			   img=ImageIO.read(new File(filename + ".jpg"));
			   width = img.getWidth();
			   height = img.getHeight();
			   setSize(width, height);
			}
			catch(IOException e) {
			   System.out.println(e.getMessage() +  filename);
			   System.exit(1);
			}
			g.drawImage(img,0,0,null);
		}		
	}

