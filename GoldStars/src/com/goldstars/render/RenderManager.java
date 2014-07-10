package com.goldstars.render;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;

import com.goldstars.GoldStars;

public class RenderManager {

	GoldStars os;

	Graphics g;
	
	BufferedImage img;
	int pixels[];

	public RenderManager(GoldStars os) {
		this.os = os;
		img = new BufferedImage(os.s.getWidth(), os.s.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		g = new Graphics(os.s.getWidth(), os.s.getHeight());
	}

	public void draw() {
		BufferStrategy bs = os.getBufferStrategy();
		if (bs == null) {
			os.createBufferStrategy(3);
			return;
		}
		clear();
		render();
		for (int i = 0; i < g.pixels.length; i++) {
			pixels[i] = g.pixels[i];
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.drawImage(img, 0, 0, os.s.getWidth(), os.s.getHeight(), null);
		g.dispose();
		bs.show();
	}

	public void render() {
		g.drawImage(new File("PechiPremium.gif"), 20, 40);
	}
	
	public void clear() {
		// Refresh
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	
}
