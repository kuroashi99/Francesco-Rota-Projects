package scegliPanorama;

import java.awt.Graphics;

import javax.swing.JPanel;

//ABSTRACTION CLASS
public class PannelloPanorama extends JPanel {
	
	//IMPLEMENTATION
	protected Panorama panorama = FabbricaPanorama.getInstance().creaPanorama();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(panorama.getPanorama(), 0, 0, null);
	}

}
