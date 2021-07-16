package history;

import java.io.Serializable;

public class Element implements Serializable{
	private int x;
	private int y;
	private char player;
	
	public Element(int x, int y, char player){
		this.x = x;
		this.y = y;
		this.player = player;
	}
	@Override
	public final String toString(){
		return ("" + x + " -- " + y + ", " + player); 
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public char getPlayer(){
		return this.player;
	}
}