package model;

import view.MenuChoices;
import view.PanelHandler;
import view.RoundHandler;

public class Game {
	private Character p1;
	private Character p2;
	private static Game game = null;
	private int p1Score;
	private int p2Score;
	private int round;
	public boolean gameOver;
	boolean flag = false;
	CollitionHandler ch;


	private Game() {
		
		p1Score = 0;
		p2Score = 0;
		round=0;
		gameOver = false;
		this.p1 = MenuChoices.getInstance().getP1();
		this.p2 = MenuChoices.getInstance().getP2();
	}

	public void startGame() {
		myGameLoop myLoop = new myGameLoop();
		Thread t = new Thread(myLoop);
		startRound();
		t.start();
	}

	public void startRound() {
		//
		RoundHandler.setState(RoundHandler.FIGHTING);
		refreshRoundCount();
		//
		resetChar();
		p1.setX(30); p1.setDirection(model.Character.DIRECTION_RIGHT);
		p2.setX(PanelHandler.WIDTH-p2.getWidth()-20); p2.setDirection(model.Character.DIRECTION_LEFT);
		if(!flag) {
			ch = new CollitionHandler(p1, p2);
			Thread t = new Thread(ch);
			t.start();
		}
		flag = true;
	}
	
	private void resetChar() {
		p1.setDefault();
		p2.setDefault();
	}

	public static Game getInstance() {
		if (game == null) 
			game = new Game();
		return game;
	}


	public void checkStatusRound() {
		if (p1.dead) {
			p2Score++;
			newRound();
		} else if (p2.dead) {
			p1Score++;
			newRound();
		}
	}

	public void newRound() {
		if (!checkWin()) {
			RoundHandler.setState(RoundHandler.ROUND_END);
		}
		else 
			gameOver();
	}
	

	public boolean checkWin() {
		if (p1Score == 2 || p2Score == 2)
			gameOver = true;
		return gameOver;
	}

	public static void gameOver() {
		game = null;
		//
		RoundHandler.setState(RoundHandler.GAME_OVER);
		//
	}
	
	private void refreshRoundCount() {
		if(p1Score+p2Score>2)
			round=2;
		else
			round=p1Score+p2Score;
	}
	
	public int getRound() {
		return round;
	}
	public Character getP1() {
		return p1;
	}

	public void setP1(Character p1) {
		this.p1 = p1;
	}

	public Character getP2() {
		return p2;
	}

	public void setP2(Character p2) {
		this.p2 =  p2;
	}

	public int getP1Score() {
		return p1Score;
	}

	public void setP1Score(int p1Score) {
		this.p1Score = p1Score;
	}

	public int getP2Score() {
		return p2Score;
	}

	public void setP2Score(int p2Score) {
		this.p2Score = p2Score;
	}
	
	public CollitionHandler getCollitionHandler() {
		return ch;
	}
	

}
