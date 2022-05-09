package model;

public class Combat {
	
	public boolean LP = false;
	public boolean HP = false;
	public boolean LK = false;
	public boolean HK = false;
	public boolean BL = false;
	int dmg = 0;

	public synchronized void attack() {
		if (this.LP)
			dmg = 25;
		if (this.HP)
			dmg = 30;
		if (this.LK)
			dmg = 28;
		if (this.HK)
			dmg = 32;
	}

	public void lightPunch() {
		if (!this.inAttack()) {
			this.LP = true;
		}
	}

	public void HardPunch() {
		if (!this.inAttack()) {
			this.HP = true;
		}
	}

	public void lightKick() {
		if (!this.inAttack()) {
			this.LK = true;
		}
	}

	public void hardKick() {
		if (!this.inAttack()) {
			this.HK = true;
		}
	}
	
	public void block() {
		if (!this.inAttack())
			this.BL = true;
	}

	// controllo se il personaggio sta gia' attaccando
	public synchronized boolean inAttack() {
		if (this.LP || this.HP || this.LK || this.HK)
			return true;
		return false;
	}
	
	public synchronized boolean blocking() {
		return BL;
	}
	
	public void endBlock() {
		BL = false;
	}

	public int getDmg() {
		return dmg;
	}
	
	public void endAttack() {
		LP = false;
		HP = false;
		LK = false;
		HK = false;
	}
}
