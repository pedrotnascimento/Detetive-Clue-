package detetive;
import graphics.Dado;
import java.util.Random;
public class Dados {
	Random r = new Random();
	public Dados(){
		
		
	}
	
	public int roll(){
		int num = r.nextInt(6)+1 ;
		new Dado("dado"+ Integer.toString(num));
		return num;
	}
}
