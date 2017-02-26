package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Maingame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication( new Maingame(), config);
		config.title = Maingame.NAME;
		config.height = Maingame.HEIGHT;
		config.width = Maingame.WIDTH;
		config.resizable = false;
	}
}
