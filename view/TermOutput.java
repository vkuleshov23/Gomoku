package view;
import model.*;
import java.util.Scanner;

public class TermOutput{
	public static class View{
		Gomoku game;
		Scanner scan;
		View(){
			scan = new Scanner(System.in);
			game = new Gomoku();
		}
		public void gameLoop(){
			System.out.println(game);
			while(true){
				this.doMove();
			}
		}
		private void doMove(){
			System.out.println("Input coordinates: ");
			int x = scan.nextInt(); 
			int y = scan.nextInt();
			if(game.move(x-1, y-1) == true){
				System.out.println(game.getWinner() + " is winner");	
				System.out.println(game);
				game.newGame();
			} else 
				System.out.println(game);
		}
	}

	public static void main(String[] args){
		View gomoku = new View();
		gomoku.gameLoop();
	}
}