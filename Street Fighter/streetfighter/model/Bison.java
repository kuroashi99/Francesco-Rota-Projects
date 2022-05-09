package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.PanelHandler;

public class Bison extends Character {
	
	public Bison() {
		this.name="bison";
		this.hp = TOTAL_HP;
		this.dead = false;
		this.width = 65*4;
		this.height = 83*4;
		this.x = 30;
		this.y=PanelHandler.HEIGHT-this.height-40;
		this.idleDx = new Image[3];
		this.idleSx = new Image[3];
		this.punchDx = new Image[2];
		this.punchSx = new Image[2];
		this.heavyPunchDx=new Image[3];
		this.heavyPunchSx=new Image[3];
		this.heavyKickSx=new Image[4];
		this.heavyKickDx=new Image[4];
		this.walkDx = new Image[4];
		this.walkSx = new Image[4];
		this.kickDx = new Image[4];
		this.kickSx = new Image[4];
		this.jumpDx = new Image[5];
		this.jumpSx = new Image[5];
		this.deadDx = new Image[3];
		this.deadSx = new Image[3];
		this.getHitDx = new Image[3];
		this.getHitSx = new Image[3];
		this.victory = new Image[3];
		this.loadImages();
		this.combat = new Combat();
		this.movement = new Movement(this);
	}

	@Override
	protected void loadImages() {
		for (int i = 0; i < this.idleDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/idleDx/" + i + ".png"));
				img = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
				this.idleDx[i] = img;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.idleSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/idleSx/" + i + ".png"));
				img = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
				this.idleSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.punchDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/punchDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4, Image.SCALE_SMOOTH);
				this.punchDx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.punchSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/punchSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4, Image.SCALE_SMOOTH);
				this.punchSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.walkDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/walkDx/" + i + ".png"));
				img = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
				this.walkDx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.walkSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/walkSx/" + i + ".png"));
				img = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
				this.walkSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.kickDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/kickDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4-40, Image.SCALE_SMOOTH);
				this.kickDx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.kickSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/kickSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4-40, Image.SCALE_SMOOTH);
				this.kickSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		////
		for (int i = 0; i < this.heavyPunchDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/heavyPunchDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4+25, Image.SCALE_SMOOTH);
				this.heavyPunchDx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < this.heavyPunchSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/heavyPunchSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4+25, Image.SCALE_SMOOTH);
				this.heavyPunchSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < this.heavyKickSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/heavyKickSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4-40, Image.SCALE_SMOOTH);
				this.heavyKickSx[this.heavyKickSx.length-i-1] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < this.heavyKickDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/heavyKickDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4-40, Image.SCALE_SMOOTH);
				this.heavyKickDx[this.heavyKickSx.length-i-1] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		////
		for (int i = 0; i < this.jumpDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/jumpDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4+20, img.getHeight(null)*4-20, Image.SCALE_SMOOTH);
				this.jumpDx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.jumpSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/jumpSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4+20, img.getHeight(null)*4-20, Image.SCALE_SMOOTH);
				this.jumpSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.deadDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/deadDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4-40, Image.SCALE_SMOOTH);
				this.deadDx[i] = img;
				if(i==this.deadDx.length-1) {
					Image tmp= this.deadDx[deadDx.length-1];
					this.deadDx[deadDx.length-1]=tmp.getScaledInstance(tmp.getWidth(null)+30, tmp.getHeight(null)+30, Image.SCALE_SMOOTH);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.deadSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/deadSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4-40, Image.SCALE_SMOOTH);
				this.deadSx[i] = img;
				if(i==this.deadSx.length-1) {
					Image tmp= this.deadSx[deadSx.length-1];
					this.deadSx[deadSx.length-1]=tmp.getScaledInstance(tmp.getWidth(null)+30, tmp.getHeight(null)+30, Image.SCALE_SMOOTH);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.getHitDx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/getHitDx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4+10, img.getHeight(null)*4-20, Image.SCALE_SMOOTH);
				this.getHitDx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < this.getHitSx.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/getHitSx/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4+10, img.getHeight(null)*4-20, Image.SCALE_SMOOTH);
				this.getHitSx[i] = img;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/blockDx/" + 0 + ".png"));
			img = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
			this.blockDx = img;
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/blockSx/" + 0 + ".png"));
			img = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
			this.blockSx = img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < this.victory.length; i++) {
			try {
				Image img = ImageIO.read(getClass().getResourceAsStream("/resources/Bison/victory/" + i + ".png"));
				img = img.getScaledInstance(img.getWidth(null)*4, img.getHeight(null)*4, Image.SCALE_SMOOTH);
				this.victory[i] = img;
				if(i==this.victory.length-1) {
					Image tmp= this.victory[victory.length-1];
					this.victory[victory.length-1]=tmp.getScaledInstance(tmp.getWidth(null), tmp.getHeight(null)-40, Image.SCALE_SMOOTH);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("/view/resources/names/" + this.name + ".png"));
			this.nameText = img;
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/portraits/" + this.name + ".png"));
			this.portrait=img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Image img = ImageIO.read(getClass().getResourceAsStream("/view/resources/mugshots/dx/" + this.name + ".png"));
			this.mugshotDx = img;
			img = ImageIO.read(getClass().getResourceAsStream("/view/resources/mugshots/sx/" + this.name + ".png"));
			this.mugshotSx=img;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	protected void setDefault() {
		//
		if(view!=null)
			view.stop();
		//
		this.hp = TOTAL_HP;
		this.dead = false;
		this.y=PanelHandler.HEIGHT-this.height-35;
		
		combat.endAttack();
	}
}
