package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.FightController;
import model.CollitionHandler;
import model.Game;

public class FightPanel extends JPanel implements Runnable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3728431663909780552L;
	CharacterView p1, p2;
	Image lifebar, P1, P2, stage, p1Wins, p2Wins, endText, w;
	Image[] roundText;
	Game game;
	CollitionHandler ch;
	FightController fc;
	Thread loop;
	public boolean devMode=false, gameOver=false, stop=false;;
	
	public FightPanel() {
		
		
		stage=MenuChoices.getInstance().getArena().getScaledInstance(PanelHandler.WIDTH, PanelHandler.HEIGHT, Image.SCALE_SMOOTH);
		loadImages();
		
		if(PanelHandler.getIstance().getReset()) {
			game = Game.getInstance();
			game.setP1(MenuChoices.getInstance().getP1());
			game.setP2(MenuChoices.getInstance().getP2());
			PanelHandler.getIstance().setReset(false);
			
		}
			
		game = Game.getInstance();
		game.startGame();
		ch=game.getCollitionHandler();
		initCharacter();
		
		this.addKeyListener(new FightController(this));
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		loop=new Thread(this);
		loop.start();
		
	
	}
	
	@Override
	public void run() {
		while(!stop) {
			
			switch(RoundHandler.getState()) {
			
			case RoundHandler.FIGHTING:
				if(!fc.isActive()) {
					fc.setActive(true);
				}
				break;
				
			case RoundHandler.ROUND_END:
				if(fc.isActive()) {
					fc.setActive(false);
				}
				if(game.getP1().getHp()<=0&&p1.getState()!=CharacterView.DEAD) {
					p1.die();
				}
				else if(game.getP2().getHp()<=0&&p2.getState()!=CharacterView.DEAD&&p1.getState()!=CharacterView.WIN) {
					p2.die();
				}
				break;
				
			case RoundHandler.GAME_OVER:
				if(fc.isActive()) {
					fc.setActive(false);
				}
				if(game.getP1().getHp()<=0&&p1.getState()!=CharacterView.DEAD) {
					p1.die();
				}
				else if(game.getP2().getHp()<=0&&p2.getState()!=CharacterView.DEAD) {
					p2.die();
				}
				gameOver=true;
				fc.setGameOver(true);
				break;
			}
			
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMisc(g);
		drawPlayers(g);
		if(gameOver) {
			drawEndText(g);
		}
		
	}
	
	

	private void drawEndText(Graphics g) {
		if(game.getP1Score()==2)
			g.drawImage(p1Wins, PanelHandler.WIDTH/2-p1Wins.getWidth(null)/2, PanelHandler.HEIGHT/3, null);
		
		else
			g.drawImage(p2Wins, PanelHandler.WIDTH/2-p2Wins.getWidth(null)/2, PanelHandler.HEIGHT/3, null);
		
		g.drawImage(endText, PanelHandler.WIDTH/2-endText.getWidth(null)/2, PanelHandler.HEIGHT-52, null);
		
	}

	private void drawMisc(Graphics g) {
		//ARENA
		g.drawImage(stage, 0, 0, null);
		//LIFEBARS
		g.drawImage(lifebar, 15, 30, null);
		//PORTRAITS
		g.drawImage(p1.c.portrait, 15, 85, null);
		g.drawImage(p2.c.portrait, PanelHandler.WIDTH-125, 85, null);
		//NAMES
		g.drawImage(p1.c.nameText, 125, 85, null);
		g.drawImage(p2.c.nameText, PanelHandler.WIDTH-48-p2.c.portrait.getWidth(null)-p2.c.nameText.getWidth(null), 85, null);
		//1P,2P
		g.drawImage(P1, 15, 185, null);
		g.drawImage(P2, PanelHandler.WIDTH-65, 185, null);
		//ROUND
		g.drawImage(roundText[game.getRound()], lifebar.getWidth(null)/2-96, 90, null);
		//ROUND WON
		drawRoundsWon(g);
		//DAMAGES
		drawDamages(g);
		//HITBOXES
		drawHitboxes(g);

	}
	
	private void drawRoundsWon(Graphics g) {
		//P1
		if(game.getP1Score()==1)
			g.drawImage(w, 125, 125, null);
		else if(game.getP1Score()==2) {
			g.drawImage(w, 125, 125, null);
			g.drawImage(w, 125+40, 125, null);
		}
		//P2
		if(game.getP2Score()==1)
			g.drawImage(w, PanelHandler.WIDTH-180, 125, null);
		else if(game.getP2Score()==2) {
			g.drawImage(w,PanelHandler.WIDTH-220, 125, null);
			g.drawImage(w, PanelHandler.WIDTH-180, 125, null);
		}
	}

	private void drawDamages(Graphics g) {
		g.setColor(new Color(150,0,0));
		
		if(game.getP1().getHp()>0) 
			g.fillRect(28, 41, (model.Character.TOTAL_HP-game.getP1().getHp()), 31);
		else if(game.getP1().getHp()<=0)
			g.fillRect(28, 41, model.Character.TOTAL_HP-6, 31);
		
		if(game.getP2().getHp()>0) 
			g.fillRect((PanelHandler.WIDTH-51)-(model.Character.TOTAL_HP-game.getP2().getHp()), 41, model.Character.TOTAL_HP-game.getP2().getHp(), 31);
		else if(game.getP2().getHp()<=0) {
			g.fillRect((PanelHandler.WIDTH-51)-model.Character.TOTAL_HP, 41, model.Character.TOTAL_HP, 31);
			System.out.println(model.Character.TOTAL_HP-game.getP2().getHp());
		}
	}
	
	private void drawHitboxes(Graphics g) {
		if(devMode) {
			g.setColor(Color.GREEN);
			g.drawRect((int)ch.p1HitBox.getX(),(int) ch.p1HitBox.getY(), (int)ch.p1HitBox.getWidth(),(int) ch.p1HitBox.getHeight());
			g.drawRect((int)ch.p2HitBox.getX(),(int) ch.p2HitBox.getY(), (int)ch.p2HitBox.getWidth(),(int) ch.p2HitBox.getHeight());
			g.setColor(Color.RED);
			g.drawRect((int)ch.blowPlayer1.getX(),(int) ch.blowPlayer1.getY(), (int)ch.blowPlayer1.getWidth(),(int) ch.blowPlayer1.getHeight());
			g.drawRect((int)ch.blowPlayer2.getX(),(int) ch.blowPlayer2.getY(), (int)ch.blowPlayer2.getWidth(),(int) ch.blowPlayer2.getHeight());	
		}
	}
	
	private void drawPlayers(Graphics g) {
		g.drawImage(p1.current, p1.getX(), p1.getY(), null);
		g.drawImage(p2.current, p2.getX(), p2.getY(),  null);
	}

	private void loadImages() {
		roundText=new Image[3];
		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("/view/resources/lifebars.png"));
			lifebar = img.getScaledInstance(PanelHandler.WIDTH-50, 50, Image.SCALE_SMOOTH);
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/1p.png"));
			P1=img.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/2p.png"));
			P2=img.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/1p_wins.png"));
			p1Wins=img;
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/2p_wins.png"));
			p2Wins=img;
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/end_text.png"));
			endText=img;
			img= ImageIO.read(getClass().getResourceAsStream("/view/resources/w.png"));
			w=img.getScaledInstance(img.getWidth(null)-10, img.getHeight(null)-10, Image.SCALE_SMOOTH);
			
			for(int i=0;i<roundText.length;i++) {
				img = ImageIO.read(getClass().getResourceAsStream("/view/resources/roundText/"+ i + ".png"));
				roundText[i]=img;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void initCharacter() {
		p1=new CharacterView(game.getP1(), this);
		p2=new CharacterView(game.getP2(), this);
		game.getP1().setView(p1);
		game.getP2().setView(p2);
	}
	public CharacterView getP1() {
		return p1;
	}
	public CharacterView getP2() {
		return p2;
	}
	public boolean getDevMode() {
		return devMode;
	}
	public void devMode() {
		devMode=true;
	}
	public void toggleDevMode(){
		devMode=false;
	}
	public void setFightController(FightController fc) {
		this.fc = fc;
	}


	public void restart() {
		gameOver=false;
		game = Game.getInstance(); 
		game.startGame();
		ch=game.getCollitionHandler();
		stop=false;
		initCharacter();
		addKeyListener(new FightController(this));
		setFocusable(true);
		requestFocusInWindow();
		
	}
	
	public void pause() {
		try {
			Thread.sleep(100*20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
