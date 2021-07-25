package ai;

import model.*;
import java.io.Serializable;

public class ListElement implements Serializable{
	private int sum;
	private Coordinates crd;
	public ListElement(Coordinates crd, int sum){
		this.crd = crd;
		this.sum = sum;
	}
	public ListElement(int x, int y, int sum){
		this.crd = new Coordinates(x, y);
		this.sum = sum;
	}
	public ListElement(int x, int y){
		this.crd = new Coordinates(x, y);
		this.sum = 0;
	}
	public ListElement(Coordinates crd){
		this.crd = crd;
		this.sum = 0;
	}
	public int setSum(int sum){
		this.sum = sum;
		return sum;
	}
	public int addSum(int sum){
		this.sum += sum;
		return sum;
	}
	public int getSum(){
		return sum;
	}
	public void setCoordinates(Coordinates crd){
		this.crd = crd;
	}
	public Coordinates getCoordinates(){
		return crd;
	}
	public int getX(){
		return crd.getX();
	}
	public int getY(){
		return crd.getY();
	}
	@Override
	public int hashCode(){
		return crd.hashCode();
	}
	@Override
	public String toString(){
		return (crd.toString());
	}
	@Override
	public boolean equals(Object el){
		if(el instanceof ListElement)
			return (this.toString().equals(el.toString()));
		return false;
	}
}