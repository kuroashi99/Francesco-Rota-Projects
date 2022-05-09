package board;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Board");
		f.setSize(Settings.WIDTH, Settings.HEIGHT);
		Board board = new Board();
		TopPanel top = new TopPanel(board);
		f.add(top, BorderLayout.PAGE_START);
		f.add(board, BorderLayout.CENTER);
		
		//ComponentAdapter is similar to ComponentListener but it is an abstract class.
		//In this way we do not need to implement all methods,
		//but only the one that we want to override.
		f.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				Settings.HEIGHT = f.getHeight();
				Settings.WIDTH = f.getWidth();
				board.componentResized();				
			}			
		});
		f.setMinimumSize(new Dimension(800,600));
//		f.setResizable(false);
		f.setVisible(true);		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
