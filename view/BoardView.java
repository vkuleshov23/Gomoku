package view;
import history.*;
import saves.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class BoardView extends JFrame{
	
	private static final int panelButtonNum = 4;

	BoardView(String title){
		super(title);
		Gomoku game = new Gomoku();
		this.creating(game);
	}
	BoardView(String title, Gomoku game){
		super(title);
		this.creating(game);
	}

	public void creating(Gomoku game){
	
		BoardPanel bp = new BoardPanel(game, this);
        Container c = getContentPane();
        bp.setBounds(0, 50, 1000, 950);

		JButton[] panelButton = new JButton[panelButtonNum];
	
		String[] panelButtonName = new String[]{"Undo", "Save", "History", "Quit to Menu"};

		for(int i = 0, step = 200, x = 100; i < panelButtonNum; i++, x += step){
			panelButton[i] = new JButton(panelButtonName[i]);
			panelButton[i].setBounds(x, 10, step-4, 35);
			c.add(panelButton[i], BorderLayout.NORTH);
		}
		panelButton[0].addActionListener(new UndoActListener(bp));
		panelButton[1].addActionListener(new SaveActListener(bp));
		panelButton[2].addActionListener(new HistoryActListener(bp));
		panelButton[3].addActionListener(new QuitActListener(this));

		
        c.add(bp, BorderLayout.CENTER);

		this.setSize(1000, 1000);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static class QuitActListener implements ActionListener{
		JFrame forClosing;
		QuitActListener(JFrame e){ forClosing = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			this.forClosing.dispose();
			System.out.println("Go to Main Menu...");
			new MainMenu("Gomoku");
		}
	}
	public static class HistoryActListener implements ActionListener{
		BoardPanel forTakeHist;
		HistoryActListener(BoardPanel e){ forTakeHist = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println(this.forTakeHist.getGame().getHistory());
			new HistoryMenu("History", forTakeHist);
		}
	}
	public static class UndoActListener implements ActionListener{
		BoardPanel forUndoMove;
		UndoActListener(BoardPanel e){ forUndoMove = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.print("Undo: ");
			System.out.println(this.forUndoMove.getGame().undo());
			this.forUndoMove.repaint();
		}
	}
	public static class SaveActListener implements ActionListener{
		BoardPanel forSaveGame;
		SaveActListener(BoardPanel e){ forSaveGame = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("Open Save Menu");
			new SaveMenu("Save File Menu", forSaveGame);
			System.out.println("Done!");
		}
	}
}