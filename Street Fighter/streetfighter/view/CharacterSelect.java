package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.Bison;
import model.Chunli;
import model.FeiLong;
import model.Guile;
import model.Ken;
import model.Ryu;
import model.Character;

public class CharacterSelect extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -48329110505274298L;
	static final int NUM_CHAR=6;
	static final int RYU=0,KEN=1,FEI=2,BISON=3,CHUNLI=4,GUILE=5;
	static final int P1=0,P2=1,CONFIRM=3;
	static final Color FRAME_COLOR=Color.YELLOW;
	
	public static final int WINDOW_WIDTH=347, WINDOW_HEIGHT=355, WINDOW_SX_X=39, WINDOW_Y=152, WINDOW_DX_X=PanelHandler.WIDTH-WINDOW_WIDTH-43;

	
	int index, state;
	private Character[] charactersP1, charactersP2;
	Image structure, ccText, ccgbText, cselectText, confirmText, readyText, P1Text, P2Text;
	Character p1, p2;
	Thread loop;
	
	public CharacterSelect() {
		index=0;
		state=P1;
		initializeCharacters();
		initializeVisuals();
		initializeController();
		loop=new Thread(this);
		loop.start();
		
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(structure, 0, 0, null);
		
		switch(state) {
			case P1:
				drawWindowSx(g);
				drawWindowDx(g,0);
				drawText(g);
				break;
			
			case P2:
				drawWindowSx(g, p1);
				drawWindowDx(g);
				drawText(g);
				break;
			
			case CONFIRM:
				drawWindowSx(g, p1);
				drawWindowDx(g, p2);
				drawText(g);
				break;
		}
	}


	@Override
	public void run() {
		while(PanelHandler.getIstance().getCurrentPanel()==PanelHandler.CHAR) {
			repaint();
			try {
				Thread.sleep(PanelHandler.frequency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void drawText(Graphics g) {
		g.drawImage(cselectText, PanelHandler.WIDTH/2-cselectText.getWidth(null)/2, 10, null);
		g.drawImage(P1Text, WINDOW_SX_X, WINDOW_Y-P1Text.getWidth(null)*2-5, P1Text.getWidth(null)*2,P1Text.getHeight(null)*2,  null);
		g.drawImage(P2Text, WINDOW_DX_X+WINDOW_WIDTH-P2Text.getWidth(null)*2, WINDOW_Y-P2Text.getWidth(null)*2, P2Text.getWidth(null)*2,P2Text.getHeight(null)*2,  null);
		switch(state) {
		
		case P1:
			g.drawImage(ccText, PanelHandler.WIDTH/2-ccText.getWidth(null)/2, WINDOW_Y+WINDOW_HEIGHT+50, null);
			break;
		case P2:
			g.drawImage(ccgbText, PanelHandler.WIDTH/2-ccText.getWidth(null)/2, WINDOW_Y+WINDOW_HEIGHT+50, null);
			g.drawImage(readyText, WINDOW_SX_X+WINDOW_WIDTH/2-readyText.getWidth(null)/2, WINDOW_Y+WINDOW_HEIGHT+35, null);
			break;
		case CONFIRM:
			g.drawImage(confirmText, PanelHandler.WIDTH/2-ccText.getWidth(null)/2, WINDOW_Y+WINDOW_HEIGHT+50, null);
			g.drawImage(readyText, WINDOW_SX_X+WINDOW_WIDTH/2-readyText.getWidth(null)/2, WINDOW_Y+WINDOW_HEIGHT+35, null);
			g.drawImage(readyText, WINDOW_DX_X+WINDOW_WIDTH/2-readyText.getWidth(null)/2, WINDOW_Y+WINDOW_HEIGHT+35, null);
			break;
		}
		
	}
	
	private void drawWindowSx(Graphics g) {
		
		g.setColor(new Color(0,0,40));
		//Background
		g.fillRect(WINDOW_SX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		//Mugshot e Nome
		g.drawImage(charactersP1[index].mugshotSx, WINDOW_SX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT, null );
		g.drawImage(charactersP1[index].nameText, (WINDOW_SX_X+WINDOW_WIDTH/2)-charactersP1[index].nameText.getWidth(null)/2, WINDOW_Y-50,  null );
		//Cornice
		g.setColor(FRAME_COLOR);
		g.drawRect(WINDOW_SX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}
	
	private void drawWindowSx(Graphics g, Character p1) {
			
			g.setColor(new Color(0,0,40));
			//Background
			g.fillRect(WINDOW_SX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
			//Mugshot e Nome
			g.drawImage(p1.mugshotSx, WINDOW_SX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT, null );
			g.drawImage(p1.nameText, (WINDOW_SX_X+WINDOW_WIDTH/2)-p1.nameText.getWidth(null)/2, WINDOW_Y-50,  null );
			//Cornice
			g.setColor(FRAME_COLOR);
			g.drawRect(WINDOW_SX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
			
		}
	
	private void drawWindowDx(Graphics g) {
			
			g.setColor(new Color(0,0,40));
			//Background
			g.fillRect(WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
			//Mugshot e Nome
			g.drawImage(charactersP1[index].mugshotDx, WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT, null );
			g.drawImage(charactersP1[index].nameText, (WINDOW_DX_X+WINDOW_WIDTH/2)-charactersP1[index].nameText.getWidth(null)/2, WINDOW_Y-50,  null );
			//Cornice
			g.setColor(FRAME_COLOR);
			g.drawRect(WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
			
		}
	
	private void drawWindowDx(Graphics g, Character p2) {
		
		g.setColor(new Color(0,0,40));
		//Background
		g.fillRect(WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		//Mugshot e Nome
		g.drawImage(p2.mugshotDx, WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT, null );
		g.drawImage(p2.nameText, (WINDOW_DX_X+WINDOW_WIDTH/2)-p2.nameText.getWidth(null)/2, WINDOW_Y-50,  null );
		//Cornice
		g.setColor(FRAME_COLOR);
		g.drawRect(WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}
	
	private void drawWindowDx(Graphics g, int i) {
		g.setColor(new Color(0,0,40));
		//Background
		g.fillRect(WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		//Mugshot e Nome
		g.drawImage(charactersP1[i].mugshotDx, WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT, null );
		g.drawImage(charactersP1[i].nameText, (WINDOW_DX_X+WINDOW_WIDTH/2)-charactersP1[i].nameText.getWidth(null)/2, WINDOW_Y-50,  null );
		//Cornice
		g.setColor(FRAME_COLOR);
		g.drawRect(WINDOW_DX_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}
	
	private void initializeController() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D) {
					if(index==NUM_CHAR-1)
						index=0;
					else
						index++;
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A) {
					if(index==0)
						index=NUM_CHAR-1;
					else
						index--;
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_ENTER||e.getKeyCode()==KeyEvent.VK_Y||e.getKeyCode()==KeyEvent.VK_SPACE) {
					switch(state) {
						case P1:
							p1=charactersP1[index];
							state=P2;
							index=0;
							break;
						case P2:
							p2=charactersP2[index];
							state=CONFIRM;
							index=0;
							break;
						case CONFIRM:
							MenuChoices.getInstance().setPlayers(p1, p2);
							PanelHandler.getIstance().changeCurrentPanel(new ArenaSelect(JSplitPane.VERTICAL_SPLIT));
							break;
					}
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE||e.getKeyCode()==KeyEvent.VK_N) {
					switch(state) {
						case P2:
							p1=null;
							state=P1;
							break;
						case CONFIRM:
							p2=null;
							state=P2;
							break;
					}
				}
			}
		});
		setFocusable(true);
		requestFocusInWindow(true);
		
	}
	
	private void initializeVisuals() {
		try {
			structure=ImageIO.read(getClass().getResourceAsStream("/view/resources/structure.png")).getScaledInstance(PanelHandler.WIDTH, PanelHandler.HEIGHT, Image.SCALE_SMOOTH);
			cselectText=ImageIO.read(getClass().getResourceAsStream("/view/resources/cselect.png"));
			ccText=ImageIO.read(getClass().getResourceAsStream("/view/resources/cc_text.png"));
			ccgbText=ImageIO.read(getClass().getResourceAsStream("/view/resources/ccgb_text.png"));
			readyText=ImageIO.read(getClass().getResourceAsStream("/view/resources/ready.png"));
			confirmText=ImageIO.read(getClass().getResourceAsStream("/view/resources/confirm_text.png"));
			P1Text=ImageIO.read(getClass().getResourceAsStream("/view/resources/1p.png"));
			P2Text=ImageIO.read(getClass().getResourceAsStream("/view/resources/2p.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void initializeCharacters() {
		charactersP1=new Character[NUM_CHAR];
		charactersP1[RYU]=new Ryu();
		charactersP1[KEN]=new Ken();
		charactersP1[FEI]=new FeiLong();
		charactersP1[BISON]=new Bison();
		charactersP1[CHUNLI]=new Chunli();
		charactersP1[GUILE]=new Guile();
		
		charactersP2=new Character[NUM_CHAR];
		charactersP2[RYU]=new Ryu();
		charactersP2[KEN]=new Ken();
		charactersP2[FEI]=new FeiLong();
		charactersP2[BISON]=new Bison();
		charactersP2[CHUNLI]=new Chunli();
		charactersP2[GUILE]=new Guile();
	}
	
	
}
