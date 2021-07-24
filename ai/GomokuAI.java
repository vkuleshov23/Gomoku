package ai;

import history.*;
import model.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.Serializable;

public class GomokuAI implements Serializable{
	private LinkedList<ListElement> posMove;
	private Gomoku game;
	public GomokuAI(Gomoku game, History history){
		this.posMove = new LinkedList<ListElement>();
		this.game = game;
	}
	public Coordinates findMove(){
		Coordinates lastMove = new Coordinates(game.getHistory.getLastX(), game.getHistory.getLastY());
		this.checkPossibleMoves();
		this.addPossibleMoves(lastMove);
		Iterator<ListElement> iter = this.posMove.iterator();
		while(iter.hasNext()){
			ListElement element = iter.next();
			// element.setSum(0);

		}

	}
	private void addPossibleMoves(Coordinates lastMove){
		for(int x = lastMove.getX()-1; x <= lastMove.getX()+1; x++){
			if(x >= 0 && x < this.game.getSize()){
				for(int y = lastMove.getY()-1; y <= lastMove.getY()+1; y++){
					if(y >= 0 && y < this.game.getSize()){
						if(this.game.getElement(x, y) == ' '){
							this.posMove.addLast(new ListElement(x, y));
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
		for(int i = 0; i < 4){
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
			for(int strategy = 0; strategy < 2; strategy++){ // 0 - attack; 1 - defence
				char stratChar = ' ';
				if(strategy == 0)
					stratChar = game.getCurPlayerChar();
				else
					stratChar = game.getEmenyPlayerChar();
				int curSum = 0;

				for(String pattern : /*String[]*/ allPatterns){
					curSum += compareWithPattern(line, pattern, stratChar);

				}
				if(strategy == 0)
					curSum += curSum * 1.1;
				sum += curSum;
				curSum = 0;
			}
		}
	}
	private int compareWithPattern(String s, String pattern, char stratChar){
		
		if(pattern.length() > s.length())
			return 0;

		s = changeAstrixCharToStratChar(s, stratChar);

		for(int j = 0; j < s.length()%4; j++){
			// for(int i = 0; i < 5; i++)
			if(s.regionMatches())
				// return pattern.sum();
		}
	}
	private String changeAstrixCharToStratChar(String line, char stratChar){
		String newLine = "";
		for(char c : line.toCharArray()){
			newLine += (c == '*') ? stratChar : c;
		}
		return newLine;
	}
}