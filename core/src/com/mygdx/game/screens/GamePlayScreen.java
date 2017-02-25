package com.mygdx.game.screens;

import com.mygdx.game.Maingame;
import com.mygdx.game.entities.Player;

public class GamePlayScreen extends AbstractScreen {

	private Player player;
	public GamePlayScreen(Maingame game) {
		super(game);
		init();
	}



	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		update();
		spriteBatch.begin();
		stage.draw();//narysuj scene z aktorami 
		spriteBatch.end();
	}

	private void update() {
		stage.act();//rob update co klatke dla wszystkich aktorow
		
	}



	@Override
	protected void init() {
		
		initPlayer();
	}

}
