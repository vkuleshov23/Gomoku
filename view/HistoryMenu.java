package view;
import history.*;

import java.awt.*;
import javax.swing.*;
 
public class HistoryMenu extends JFrame {

	BoardPanel bp;
	public HistoryMenu(String title, BoardPanel bp) {
 		super(title);
 		this.creating(bp);
 	
 	}
	private void creating(BoardPanel bp){
		this.getContentPane().setBackground( new Color(26,24,24) );
		this.bp = bp;
		String hist = "";
		int counter = 1;
		for(Element el : bp.getGame().getHistory().getList()){
			hist += ((counter++) + ":\t" + el.toString() + "\n");
		}
		if(counter > 23){
			counter = 23;
		}
		JTextArea textArea = new JTextArea(hist,counter,25);

		int vsb = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int hsb = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

		JScrollPane scrollPane = new JScrollPane(textArea,vsb,hsb);

		JPanel panel = new JPanel();
		panel.setBackground( new Color(26,24,24) );
		panel.setLayout(new FlowLayout());
		panel.add(scrollPane);

		this.setContentPane(panel);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	} 
}