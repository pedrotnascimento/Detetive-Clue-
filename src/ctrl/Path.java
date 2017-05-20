package ctrl;
import java.awt.Dimension;
import java.util.ArrayList;

import graphics.*;
/*
 * 
 * 
 * MODULO NÃO ESTÁ SENDO UTILIZADO NO MOMENTO(mas estava)
 * 
 * 
 * 
 */
public class Path {
	public Path(Board b){
		b.setLayout(null);
		Cell ref = new Cell();
		Dimension d = ref.getPreferredSize();	
		Cell c[][] = new Cell[24][25];

		c[9][0] = new Cell();
		b.defineCell(c[9][0], 9, 0);
	}
}
