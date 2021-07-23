package view;
import model.*;
import history.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class BoardPanel extends JPanel {
		private Gomoku game;
		private BoardView bv;
		private static final int rate = 53;
		private static final int offset = 90;
		private static final int offsetOfFont = 20;
		private boolean winFlag = false;

		BoardPanel(Gomoku game, BoardView bv){
			this.game = game;
			this.bv = bv;
			this.setBackground(Color.black);
			GameMouseListener gml = new GameMouseListener(bv);
			this.addMouseListener(gml);

		}
		BoardPanel(BoardView bv){
			this.game = new Gomoku(); 
			this.bv = bv;
			this.setBackground(Color.black);
			GameMouseListener gml = new GameMouseListener(bv);
			this.addMouseListener(gml);
		}
		Gomoku getGame(){
			return game;
		}
		public class GameMouseListener extends MouseAdapter {
			BoardView bv;
			GameMouseListener(BoardView bv){
				this.bv = bv;
			}
			public void mouseClicked(MouseEvent e){
				if(winFlag == true){
					// bv.dispose();
					// System.out.println("New Game");
					// new BoardView("2007");
					return;
				}

				int x = e.getX();
				int y = e.getY();

				if(x > offset && x < offset + rate * 15){
					x -= offset+offsetOfFont;
					if(y > offset && y < offset + rate * 15 - offsetOfFont){
						y -= offset-offsetOfFont;
						int i = x / rate;
						int j = y / rate;
						System.out.println( "move:  i = " + i + " j = " + j + " | x = " + x + " y = " + y); 
						if(!game.move(i, j)){
							repaint();
						} else {
							repaint();
							winFlag = true;
							System.out.println(game.getWinner());
							new WinMenu("End Game", game.getWinner(), game, bv);
						}
					}
				}
			}
		}
		// Font big = new Font("Yrsa", 1, 50);
		// Font big = new Font("Utopia", 1, 50);
		Font big = new Font("Ubuntu", 1, 50);
		// Font big = new Font("Nakula", 1, 50);
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(new Color(101, 45, 87));
			g.setFont(big);
			char c;
			if(game.getPlayer() == true)
				c = 'X';
			else
				c = 'O';
			g.drawString("Player: " + c, 70, 70);
			for(int i = 0; i < game.getSize(); i++){
				for(int j = 0; j < game.getSize(); j++){
					g.drawString("" + changeColor(g, i, j), offset + rate/2 + i * rate, offset + rate/2 + j * rate);
					// g.drawImage();
				}
			}
		}
		private char changeColor(Graphics g ,int i,int j){
			char c = game.getElement(i, j);
			if(c == 'X'){
				g.setColor(new Color(101, 45, 87));
			} else if(c == 'O'){
				g.setColor(new Color(114, 93, 102));
			} else if(c == ' '){
				g.setColor(new Color(56, 34, 46));
				// return '•';
				return '¤';
			}
			return c;
		}
	}