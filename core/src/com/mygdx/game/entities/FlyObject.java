package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Maingame;

public class FlyObject extends Image{
	
	public enum FlyObjectType{
		MONEY, PASSIVE
		
	}
	
	public final static String MONEY = "assets/money.png";
	public final static String BAG = "assets/passive.png";
	private final static int WIDTH = 50;
	private final static int HEIGHT= 50;
	
	private final static int STARTING_X_1 = 0;
	private final static int STARTING_X_2 = Maingame.WIDTH;
	private final static int STARTING_Y = -100;
	
	
	
	private FlyObjectType type;
	private Maingame game;
	
	private int startingX;
	
	public FlyObject(FlyObjectType type, Maingame game){
		super(new Texture(getTextureString(type)));

this.type = type;
this.game = game;


		this.setOrigin(WIDTH/2, HEIGHT/2);
		this.setSize(WIDTH, HEIGHT);
		
		
		moneySpawnplay();
		
		
		//starting position
		startingX = MathUtils.randomBoolean() ? STARTING_X_1 : STARTING_X_2;
		this.setPosition(startingX, STARTING_Y);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, 
					int pointer, int button) {
			
				reactOnClick();
				return super.touchDown(event, x, y, pointer, button);
			}

		
			
			
		});
	}
	
	private void moneySpawnplay() {
	if(FlyObjectType.MONEY.equals(type)){
		game.getSoundService().moneySoundplay();
	}
	else{
		game.getSoundService().money2Soundplay();
	}
	
		
	}
	private void reactOnClick() {
	
		
		
		if(FlyObjectType.MONEY.equals(type)){
			game.getScoreService().addPoints(50);
		}
		else if(FlyObjectType.PASSIVE.equals(type)){
			game. getScoreService().addPassiveIncome();
		}
		game.getSoundService().flyObjectSoundplay();
		FlyObject.this.remove();
	}
	
	private static String getTextureString(FlyObjectType type) {
		
		if(FlyObjectType.MONEY.equals(type)){
			
			return MONEY;
		}
		else if(FlyObjectType.PASSIVE.equals(type)){
			
			return BAG;
		}
		
		
		return "";
	}
	public void fly(){
		
		int xSign = 0;
		
		
		if(startingX == STARTING_X_1)
		{
			
			xSign = 1;
			
		}
		else
{
			
			xSign = -1;
			
		}
			
		
		
		
		
		Action a = Actions.parallel(
				Actions.moveBy(xSign *(MathUtils.random(0,300)+300), MathUtils.random(100,200)+200, MathUtils.random(1,5)),
				Actions.rotateBy(360,5)
				);
		Action b = Actions.parallel(
				Actions.moveBy(xSign * -500, 900, 3),
				Actions.rotateBy(360,3)
				);
				Action c = Actions.run(new Runnable(){
					
					public void run(){
						FlyObject.this.remove();
						
					}	
				});
		
		this.addAction(Actions.sequence(a,b,c));
	}
	
	
}
