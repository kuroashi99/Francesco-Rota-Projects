package scegliPanorama;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spiaggia extends Panorama {

	public Spiaggia() throws IOException {
		super();
	}

	@Override
	public void getResources() throws IOException {
		this.panorama = ImageIO.read(getClass().getResourceAsStream("/scegliPanorama/resources/spiaggia.jpg")).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_SMOOTH);

	}

}
