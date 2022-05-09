package snake.core;

import java.util.ArrayList;

import snake.config.Settings;

public class Snake {

	private ArrayList<Block> body;
	private Block head;
	
	public Snake() {
		body = new ArrayList<Block>();
		head = new Block(Settings.BLOCK_SIZE,Settings.BLOCK_SIZE);		
	}
		
	public Block getHead() {
		return head;
	}
	
	public ArrayList<Block> getBody() {		
		return body;
	}
	
	public void add(Block b) {
		body.add(b);
	}
}
