package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class ScoreService {

	public final static String GAME_PREFS = "com.mygdx.game.prefs";
	public final static String GAME_SCORE = "com.mygdx.game.prefs.score";
	public final static String GAME_PASSIVE_INCOME = "com.mygdx.game.prefs.passive_income";
	
	private Preferences prefs;
	
	private int points;
	private int passiveIncome;

	
	
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
	
	private void loadPassiveIncome() {
		passiveIncome = prefs.getInteger( GAME_PASSIVE_INCOME);
		
	}
	
	
	public void addPoints(int pointsToAdd){
		points+=pointsToAdd;
		updateSavedScoreAndPoints();
}
	public void addPoint(){
		points++;
		updateSavedScoreAndPoints();
}
	private void updateSavedScoreAndPoints() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
		prefs.flush();
	}
	public void resetGameScore() {
		points = 0;
		passiveIncome = 0;
		updateSavedScoreAndPoints();
	}
	public void addPassiveIncome() {
		passiveIncome++;
		updateSavedScoreAndPoints();
	}
	
	
	/////////////////////////////////////////////////////////
	//////////////////// getters && setters ////////////////
	///////////////////////////////////////////////////////
	
	public int getPoints() {
		return points;
	}




	public int getPassiveIncome() {
		return passiveIncome;
	}



	public void setPassiveIncome(int passiveIncome) {
		this.passiveIncome = passiveIncome;
	}

}
