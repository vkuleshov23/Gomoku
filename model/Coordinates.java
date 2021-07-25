package model;

import java.io.Serializable;

public class Coordinates implements Serializable{
	private static final int size = 15;
	private int x;
	private int y;
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getSize(){
		return this.size;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	@Override
	public int hashCode(){
		return (x*size + y);
	}
	@Override
	public String toString(){
		return ("" + x + ", " + y);
	}
	@Override
	public boolean equals(Object el){
		if(el instanceof Coordinates)
			return (this.toString().equals(el.toString()));
		return false;
	}

}