package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.SplashScreen;

public class Maingame extends Game {
	public final static String NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean pause;
	
	
	@Override
	public void create () {
this.setScreen(new SplashScreen(this));
		
	}


	

	
	

	
	public boolean isPause() {
		return pause;
	}
	

	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	

	
	
	
}
