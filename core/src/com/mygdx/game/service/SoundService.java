package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
public class SoundService{
	private Sound moneySound;
	
	
	
		public SoundService(){
init();


		}
	
		private void init() {
			moneySound = Gdx.audio.newSound(Gdx.files.internal("assets/money.mp3"));
			
		}

		public void moneySoundplay(){
		moneySound.play();
		
		
		}
	
}

