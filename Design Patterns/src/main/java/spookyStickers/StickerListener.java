package spookyStickers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class StickerListener implements ActionListener {
	
	public StickerListener() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelFacade.getInstance().setCurrentImage((StickerButton)e.getSource());
		
	}

	

}
