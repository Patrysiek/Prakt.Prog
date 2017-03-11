package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class FlyObject extends Image{
	public final static String MONEY = "assets/money.png";
	
	private final static int WIDTH = 50;
	private final static int HEIGHT= 50;
	
	private final static int STARTING_X = 0;
	private final static int STARTING_Y = -100;
	
	public FlyObject(String texture){
		super(new Texture(texture));

		this.setOrigin(WIDTH/2, HEIGHT/2);
		this.setSize(WIDTH, HEIGHT);
		
		//starting position
		this.setPosition(STARTING_X, STARTING_Y);
		
		this.addListener(new ClickListener(){
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y, 
					int pointer, int button) {
			
				
				FlyObject.this.remove();
				
				return super.touchDown(event, x, y, pointer, button);
			}
			
			
		});
	}
	public void fly(){
		Action a = Actions.parallel(
				Actions.moveBy(300, 200, 5),
				Actions.rotateBy(360,5)
				);
		Action b = Actions.parallel(
				Actions.moveBy(-500, 900, 3),
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
