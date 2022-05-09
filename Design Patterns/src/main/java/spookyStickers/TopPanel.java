package spookyStickers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	
	private ArrayList<DrawnStickerDecorator> drawnStickers = new ArrayList<DrawnStickerDecorator>();
	private Image bg;
	private Sticker currentSticker;
	
	public TopPanel() throws IOException {
		bg = ImageIO.read(getClass().getResourceAsStream("/spookyStickers/resources/bg.jpg"));
		bg = bg.getScaledInstance(Display.WIDTH, Display.HEIGHT-100, Image.SCALE_SMOOTH);
		PanelFacade.getInstance().setTopPanel(this);
		this.addMouseListener(new TopPanelListener(this));
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, null);
		for(DrawnStickerDecorator s: drawnStickers) {
			g.drawImage(s.img, s.getX(), s.getY(), null);
		}
	}
	
	public void draw(int x, int y) throws IOException {
		drawnStickers.add(new DrawnStickerDecorator(PanelFacade.getInstance().cloneCurrentSticker(), x, y));
		repaint();
		revalidate();
	}
	

	public Sticker getCurrentSticker() {
		return currentSticker;
	}

	public void setCurrentSticker(Sticker currentSticker) {
		this.currentSticker = currentSticker;
	}

}
