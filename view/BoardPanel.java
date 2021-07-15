package view;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel {
		private Gomoku game; 
		private static final int rate = 53;
		private static final int offset = 90;
		private boolean winFlag = false;

		BoardPanel(Gomoku game){
			this.game = game;
			this.setBackground(Color.black);
			GameMouseListener gml = new GameMouseListener();
			this.addMouseListener(gml);

		}
		BoardPanel(){
			this.game = new Gomoku(); 
			this.setBackground(Color.black);
			GameMouseListener gml = new GameMouseListener();
			this.addMouseListener(gml);
		}

		class GameMouseListener extends MouseAdapter {
			public void mouseClicked(MouseEvent e){
				if(winFlag == true){
					return;
				}

				int x = e.getX();
				int y = e.getY();

				if(x > offset){
					x -= offset;
					if(y > offset){
						y -= offset;
						int i = x / rate;
						int j = y / rate;
						System.out.println("x = " + x + " y = " + y); 
						System.out.println("i = " + i + " j = " + j);
						if(!game.move(i, j)){
							repaint();
						} else {
							repaint();
							winFlag = true;
							new WinMenu(game.getWinner());
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
				g.setColor(Color.red);
			} else if(c == 'O'){
				g.setColor(Color.blue);
			} else if(c == ' '){
				g.setColor(Color.white);
				return '.';
			}
			return c;
		}
	}