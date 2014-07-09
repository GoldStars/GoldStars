package com.goldstars;

import java.awt.Canvas;
import java.awt.DisplayMode;

import com.goldstars.render.ScreenManager;

public class GoldStars extends Canvas {

	private static final long serialVersionUID = 1L;

	public ScreenManager s;

	private static final DisplayMode modes[] = {
			new DisplayMode(800, 600, 32, 0), new DisplayMode(800, 600, 24, 0),
			new DisplayMode(800, 600, 16, 0),

			new DisplayMode(640, 480, 32, 0), new DisplayMode(640, 480, 24, 0),
			new DisplayMode(640, 480, 16, 0), };

	public GoldStars() {
		s = new ScreenManager();
		DisplayMode displayMode = s.findFirstCompatibleMode(modes);
		s.setFullScreen(displayMode);
	}

}
