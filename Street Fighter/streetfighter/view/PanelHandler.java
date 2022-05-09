package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;




public class PanelHandler {
	
	static public final int MAIN=1;
	static public final int ARENA=2;
	static public final int FIGHT=3;
	static public final int CHAR=4;
	static public final int frequency=100;
	
	static public final int WIDTH=1240;
	static public final int HEIGHT=720;
	
	private int currentPanel;
	private boolean reset;
	private JFrame f;
	private SongHandler sh;
	private MainMenu mm=null;
	private FightPanel fp=null;
	
	static private PanelHandler instance=null;
	
	private PanelHandler() {
		f = new JFrame();
		f.setTitle("Street Fighter");
		f.setSize(WIDTH,HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
		try {
			f.setIconImage(ImageIO.read(getClass().getResourceAsStream("/view/resources/icona.png")));
		} catch (IOException e) {e.printStackTrace();}
		
		mm=new MainMenu();
		changeCurrentPanel(mm);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		sh=new SongHandler();
		sh.startMenuTheme();
	}
	
	public void returnToMainMenu() {
		f.setContentPane(mm);
		f.revalidate();
		currentPanel=MAIN;
		mm.requestFocusInWindow();
		sh.changeToMenuTheme();
		
	}

	public void changeCurrentPanel(MainMenu mm) {
		currentPanel=MAIN;
		f.setContentPane(mm);
		f.revalidate();
		fp=null;
		
	}
	
	public void changeCurrentPanel(ArenaSelect as) {
		currentPanel=ARENA;
		f.setContentPane(as);
		f.revalidate();
		fp=null;
		
	}
	
	public void changeCurrentPanel(FightPanel fp) {
		currentPanel=FIGHT;
		f.setContentPane(fp);
		f.revalidate();
		fp.requestFocusInWindow();
		sh.changeToFightTheme();
	}
	
	public void changeCurrentPanel(CharacterSelect cs) {
		currentPanel=CHAR;
		f.setContentPane(cs);
		f.revalidate();
		
		cs.requestFocusInWindow();
	
	}
	
	public static PanelHandler getIstance() {
		if(instance==null)
			instance=new PanelHandler();
		return instance;
	}
	
	public FightPanel getFightPanel() {
		return fp;
	}
	
	public int getCurrentPanel() {
		return currentPanel;
	}
	public boolean getReset() {
		return reset;
	}
	public void setReset(boolean reset) {
		this.reset = reset;
	}
}
