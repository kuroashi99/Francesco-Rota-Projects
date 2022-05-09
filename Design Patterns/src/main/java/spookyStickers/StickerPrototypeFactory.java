package spookyStickers;

import java.io.IOException;
import java.util.Arrays;

public class StickerPrototypeFactory {
	
	public static final int NUM_STICKERS = 4;
	private final static int GHOST = 0;
	private final static int PUMPKIN = 1;
	private final static int WITCH = 2;
	private final static int SKELLY = 3;
	

	
	
	private StickerGhost ghostPrototype;
	private StickerPumpkin pumpkinPrototype;
	private StickerWitch witchPrototype;
	private StickerSkeleton skellyPrototype;
	
	public StickerPrototypeFactory(StickerGhost g, StickerPumpkin pk, StickerWitch w, StickerSkeleton s ) {
		this.ghostPrototype = g;
		this.pumpkinPrototype = pk;
		this.skellyPrototype = s;
		this.witchPrototype = w;
		
	}
	
	public Sticker[] makeStickers() throws IOException {
		Sticker[] tmp = new Sticker[NUM_STICKERS];
		for(int i = 0; i < NUM_STICKERS; i++ ) {
			switch(i) {
				case GHOST:
					tmp[i] = makeGhost();
					break;
				
				case PUMPKIN:
					tmp[i] = makePumpkin();
					break;
				
				
				case SKELLY:
					tmp[i] = makeSkelly();
					break;
				
				case WITCH:
					tmp[i] = makeWitch();
					break;

			}
		}
		return tmp;
	}
	
	public StickerGhost makeGhost() throws IOException {
		return (StickerGhost) ghostPrototype.clona();
	}
	

	public StickerPumpkin makePumpkin() throws IOException {
		return (StickerPumpkin) pumpkinPrototype.clona();
	}
	
	public StickerWitch makeWitch() throws IOException {
		return (StickerWitch) witchPrototype.clona();
	}
	
	public StickerSkeleton makeSkelly() throws IOException {
		return (StickerSkeleton) skellyPrototype.clona();
	}
		

}


