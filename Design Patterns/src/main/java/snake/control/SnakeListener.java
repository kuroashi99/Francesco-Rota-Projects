package snake.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snake.core.Game;
import snake.core.Movements;
import snake.view.SnakePanel;

public class SnakeListener extends KeyAdapter {
	
	private SnakePanel snakePanel;
	public SnakeListener(SnakePanel snakePanel) {		
		this.snakePanel = snakePanel;		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_Q)
			System.exit(0);
		
		if(Game.getGame().isAlive() && !Game.getGame().win()) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				Game.getGame().move(Movements.MOVE_LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				Game.getGame().move(Movements.MOVE_RIGHT);
				break;
			case KeyEvent.VK_DOWN:
				Game.getGame().move(Movements.MOVE_DOWN);
				break;
			case KeyEvent.VK_UP:
				Game.getGame().move(Movements.MOVE_UP);
				break;
			case KeyEvent.VK_N:
				Game.restartGame();			
			default:
				break;
			}		
			snakePanel.repaint();
		}		
	}	
}
