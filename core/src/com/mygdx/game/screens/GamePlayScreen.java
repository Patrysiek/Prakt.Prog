package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Maingame;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.IClickCallback;
import com.mygdx.game.ui.PlayerButton;
import com.mygdx.game.ui.ResetScoreButton;
import com.mygdx.game.ui.ScoreLabel;

public class GamePlayScreen extends AbstractScreen {

	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;
	private Texture bgTexture;
	public GamePlayScreen(Maingame game) {
		super(game);
	}
	@Override
	protected void init() {
		bgTexture = new Texture("assets/meadow.png");
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
	}


	private void initResetScoreButton() {
		resetScoreButton = new ResetScoreButton(new IClickCallback(){
			
			public void onClick(){
				game.resetGameScore();
			}
			
			
		});
		stage.addActor(resetScoreButton);
		
		
	}
	

	
	
	private void initScoreLabel() {
		
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}
	
	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback(){
	
			@Override
			public void onClick(){
			player.reactOnClick();
			game.addPoint();
			
	}
	
});
		stage.addActor(playerButton);
	}
	
	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
		initScoreLabel();
	}

	
	
	@Override
	public void render(float delta) {
		super.render(delta);
		update();

		spriteBatch.begin();
		spriteBatch.draw(bgTexture, 0, 0,  Maingame.WIDTH, Maingame.HEIGHT);
		spriteBatch.end();
		spriteBatch.begin();
		stage.draw();//narysuj scene z aktorami 
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("score :" + game.getPoints());
		stage.act();//rob update co klatke dla wszystkich aktorow

	}




}
