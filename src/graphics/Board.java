package graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//import java.io.*;
import javax.imageio.*;




public class Board extends JPanel{
	int width = 0;
	int height = 0;
	int sizeBoardCell = 25; 
	int pos0_X = 50;
	int pos0_Y = 50;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		BufferedImage img=null;

		try {
		   img=ImageIO.read(new File("board.jpg"));
		   width = img.getWidth();
		   height = img.getHeight();
		   setSize(width, height);
		   setLayout(null);
		}
		catch(IOException e) {
		   System.out.println(e.getMessage());
		   System.exit(1);
		}
		
		g.drawImage(img,0,0,null);
	}
	
	
	public void defineCell(Cell cell, int x, int y){
		Dimension d = cell.getPreferredSize();
		
		cell.setBounds(x*sizeBoardCell + pos0_X, y*sizeBoardCell + pos0_Y, d.width, d.height);
		add(cell);
	}
}
