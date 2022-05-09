package controller;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.CharacterView;
import view.FightPanel;
import view.MenuChoices;
import view.PanelHandler;
import model.Movement;


public class FightController implements KeyListener {
	
	CharacterView p1, p2;
	FightPanel fp;
	private boolean active = true, gameOver=false;
	
	
	public FightController(FightPanel fp) {
		p1=fp.getP1();
		p2=fp.getP2();
		this.fp=fp;
		this.fp.setFightController(this);
	}
	
	
    public void setActive(boolean active){
        this.active = active;
    }
    public boolean isActive() {
    	return active;
    }
    public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(active) {
		//--> P1   ////////////////////////////////////////
			if(!p1.getC().isDead()) {
				//MOVE
				if(e.getKeyCode() == KeyEvent.VK_D) {
					p1.getC().move(Movement.MOVE_RIGHT);
					p1.move();
				}
				else if(e.getKeyCode() == KeyEvent.VK_A) {
					p1.getC().move(Movement.MOVE_LEFT);
					p1.move();
				}
				//JUMP
				else if(e.getKeyCode() == KeyEvent.VK_W) {
					p1.jump();
				}
				//PUNCH
				else if(e.getKeyCode() == KeyEvent.VK_C) {
					p1.punch();
				}
				//KICK
				else if(e.getKeyCode() == KeyEvent.VK_F) {
					p1.kick();
				}
				//HEAVY PUNCH
				else if(e.getKeyCode() == KeyEvent.VK_V) {
					p1.heavyPunch();
				}
				//HEAVY KICK
				else if(e.getKeyCode() == KeyEvent.VK_G) {
					p1.heavyKick();
				}
				//BLOCK
				else if(e.getKeyCode() == KeyEvent.VK_S) {
					p1.getC().block();
					p1.block();
				}
			}
			///--> P2   ////////////////////////////////////////
			if(!p1.getC().isDead()) {
				//MOVE
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					p2.getC().move(Movement.MOVE_RIGHT);
					p2.move();
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					p2.getC().move(Movement.MOVE_LEFT);
					p2.move();
				}
				//JUMP
				else if(e.getKeyCode() == KeyEvent.VK_UP) {
					p2.jump();
				}
				//PUNCH
				else if(e.getKeyCode() == KeyEvent.VK_N) {
					p2.punch();
				}
				//KICK
				else if(e.getKeyCode() == KeyEvent.VK_J) {
					p2.kick();
				}
				//HEAVY PUNCH
				else if(e.getKeyCode() == KeyEvent.VK_M) {
					p2.heavyPunch();
				}
				//HEAVY KICK
				else if(e.getKeyCode() == KeyEvent.VK_K) {
					p2.heavyKick();
				}
				//BLOCK
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					p2.getC().block();
					p2.block();
				}
			}
		
		//--> MISC
			//DEV MODE
			if(e.getKeyCode() == KeyEvent.VK_F1) {
				if(fp.getDevMode())
					fp.toggleDevMode();
				else 
					fp.devMode();
			}
		}
		else if(gameOver) {
			if(e.getKeyCode() == KeyEvent.VK_R) {
				fp.stop=true;
				fp.restart();
			}
			else if(e.getKeyCode() == KeyEvent.VK_Q) {
				fp.stop=true;
				PanelHandler.getIstance().setReset(true);
				MenuChoices.getInstance().reset();
				PanelHandler.getIstance().returnToMainMenu();
			}
			gameOver=false;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_S) {
			p1.stop();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_DOWN) {
			p2.stop();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			p2.getC().combat.endBlock();
		else if(e.getKeyCode() == KeyEvent.VK_S)
			p1.getC().combat.endBlock();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
	

}
