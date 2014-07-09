package com.goldstars.render;

public class Renderer {

	public int[] pixels;
	
	int width, height;
	
	public Renderer(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
}
