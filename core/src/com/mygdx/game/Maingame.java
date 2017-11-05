package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.mygdx.game.screens.SplashScreen;
import com.mygdx.game.service.BalanceService;
import com.mygdx.game.service.FeatureFlagService;
import com.mygdx.game.service.ScoreService;
import com.mygdx.game.service.ShopService;
import com.mygdx.game.service.SoundService;

public class Maingame extends Game {
	
	public final static String NAME = "Tutorial Clicker";
	
	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;
	
	private SoundService soundService;
	private ScoreService scoreService;
	private FeatureFlagService featureFlagService;
	private ShopService shopService;
	private BalanceService balanceService;
	private boolean pause;
	
	@Override
	
	
	
	
	
	
	
	

	public void create () {
		init();
this.setScreen(new SplashScreen(this));
		
	}
	
	
	
	
	
	
	
	
	
	private void init() {
	
	initSoundService();
	initScoreService();
	initFeatureFlagService();
	initShopShervice();
	initBalanceShervice();
		
	}
	









	private void initBalanceShervice() {
		balanceService = new BalanceService();
		
	}









	private void initShopShervice() {
		shopService = new ShopService();
		
	}









	private void initFeatureFlagService() {
		
		
		featureFlagService = new FeatureFlagService();
		
	}
	private void initScoreService() {
		scoreService = new ScoreService();
			
		}
	
	private void initSoundService() {
	soundService = new SoundService();
		
	}

	/**
	 * ------------------------------------------------------------
	 * ------------------------------------------------------------
	 * ------------------GETTERS AND SETTERS-----------------------
	 * ------------------------------------------------------------
	 * ------------------------------------------------------------
	 */
	

	
	public boolean isPause() {
		return pause;
	}
	

	public void setPause(boolean pause) {
		this.pause = pause;
	}


	public SoundService getSoundService() {
		return soundService;
	}



	public ScoreService getScoreService() {
		return scoreService;
	}









	public FeatureFlagService getFeatureFlagService() {
		return featureFlagService;
	}









	public ShopService getShopService() {
		return shopService;
	}









	public BalanceService getBalanceService() {
		return balanceService;
	}





	
	
}
