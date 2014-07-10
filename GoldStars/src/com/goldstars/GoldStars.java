package com.goldstars;

import java.awt.Canvas;
import java.awt.DisplayMode;

import com.goldstars.render.RenderManager;
import com.goldstars.render.ScreenManager;

public class GoldStars extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public ScreenManager s;
	public RenderManager rm;

	private static final DisplayMode modes[] = {

	new DisplayMode(1600, 900, 32, 0), new DisplayMode(1600, 900, 24, 0),
			new DisplayMode(1600, 900, 16, 0),
			new DisplayMode(1280, 720, 32, 0),
			new DisplayMode(1280, 720, 24, 0),
			new DisplayMode(1280, 720, 16, 0),
			new DisplayMode(800, 600, 32, 0), new DisplayMode(800, 600, 24, 0),
			new DisplayMode(800, 600, 16, 0),

			new DisplayMode(640, 480, 32, 0), new DisplayMode(640, 480, 24, 0),
			new DisplayMode(640, 480, 16, 0), };

	Thread t;
	boolean running = false;

	public GoldStars() {
		s = new ScreenManager();
		DisplayMode displayMode = s.findFirstCompatibleMode(modes);
		s.setFullScreen(displayMode);
		s.getFullScreenWindow().add(this);

		rm = new RenderManager(this);
	}

	// Main loop
	public void run() {
		while (running) {
			rm.draw();
		}
		// Shut down
	}

	public void start() {
		running = true;
		t = new Thread(this);
		t.start();
	}

	public void stop() {
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GoldStars().start();
	}

}
