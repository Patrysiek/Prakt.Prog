 package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.IRequestCallback;
import com.mygdx.game.Maingame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg,NoInternetImage;
	private boolean showError = false;
	public SplashScreen(final Maingame game) {
		super(game);
		init();
		

	}


	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		if(!showError) {
		spriteBatch.draw(splashImg, 30, 200);
		}
		else
		{
			spriteBatch.draw(NoInternetImage, 0, 0);
		}
		
		spriteBatch.end();
	}


	@Override
	protected void init() {
		splashImg = new Texture("assets/splash.png");
		NoInternetImage = new Texture("assets/NetError.png");
		game.getFeatureFlagService().makeRequest(new IRequestCallback() {
			
			@Override
			public void onSucceed() {
				Gdx.app.postRunnable(new Runnable() {
					
					@Override
					public void run() {
						showError = false;
						game.setScreen(new GamePlayScreen(game));
					
					}
				});
				
				
			}
			
			@Override
			public void onError() {
				
						showError = true;
			}
		});
		game.getBalanceService().makeRequest(new IRequestCallback() {
			
			@Override
			public void onSucceed() {
				Gdx.app.postRunnable(new Runnable() {
					
					@Override
					public void run() {
						showError = false;
						game.setScreen(new GamePlayScreen(game));
					
					}
				});
				
			}
			
			@Override
			public void onError() {
				showError = true;
				
			}
		});
		
		
		
		
		
		
	}




}
