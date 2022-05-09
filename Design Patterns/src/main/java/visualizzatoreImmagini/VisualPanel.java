package visualizzatoreImmagini;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class VisualPanel extends JPanel {
	public static final int WIDTH = 1240;
	public static final int HEIGHT = 670;
	
	private FabbricaImmagini fb;
	private ImmagineProxy proxyImg;
	
	public VisualPanel() {
		JFileChooser fc = new JFileChooser();
		fb = FabbricaImmagini.getInstance();
		
		int res = fc.showOpenDialog(this);
		if(res == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fc.getSelectedFile();
				Image img = ImageIO.read(file).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
				proxyImg = fb.creaImmagineProxy(fb.creaImmagine(img, WIDTH, HEIGHT));
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(proxyImg.getImg(), 0, 0, null);
	}

}
