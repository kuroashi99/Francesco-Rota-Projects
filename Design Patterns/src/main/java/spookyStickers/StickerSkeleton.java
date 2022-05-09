package spookyStickers;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StickerSkeleton extends Sticker {
	
	public StickerSkeleton() throws IOException {
		super();
	}
	
	private StickerSkeleton(StickerSkeleton s) throws IOException {
		this.img = s.img;
		this.name = getName();
	}

	@Override
	public Image getResources() throws IOException {
		Image tmp = ImageIO.read(getClass().getResourceAsStream("/spookyStickers/resources/3.png")).getScaledInstance(Sticker.WIDTH, Sticker.HEIGHT, Image.SCALE_SMOOTH);
		return tmp;
	}

	@Override
	public Sticker clona() throws IOException {
		return new StickerSkeleton(this);
	}

	@Override
	protected String getName() {
		return "SKELETON";
	}

}
