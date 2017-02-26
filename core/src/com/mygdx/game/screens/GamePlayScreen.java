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

public class GamePlayScreen extends AbstractScreen {

	private Player player;
	private Button playerButton;
	private Label scoreLabel;
	
	public GamePlayScreen(Maingame game) {
		super(game);
	}



	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
		initScoreLabel();
	}
	private void initScoreLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		scoreLabel = new Label("",labelStyle);	
		scoreLabel.setX(20);
		scoreLabel.setY(650);
		stage.addActor(scoreLabel);
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
		scoreLabel.setText("score :" + game.getPoints());
		stage.act();//rob update co klatke dla wszystkich aktorow
		
	}



	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
	}



	private void initPlayerButton() {
	playerButton = new Button(new ButtonStyle()) ;
		playerButton.setWidth(460); 
		playerButton.setHeight(360); 
		playerButton.setX(10); 
		playerButton.setY(170);
		playerButton.setDebug(true);
		
		
		stage.addActor(playerButton);
		
		playerButton.addListener(new ClickListener(){
		 @Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			 game.addPoint();
			player.reactOnClick();
			
			return super.touchDown(event, x, y, pointer, button);
		}
			
		});
		
		
	}

}
