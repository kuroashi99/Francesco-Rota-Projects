package model;

import java.awt.Rectangle;

public class CollitionHandler implements Runnable {


	Character player1;
	Character player2;
	Game instance;
	public Rectangle blowPlayer1;
	public Rectangle blowPlayer2;
	public Rectangle p1HitBox;
	public Rectangle p2HitBox;

	CollitionHandler(Character p1, Character p2) {
		player1 = p1;
		player2 = p2;
		instance = Game.getInstance();
		p1HitBox = new Rectangle(player1.getX() - 1, player1.getY() - 1, player1.getWidth(), player1.getHeight());
		p2HitBox = new Rectangle(player2.getX() - 1, player2.getY() - 1, player2.getWidth(), player2.getHeight());
		blowPlayer1 = new Rectangle(0, 0, 0, 0);
		blowPlayer2 = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public void run() {
		while (true) {
			blowPlayer1.setBounds(0, 0, 0, 0);
			blowPlayer2.setBounds(0, 0, 0, 0);
			if(player1 instanceof Bison) {
				p1HitBox.setBounds(player1.getX() - 1, player1.getY() - 1, player1.getWidth() - 30, player1.getHeight());
			}
			else
				p1HitBox.setBounds(player1.getX() - 1, player1.getY() - 1, player1.getWidth() , player1.getHeight());
			if(player2 instanceof Bison) {
				p2HitBox.setBounds(player2.getX() - 1, player2.getY() - 1, player2.getWidth() - 30, player2.getHeight());
			}
			else
				p2HitBox.setBounds(player2.getX() - 1, player2.getY() - 1, player2.getWidth(), player2.getHeight());
			
			if (player1.combat.inAttack() && !player2.combat.inAttack()) {
				if (player1.isLightPunching()) {
					blowPlayer1 = HitBoxBlow.getLightPunchHitBox(player1);
					if (blowPlayer1.intersects(p2HitBox)) {
						if ((!player2.combat.blocking()) || (player2.combat.blocking() && player1.getDirection() == player2.getDirection())) {
							if (player2.getHp() - player1.combat.getDmg() > 0)
								player2.view.getHit();
							//
							player2.setHp(player2.getHp() - player1.combat.getDmg());
						}
					}
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (player1.isHardPunching()) {
					blowPlayer1 = HitBoxBlow.getHardPunchHitBox(player1);
					if (blowPlayer1.intersects(p2HitBox)) {
						if ((!player2.combat.blocking()) || (player2.combat.blocking() && player1.getDirection() == player2.getDirection())) {
							if (player2.getHp() - player1.combat.getDmg() > 0)
								player2.view.getHit();
							//
							player2.setHp(player2.getHp() - player1.combat.getDmg());
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (player1.isLightKicking()) {
					blowPlayer1 = HitBoxBlow.getLightKickHitBox(player1);
					if (blowPlayer1.intersects(p2HitBox)) {
						if ((!player2.combat.blocking()) || (player2.combat.blocking() && player1.getDirection() == player2.getDirection())) {
							if (player2.getHp() - player1.combat.getDmg() > 0)
								player2.view.getHit();
							//
							player2.setHp(player2.getHp() - player1.combat.getDmg());
						}
					}
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (player1.isHardKicking()) {
					blowPlayer1 = HitBoxBlow.getHardKickHitBox(player1);
					if (blowPlayer1.intersects(p2HitBox)) {
						if ((!player2.combat.blocking()) || (player2.combat.blocking() && player1.getDirection() == player2.getDirection())) {
							if (player2.getHp() - player1.combat.getDmg() > 0)
								player2.view.getHit();
							//
							player2.setHp(player2.getHp() - player1.combat.getDmg());
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (player2.combat.inAttack() && !player1.combat.inAttack()) {
				if (player2.isLightPunching()) {
					blowPlayer2 = HitBoxBlow.getLightPunchHitBox(player2);
					if (blowPlayer2.intersects(p1HitBox)) {
						if ((!player1.combat.blocking()) || (player1.combat.blocking() && player2.getDirection() == player1.getDirection())) {
							if (player1.getHp() - player2.combat.getDmg() > 0)
								player1.view.getHit();
							//
							player1.setHp(player1.getHp() - player2.combat.getDmg());
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (player2.isHardPunching()) {
					blowPlayer2 = HitBoxBlow.getHardPunchHitBox(player2);
					if (blowPlayer2.intersects(p1HitBox)) {
						if ((!player1.combat.blocking()) || (player1.combat.blocking() && player2.getDirection() == player1.getDirection())) {
							if (player1.getHp() - player2.combat.getDmg() > 0)
								player1.view.getHit();
							//
							player1.setHp(player1.getHp() - player2.combat.getDmg());
							System.out.println(player2.hp);
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (player2.isLightKicking()) {
					blowPlayer2 = HitBoxBlow.getLightKickHitBox(player2);
					if (blowPlayer2.intersects(p1HitBox)) {

						if ((!player1.combat.blocking()) || (player1.combat.blocking() && player2.getDirection() == player1.getDirection())) {
							if (player1.getHp() - player2.combat.getDmg() > 0)
								player1.view.getHit();
							//
							player1.setHp(player1.getHp() - player2.combat.getDmg());
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (player2.isHardKicking()) {
					blowPlayer2 = HitBoxBlow.getHardKickHitBox(player2);
					if (blowPlayer2.intersects(p1HitBox)) {
						if ((!player1.combat.blocking()) || (player1.combat.blocking() && player2.getDirection() == player1.getDirection())) {
							if (player1.getHp() - player2.combat.getDmg() > 0)
								player1.view.getHit();
							//
							player1.setHp(player1.getHp() - player2.combat.getDmg());
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (player1.combat.inAttack() && player2.combat.inAttack()) {

				// CASO IN CUI ENTRAMBI I PLAYER SI COLPISCONO CON PUGNI LEGGERI
				if (player1.isLightPunching() && player2.isLightPunching()) {
					blowPlayer1 = HitBoxBlow.getLightPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						continue;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA PUGNO LEGGERO E GIOCATORE 2 PUGNO PESANTE
				else if (player1.isLightPunching() && player2.isHardPunching()) {
					blowPlayer1 = HitBoxBlow.getLightPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player1.setHp(player1.getHp() - (player2.combat.getDmg() - player1.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA PUGNO LEGGERO E GIOCATORE 2 CALCIO LEGGERO
				else if (player1.isLightPunching() && player2.isLightKicking()) {
					blowPlayer1 = HitBoxBlow.getLightPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player1.setHp(player1.getHp() - (player2.combat.getDmg() - player1.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE UNO USA PUGNO LEGGERO E GIOCATORE 2 CALCIO PESANTE
				else if (player1.isLightPunching() && player2.isHardKicking()) {
					blowPlayer1 = HitBoxBlow.getLightPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player1.setHp(player1.getHp() - (player2.combat.getDmg() - player1.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE UNO USA PUGNO PESANTE E GIOCATORE 2 PUGNO LEGGERO
				else if (player1.isHardPunching() && player2.isLightPunching()) {
					blowPlayer1 = HitBoxBlow.getHardPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2)) {
						player2.setHp(player2.getHp() - (player1.combat.getDmg() - player2.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE UNO USA PUGNO PESANTE E GIOCATORE 2 USA PUGNO PESANTE
				else if (player1.isHardPunching() && player2.isHardPunching()) {
					blowPlayer1 = HitBoxBlow.getHardPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						continue;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA PUGNO PESANTE E GIOCATORE 2 CALCIO LEGGERO
				else if (player1.isHardPunching() && player2.isLightKicking()) {
					blowPlayer1 = HitBoxBlow.getHardPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player2.setHp(player2.getHp() - (player1.combat.getDmg() - player2.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE UNO USA PUGNO PESANTE E GIOCATORE 2 CALCIO PESANTE
				else if (player1.isHardPunching() && player2.isHardKicking()) {
					blowPlayer1 = HitBoxBlow.getHardPunchHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player1.setHp(player1.getHp() - (player2.combat.getDmg() - player1.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO LEGGERO E GIOCATORE 2 PUGNO LEGGERO
				else if (player1.isLightKicking() && player2.isLightPunching()) {
					blowPlayer1 = HitBoxBlow.getLightKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player2.setHp(player2.getHp() - (player1.combat.getDmg() - player2.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO LEGGERO E GIOCATORE 2 USA PUGNO PESANTE
				else if (player1.isLightKicking() && player2.isHardPunching()) {
					blowPlayer1 = HitBoxBlow.getLightKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player1.setHp(player1.getHp() - (player2.combat.getDmg() - player1.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO LEGGERO E GIOCATORE 2 USA CALCIO LEGGERO
				else if (player1.isLightKicking() && player2.isLightKicking()) {
					blowPlayer1 = HitBoxBlow.getLightKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						continue;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO LEGGERO E GIOCATORE 2 USA CALCIO PESANTE
				else if (player1.isLightKicking() && player2.isHardKicking()) {
					blowPlayer1 = HitBoxBlow.getLightKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player1.setHp(player1.getHp() - (player2.combat.getDmg() - player1.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO PESANTE E GIOCATORE 2 USA PUGNO LEGGERO
				else if (player1.isHardKicking() && player2.isLightPunching()) {
					blowPlayer1 = HitBoxBlow.getHardKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player2.setHp(player2.getHp() - (player1.combat.getDmg() - player2.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO PESANTE E GIOCATORE 2 USA PUGNO PESANTE
				else if (player1.isHardKicking() && player2.isHardPunching()) {
					blowPlayer1 = HitBoxBlow.getHardKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardPunchHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player2.setHp(player2.getHp() - (player1.combat.getDmg() - player2.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO PESANTE E GIOCATORE 2 USA CALCIO LEGGERO
				else if (player1.isHardKicking() && player2.isLightKicking()) {
					blowPlayer1 = HitBoxBlow.getHardKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getLightKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						player2.setHp(player2.getHp() - (player1.combat.getDmg() - player2.combat.getDmg()));
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// CASO IN CUI GIOCATORE 1 USA CALCIO PESANTE E GIOCATORE 2 USA CALCIO PESANTE
				else if (player1.isHardKicking() && player2.isHardKicking()) {
					blowPlayer1 = HitBoxBlow.getHardKickHitBox(player1);
					blowPlayer2 = HitBoxBlow.getHardKickHitBox(player2);
					if (blowPlayer1.intersects(blowPlayer2) || blowPlayer1.intersects(p1HitBox)
							|| blowPlayer2.intersects(p2HitBox)) {
						continue;
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (player1.dead || player2.dead) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (instance.gameOver) {
					break;
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

