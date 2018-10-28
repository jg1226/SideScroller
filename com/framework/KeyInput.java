package com.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.Objects.Bullet;
import com.window.Handler;

public class KeyInput extends KeyAdapter{
	private int c = 0;
	private int up = 0;
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player) {
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_SHIFT && !tempObject.getJumping()) {
					tempObject.setJumping(true);
					tempObject.setVelY(-10);
				}
				if(key == KeyEvent.VK_W) {
					tempObject.setUp(1);
					up = 1;
				}
				if(key == KeyEvent.VK_R) c = 0;
				if(key == KeyEvent.VK_SPACE) {
					if(c < 5) {
						if(up == 1) {
							handler.addObject(new Bullet(tempObject.getX(), tempObject.getY(), ObjectId.Bullet, tempObject.getFacing() * 15, tempObject.getFacing()));
						}else {
							handler.addObject(new Bullet(tempObject.getX(), tempObject.getY(), ObjectId.Bullet, tempObject.getFacing() * 15));
						}
						c++;
					}
				}
			}
		}
		
		if(key==KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player) {
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
			}
			if(key == KeyEvent.VK_W) {
				tempObject.setUp(0);
				up = 0;
			}
				
		}

	}// end of key released

}
