package model;

import view.PanelHandler;

public class Movement {

	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_LEFT = 2;
	
	Character player;
	
	Movement(Character p) {
		this.player = p;
	}
	
	public void move(int movement) {
		switch(movement) {
		case MOVE_RIGHT:
			if(player.getDirection() == Character.DIRECTION_RIGHT) {
				if(player.getX() == PanelHandler.WIDTH - player.getWidth())
					break;
				else if(player.getX() + player.getSpeed() >= PanelHandler.WIDTH - player.getWidth())
					player.setX(PanelHandler.WIDTH - player.getWidth());
				else
					player.setX(player.getX() + player.getSpeed());
			}
			else {
				player.setDirection(Character.DIRECTION_RIGHT);
				if(player.getX() == PanelHandler.WIDTH)
					break;
				else if(player.getX() + player.getSpeed() > PanelHandler.WIDTH)
					player.setX(PanelHandler.WIDTH);
				else
					player.setX(player.getX() + player.getSpeed());
			}
			break;
		case MOVE_LEFT:
			if(player.getDirection() == Character.DIRECTION_LEFT) {
				if(player.getX() == 0)
					break;
				else if(player.getX() - player.getSpeed() < 0)
					player.setX(0);
				else
					player.setX(player.getX() - player.getSpeed());
			}
			else {
				player.setDirection(Character.DIRECTION_LEFT);
				if(player.getX() == 0)
					break;
				else if(player.getX() - player.getSpeed() < 0)
					player.setX(0);
				else
					player.setX(player.getX() - player.getSpeed());
			}
			break;
		}
	}

}
