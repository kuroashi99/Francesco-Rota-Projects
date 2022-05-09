package scegliPanorama;

import java.io.IOException;


import javax.swing.JOptionPane;

public class FabbricaPanorama {
	
	private static FabbricaPanorama inst = null;
	
	public static FabbricaPanorama getInstance()
	{
		if(inst == null)
		{
			inst = new FabbricaPanorama();
		}
		return inst;
	}

	private String nomeClasse;
	
	private FabbricaPanorama(){
		
		nomeClasse = JOptionPane.showInputDialog("Quale panorama desideri visualizzare?\n (Montagne, Spiaggia o Pianura?)");
	
	}

	public Panorama creaPanorama(){
		
		if(nomeClasse.equalsIgnoreCase("Montagne")) {
			try {
				return new Montagne();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		else if(nomeClasse.equalsIgnoreCase("Spiaggia")) {
			try {
				return new Spiaggia();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		else if(nomeClasse.equalsIgnoreCase("Pianura")) {
			try {
				return new Pianura();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		
		return null;
		
	}


}
