package com.mygdx.game.service;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class PassiveIncomeService {
	private ScoreService scoreService;
	private final static int INFINITE = 100000000;

public PassiveIncomeService(ScoreService scoreService)	{
		this.scoreService = scoreService;
		calculateGainedPassiveIncome();
	}
	public void start(){
		
		Timer.schedule(new Task(){
			
			@Override
			public void run(){
				scoreService.addPoints(scoreService.getPassiveIncome());
				
				
			}
			
			
		}, 1,1,INFINITE);
		
	}
	void calculateGainedPassiveIncome() {
		long savedTimeStamp = scoreService.saveCurrentGamestate();
		if(savedTimeStamp>0){
			
			long millisPassed = TimeUtils.timeSinceMillis(savedTimeStamp);
			long seconds = TimeUnit.MILLISECONDS.toSeconds(millisPassed);
			addPointsBasingOnPassedTime(seconds);
			
		}
		else
		{
			//do nothing
		}
		
	}
	private void addPointsBasingOnPassedTime(long seconds){
		if(seconds>0){
			int points = (int)(seconds * scoreService.getPassiveIncome());
			points /= 5;
			scoreService.addPoints(points);
			
		}
		
		
	}
	
}
