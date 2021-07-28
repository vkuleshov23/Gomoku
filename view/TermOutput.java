package view;
import model.*;
import java.util.Scanner;

public class TermOutput{
	public static class View{
		private Gomoku game;
		private Scanner scan;
		View(){
			scan = new Scanner(System.in);
			game = new Gomoku(false);
		}
		public void gameLoop(){
			System.out.println(this);
			while(true){
				this.doMove();
			}
		}
		private void doMove(){
			System.out.println("Input coordinates: ");
			int x = scan.nextInt(); 
			int y = scan.nextInt();
			if(game.move(x-1, y-1) == 1){
				System.out.println(this);
				System.out.println(game.getWinner() + " is winner");	
				game = new Gomoku(false);
				System.out.println(this);
			} else 
				System.out.println(this);
		}	
		@Override
		public String toString(){
			char c = '|';
			StringBuilder str = new StringBuilder();
			str.append("     1   2   3   4   5   6   7   8   9   10  11  12  13  14  15\n");
			str.append("   -------------------------------------------------------------\n");
			for(int i = 0; i < game.getSize(); i++){
				if(i < 9){
					str.append(i+1 + "  " + c + " ");
				} else {
					str.append(i+1 + " " + c + " ");

				}
				for (int j = 0; j < game.getSize(); j++) {
					str.append(game.getElement(i, j));
					str.append(" " + c + " ");
				}
				str.append("\n   -------------------------------------------------------------\n");
			}
			return str.toString();
		}
	}

	public static void main(String[] args){
		View gomoku = new View();
		gomoku.gameLoop();
	}
}