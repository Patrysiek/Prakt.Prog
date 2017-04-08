package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Maingame;
import com.mygdx.game.controllers.FlyStuffController;
import com.mygdx.game.controllers.RandomEventController;
import com.mygdx.game.entities.Player;
import com.mygdx.game.service.PassiveIncomeService;
import com.mygdx.game.ui.IClickCallback;
import com.mygdx.game.ui.PlayerButton;
import com.mygdx.game.ui.ResetScoreButton;
import com.mygdx.game.ui.BasicDialog;
import com.mygdx.game.ui.GameLabel;

public class GamePlayScreen extends AbstractScreen {

	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private GameLabel scoreLabel;
	private Image bgImage;
	private PassiveIncomeService passiveIncomeService;
	private RandomEventController randomEventController;
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
		initPassiceIncomeDialogInformate();
		initRandomEventController();
	}
	private void initRandomEventController() {
		randomEventController = new RandomEventController(game);
		
	}
	private void initPassiceIncomeDialogInformate() {
		if(passiveIncomeService.getPointsToAdd()>0)
		{
			
			
		BasicDialog basicDialog = new BasicDialog(); 	
		stage.addActor(basicDialog);
		basicDialog.initContent("Passive income game gauned: "+passiveIncomeService.getPointsToAdd());
		}
		
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
	
		game.getScoreService().saveCurrentGamestate();
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
		
		scoreLabel = new GameLabel();
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
