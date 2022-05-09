package spookyStickers;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	
	
	private StickerPrototypeFactory factory;
	
	
	public BottomPanel() throws IOException {
		this.setLayout(new GridLayout(1, StickerPrototypeFactory.NUM_STICKERS ));
		this.setBackground(Color.BLACK);
		factory = new StickerPrototypeFactory(new StickerGhost(), new StickerPumpkin(), new StickerWitch(), new StickerSkeleton());
		PanelFacade.getInstance().setBottomPanel(this);
		addStickers();
	}


	private void addStickers() throws IOException {
		Sticker[] stickers = factory.makeStickers();
		
		for (Sticker s : stickers) {
			JButton button = new StickerButton(s);
			this.add(button);
		}	
		
		this.revalidate();
		
	}


	public StickerGhost getGhostClone() throws IOException {
		return factory.makeGhost();
	}


	public StickerPumpkin getPumpkinClone() throws IOException {
		return factory.makePumpkin();
	}
	
	public StickerWitch getWitchClone() throws IOException {
		return factory.makeWitch();

	}
	
	public StickerSkeleton getSkeletonClone() throws IOException {
		return factory.makeSkelly();

	}
	
	

}
