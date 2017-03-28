package com.mygdx.game.service;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
public class SoundService{
	private Sound moneySound;
	private Music muzyka ;
	private Sound jump;
	private Sound money2;
	private Sound fly;
	
	
	
	
		public SoundService(){
init();


		}
	
		private void init() {
			moneySound = Gdx.audio.newSound(Gdx.files.internal("assets/money.mp3"));
			muzyka = Gdx.audio.newMusic(Gdx.files.internal("assets/music.mp3"));
			jump = Gdx.audio.newSound(Gdx.files.internal("assets/jump.mp3"));
			money2 = Gdx.audio.newSound(Gdx.files.internal("assets/money2.mp3"));
			fly = Gdx.audio.newSound(Gdx.files.internal("assets/fly.mp3"));
		}

		public void moneySoundplay(){
		moneySound.play();
		}
		public void jumpSoundplay(){
			jump.play();
			}
		public void money2Soundplay(){
			money2.play();
			}
		public void flyObjectSoundplay(){
			fly.play();
			}
	
		
		public void startPlayMusic(boolean looped){
			muzyka.setVolume(0.5f);
			muzyka.play();
			muzyka.setLooping(looped);
		}
	
}

