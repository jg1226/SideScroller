package com.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected float x, y;
	protected ObjectId id;
	protected float velX = 0, velY = 0;
	protected Boolean falling = true;
	protected Boolean jumping = true;
	protected int up = 0;

	protected int facing = 1;

	public GameObject(float x, float y, ObjectId id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	// methods
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBound();
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public Boolean getFalling() {
		return falling;
	}

	public void setFalling(Boolean falling) {
		this.falling = falling;
	}

	public Boolean getJumping() {
		return jumping;
	}
	
	public void setJumping(Boolean jumping) {
		this.jumping = jumping;
	}
	
	public int getFacing() {
		return facing;
	}
	
	public void setFacing(int facing) {
		this.facing = facing;
	}
	
	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}
	
}// end of class
