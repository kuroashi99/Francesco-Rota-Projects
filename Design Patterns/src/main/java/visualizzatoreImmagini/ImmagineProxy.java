package visualizzatoreImmagini;
import java.awt.Image;

public class ImmagineProxy implements InterfacciaImmagine {
	
	private Immagine immagine;
	
	public ImmagineProxy(Immagine immagine) {
		this.immagine = immagine;
	}

	@Override
	public Image getImg() {
		return immagine.getImg();
	}

	@Override
	public int getWidth() {
		return immagine.getWidth();
	}

	@Override
	public int getHeight() {
		return immagine.getHeight();
	}
}
