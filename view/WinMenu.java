package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinMenu extends JFrame{
	private static final int size = 2;
	public WinMenu(String winner){
		super("Game End");
		this.creating(winner);
	}
	private void creating(String winner){

		JButton[] winMenuButton = new JButton[size];
		String[] winMenuButtonsAndLabelName = new String[]{"Rematch", "Quit to Menu", "Winner: "};
        Container c = getContentPane();

        JLabel label= new JLabel(winMenuButtonsAndLabelName[2] + winner);
        label.setBounds(105, 60, 210, 60);
        c.add(label, BorderLayout.CENTER);


		for(int i = 0, step = 60, y = 180; i < size; i++, y+=step){
			winMenuButton[i] = new JButton(winMenuButtonsAndLabelName[i]);
			winMenuButton[i].setBounds(105, y, 210, 60);
			c.add(winMenuButton[i], BorderLayout.CENTER);
		}

		this.setSize(420, 420);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);

	}
}