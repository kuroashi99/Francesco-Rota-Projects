package spookyStickers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TopPanelListener extends MouseAdapter {
	
	
	public TopPanelListener(TopPanel tp) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			PanelFacade.getInstance().draw(e.getX()-Sticker.WIDTH/2, e.getY()-Sticker.HEIGHT/2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
