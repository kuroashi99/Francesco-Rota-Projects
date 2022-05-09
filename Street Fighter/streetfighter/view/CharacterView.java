package view;

import java.awt.Image;


import model.Character;
import model.Chunli;
import model.Game;
import model.Guile;
import model.Movement;
import model.Ryu;

public class CharacterView implements Runnable {
	static public final int IDLE=0;
	static public final int MOVE=1;
	static public final int JUMP=2;
	static public final int PUNCH=3;
	static public final int GETHIT=4;
	static public final int DEAD=5;
	static public final int WIN=6;
	static public final int KICK=7;
	static public final int BLOCK=8;
	static public final int HEAVY_KICK=9;
	static public final int HEAVY_PUNCH=10;
	
	public final int frequency=100;
	Character c;
	Image current;
	private int index;
	private int state;
	private boolean run;
	FightPanel fightPanel;
	Thread t;

	public CharacterView(Character p1) {
		run=true;
		c=p1;
		index=0;
		state=IDLE;
		t=new Thread(this);
		t.start();
	}
	
	public CharacterView(Character p1, FightPanel fightPanel) {
		run=true;
		c=p1;
		index=0;
		state=IDLE;
		t=new Thread(this);
		t.start();
		this.fightPanel=fightPanel;
	}

	public void move() {
		state=MOVE;
	}
	
	public void stop() {
		if((RoundHandler.getState()==RoundHandler.ROUND_END||RoundHandler.getState()==RoundHandler.GAME_OVER)&&c.getHp()>0)
			win();
		else
			state=IDLE;
	}
	
	public void jump() {
		state=JUMP;	
	}

	public void punch() {
		state=PUNCH;
		
	}
	public void kick() {
		state=KICK;
		
	}
	
	public void heavyPunch() {
		state=HEAVY_PUNCH;
		
	}
	public void heavyKick() {
		state=HEAVY_KICK;
		
	}
	public void block() {
		state=BLOCK;
	}
	
	public void getHit() {
		state=GETHIT;
	}
	
	public void die() {
		state=DEAD;
	}
	
	public void win() {
		state=WIN;
	}
		

	@Override
	public void run() {
		while(run) {
			if(fightPanel.stop)
				run=false;
			switch(state) {
			case IDLE:
				c.combat.endBlock();
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					if(index>=c.idleDx.length)
						index=0;
						current=c.idleDx[index++];
					} else if (c.getDirection()==Character.DIRECTION_LEFT){
						if(index>=c.idleSx.length)
							index=0;
						current=c.idleSx[index++];	
					}
				break;
				
			case MOVE:
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					if(index>=c.walkDx.length)
						index=0;
					current=c.walkDx[index++];
				} else {
					if(index>=c.walkSx.length)
						index=0;
					current=c.walkSx[index++];	
				}
				break;
				
			case JUMP:
				index=0;
				c.combat.endBlock();
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0;i<c.jumpDx.length;i++) {
						current=c.jumpDx[index++];
						
						if(c.jumpDx.length%2==0) {
							if(i<c.jumpDx.length/2)
								c.setY(c.getY()-100);
							else
								c.setY(c.getY()+100);
						} else {
							if(i<c.jumpDx.length/2)
								c.setY(c.getY()-100);
							else if(i>c.jumpDx.length/2)
								c.setY(c.getY()+100);
						}
						
						
						c.move(Movement.MOVE_RIGHT);
						c.move(Movement.MOVE_RIGHT);
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					stop();
				}else {
					for(int i=0;i<c.jumpSx.length;i++) {
						current=c.jumpSx[index++];
						if(c.jumpDx.length%2==0) {
							if(i<c.jumpDx.length/2)
								c.setY(c.getY()-100);
							else
								c.setY(c.getY()+100);
						} else {
							if(i<c.jumpDx.length/2)
								c.setY(c.getY()-100);
							else if(i>c.jumpDx.length/2)
								c.setY(c.getY()+100);
						}
						c.move(Movement.MOVE_LEFT);
						c.move(Movement.MOVE_LEFT);
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					stop();
				}
				break;
				
			
				
			case PUNCH:
				c.combat.endBlock();
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0; i<c.punchDx.length; i++) {
						if(i==c.punchDx.length/2-1)
							c.attack(Character.LIGHT_PUNCH);
						current=c.punchDx[index++];
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				}else {
					for(int i=0;i<c.punchSx.length;i++) {
						if(i==c.punchDx.length/2-1)
							c.attack(Character.LIGHT_PUNCH);
						current=c.punchSx[index++];
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				}
				break;
			
			case KICK:
				c.combat.endBlock();
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0; i<c.kickDx.length; i++) {
						if(i==c.kickDx.length/2-1)
							c.attack(Character.LIGHT_KICK);
						current=c.kickDx[index++];
						
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				}else {
					for(int i=0;i<c.kickSx.length;i++) {
						if(i==c.kickSx.length/2-1)
							c.attack(Character.LIGHT_KICK);
						current=c.kickSx[index++];
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				}
				break;
			
			case BLOCK:
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) 
					current=c.blockDx;
				else
					current=c.blockSx;
				break;
				
			case HEAVY_PUNCH:
				c.combat.endBlock();
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0; i<c.heavyPunchDx.length; i++) {
						if(i==c.heavyPunchDx.length/2-1)
							c.attack(Character.HARD_PUNCH);
						current=c.heavyPunchDx[index++];
						
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				} else {
					for(int i=0;i<c.heavyPunchSx.length;i++) {
						if(i==c.heavyPunchSx.length/2-1)
							c.attack(Character.HARD_PUNCH);
						current=c.heavyPunchSx[index++];
						
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				}
				break;
				
			case HEAVY_KICK:
				c.combat.endBlock();
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0; i<c.heavyKickDx.length; i++) {
						if(i==c.heavyKickDx.length/2-1)
							c.attack(Character.HARD_KICK);
						current=c.heavyKickDx[index++];
						
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					c.combat.endAttack();
					stop();
				}else {
					for(int i=0;i<c.heavyKickSx.length;i++) {
						if(i==c.heavyKickSx.length/2-1)
							c.attack(Character.HARD_KICK);
						current=c.heavyKickSx[index++];
						
						
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					
					c.combat.endAttack();
					stop();
				}
				break;
			
			case GETHIT:
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0; i<c.getHitDx.length; i++) {
						current=c.getHitDx[index++];
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					stop();
				}else {
					for(int i=0;i<c.getHitSx.length;i++) {
						current=c.getHitSx[index++];
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
					stop();
				}
				break;
				
			case DEAD:
				index=0;
				if(c.getDirection()==Character.DIRECTION_RIGHT) {
					for(int i=0;i<c.deadDx.length;i++) {
						if(current!=c.deadDx[c.deadDx.length-1]) {
							current=c.deadDx[index++];
							
						
							if(c instanceof Guile)
								c.setY(c.getY()+c.getHeight()/6);
							else
								c.setY(c.getY()+c.getHeight()/5+7);
						
						}
						
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
	
				}	
					
				else 
					for(int i=0;i<c.deadSx.length;i++) {
						if(current!=c.deadSx[c.deadSx.length-1]) {
							current=c.deadSx[index++];
							
							
							if(c instanceof Guile)
								c.setY(c.getY()+c.getHeight()/6);
							else
								c.setY(c.getY()+c.getHeight()/5+7);    
							
						}
						try {
							Thread.sleep(frequency);
						} catch (InterruptedException e) {e.printStackTrace();}
					}
			
					
				break;
				
			case WIN:
				index=0;
				for(int i=0;i<c.victory.length;i++) {
					
					if(current!=c.victory[c.victory.length-1]) {
						current=c.victory[index++];
						if(c instanceof Chunli)
							c.setY(c.getY()-30);
						else if(c instanceof Ryu)
							c.setY(c.getY()-33);
						
						else if(c instanceof Guile) {
							if(i==c.victory.length-1)
								c.setY(c.getY()-50);
							else
								c.setY(c.getY()-10);
						}
					}
					try {
						Thread.sleep(frequency);
					} catch (InterruptedException e) {e.printStackTrace();}
				}
				fightPanel.pause();
				/*try {
					Thread.sleep(frequency*15);
				} catch (InterruptedException e) {e.printStackTrace();}*/
				
				if(RoundHandler.getState()==RoundHandler.ROUND_END)
					Game.getInstance().startRound();
				
				break;
			
			}
			
			try {
				Thread.sleep(frequency+30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
			
		
	}
	
	public int getState() {
		return state;
	}
	
	public int getX() {
		return c.getX();
	}
	
	public int getY() {
		return c.getY();
	}

	public int getHeight() {
		return c.getHeight();
	}
	public int getWidth() {
		return c.getWidth();
	}
	
	public Character getC() {
		return c;
	}

}
