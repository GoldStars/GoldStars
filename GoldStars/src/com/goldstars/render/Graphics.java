package com.goldstars.render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Graphics {

	public int[] pixels;

	int width, height;

	public Graphics(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void drawImage(File file, int xOff, int yOff) {
		BufferedImage img;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			System.err.println("Failed to read image file " + file.getName());
			return;
		}
		int imgPixels[] = img.getRGB(0, 0, img.getWidth(), img.getHeight(),
				null, 0, img.getWidth());
		for (int y = 0; y < img.getHeight(); y++) {
			int yOffset = y + yOff;
			if(yOffset > height) break;
			for (int x = 0; x < img.getWidth(); x++) {
				int xOffset = x + xOff;
				if(xOffset > width) break;
				pixels[xOffset + yOffset * width] = imgPixels[x + y
						* img.getWidth()];
			}
		}
	}

}
