package visualizzatoreImmagini;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class FabbricaImmagini {
	
	private static FabbricaImmagini instance = null;
	
	private FabbricaImmagini() {
	}
	
	public static FabbricaImmagini getInstance() {
		if(instance == null)
			instance = new FabbricaImmagini();
		return instance;
	}
	
	public Immagine creaImmagine(Image img, int width, int height) {
		return new Immagine(img, width, height);
	}
	
	public ImmagineProxy creaImmagineProxy(Immagine immagine) {
		return new ImmagineProxy(immagine);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(VisualPanel.WIDTH, VisualPanel.HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Visualizza Immagine");
		
		JPanel panel= new VisualPanel();
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


