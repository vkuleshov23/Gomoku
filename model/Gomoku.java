package model;
import history.*;

import java.io.Serializable;
import java.util.LinkedList;

public class Gomoku implements Serializable{
	static final int size = 15;
	static final int countForWin = 5;
	private char[][] board;
	private boolean player;
	private History history;

	public Gomoku(){
		history = new History();
		this.board = new char[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				this.board[i][j] = ' ';
			}
		}
		this.player = true;
	}
	public Gomoku(char[][] board, boolean player, History history){
		this.history = history;
		this.player = player;
		for(int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	public boolean move(int x, int y){
		if(!this.checkMove(x, y))
			return false;

		
		if(player == true){
			this.board[x][y] = 'X';
			history.addMove(x, y, 'X');
		}
		else{
			this.board[x][y] = 'O';
			history.addMove(x, y, 'O');
		}

		if(this.checkWin())
			return true;
		this.changePlayer();
		return false;
	}
	private boolean checkMove(int x, int y){
		if(x < 0 || x > size && y < 0 || y > size)
			return false;
		if(this.board[x][y] != ' ')
			return false;
		return true;
	}
	public Element undo(){
		if(history.getSize() != 0){
			Element el = history.getLast();
			this.board[el.getX()][el.getY()] = ' ';
			char c = el.getPlayer();
			if(c == 'X'){
				this.player = true;
			} else {
				this.player = false;
			}
			history.deleteMove();
			return el;
		}
		return new Element(-1, -1, '-');
	}
	private boolean checkWin(){
		char c;
		
		if(player == true)
			c = 'X';
		else
			c = 'O';

		int counter = 0;

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(c == this.board[i][j])
					counter++;
				else
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(c == this.board[j][i])
					counter++;
				else 
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}

		for(int length = this.countForWin-1; length < size; length++){
			for(int j = 0, i = length; j <= length; j++, i--){
				if(c == this.board[i][j])
					counter++;
				else 
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}

		for (int length = size, start = 0; length > this.countForWin-1; length--, start++){
			for(int j = 0, i = start; j < length; j++, i++){
				if(c == this.board[i][j])
					counter++;
				else
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}

		for (int length = size - 1, start = 1; length > this.countForWin-1; length--, start++) {
			for(int j = start, i = size - 1, k = 0; k < length; j++, k++){
				if(c == this.board[i-k][j])
					counter++;
				else 
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}
		for (int length = size - 1, start = 1; length > this.countForWin-1; length--, start++) {
			for(int j = start, i = 0, k = 0; k < length; j++, k++){
				if(c == this.board[i+k][j])
					counter++;
				else 
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}

		return false;
	}
	public LinkedList<Element> getHistory(){
		return history.getHistory();
	}
	public String getWinner(){
		if(this.player == true) return "Player X";
		else return "PLayer O";
	}
	public int getSize(){ return this.size; }
	public char getElement(int x, int y){
		return this.board[x][y];
	}
	public boolean getPlayer(){
		return this.player;
	}
	private void changePlayer(){
		this.player = !this.player;
	}
	public void newGame(){
		this.player = true;
		for(int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				this.board[i][j] = ' ';
			}
		}
	}
}