package com.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.framework.GameObject;
import com.framework.ObjectId;
import com.framework.Texture;
import com.window.Game;

public class Block extends GameObject{

	Texture tex = Game.getInstance();
	private int type;
	public Block(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.white);
		//g.drawRect((int)x, (int)y, 32, 32);
		if(type == 0) {
			g.drawImage(tex.block[0], (int) x, (int) y, 32, 32, null);
		}
		if(type == 1) {
			g.drawImage(tex.block[1], (int) x, (int) y, 32, 32, null);
		}
		if(type == 2) {
			g.drawImage(tex.block[2], (int) x, (int) y, null);
		}
		if(type == 3) {
			g.drawImage(tex.block[3], (int) x, (int) y, null);
		}
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, 32, 32);
	}


}// end of class
