package spookyStickers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Display {
	
	private static Display instance = null;
	static public final int WIDTH=1240;
	static public final int HEIGHT=720;
	
	private JFrame f;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	
	private Display() throws IOException {
		
		f = new JFrame();
		f.setTitle("Spooky Title");
		f.setSize(WIDTH,HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
		
		topPanel = new TopPanel();
		bottomPanel = new BottomPanel();
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
		splitPane.setDividerLocation(HEIGHT-150);
		splitPane.setDividerSize(0);
		f.add(splitPane);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	
	public static Display getInstance() throws IOException {
		if(instance==null)
			instance = new Display();
		return instance;
	}
	
	public JFrame getJFrame() {
		return f;
	}

}
