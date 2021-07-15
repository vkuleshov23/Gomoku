package view;
import history.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardView extends JFrame{
	
	private static final int panelButtonNum = 4;

	BoardView(){
		super("Board");
		this.creating();
	}

	public void creating(){
	
		BoardPanel bp = new BoardPanel(this);
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
			new MainMenu("Gomoku");
		}
	}
	public static class HistoryActListener implements ActionListener{
		BoardPanel forTakeHist;
		HistoryActListener(BoardPanel e){ forTakeHist = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			System.out.println("History:");
			System.out.println(this.forTakeHist.getGame().getHistory());
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
}