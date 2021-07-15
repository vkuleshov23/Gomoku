package view;

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
		panelButton[3].addActionListener(new QuitActListener(this));

		
        c.add(bp, BorderLayout.CENTER);

		// this.add(bp);
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
}