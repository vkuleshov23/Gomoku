import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {
	public static void main(String[] args) {
		JFrame menu = new JFrame("Gomoku");

		JButton[] menuButton = new JButton[3];

		menuButton[0] = new JButton("New Game");
		menuButton[1] = new JButton("Load Game");
		menuButton[2] = new JButton("Quit");


		menuButton[0].addActionListener(new NewGameActListener(menu));
		menuButton[2].addActionListener(new QuitActListener());
			

		for(int i = 0, j = 100, step = 150; i < 3; i++, j += step ){
			menuButton[i].setBounds(100, j, 400, 50);
		}
		for(int i = 0; i < 3; i++){
			menu.add(menuButton[i]);
		}
		menu.setSize(600, 600);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLayout(null);
		menu.setVisible(true);
	}

	public static class NewGameActListener implements ActionListener{
		JFrame forClosing;
		NewGameActListener(JFrame e){ forClosing = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			ModeChoose mch = new ModeChoose();
		}
	}

	public static class QuitActListener implements ActionListener {
		QuitActListener(){}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}