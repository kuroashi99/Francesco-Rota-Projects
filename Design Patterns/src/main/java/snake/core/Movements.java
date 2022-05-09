package snake.core;

import java.util.ArrayList;

public class Movements {

	private final static int speed = 10;
	public final static int MOVE_RIGHT = 0;
	public final static int MOVE_LEFT = 1;
	public final static int MOVE_UP = 2;
	public final static int MOVE_DOWN = 3;

	private static boolean collision(Snake s, Block b) {
		if(s.getHead().getX() == b.getX() && s.getHead().getY() == b.getY())
			return true;
		return false;
	}
	
	private static boolean collision(Snake s, ArrayList<Grass> grass) {
		//If the head of the snake is on the grass then there is a collision
		for(Grass g : grass) {
			if(collision(s, g))
				return true;
		}
		//If the snake touch its body then there is a collision
		for(Block b : s.getBody()) {
			if(collision(s, b))
				return true;
		}
		
		return false;
	}

	private static void moveHead(int direction, Snake s) {
		Block b = s.getHead();
		switch (direction) {
		case MOVE_RIGHT:
			b.x += speed;
			break;

		case MOVE_LEFT:
			b.x -= speed;
			break;

		case MOVE_UP:
			b.y -= speed;
			break;

		case MOVE_DOWN:
			b.y += speed;
			break;
		}
	}

	private static void moveBody(Snake s, int x, int y) {
		ArrayList<Block> body = s.getBody();
		if (body.isEmpty())
			return;
		for (int i = body.size() - 1; i >= 1; i--) {
			move(body.get(i), body.get(i - 1));
		}
		move(body.get(0),new Block(x, y));
	}

	private static void move(Block start, Block end) {
		start.x = end.x;
		start.y = end.y;
	}

	public static boolean move(int direction, Snake s, ArrayList<Grass> grass) {
		int old_x = s.getHead().x;
		int old_y = s.getHead().y;
		moveHead(direction, s);
		moveBody(s, old_x, old_y);
		if (collision(s, grass))
			return false;
		return true;
	}

	public static boolean samePosition(Snake s, Block b) {
		if(samePosition(s.getHead(), b))
			return true;
		for(Block b1 : s.getBody())
			if(samePosition(b1, b))
				return true;
		return false;
	}
	
	public static boolean samePosition(Block b1, Block b2) {
		return b1.getX() == b2.getX() && b1.getY() == b2.getY();
	}
}
