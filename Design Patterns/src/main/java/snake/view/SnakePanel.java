package snake.view;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import snake.config.Settings;
import snake.core.Block;
import snake.core.Game;
import snake.core.Grass;
import snake.core.Snake;

public class SnakePanel extends JPanel {
	
	private static final long serialVersionUID = -2623791009785894161L;
	
	private void drawGrass(Graphics g) {
		Color orig = g.getColor();
		g.setColor(Color.GREEN);
		for(Grass e : Game.getGame().getGrass()) {
			g.fillRect(e.getX(), e.getY(), Settings.BLOCK_SIZE, Settings.BLOCK_SIZE);			
		}
		g.setColor(orig);
	}
	
	@Override
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		drawGrass(g);
		
		g.setColor(Color.BLACK);
		Snake snake = Game.getGame().getSnake();		
		g.fillOval(snake.getHead().getX(), snake.getHead().getY(), Settings.BLOCK_SIZE, Settings.BLOCK_SIZE);		
		for(Block c : snake.getBody())
			g.fillRect(c.getX(), c.getY(), Settings.BLOCK_SIZE, Settings.BLOCK_SIZE);
		
		if(!Game.getGame().isAlive())
			g.drawString("Game over!", Settings.WINDOW_SIZE/8, Settings.WINDOW_SIZE/2);		
		else if(Game.getGame().win()) {
			g.setColor(Color.WHITE);
			g.drawString("You win!", Settings.WINDOW_SIZE/8, Settings.WINDOW_SIZE/2);
		}
		else {
			Block b = Game.getGame().getBlock();
			g.setColor(Color.BLUE);
			g.fillRect(b.getX(), b.getY(), Settings.BLOCK_SIZE, Settings.BLOCK_SIZE);
		}
	}
}
