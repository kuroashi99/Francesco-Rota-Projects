package snake.core;

import java.util.ArrayList;
import java.util.Random;

import snake.config.Settings;

public class Game {

	private Snake snake;
	private ArrayList<Grass> grass;
	private Block b;
	boolean alive;
	private static Game game = null;
	private int numberOfValidPositions;

	private Game() {
		snake = new Snake();
		grass = new ArrayList<Grass>();
		b = null;
		alive = true;
		generateGrass();
		
		int possibleBlocks = Settings.WINDOW_SIZE/Settings.BLOCK_SIZE;
		numberOfValidPositions = possibleBlocks * possibleBlocks;
		//Remove the grass
		numberOfValidPositions -= possibleBlocks * 2;
		numberOfValidPositions -= (possibleBlocks-2) * 2;			
	}
	
	public static Game getGame() {
		if(game == null)
			game = new Game();
		return game;
	}
	
	public static void restartGame() {
		game = new Game();
	}

	public ArrayList<Grass> getGrass() {
		return grass;
	}

	private void generateGrass() {
		if (!grass.isEmpty())
			return;
		for (int i = 0; i < Settings.WINDOW_SIZE; i += Settings.BLOCK_SIZE) {
			grass.add(new Grass(i, 0));
			grass.add(new Grass(i, Settings.WINDOW_SIZE - Settings.BLOCK_SIZE));			
		}
		for (int i = 0; i < Settings.WINDOW_SIZE; i += Settings.BLOCK_SIZE) {
			grass.add(new Grass(0, i));
			grass.add(new Grass(Settings.WINDOW_SIZE - Settings.BLOCK_SIZE, i));
		}
	}

	public Block generateBlock() {		
		Random r = new Random();
		Block tmp;
		do {
			// this is to obtain a position in blocks that can be divided by
			// Settings.BLOCK_SIZE
			int x = (r.nextInt(Settings.WINDOW_SIZE) / Settings.BLOCK_SIZE)
					* Settings.BLOCK_SIZE;
			int y = (r.nextInt(Settings.WINDOW_SIZE) / Settings.BLOCK_SIZE)
					* Settings.BLOCK_SIZE;
			tmp = new Block(x, y);
		} while (!isBlockValid(tmp));
		return tmp;
	}
	
	private boolean isBlockValid(Block b) {
		for(Grass g : grass) {
			if(Movements.samePosition(g, b))
				return false;
		}
		return !Movements.samePosition(snake, b);
	}

	public Block getBlock() {
		if (b == null)
			b = generateBlock();
		return b;
	}

	public Snake getSnake() {
		return snake;
	}

	public boolean isAlive() {
		return alive;
	}
	
	public boolean win() {
		return numberOfValidPositions == 0;
	}

	public void move(int direction) {
		boolean ret = Movements.move(direction, snake, grass);
		if (!ret) {
			alive = false;
		} else if (Movements.samePosition(snake, b)) {
			snake.add(b);
			numberOfValidPositions--;
			b = null;
		}
	}
}
