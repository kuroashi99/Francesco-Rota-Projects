package model;

import view.RoundHandler;

public class myGameLoop implements Runnable {

	private Game gameInstance;

	public myGameLoop() {
		gameInstance = Game.getInstance();
	}

	@Override
	public void run() {
		while (!gameInstance.gameOver) {
			//
			if(RoundHandler.getState()==RoundHandler.FIGHTING)
				gameInstance.checkStatusRound();
			//
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

}

