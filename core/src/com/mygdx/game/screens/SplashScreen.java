 package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.IRequestCallback;
import com.mygdx.game.Maingame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;
	
	public SplashScreen(final Maingame game) {
		super(game);
		init();
		

	}


	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 30, 200);
		
		
		spriteBatch.end();
	}


	@Override
	protected void init() {
		splashImg = new Texture("assets/splash.png");
		
		game.getFeatureFlagService().makeRequest(new IRequestCallback() {
			
			@Override
			public void onSucceed() {
				Gdx.app.postRunnable(new Runnable() {
					
					@Override
					public void run() {
						game.setScreen(new GamePlayScreen(game));
					
					}
				});
				
				
			}
			
			@Override
			public void onError() {
				// TODO make some error messages
				
			}
		});
		
	}




}
