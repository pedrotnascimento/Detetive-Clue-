package graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import java.io.*;
import javax.imageio.*;

public class Cell extends JPanel{
	public int width = 0;
	public int height = 0;
	String filename = "cell_test.png";
	
	public Cell(){

	}
	
	public Cell(String filename){
		this.filename = filename;
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
	
	public void setPosition(int x, int y){
		Dimension d = this.getPreferredSize();
		this.setBounds(x, y, d.width, d.height);
	}

}
