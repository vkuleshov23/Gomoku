package ai;

import java.io.Serializable;

public class Pattern implements Serializable{
	int sum;
	String pattern;

	public Pattern(String pattern, int sum){
		this.pattern = pattern;
		this.sum = sum;
	}
	public int getSum(){
		return sum;
	}
	public String getPattern(){
		return pattern;
	}
	@Override
	public String toString(){
		return pattern + ", " + sum;
	}
}