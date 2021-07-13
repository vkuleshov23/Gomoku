import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {

	private static final int size = 3;

	public MainMenu(String title){
		super(title);
		JButton[] menuButton = new JButton[3];

		menuButton[0] = new JButton("New Game");
		menuButton[1] = new JButton("Load Game");
		menuButton[2] = new JButton("Quit");


		menuButton[0].addActionListener(new NewGameActListener(this));
		menuButton[2].addActionListener(new QuitActListener());
			

		for(int i = 0, j = 100, step = 150; i < size; i++, j += step ){
			menuButton[i].setBounds(100, j, 400, 50);
		}
		for(int i = 0; i < size; i++){
			this.add(menuButton[i]);
		}
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainMenu("Gomoku");
	}

	public static class NewGameActListener implements ActionListener{
		JFrame forClosing;
		NewGameActListener(JFrame e){ forClosing = e;}
		@Override
		public void actionPerformed(ActionEvent e){
			this.forClosing.dispose();
			new ModeChoose();
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