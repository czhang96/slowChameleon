package com.me.slowChameleon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class sc implements ApplicationListener {
	SpriteBatch batch;
	Chameleon cham;
	
	Vector2 position;
	Texture texture;
	Stage stage;
	Label label;
	LabelStyle style;
	BitmapFont font;
	
	Skin skin;
	TextureAtlas buttonAtlas;
	
	TextButtonStyle buttonStyleRed;
	TextButtonStyle buttonStyleBlue;
	TextButtonStyle buttonStyleGreen;
	TextButtonStyle buttonStyleYellow;
	
	TextButton buttonRed;
	TextButton buttonBlue;
	TextButton buttonGreen;
	TextButton buttonYellow;
	float delay;
	public void create() {		
		delay=1;
		batch= new SpriteBatch();
		stage= new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"),false);
		style = new LabelStyle(font, Color.RED);
		
		cham = new Chameleon(new Vector2(400,500));
		
		label = new Label("Example", style);
		label.setPosition(50,50);
		stage.addActor(label);
		
		skin= new Skin();
		buttonAtlas = new TextureAtlas("buttons/button.pack");
		skin.addRegions(buttonAtlas);

		
		buttonStyleRed = new TextButtonStyle();
		buttonStyleRed.up = skin.getDrawable("button-r");
		buttonStyleRed.down = skin.getDrawable("button-r");
		buttonStyleRed.font=font;
		buttonRed= new TextButton("",buttonStyleRed);
		buttonRed.setPosition(200,100);
		
		buttonStyleBlue = new TextButtonStyle();
		buttonStyleBlue.up = skin.getDrawable("button-b");
		buttonStyleBlue.down = skin.getDrawable("button-b");
		buttonStyleBlue.font=font;
		buttonBlue= new TextButton("",buttonStyleBlue);
		buttonBlue.setPosition(200,350);
		
		buttonStyleGreen = new TextButtonStyle();
		buttonStyleGreen.up = skin.getDrawable("button-g");
		buttonStyleGreen.down = skin.getDrawable("button-g");
		buttonStyleGreen.font=font;
		buttonGreen= new TextButton("",buttonStyleGreen);
		buttonGreen.setPosition(600,100);
		
		buttonStyleYellow = new TextButtonStyle();
		buttonStyleYellow.up = skin.getDrawable("button-y");
		buttonStyleYellow.down = skin.getDrawable("button-y");
		buttonStyleYellow.font=font;
		buttonYellow= new TextButton("",buttonStyleYellow);
		buttonYellow.setPosition(600,350);
		
		stage.addActor(buttonRed);
		stage.addActor(buttonBlue);
		stage.addActor(buttonGreen);
		stage.addActor(buttonYellow);
		
		Gdx.input.setInputProcessor(stage);
		
		buttonRed.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham-red.jpg")));
				    }
				}, delay);
				
				return true;
			}
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham.jpg")));
				    }
				}, delay);

			}
			
		});
		buttonBlue.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham-blue.jpg")));
				    }
				}, delay);
				
				
				return true;
			}
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham.jpg")));
				    }
				}, delay);
				

			}
			
		});
		buttonGreen.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham-green.jpg")));
				    }
				}, delay);
				
				return true;
			}
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham.jpg")));
				    }
				}, delay);

			}
			
		});
		buttonYellow.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham-yellow.jpg")));
				    }
				}, delay);
				
				return true;
			}
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Timer.schedule(new Task(){
				    public void run() {
				    	cham.setTexture(new Texture(Gdx.files.internal("cham.jpg")));
				    }
				}, delay);

			}
			
		});
	}


	public void render() {	
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		cham.update();
		stage.act();
		
		batch.begin();
		
		
		batch.draw(cham.getTexture(),cham.getPosition().x, Gdx.graphics.getHeight()-cham.getPosition().y);
		
		
		batch.end();
		stage.draw();
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
