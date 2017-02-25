 package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.Maingame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;
	
	public SplashScreen(final Maingame game) {
		super(game);
		init();
		
	Timer.schedule(new Task(){
		
			@Override
			public void run(){
			game.setScreen(new GamePlayScreen(game));
			
			}
		
		
		},1);
	}


	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		
		
		spriteBatch.end();
	}


	@Override
	protected void init() {
		splashImg = new Texture("assets/badlogic.jpg");
		
	}




}
