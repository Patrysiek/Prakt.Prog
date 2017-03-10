package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Maingame;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.IClickCallback;
import com.mygdx.game.ui.PlayerButton;

public class GamePlayScreen extends AbstractScreen {

	private Player player;
	private PlayerButton playerButton;
	private Button resetScoreButton;
	private Label scoreLabel;

	public GamePlayScreen(Maingame game) {
		super(game);
	}
	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
	}


	private void initResetScoreButton() {
		resetScoreButton = new Button(new ButtonStyle());
		resetScoreButton.setWidth(100);
		resetScoreButton.setHeight(100);
		resetScoreButton.setX(350);
		resetScoreButton.setY(550);
		resetScoreButton.setDebug(true);
		resetScoreButton.setName("reset");
		stage.addActor(resetScoreButton);
		resetScoreButton.addListener(new ClickListener(){

				@Override
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
						game.resetGameScore();

						return super.touchDown(event, x, y, pointer, button);
				}
		});
	}
	

	
	
	private void initScoreLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		scoreLabel = new Label("",labelStyle);	
		scoreLabel.setX(20);
		scoreLabel.setY(650);
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
		stage.draw();//narysuj scene z aktorami 
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("score :" + game.getPoints());
		stage.act();//rob update co klatke dla wszystkich aktorow

	}




}
