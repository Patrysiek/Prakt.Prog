package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Maingame;
import com.mygdx.game.controllers.FlyStuffController;
import com.mygdx.game.entities.Player;
import com.mygdx.game.service.PassiveIncomeService;
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
	private PassiveIncomeService passiveIncomeService;
	
	private FlyStuffController flyStuffControler;
	public GamePlayScreen(Maingame game) {
		super(game);
	}
	@Override
	protected void init() {
		
		initBg();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initFlyStuffController();
		startPlayMusic();
		initPassiveIncomeService();
	}
	@Override
	public void render(float delta) {
		super.render(delta);
		update();

		spriteBatch.begin();
		
		stage.draw();//narysuj scene z aktorami 
		spriteBatch.end();
	}
	@Override
	public void pause() {
		super.pause();
		game.getScoreService().saveCurrentTimestamp();
	}

	private void update() {
		scoreLabel.setText("score :" + game. getScoreService().getPoints());
		stage.act();//rob update co klatke dla wszystkich aktorow

	}

	
	

private void initPassiveIncomeService() {
		passiveIncomeService = new PassiveIncomeService(game.getScoreService());
		passiveIncomeService.start();
		
	}
private void startPlayMusic() {
		game.getSoundService().startPlayMusic(true);
		
	}
private void initFlyStuffController() {
	
	
	flyStuffControler = new FlyStuffController(game, stage);
		
	}

	private void initBg() {
		bgImage = new Image(new Texture("assets/meadow.png"));
		stage.addActor(bgImage);
		
	}
	private void initResetScoreButton() {
		resetScoreButton = new ResetScoreButton(new IClickCallback(){
			
			public void onClick(){
				game.getScoreService().resetGameScore();
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
			game. getScoreService().addPoint();
			game.getSoundService().jumpSoundplay();
			
	}
	
});
		stage.addActor(playerButton);
	}
	
	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
		initScoreLabel();
	}

	
	
	




}
