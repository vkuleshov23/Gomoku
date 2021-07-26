package ai;

import history.*;
import model.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class GomokuAI implements Serializable{
	private HashSet<ListElement> posMove;
	private Gomoku game;
	public GomokuAI(Gomoku game){
		this.posMove = new HashSet<ListElement>();
		this.game = game;
		this.loadHistory();
	}
	public void loadHistory(){
		for(Element el : game.getHistory().getList()){
			this.addPossibleMoves(new Coordinates(el.getX(), el.getY()));
		}
		this.checkPossibleMoves();
	}
	public Coordinates findMove(){
		Coordinates lastMove = new Coordinates(game.getHistory().getLastX(), game.getHistory().getLastY());
		this.checkPossibleMoves();
		this.addPossibleMoves(lastMove);
		Iterator<ListElement> iter = this.posMove.iterator();
		int maxSum = 0;
		while(iter.hasNext()){
			ListElement element = iter.next();
			int posSum = this.calculateMaxSum(element.getX(), element.getY());
			element.setSum(posSum);
			// System.out.println(element + ", sum: " + element.getSum());
			if(posSum > maxSum)
				maxSum = posSum;
		}
		ArrayList<ListElement> maxCostMoves = new ArrayList<ListElement>();
		iter = this.posMove.iterator();
		while(iter.hasNext()){
			ListElement element = iter.next();
			if(element.getSum() == maxSum){
				maxCostMoves.add(element);
			}
		}
		ListElement element = maxCostMoves.get((int)(Math.random() * maxCostMoves.size()));
		addPossibleMoves(element.getCoordinates());
		return element.getCoordinates();
	}
	private void addPossibleMoves(Coordinates lastMove){
		for(int x = lastMove.getX()-1; x <= lastMove.getX()+1; x++){
			if(x >= 0 && x < this.game.getSize()){
				for(int y = lastMove.getY()-1; y <= lastMove.getY()+1; y++){
					if(y >= 0 && y < this.game.getSize()){
						if(this.game.getElement(x, y) == ' '){
							this.posMove.add(new ListElement(x, y));
						}
					}
				}
			}
		}
	}
	private void checkPossibleMoves(){
		Iterator<ListElement> iter = this.posMove.iterator();
		while(iter.hasNext()){
			ListElement element = iter.next();
			if(game.getElement(element.getX(), element.getY()) != ' '){
				iter.remove();
			}
		}
	}
	private int calculateMaxSum(int x, int y){
		int sum = 0;
		for(int i = 0; i < 4; i++){
			String line = "";
			for(int j = -4; j <= 4; j++){
				switch(i){
					case(0):
						if(x + j >= 0 && x + j < game.getSize())
							line += (j == 0) ? '*' : game.getElement(x + j, y);
						break;
					case(1):
						if(y + j >= 0 && y + j < game.getSize())
							line += (j == 0) ? '*' : game.getElement(x, y + j);
						break;
					case(2):
						if(x + j >= 0 && x + j < game.getSize())
							if(y + j >= 0 && y + j < game.getSize())
								line += (j == 0) ? '*' : game.getElement(x + j, y + j);
						break;
					case(3):
						if(x - j >= 0 && x - j < game.getSize())
							if(y + j >= 0 && y + j < game.getSize())
								line += (j == 0) ? '*' : game.getElement(x - j, y + j);
						break;
				}
			}
			if(line.length() < 5)
				continue;
			// System.out.println("LINE: " + line);
			for(int strategy = 0; strategy < 2; strategy++){ // 0 - attack; 1 - defence
				char stratChar = ' ';
				if(strategy == 0)
					stratChar = game.getCurPlayerChar();
				else
					stratChar = game.getEmenyPlayerChar();
				int curSum = 0;

				for(int k = 0; k < PatternList.size; k++){
					try{
													// System.out.println(line + " : " + PatternList.getPattern(k, stratChar).getPattern());
						curSum += compareWithPattern(line, PatternList.getPattern(k, stratChar), stratChar);
					} catch (IOException e) {
						System.out.println(e.getMessage());
						return 0;
					}
				}
													// System.out.println("--------------");
				if(strategy == 0)
					curSum += curSum * 1.1;
				sum += curSum;
				curSum = 0;
			}
		}
		return sum;
	}
	private int compareWithPattern(String s, Pattern pattern, char stratChar){
		
		// System.out.println("pattern length: " + pattern.getPattern().length() + " | line length: " + s.length());
		if(pattern.getPattern().length() > s.length())
			return 0;

		int sum = 0;
		int offset = getAstrixIndex(s);
		s = changeAstrixToStrat(s, stratChar);
		int patternStartPos = offset - pattern.getPattern().length()-1;
		// System.out.println("Line: " + s);
		for(;patternStartPos <= offset; patternStartPos++) {
			if(patternStartPos < 0){
				continue;
			} else if(patternStartPos + pattern.getPattern().length() > s.length()){
				break;
			} else {
				if(pattern.getPattern().regionMatches(0, s, patternStartPos, pattern.getPattern().length())){
					sum += pattern.getSum();
				} else {
					continue;
				}
			}
		}
		return sum;
	}
	private int getAstrixIndex(String line){
		int i = 0;
		for(char c : line.toCharArray()){
			if(c == '*'){
				return i;
			}
			i++;
		}
		return i;
	}
	private String changeAstrixToStrat(String line, char stratChar){
		String newLine = "";
		for(char c : line.toCharArray()){
			if(c == '*'){
				c = stratChar;
			}
			newLine += c;
		}
		return newLine;
	}
}