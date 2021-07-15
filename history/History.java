package history;

import java.util.LinkedList;

public class History{

	private LinkedList<Element> hist;
	public History(){
		this.hist = new LinkedList<Element>();
	}
	public void addMove(int x, int y, char player){
		Element el = new Element(x, y, player);
		this.hist.addLast(el);
	}
	public Element getLast(){
		return hist.getLast();
	}
	public char getLastPlayer(){
		return (hist.getLast()).getPlayer();
	}
	public int getLastX(){
		return (hist.getLast()).getX();
	}
	public int getLastY(){
		return (hist.getLast()).getY();
	}
	public void deleteMove(){
		if(hist.size() > 0 ){
			hist.removeLast();
		}
	}
	public int getSize(){
		return hist.size();
	}
	public void saveHistory(){

	}
	public LinkedList<Element> getHistory(){
		return hist;
	}
	@Override
	public final String toString(){
		StringBuilder str = new StringBuilder();
		for (Element el : hist) {
			str.append(el);
			str.append("\n");
		}
		str.deleteCharAt(2);
		return str.toString();
	}
}