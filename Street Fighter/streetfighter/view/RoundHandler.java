package view;

public class RoundHandler {

	public static final int FIGHTING=0;
	public static final int ROUND_END=1;
	public static final int GAME_OVER=2;
	
	private static int state=FIGHTING;
	
	public static int getState() {
		return state;
	}
	
	public static void setState(int newState) {
		state=newState;
	}
}
