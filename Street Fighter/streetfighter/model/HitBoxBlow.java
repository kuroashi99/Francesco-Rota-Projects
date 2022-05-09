package model;

import java.awt.Rectangle;

public class HitBoxBlow {
	private final static int HITBOX_LIGHT_PUNCH_X = 110;
	private final static int HITBOX_HARD_PUNCH_X = 120;
	private final static int HITBOX_LIGHT_PUNCH_Y = 80;
	private final static int HITBOX_HARD_PUNCH_Y = 50;
	private final static int HITBOX_LIGHT_KICK_X = 160;
	private final static int HITBOX_LIGHT_KICK_Y = 50;
	private final static int HITBOX_HARD_KICK_X = 170;
	private final static int HITBOX_HARD_KICK_Y = 80;

	private static Rectangle lightPunch = new Rectangle(0, 0, 0, 0);
	private static Rectangle hardPunch = new Rectangle(0, 0, 0, 0);
	private static Rectangle lightKick = new Rectangle(0, 0, 0, 0);
	private static Rectangle hardKick = new Rectangle(0, 0, 0, 0);

	public static Rectangle getLightPunchHitBox(Character C) {
		if (C instanceof Ryu || C instanceof Ken) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightPunch.setBounds(C.getX() + 60, C.getY() + 30, HITBOX_LIGHT_PUNCH_X + 20, HITBOX_LIGHT_PUNCH_Y);
			else
				lightPunch.setBounds(C.getX(), C.getY() + 30, HITBOX_LIGHT_PUNCH_X, HITBOX_LIGHT_PUNCH_Y);
		} else if (C instanceof Bison) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightPunch.setBounds(C.getX() + 90, C.getY() + 30, HITBOX_LIGHT_PUNCH_X + 20, HITBOX_LIGHT_PUNCH_Y);
			else
				lightPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_LIGHT_PUNCH_X, HITBOX_LIGHT_PUNCH_Y);
		}
		else if (C instanceof Chunli) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightPunch.setBounds(C.getX() + 40, C.getY() + 30, HITBOX_LIGHT_PUNCH_X + 20, HITBOX_LIGHT_PUNCH_Y); 
			else
				lightPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_LIGHT_PUNCH_X, HITBOX_LIGHT_PUNCH_Y);
		}
		else if (C instanceof FeiLong) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightPunch.setBounds(C.getX() + 80, C.getY() + 40, HITBOX_LIGHT_PUNCH_X + 30, HITBOX_LIGHT_PUNCH_Y - 40);  
			else
				lightPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_LIGHT_PUNCH_X - 20, HITBOX_LIGHT_PUNCH_Y - 40);
		}
		else if (C instanceof Guile) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightPunch.setBounds(C.getX() + 70, C.getY() + 30, HITBOX_LIGHT_PUNCH_X + 20, HITBOX_LIGHT_PUNCH_Y - 30);  
			else
				lightPunch.setBounds(C.getX() + 30, C.getY() + 30, HITBOX_LIGHT_PUNCH_X - 40, HITBOX_LIGHT_PUNCH_Y - 30);
		}
		return lightPunch;
	}

	public static Rectangle getHardPunchHitBox(Character C) {
		if (C instanceof Ryu || C instanceof Ken) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardPunch.setBounds(C.getX() + 80, C.getY() + 30, HITBOX_HARD_PUNCH_X + 35, HITBOX_HARD_PUNCH_Y);
			else
				hardPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_HARD_PUNCH_X - 60, HITBOX_HARD_PUNCH_Y);
		} else if (C instanceof Bison) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardPunch.setBounds(C.getX() + 120, C.getY() + 30, HITBOX_HARD_PUNCH_X + 35, HITBOX_HARD_PUNCH_Y + 40);
			else
				hardPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_HARD_PUNCH_X - 60, HITBOX_HARD_PUNCH_Y + 40);
		}
		else if (C instanceof Chunli) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardPunch.setBounds(C.getX() + 65, C.getY() + 30, HITBOX_HARD_PUNCH_X + 35, HITBOX_HARD_PUNCH_Y); 
			else
				hardPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_HARD_PUNCH_X - 60, HITBOX_HARD_PUNCH_Y);
		}
		else if (C instanceof FeiLong) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardPunch.setBounds(C.getX() + 80, C.getY() + 30, HITBOX_HARD_PUNCH_X + 35, HITBOX_HARD_PUNCH_Y); 
			else
				hardPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_HARD_PUNCH_X - 60, HITBOX_HARD_PUNCH_Y);
		}
		else if (C instanceof Guile) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardPunch.setBounds(C.getX() + 80, C.getY() + 30, HITBOX_HARD_PUNCH_X + 85, HITBOX_HARD_PUNCH_Y); 
			else
				hardPunch.setBounds(C.getX() + 10, C.getY() + 30, HITBOX_HARD_PUNCH_X - 60, HITBOX_HARD_PUNCH_Y);
		}
		return hardPunch;
	}

	public static Rectangle getLightKickHitBox(Character C) {
		if (C instanceof Ryu || C instanceof Ken) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightKick.setBounds(C.getX() + 60, C.getY(), HITBOX_LIGHT_KICK_X, HITBOX_LIGHT_KICK_Y);
			else
				lightKick.setBounds(C.getX() + 5, C.getY() - 15, HITBOX_LIGHT_KICK_X - 100, HITBOX_LIGHT_KICK_Y);
		} else if (C instanceof Bison) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)   
				lightKick.setBounds(C.getX() + 70, C.getY() + 100, HITBOX_LIGHT_KICK_X, HITBOX_LIGHT_KICK_Y + 30); 
			else
				lightKick.setBounds(C.getX() + 5, C.getY() + 100, HITBOX_LIGHT_KICK_X, HITBOX_LIGHT_KICK_Y);
		}
		else if (C instanceof Chunli) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightKick.setBounds(C.getX() + 100, C.getY() + 100, HITBOX_LIGHT_KICK_X, HITBOX_LIGHT_KICK_Y); 
			else
				lightKick.setBounds(C.getX() + 5, C.getY() + 100, HITBOX_LIGHT_KICK_X - 100, HITBOX_LIGHT_KICK_Y);
		}
		else if (C instanceof FeiLong) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightKick.setBounds(C.getX() + 130, C.getY(), HITBOX_LIGHT_KICK_X, HITBOX_LIGHT_KICK_Y); 
			else
				lightKick.setBounds(C.getX() + 5, C.getY() - 15, HITBOX_LIGHT_KICK_X - 100, HITBOX_LIGHT_KICK_Y);
		}
		else if (C instanceof Guile) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				lightKick.setBounds(C.getX() + 60, C.getY() + 120, HITBOX_LIGHT_KICK_X + 30, HITBOX_LIGHT_KICK_Y); 
			else
				lightKick.setBounds(C.getX() - 15, C.getY() + 120, HITBOX_LIGHT_KICK_X - 50, HITBOX_LIGHT_KICK_Y);
		}
		return lightKick;
	}

	public static Rectangle getHardKickHitBox(Character C) {
		if (C instanceof Ryu || C instanceof Ken) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardKick.setBounds(C.getX() + 80, C.getY(), HITBOX_HARD_KICK_X, HITBOX_HARD_KICK_Y);
			else
				hardKick.setBounds(C.getX() - 10, C.getY(), HITBOX_HARD_KICK_X - 100, HITBOX_HARD_KICK_Y);
		}
		if (C instanceof Bison) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardKick.setBounds(C.getX() + 90, C.getY() + 100, HITBOX_HARD_KICK_X + 20, HITBOX_HARD_KICK_Y); 
			else
				hardKick.setBounds(C.getX() +    10, C.getY() + 100, HITBOX_HARD_KICK_X - 50, HITBOX_HARD_KICK_Y);
		}
		else if (C instanceof Chunli) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardKick.setBounds(C.getX() + 80, C.getY(), HITBOX_HARD_KICK_X, HITBOX_HARD_KICK_Y); 
			else
				hardKick.setBounds(C.getX() + 10, C.getY(), HITBOX_HARD_KICK_X - 100, HITBOX_HARD_KICK_Y);
		}
		else if (C instanceof FeiLong) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardKick.setBounds(C.getX() + 80, C.getY(), HITBOX_HARD_KICK_X, HITBOX_HARD_KICK_Y - 20);
			else
				hardKick.setBounds(C.getX() - 10, C.getY(), HITBOX_HARD_KICK_X - 100, HITBOX_HARD_KICK_Y);
		}
		else if (C instanceof Guile) {
			if (C.getDirection() == Character.DIRECTION_RIGHT)
				hardKick.setBounds(C.getX() + 80, C.getY(), HITBOX_HARD_KICK_X, HITBOX_HARD_KICK_Y);
			else
				hardKick.setBounds(C.getX(), C.getY(), HITBOX_HARD_KICK_X - 100, HITBOX_HARD_KICK_Y);
		}
		return hardKick;
	}
}
