package spookyStickers;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;

import spookyStickers.Sticker;

public class StickerGhost extends Sticker {
	
	

	public StickerGhost() throws IOException {
		super();
	}
	
	private StickerGhost(StickerGhost s) throws IOException {
		this.img = s.img;
		this.name = getName();
	}

	@Override
	public Image getResources() throws IOException {
		Image tmp = ImageIO.read(getClass().getResourceAsStream("/spookyStickers/resources/0.png")).getScaledInstance(Sticker.WIDTH, Sticker.HEIGHT, Image.SCALE_SMOOTH);
		return tmp;
	}

	@Override
	public Sticker clona() throws IOException {
		return new StickerGhost(this);
	}

	@Override
	protected String getName() {
		return "GHOST";
	}

}
