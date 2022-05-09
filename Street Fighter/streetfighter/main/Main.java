package main;




import view.PanelHandler;


public class Main {

	public static void main(String[] args) {
		
		
		try {
		PanelHandler.getIstance();
		System.out.println("avvio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
