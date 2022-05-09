package view;

import java.io.File;

public class SongHandler {
	
	 private Song menuTheme;
	 private Song fightTheme;
	 
	 public SongHandler() {
//		menuTheme=new Song(System.getProperty("user.dir")+File.separator+"view"+File.separator+"resources"+File.separator+"themes"+File.separator+"menuTheme.wav");
//		fightTheme=new Song(System.getProperty("user.dir")+File.separator+"view"+File.separator+"resources"+File.separator+"themes"+File.separator+"fightTheme.wav");
		 menuTheme= new Song("/view/resources/themes/menuTheme.wav");
		 fightTheme= new Song("/view/resources/themes/fightTheme.wav");
	}
	 
	public void startMenuTheme() {
		menuTheme.start();
	}
	
	public void changeToFightTheme() {
		menuTheme.stop();
		fightTheme.start();
	}
	
	public void changeToMenuTheme() {
		fightTheme.stop();
		menuTheme.start();
	}

}
