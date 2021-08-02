package view;
import saves.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.ClassNotFoundException;

class LoadMenu extends JFrame implements ActionListener {

	private String filename;
	private JFrame forClosing;
	JTextField t;
	JButton b;
	JLabel l;
	public LoadMenu(String title, JFrame e){
		super(title);
		this.forClosing = e;
		this.creating();
	}
	private void creating(){
		this.getContentPane().setBackground( new Color(26,24,24) );
		t = new JTextField(16);
		b = new JButton("Submit");
		b.setForeground(new Color(0,0,0));
		b.setBackground(new Color(170, 169, 158));
		l = new JLabel("Enter filename without extension");
		l.setForeground(new Color(227,227,227));
		JPanel p = new JPanel();
		p.setBackground(new Color(26, 24, 24));
		
		t.setText("");

		b.addActionListener(this);
		p.add(t);
		p.add(b);
		p.add(l);

		this.add(p);
		this.setSize(300, 100);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if (s.equals("Submit")) {
			this.filename = t.getText();
			if(filename.equals("")){
				t.setText("");
				return;
			}
			System.out.println("LoadGame game...");
			try{
				new BoardView("Gomoku Game Board", LoadGame.load(filename));
				this.dispose();
				this.forClosing.dispose();
				System.out.println("Done!");
			} catch(IOException err) {
				System.out.println("File Not Found or no Saves...");
				System.out.println(err.getMessage());
				l.setText("File Not Found or Load Problems");
				t.setText("");
			} catch(ClassNotFoundException err){
				System.out.println("Class Not Found...");
				System.out.println("Serialization problems...");
				System.out.println(err.getMessage());
				new ModeChoose("There are no saves. Choose New Game Mode");
				System.out.println("No saves, go to choosing mode");
				this.dispose();
				this.forClosing.dispose();
				System.out.println("Done!");
			}
		}
	}
}
