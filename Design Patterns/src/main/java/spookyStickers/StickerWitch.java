package spookyStickers;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StickerWitch extends Sticker {

	public StickerWitch() throws IOException {
		super();
	}
	
	private StickerWitch(StickerWitch s) throws IOException {
		this.img = s.img;
		this.name = getName();
	}

	@Override
	public Image getResources() throws IOException {
		Image tmp = ImageIO.read(getClass().getResourceAsStream("/spookyStickers/resources/5.png")).getScaledInstance(Sticker.WIDTH, Sticker.HEIGHT, Image.SCALE_SMOOTH);
		return tmp;
	}

	@Override
	public Sticker clona() throws IOException {
		return new StickerWitch(this);
	}

	@Override
	protected String getName() {
		return "WITCH";
	}

}
