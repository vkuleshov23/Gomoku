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
					bv.dispose();
					new BoardView();
					return;
				}

				int x = e.getX();
				int y = e.getY();

				if(x > offset){
					x -= offset+offsetOfFont;
					if(y > offset){
						y -= offset-offsetOfFont;
						int i = x / rate;
						int j = y / rate;
						System.out.println("x = " + x + " y = " + y + " i = " + i + " j = " + j); 
						if(!game.move(i, j)){
							repaint();
						} else {
							repaint();
							winFlag = true;
							new WinMenu(game.getWinner(), game, bv);
						}
					}
				}
			}
		}
		Font big = new Font("Courier New", 1, 50);
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.black);
			g.setFont(big);
			for(int i = 0; i < game.getSize(); i++){
				for(int j = 0; j < game.getSize(); j++){
					g.drawString("" + changeColor(g, i, j), offset + rate/2 + i * rate, offset + rate/2 + j * rate);
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