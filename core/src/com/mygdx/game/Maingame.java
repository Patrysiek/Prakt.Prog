package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.mygdx.game.screens.SplashScreen;

public class Maingame extends Game {
	public final static String NAME = "Tutorial Clicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean pause;
	private int points;
	
	@Override
	public void create () {
this.setScreen(new SplashScreen(this));
		
	}
	public void addPoint(){
		points++;
		
}

	

	/**
	 * ------------------------------------------------------------
	 * ------------------------------------------------------------
	 * ------------------GETTERS AND SETTERS-----------------------
	 * ------------------------------------------------------------
	 * ------------------------------------------------------------
	 */
	

	
	public boolean isPause() {
		return pause;
	}
	

	public void setPause(boolean pause) {
		this.pause = pause;
	}








	public int getPoints() {
		return points;
	}








	

	
	
	
}
