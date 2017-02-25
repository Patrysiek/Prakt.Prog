package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Maingame;

public abstract class AbstractScreen implements Screen{

	protected Maingame game;
	protected Stage stage;
	private OrthographicCamera camera;
	
	protected SpriteBatch spriteBatch;
	
	public AbstractScreen(Maingame game ){
		this.game = game;
		createCamera();
		stage = new Stage(new StretchViewport(Maingame.WIDTH, Maingame.HEIGHT));
		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
		init();
	}

	
		
		
	

	 protected abstract void init();






	void createCamera() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Maingame.WIDTH, Maingame.HEIGHT);
		camera.update();
	}
	
	public void render(float delta){
		clearScreen();
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		
	}
	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	}
	@Override
	public void show() {
	
	}
	
	@Override
	public void resume() {
	game.setPause(false);	
	}
	@Override
	public void pause() {
		game.setPause(true);	
	}
	@Override
	public void hide() {
		
		
	}
	
	@Override
	public void dispose() {
		game.dispose();
	}
	
	
	@Override
	public void resize(int width, int height) {
		
	}
	
}
