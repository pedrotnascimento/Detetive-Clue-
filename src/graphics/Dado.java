package graphics;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dado extends JFrame{
	public Dado (String dadoNome){
		JPanel dado =  new DadoImage(dadoNome);
	
		add(dado);
//		setSize(90, 210);
		Dimension d = getPreferredSize();
		setBounds(1000, 0, 90, 210);
		setVisible(true);
	}
	
	
	//Nested class, assim eu posso pegar o JPanel para usar num frame que eu desejar
	// ou usar no proprio do Dado
	public class DadoImage extends JPanel{
		String filename;
		int width;
		int height;
		
		public DadoImage(String dado){
			this.filename = dado;
		}
		
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
}

