package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.mygdx.game.screens.SplashScreen;

public class Maingame extends Game {
	public final static String GAME_PREFS = "com.mygdx.game.prefs";
	public final static String GAME_SCORE = "com.mygdx.game.prefs.score";
	public final static String NAME = "Tutorial Clicker";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean pause;
	private int points;
	private Preferences prefs;
	@Override
	public void create () {
		init();
this.setScreen(new SplashScreen(this));
		
	}
	private void init() {
	prefs  = Gdx.app.getPreferences(GAME_PREFS);
	loadScore();
		
	}
	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
		
	}
	public void addPoints(int pointsToAdd){
		points+=pointsToAdd;
		UpdateSavedScore();
}
	public void addPoint(){
		points++;
		UpdateSavedScore();
}
	private void UpdateSavedScore() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}
	public void resetGameScore() {
		points = 0;
		UpdateSavedScore();
	}
	public void addPassiveIncome() {
		// TODO implement
		System.out.println("passie income");
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
