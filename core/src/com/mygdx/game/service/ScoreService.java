package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

	public final static String GAME_PREFS = "com.mygdx.game.prefs";
	public final static String GAME_SCORE = "com.mygdx.game.prefs.score";
	
	
	private int points;
	private Preferences prefs;
	
	
	public  ScoreService(){
		init();
		
		
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
	
	
	
	
	public int getPoints() {
		return points;
	}

}
