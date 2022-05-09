package spookyStickers;

import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class Sticker {
	
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	

	protected Image img;
	public String name;

	public  Sticker() throws IOException {
		this.img = getResources();
		this.name = getName();
	}
	
	protected abstract String getName();

	public abstract Sticker clona() throws IOException;
	
	protected abstract Image getResources() throws IOException;
	
	

}
