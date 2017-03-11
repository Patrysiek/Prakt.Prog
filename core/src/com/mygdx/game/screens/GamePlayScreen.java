package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Maingame;
import com.mygdx.game.entities.FlyObject;
import com.mygdx.game.entities.FlyObject.FlyObjectType;
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
	private Image bgImage;
	private FlyObject flyObject1;
	public GamePlayScreen(Maingame game) {
		super(game);
	}
	@Override
	protected void init() {
		
		initBg();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initFlyObjects();
	}


	private void initFlyObjects() {
		flyObject1 = new FlyObject(FlyObjectType.PASSIVE, game);
		stage.addActor(flyObject1);
		flyObject1.fly();
	}
	private void initBg() {
		bgImage = new Image(new Texture("assets/meadow.png"));
		stage.addActor(bgImage);
		
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
		
		stage.draw();//narysuj scene z aktorami 
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("score :" + game.getPoints());
		stage.act();//rob update co klatke dla wszystkich aktorow

	}




}
