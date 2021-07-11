package gomoku.model;
import java.io.Serializable;

public class Gomoku implements Serializable{
	static final int size = 15;
	static final int countForWin = 5;
	private char[][] board;
	private boolean player;

	public Gomoku(){
		this.board = new char[size][size];
		this.player = 1;
	}
	public Gomoku(char[][] board, boolean player, boolean flagAboutWin){
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
		player ? this.board[x][y] = "X" : this.board[x][y] = "O";
		if(this.checkWin)
			return true;
		this.changePlayer();
		return false;
	}
	private boolean checkMove(int x, int y){
		if(x < 0 && x > size || y < 0 && y > size)
			return false;
		if(this.board[x][y] = " ")
			return false;
		return true;
	}
	private boolean checkWin(){
		char c;
		player ? c = "X" : c = "O";
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
					counter++
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
					counter++
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
					counter++
				else 
					counter = 0;
				if(counter == this.countForWin)
					return true;
			}
			counter = 0;
		}

		return false;
	}
	public getWinner(){
		return this.player;
	}
	private void changePlayer(){
		this.player != this.player;
	}
	public void newGame(){
		this.player = 1;
		for(int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				this.board[i][j] = " ";
			}
		}
	}
}