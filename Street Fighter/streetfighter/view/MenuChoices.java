package view;

import java.awt.Image;

import model.Character;

public class MenuChoices {
	
	private Character p1, p2;
	private Image arena;
	static private MenuChoices instance=null;
	
	private MenuChoices() {
		
	}
	
	public  void setPlayers(Character p1, Character p2) {
		this.p1=p1;
		this.p2=p2;
	}
	public  Character getP1() {
		return p1;
	}
	public  Character getP2() {
		return p2;
	}
	public  void setArena(Image arena) {
		this.arena = arena;
	}
	public  Image getArena() {
		return arena;
	}
	
	public void reset() {
		instance=null;
	}
	
	public static MenuChoices getInstance() {
		if(instance==null)
			instance=new MenuChoices();
		return instance;
	}

}
