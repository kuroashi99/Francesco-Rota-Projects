package view;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Arena extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH=350;
	public static final int HEIGHT=150;
	
	Image arena;
	
	public Arena(Image arena) {
		this.arena=arena;
		this.setIcon(new ImageIcon(arena.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
		addListener();
	}

	private void addListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuChoices.getInstance().setArena(arena);
				PanelHandler.getIstance().changeCurrentPanel(new FightPanel());	
			}
		});
		
	}

}
