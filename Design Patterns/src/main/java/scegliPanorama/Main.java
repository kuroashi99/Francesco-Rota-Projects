package scegliPanorama;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	
	public static final int WIDTH = 1240;
	public static final int HEIGHT = 640;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Che panorama!");
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new PannelloPanorama();
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}

}
