package view;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinMenu extends JFrame{
	private static final int size = 2;
	private Gomoku game;
	public WinMenu(String winner, Gomoku game){
		super("Game End");
		this.creating(winner);
		this.game = game;
	}
	private void creating(String winner){

		JButton[] winMenuButton = new JButton[size];
		String[] winMenuButtonsAndLabelName = new String[]{"Rematch", "Quit to Menu", "Winner: "};
        Container c = getContentPane();

        JLabel label= new JLabel(winMenuButtonsAndLabelName[2] + winner);
        label.setBounds(100, 60, 320, 60);
        c.add(label, BorderLayout.CENTER);


		for(int i = 0, step = 120, y = 150; i < size; i++, y+=step){
			winMenuButton[i] = new JButton(winMenuButtonsAndLabelName[i]);
			winMenuButton[i].setBounds(50, y, 320, 60-5);
			c.add(winMenuButton[i], BorderLayout.CENTER);
		}
		winMenuButton[0].addActionListener(new RematchActListener(this, game));
		winMenuButton[1].addActionListener(new QuitActListener(this));

		this.setSize(420, 420);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
	public static class QuitActListener implements ActionListener{
		JFrame wm;
		QuitActListener(JFrame wm){ this.wm = wm; }
		@Override
		public void actionPerformed(ActionEvent e){
			this.wm.dispose();
			new MainMenu("Gomoku");
		}
	}

	public static class RematchActListener implements ActionListener{
		JFrame wm;
		Gomoku game;
		RematchActListener(JFrame wm, Gomoku game){ this.wm = wm; this.game = game;}
		@Override
		public void actionPerformed(ActionEvent e){
			this.wm.dispose();
			new BoardView();
		}
	}
}