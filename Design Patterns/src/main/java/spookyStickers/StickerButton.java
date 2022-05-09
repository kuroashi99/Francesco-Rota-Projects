package spookyStickers;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StickerButton extends JButton {
	
	final private Sticker sticker;
	
	public StickerButton(Sticker s) {
		super(new ImageIcon(s.img));
		this.sticker = s;
		this.setBackground(Color.BLACK);
		this.addActionListener(new StickerListener());
		
	}

	public Sticker getSticker() {
		return sticker;
	}

}
