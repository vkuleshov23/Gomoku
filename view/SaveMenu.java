package view;
import saves.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.ClassNotFoundException;

class SaveMenu extends JFrame implements ActionListener {

	private String filename;
	JTextField t;
	JButton b;
	JLabel l;
	BoardPanel bp;
	public SaveMenu(String title, BoardPanel bp){
		super(title);
		this.bp = bp;
		this.creating();
	}
	private void creating(){
		t = new JTextField(16);
		b = new JButton("Submit");
		l = new JLabel("Enter filename without extension");
		JPanel p = new JPanel();
		
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
			if(this.filename.equals("")){
				return;
			}
			System.out.println("Saving game...");
			try{
				GameSave.save(this.bp.getGame(), filename);
				this.dispose();
				System.out.println("Done!");
			} catch(IOException err){
				System.out.println("Some problem with encodind or writing...");
				System.out.println(err.getMessage());
				l.setText("Error! try change filename");
				
			}
		}
	}
}
