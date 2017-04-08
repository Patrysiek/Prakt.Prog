package com.mygdx.game.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Maingame;

public class RandomEventController {
	private Maingame game;
	
	private static final int RANDOM_TICK_INTERVAL = 5;
	
	public RandomEventController(Maingame game){
	
		this.game = game;
		init();
		
		
	}
	
	
	
	private void init(){
		
		Timer.schedule(new Task(){

			@Override
			public void run() {
				if(MathUtils.randomBoolean()){
					triggerRandomEvent();
				}
				
			}

			
			
			
			
		},RANDOM_TICK_INTERVAL,RANDOM_TICK_INTERVAL);
		
	}
	
	private void triggerRandomEvent() {
		int randomNumber = MathUtils.random(1,3);
		switch(randomNumber){
		case 1:
			gainmoneyEvent();
			break;
			
			
			case 2:
			loseMoneyEvent();
			break;
			case 2:
				gainPassiveIncome();
				break;
			default:
				break;
		}
		
		
	}



	private void gainPassiveIncome() {
		game.getScoreService().addPassiveIncome();
		
	}



	private void loseMoneyEvent() {
		game.getScoreService().addPoints(-123);	
		
	}



	private void gainmoneyEvent() {
		game.getScoreService().addPoints(123);
		
	}

}
