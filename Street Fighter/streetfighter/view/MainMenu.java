package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainMenu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7731091967334822015L;
	Image logo, startText, copyrightText;
	
	
	public MainMenu() {
		this.addListener();
		try {
			logo=ImageIO.read(getClass().getResourceAsStream("/view/resources/logo.gif"));
			logo=logo.getScaledInstance(PanelHandler.WIDTH, PanelHandler.HEIGHT/2, Image.SCALE_SMOOTH);
			startText=ImageIO.read(getClass().getResourceAsStream("/view/resources/press_start.png"));
			copyrightText=ImageIO.read(getClass().getResourceAsStream("/view/resources/copyright.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(0,0,40));
		g.drawImage(logo, 0, 0, null);
		g.drawImage(startText, (PanelHandler.WIDTH/4)+108, (PanelHandler.HEIGHT/2)+100, null);
		g.drawImage(copyrightText, (PanelHandler.WIDTH/4)+25, (PanelHandler.HEIGHT)-80, null);
		
	}

	private void addListener() {
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER||e.getKeyCode()==KeyEvent.VK_SPACE)
					PanelHandler.getIstance().changeCurrentPanel(new CharacterSelect());
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}	
		});
		setFocusable(true);
	}

}
