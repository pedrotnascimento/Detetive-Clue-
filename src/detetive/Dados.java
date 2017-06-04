package detetive;
import graphics.Dado;
import java.util.Random;
public class Dados {
	Random r = new Random();
	Dado dado;
	public Dados(){
		
		
	}
	
	public int roll(){
		int num = r.nextInt(6)+1 ;
		dado = new Dado("dado"+ Integer.toString(num));
		return num;
	}
	
	public Dado getDado(){
		return dado;
	}
}
