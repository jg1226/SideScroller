package com.window;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {// loads images

	private BufferedImage image;
	
	public BufferedImage loadImage(String path) {
		
		try {		
			image = ImageIO.read(getClass().getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
}// end of class
