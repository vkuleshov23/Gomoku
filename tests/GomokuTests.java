package tests;

import model.*;

public class GomokuTests{
	private static int passed;
	private static int total;
	private static int field;

	public static void showResult(){
		if(field == 0){
			System.out.println("Test is passed");
		} else {
			System.out.println("Test is field\nTotal: " + total + ". | " + field + " tests was field. " + passed + " tests was passed.");
		}
	}
	private static void check(boolean res){
		total++;
		if(!res){
			field++;
			System.out.println(total + " -");
		} else {
			passed++;
			System.out.println(total + " +");
		}
	}
	public static void run(){
		GomokuTests.moveTest1();
		GomokuTests.moveTest2();
		GomokuTests.moveTest3();
		GomokuTests.playerChangeTest1();
		GomokuTests.playerChangeTest2();
		GomokuTests.checkWinTest1();
		GomokuTests.checkWinTest2();
		GomokuTests.checkWinTest3();
		GomokuTests.checkWinTest4();
	}
	public static void main(String[] args){
		GomokuTests.run();
		GomokuTests.showResult();
	}


	//-----------------------------//
	private static void moveTest1(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		check((game.getElement(0, 0) == 'X'));
	}
	private static void moveTest2(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		game.move(0, 0);
		check(game.getCurPlayerChar() == 'O');
	}
	private static void moveTest3(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		game.undo();
		check(game.getElement(0, 0) == ' ');
	}
	private static void playerChangeTest1(){
		Gomoku game = new Gomoku(false);
		check(game.getCurPlayerChar() == 'X');
	}
	private static void playerChangeTest2(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		check(game.getCurPlayerChar() == 'O');
	}
	private static void checkWinTest1(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		game.move(0, 1);
		game.move(1, 1);
		game.move(1, 2);
		game.move(2, 2);
		game.move(2, 3);
		game.move(3, 3);
		game.move(3, 4);
		check(game.move(4, 4));
	}
	private static void checkWinTest2(){
		Gomoku game = new Gomoku(false);
		game.move(14, 0);
		game.move(1, 2);
		game.move(13, 1);
		game.move(2, 3);
		game.move(12, 2);
		game.move(3, 4);
		game.move(11, 3);
		game.move(4, 5);
		check(game.move(10, 4));
	}
	private static void checkWinTest3(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		game.move(1, 2);
		game.move(0, 1);
		game.move(12, 2);
		game.move(0, 2);
		game.move(3, 4);
		game.move(0, 3);
		game.move(4, 5);
		check(game.move(0, 4));
	}
	private static void checkWinTest4(){
		Gomoku game = new Gomoku(false);
		game.move(0, 0);
		game.move(1, 2);
		game.move(1, 0);
		game.move(12, 2);
		game.move(2, 0);
		game.move(3, 4);
		game.move(3, 0);
		game.move(4, 5);
		check(game.move(4, 0));
	}

}