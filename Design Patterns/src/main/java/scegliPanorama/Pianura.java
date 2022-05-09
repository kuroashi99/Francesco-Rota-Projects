package scegliPanorama;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pianura extends Panorama {

	public Pianura() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getResources() throws IOException {
		this.panorama = ImageIO.read(getClass().getResourceAsStream("/scegliPanorama/resources/pianura.jpg")).getScaledInstance(Main.WIDTH, Main.HEIGHT, Image.SCALE_SMOOTH);

	}

}
