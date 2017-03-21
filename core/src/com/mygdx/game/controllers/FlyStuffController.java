package com.mygdx.game.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Maingame;
import com.mygdx.game.entities.FlyObject;
import com.mygdx.game.entities.FlyObject.FlyObjectType;

public class FlyStuffController {

	private int randomSpawnTime;
	
	public FlyStuffController(Maingame game,Stage stage){
		
		
		init(game, stage);
	}

	private void init(final Maingame game,final Stage stage) {
		randomizeSpawnTime();
		
		Timer.schedule(new Task(){
			
			@Override
			public void run(){
				
				
				Timer.schedule(new Task(){
					
					@Override
					public void run(){
						
						addRandomFlyObjectToStage(game,stage);
						randomizeSpawnTime();
						
					}
					
				}, randomSpawnTime);
			}
			
		}, 5,5);
	}

	private void randomizeSpawnTime() {
		randomSpawnTime = MathUtils.random(1,10);
		
	}

	private void addRandomFlyObjectToStage(Maingame game, Stage stage){
		FlyObject flyObject = null;
		
		if(MathUtils.randomBoolean()){
			
			flyObject = new FlyObject(FlyObjectType.MONEY, game);
			
		}
		else
		{
			flyObject = new FlyObject(FlyObjectType.PASSIVE, game);
			
		}
		
		
		stage.addActor(flyObject);
		flyObject.fly();
		
		
		
	}
}
