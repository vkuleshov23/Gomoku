package gomoku.model;
import java.io.Serializable;

public class Gomoku implements Serializable{
	static final int size = 15;
	private char[][] board;
	private boolean player;

	public Gomoku(){
		this.board = new char[size][size];
		this.player = 1;
	}
	public Gomoku(char[][] board, boolean player){
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