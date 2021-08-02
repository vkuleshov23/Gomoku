package view;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinMenu extends JFrame{
	private static final int size = 2;
	private Gomoku game;
	private BoardView bv;
	public WinMenu(String title, String winner, Gomoku game, BoardView bv){
		super(title);
		this.game = game;
		this.bv = bv;
		this.creating(winner);
	}
	private void creating(String winner){

		this.getContentPane().setBackground( new Color(26,24,24) );
		JButton[] winMenuButton = new JButton[size];
		String[] winMenuButtonsName = new String[]{"Rematch", "Quit to Menu"};
        Container c = getContentPane();

        JLabel label= new JLabel(winner);
        label.setBounds(150, 60, 320, 60);
		label.setForeground(new Color(227,227,227));
        c.add(label, BorderLayout.CENTER);


		for(int i = 0, step = 120, y = 150; i < size; i++, y+=step){
			winMenuButton[i] = new JButton(winMenuButtonsName[i]);
			winMenuButton[i].setBounds(50, y, 320, 60-5);
			winMenuButton[i].setForeground(new Color(0,0,0));
			winMenuButton[i].setBackground(new Color(170, 169, 158));
			c.add(winMenuButton[i], BorderLayout.CENTER);
		}
		winMenuButton[0].addActionListener(new RematchActListener(this, game));
		winMenuButton[1].addActionListener(new QuitActListener(this));

		this.setSize(420, 420);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	public class QuitActListener implements ActionListener{
		JFrame wm;
		QuitActListener(JFrame wm){ this.wm = wm; }
		@Override
		public void actionPerformed(ActionEvent e){
			this.wm.dispose();
			bv.dispose();
			System.out.println("Go to Main Menu");
			new MainMenu("Gomoku");
		}
	}

	public class RematchActListener implements ActionListener{
		JFrame wm;
		Gomoku game;
		RematchActListener(JFrame wm, Gomoku game){ this.wm = wm; this.game = game;}
		@Override
		public void actionPerformed(ActionEvent e){
			this.wm.dispose();
			boolean ai = game.getAIflag();
			bv.dispose();
			System.out.println("New Game");
			new BoardView("Gomoku Game Board", ai);
		}
	}
}