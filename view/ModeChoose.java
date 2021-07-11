import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModeChoose extends JFrame {
	public ModeChoose(){
		super("Choose Mode");
		this.creating();
	}

	public void creating(){
		JButton[] mchButton = new JButton[2];

		mchButton[0] = new JButton("Single Player");
		mchButton[1] = new JButton("Two Players");

		for(int i = 0, j = 100, step = 150; i < 2; i++, j += step ){
			mchButton[i].setBounds(100, j, 200, 50);
		}
		for(int i = 0; i < 2; i++){
			this.add(mchButton[i]);
		}
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
	}
}