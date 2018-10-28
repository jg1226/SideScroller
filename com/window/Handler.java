package com.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.Objects.Block;
import com.framework.GameObject;
import com.framework.ObjectId;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);//loads objects from the object list
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);// renders object graphics
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {// adds to list
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {// removes from list
		this.object.remove(object);
	}
	
//	public void createLevel() {// og level this method is called on from the game class
//		for(int i = 0; i < Game.WIDTH+32; i+=32) {// left wall
//			addObject(new Block(0, i, ObjectId.Block));
//		}
//		
//		//for(int i = 0; i < Game.WIDTH+32; i+=32) {// right wall
//			//addObject(new Block(777, i, ObjectId.Block));
//		//}
//		
//		for(int i = 0; i < Game.WIDTH*2; i+=32) {// floor
//			addObject(new Block(i, Game.HEIGHT-32, ObjectId.Block));
//		}
//		for(int i = 0; i < 32*10; i+=32) {// floating floor
//			addObject(new Block(200 + i, 450, ObjectId.Block));
//		}
//		
//	}
	
}// end of class
