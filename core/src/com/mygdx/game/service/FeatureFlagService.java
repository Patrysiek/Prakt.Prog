package com.mygdx.game.service;

public class FeatureFlagService {

	
	public static final String REQUEST_URL = "http://patrysiek.pythonanywhere.com/tutorialClicker/api/v1.0/features";
	public static final String FEATURE_SHOP = "FEATURE_SHOP";
	
	
	private boolean shop = false;

	public void makeRequest() {
		
		//TODO
		
	}
	
	
	
	

	public boolean hasShop() {
		return shop;
	}


	public void setShop(boolean shop) {
		this.shop = shop;
	}
	
	
}
