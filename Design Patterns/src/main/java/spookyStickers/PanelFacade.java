package spookyStickers;

import java.io.IOException;


public class PanelFacade {
	
	private static PanelFacade instance = null;
	
	private TopPanel topPanel;
	private BottomPanel bottomPanel;
	
	private PanelFacade() {
		// TODO Auto-generated constructor stub
	}
	
	public static PanelFacade getInstance() {
		if(instance == null)
			instance = new PanelFacade();
		return instance;
	}
	

	public void setTopPanel(TopPanel topPanel) {
		this.topPanel = topPanel;
	}


	public void setBottomPanel(BottomPanel bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	public static PanelFacade getInstance(BottomPanel bp) {
		if(instance == null)
			instance = new PanelFacade();
		return instance;
	}

	public void setCurrentImage(StickerButton source) {
		topPanel.setCurrentSticker(source.getSticker());
	}

	public void draw(int x, int y) throws IOException {
		topPanel.draw(x, y);
		
	}

	public  Sticker cloneCurrentSticker() throws IOException {
		String name = topPanel.getCurrentSticker().getName();
		switch (name) {
		case "GHOST":
			return bottomPanel.getGhostClone();
			
		case"PUMPKIN":
			return bottomPanel.getPumpkinClone();
		
		case"WITCH":
			return bottomPanel.getWitchClone();
			
		case "SKELETON":
			return bottomPanel.getSkeletonClone();
			
		default:
			return null;
		}
		
	}

}
