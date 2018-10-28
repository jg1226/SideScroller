package com.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.framework.GameObject;
import com.framework.ObjectId;

public class Bullet extends GameObject{
	
	private int Up = 0;
	
	public Bullet(float x, float y, ObjectId id, int velX, int facing) {// bullets going up
		super(x, y, id);
			this.velX = velX;
			this.Up = 1;
			this.facing = facing;
			
	}
	
	public Bullet(float x, float y, ObjectId id, int velX) {// bullets moving horizontally
		super(x, y, id);
			this.velX = velX;
	}

	
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub

		if(Up == 1) {
			if(velX < 0) {
				velX = velX * -1;
			}
			y -= velX;
		}else {
			x += velX;
		}
			
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);

		if(Up == 1) {
			if(facing == 1) {
				g.fillRect((int)x+20, (int)y+8, 4, 4);// up facing right
			}else {
				g.fillRect((int)x+10, (int)y+8, 4, 4);// up facing left
			}
		}else {
			if(velX > 0) {
				g.fillRect((int)x+26, (int)y+17, 4, 4);// facing right idle
			}else {
				g.fillRect((int)x-3, (int)y+17, 4, 4);// facing right idle
			}
		}
	}


	public Rectangle getBound() {
		// TODO Auto-generated method stub
		if(Up == 1) {
			if(facing == 1) {
				return new Rectangle((int)x+20, (int)y+8, 4, 4);// up facing right
			}else {
				return new Rectangle((int)x+10, (int)y+8, 4, 4);// up facing left
			}
		}else {
			if(velX > 0) {
				return new Rectangle((int)x+26, (int)y+17, 4, 4);// facing right idle
			}else {
				return new Rectangle((int)x-3, (int)y+17, 4, 4);// facing right idle
			}
		}
		
	}// end of get bound
	

}// end of class
