package com.mygdx.game.service;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.TimeUtils;

public class ScoreService {

	public final static String GAME_PREFS = "com.mygdx.game.prefs";
	public final static String GAME_SCORE = "com.mygdx.game.prefs.score";
	public final static String GAME_PASSIVE_INCOME = "com.mygdx.game.prefs.passive_income";
	public final static String GAME_SAVED_TIMESTAMP = "com.mygdx.game.prefs.timestamp";
	private Preferences prefs;
	
	private int points;
	private int passiveIncome;

	
	public  ScoreService(){
		init();
		
		
	}
	
	
	
	
	
	
	
	private void init() {
		
		prefs  = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();
		loadPassiveIncome();
	
	}

	







	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);
		
	}
	
	private void loadPassiveIncome() {
		passiveIncome = prefs.getInteger( GAME_PASSIVE_INCOME);
		
	}
	
	
	
	public void addPoints(int pointsToAdd){
		points+=pointsToAdd;
	
}
	public void addPoint(){
		points++;
		
}

	public void resetGameScore() {
		points = 0;
		passiveIncome = 0;
		saveCurrentGamestate();
	}
	public void addPassiveIncome() {
		passiveIncome++;
		
	}
	public void saveCurrentTimestamp() {
		prefs.putLong(GAME_SAVED_TIMESTAMP, TimeUtils.millis());
		prefs.flush();
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









public long saveCurrentGamestate() {
	prefs.putInteger(GAME_SCORE, points);
	prefs.putInteger(GAME_PASSIVE_INCOME, passiveIncome);
	prefs.flush();
	return prefs.getLong(GAME_SAVED_TIMESTAMP);
}




	

}
