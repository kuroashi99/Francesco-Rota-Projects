package scegliPanorama;

import java.awt.Image;
import java.io.IOException;

//IMPLEMENTATION CLASS
public abstract class Panorama {
	
	Image panorama;
	
	public Panorama() throws IOException {
		getResources();
	}
	
	public Image getPanorama() {
		return this.panorama;
	}
	
	public abstract void  getResources() throws IOException;
	
	
	
	
	
	
}
