package view;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Song {

	private AudioInputStream audioIn;
	private Clip clip;
	
	public Song(String name) {
		try {
			InputStream is = getClass().getResourceAsStream(name);
			audioIn = AudioSystem.getAudioInputStream(is);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			clip = null;
			e.printStackTrace();
		}		
	}
	
	public void start() {
		if(clip != null) {
			if(clip.getFramePosition() == clip.getFrameLength())
				clip.setFramePosition(0);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public void stop() {
		if(clip != null) {
			clip.stop();
			clip.setFramePosition(0);
		}
	}
}
