package com.mygdx.game.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Maingame;
import com.mygdx.game.ui.BasicDialog;

public class RandomEventController {
	private Maingame game;
	private Stage stage;
	private static final int RANDOM_TICK_INTERVAL = 5;
	
	public RandomEventController(Maingame game, Stage stage){
	
		this.game = game;
		this.stage = stage;
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
			case 3:
				gainPassiveIncome();
				
				break;
			default:
				break;
		}
		
		
	}
	private void triggerDialog(String text){
		
		BasicDialog basicDialog = new BasicDialog(); 
		basicDialog.showDialog(stage,text);
	}



	private void gainPassiveIncome() {
		game.getScoreService().addPassiveIncome();
		triggerDialog("Yaaay! You gained passive Income");
		
	}



	private void loseMoneyEvent() {
		game.getScoreService().addPoints(-123);	
		triggerDialog("ooh crap ;c You lose -123 points");
		
	}



	private void gainmoneyEvent() {
		game.getScoreService().addPoints(123);
		triggerDialog("Yaaay! You gained 123 points");
		
	}

}
