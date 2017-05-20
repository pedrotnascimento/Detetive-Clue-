package ctrl;
import java.awt.Dimension;
import java.util.ArrayList;

import graphics.*;

public class Path {
	public Path(Board b){
		b.setLayout(null);
		Cell ref = new Cell();
		Dimension d = ref.getPreferredSize();	
		Cell c[][] = new Cell[24][25];
//		c[6][1] = new Cell();
//		for(int i =0; i< 24; i++){
//			for(int j =0 ; j<25;j++){
//				c[i][j] = new Cell();
//				b.defineCell(c[i][j], i ,j);
//			}
//		}
		
//		b.defineCell(cell, x, y);
		
		c[9][0] = new Cell();
		b.defineCell(c[9][0], 9, 0);
		
		
//		int firstCellX = 200;
//		int firstCellY = 100;
//		
////		int offsetX = firstCellX + d.width; 
////		int offsetY = firstCellY + d.height;
//		int sizeCell = 25; 
//		System.out.println(sizeCell);
//		int offsetX = firstCellX + sizeCell; 
//		int offsetY = firstCellY + sizeCell;
//		
//		{//before first loop
//		c.setPosition(200, 100);
//		b.add(c);
//		}
//		for(int i =0; i< 7;i++){			
//			c = new Cell(); 
//			c.setPosition(firstCellX , offsetY);
//			b.add(c);
//			offsetY += sizeCell;
//		}
	}
}
