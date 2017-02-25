package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Maingame;

public class SplashScreen extends AbstractScreen{

	private Texture splashImg;
	
	public SplashScreen(Maingame game) {
		super(game);
		init();
	}

	private void init() {
		//TODO implement better assets loading when game grows
		splashImg = new Texture("assets/badlogic.jpg");
		
	}
	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		
		
		spriteBatch.end();
	}




}
