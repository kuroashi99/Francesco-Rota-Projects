package model;

import java.awt.Image;

import view.CharacterView;

public abstract class Character {
	
	public static final int TOTAL_HP=514;

	public static final int DIRECTION_RIGHT = 0;
	public static final int DIRECTION_LEFT = 1;
	
	public static final int LIGHT_PUNCH = 0;
	public static final int HARD_PUNCH = 1;
	public static final int LIGHT_KICK = 2;
	public static final int HARD_KICK = 3;
	
	protected int hp;
	protected int x;
	protected int y;
	protected String name;
	protected int speed = 34;
	protected int direction;
	boolean dead = false;
	protected int height;
	protected int width;
	public Image[] idleDx;
	public Image[] idleSx;
	public Image[] punchDx;
	public Image[] punchSx;
	public Image[] heavyPunchSx;
	public Image[] heavyPunchDx;
	public Image[] heavyKickDx;
	public Image[] heavyKickSx;
	public Image[] walkDx;
	public Image[] walkSx;
	public Image[] kickDx;
	public Image[] kickSx;
	public Image[] jumpDx;
	public Image[] jumpSx;
	public Image[] deadDx;
	public Image[] deadSx;
	public Image[] getHitDx;
	public Image[] getHitSx;
	public Image[] victory;
	public Image nameText;
	public Image portrait;
	public Image blockDx;
	public Image blockSx;
	public Image mugshotSx;
	public Image mugshotDx;
	public Combat combat;
	public Movement movement;
	//
	public CharacterView view=null;
	//

	protected abstract void loadImages();
	
	protected abstract void setDefault();
	
	public synchronized int getHp() {
		return hp;
	}

	public synchronized void setHp(int hp) {
		this.hp = hp;
		if(this.hp <= 0)
			dead = true;
	}

	public synchronized int getX() {
		return x;
	}

	public synchronized void setX(int x) {
		this.x = x;
	}

	public synchronized int getY() {
		return y;
	}

	public synchronized void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getSpeed() {
		return speed;
	}

	public void setDirection(int direction) {
		if(direction <= 1 && direction >= 0)
			this.direction = direction;
	}

	public int getDirection() {
		return direction;
	}
	
	public boolean jumping() {
		return this.y > 270;
	}
	
	public void move(int movement) {
		if(!combat.inAttack()) {
			this.movement.move(movement);
		}
	}
	
	public void attack(int attackType) {
		switch(attackType) {
			case LIGHT_PUNCH:
				combat.lightPunch();
			case HARD_PUNCH:
				combat.HardPunch();
			case LIGHT_KICK:
				combat.lightKick();
			case HARD_KICK:
				combat.hardKick();
		}
		combat.attack();
	}
	
	public void block() {
		combat.block();
	}
	
	public boolean isLightPunching() {
		return combat.LP;
	}
	
	public boolean isHardPunching() {
		return combat.HP;
	}
	
	public boolean isLightKicking() {
		return combat.LK;
	}

	public boolean isHardKicking() {
		return combat.HK;
	}

	public boolean isDead() {
		if(hp <= 0)
			dead = true;
		return dead;
	}
	
	//
	public void setView(CharacterView view) {
		this.view = view;
	}
	
	
}
