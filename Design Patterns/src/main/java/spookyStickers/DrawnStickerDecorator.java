package spookyStickers;

import java.awt.Image;
import java.io.IOException;

public class DrawnStickerDecorator extends Sticker {
	
	Sticker s;
	int x, y;

	public DrawnStickerDecorator(Sticker s, int x, int y) throws IOException {
		this.s = s;
		this.img = s.img;
		this.x = x;
		this.y = y;
	}

	@Override
	public Sticker clona() throws IOException {
		return null;
	}

	@Override
	public Image getResources() throws IOException {
		return null;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}


	@Override
	protected String getName() {
		return null;
	}

}
