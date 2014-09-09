package com.me.slowChameleon;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Chameleon {
	Circle bounds;
	Vector2 position;
	Texture texture;
	String textureLocation;
	public Chameleon(Vector2 position){
		this.position=position;
		this.texture= new Texture(Gdx.files.internal("cham.jpg"));
		
	}
	
	public void update(){
//		if (Gdx.input.isTouched()){
//			position.x=Gdx.input.getX();
//			position.y=Gdx.input.getY();
//		}
		
	}
	
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
}
