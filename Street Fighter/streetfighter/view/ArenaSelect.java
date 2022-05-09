package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ArenaSelect extends JSplitPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int NUM_ARENE=8;
	private Arena[] arenas;
	
	private JPanel top;
	private JPanel bottom;
	private JLabel text;
	
	public ArenaSelect(int newOrientation) {
		super(newOrientation);
		setDividerLocation(75);
		setDividerSize(0);
		arenas=new Arena[NUM_ARENE];
		initializePanels();
		loadArenas();
		addArenas();
		
		setBottomComponent(bottom);
		setTopComponent(top);
	}
	
	private void initializePanels() {
		top=new JPanel(); 
		bottom=new JPanel();
		bottom.setLayout(new GridLayout(4,2,30,20));
		top.setBackground(new Color(0,0,40));
		bottom.setBackground(new Color(0,0,40));
		try {
			Image img=ImageIO.read(getClass().getResourceAsStream("/view/resources/stage_select.png"));
			text=new JLabel(new ImageIcon(img));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private void addArenas() {
		for(int i=0;i<NUM_ARENE;i++)
			bottom.add(arenas[i]);
		bottom.revalidate();
		top.add(text);
		top.revalidate();
	}
	
	private void  loadArenas() {
		for(int i=0;i<NUM_ARENE;i++) {
			try {
				arenas[i]=new Arena(ImageIO.read(getClass().getResourceAsStream("/view/resources/stages/"+ i +".gif")));
				arenas[i].setContentAreaFilled(false);
				arenas[i].setBackground(Color.BLACK);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
