package com.goldstars.render;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import com.goldstars.GoldStars;

public class RenderManager {

	GoldStars os;

	BufferedImage img;
	int pixels[];

	public RenderManager(GoldStars os) {
		this.os = os;
		img = new BufferedImage(os.s.getWidth(), os.s.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}

	public void draw() {
		BufferStrategy bs = os.getBufferStrategy();
		if (bs == null) {
			os.createBufferStrategy(2);
			return;
		}

		clear();
		render();
		
	}

	public void render() {
		
	}
	
	public void clear() {
		// Refresh
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	
}
