package scegliPanorama;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Montagne extends Panorama {
	

	public Montagne() throws IOException {
		super();
		
	}

	@Override
	public void getResources() throws IOException  {
		this.panorama = ImageIO.read(getClass().getResourceAsStream("/scegliPanorama/resources/montagne.jpg")).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_SMOOTH);
	}

}
