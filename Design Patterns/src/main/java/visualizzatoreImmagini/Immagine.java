package visualizzatoreImmagini;
import java.awt.Image;

public class Immagine implements InterfacciaImmagine {
	
	private Image img;
	private int width, height;
	
	public Immagine(Image img, int width, int height) {
		this.img = img;
		this.width = width;
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
