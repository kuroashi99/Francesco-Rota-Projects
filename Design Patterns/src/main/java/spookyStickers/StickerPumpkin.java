package spookyStickers;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class StickerPumpkin extends Sticker {
	
	protected StickerPumpkin() throws IOException {
		super();
	}

	private StickerPumpkin(Sticker s) throws IOException {
		this.img = s.img;
	}

	@Override
	public Image getResources() throws IOException {
		Image tmp = ImageIO.read(getClass().getResourceAsStream("/spookyStickers/resources/1.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return tmp;
	}

	@Override
	public Sticker clona() throws IOException {
		return new StickerPumpkin(this);
	}

	@Override
	protected String getName() {
		return "PUMPKIN";
	}
}
