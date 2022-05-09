package spookyStickers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class main {

	public static void main(String[] args) {
		try {
			Display.getInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*JFrame f = new JFrame();
		f.setTitle("Spooky Title");
		f.setSize(Display.WIDTH,Display.HEIGHT);
		f.setLocationRelativeTo(null);
		
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 4));
		try {
			StickerGhost ghost = new StickerGhost();
			
			
			bottomPanel.add(new StickerButton(ghost));
			bottomPanel.add(new StickerButton(ghost));
			bottomPanel.add(new StickerButton(ghost));
			bottomPanel.add(new StickerButton(ghost));
			
			bottomPanel.setBackground(Color.BLACK);
			bottomPanel.revalidate();
			
			JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
			splitPane.setDividerLocation(Display.HEIGHT-150);
			splitPane.setDividerSize(0);
			f.add(splitPane);
			
			
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setResizable(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		

	}

}
