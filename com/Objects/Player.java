package com.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.framework.GameObject;
import com.framework.ObjectId;
import com.framework.Texture;
import com.window.Animation;
import com.window.Game;
import com.window.Handler;

public class Player extends GameObject{
	
	private float width = 32, height = 64, gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private int type;
	
	
	private Handler handler;
	
	Texture tex = Game.getInstance();
	
	private Animation playerWalkRight;
	private Animation playerIdleRight;
	private Animation playerWalkLeft;
	private Animation playerIdleLeft;
	private Animation playerJumpUpR;
	private Animation playerJumpUpL;
	private Animation playerUpR;
	private Animation playerUpL;
	
	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		type = 1;
		playerWalkRight = new Animation(5, tex.player[11], tex.player[12], tex.player[13], tex.player[14], tex.player[15], tex.player[16], 
				tex.player[17], tex.player[18], tex.player[19], tex.player[20]);
		playerIdleRight = new Animation(10, tex.player[8], tex.player[7], tex.player[6], tex.player[5], tex.player[4], tex.player[3], 
				tex.player[2], tex.player[1], tex.player[0]);
		playerWalkLeft = new Animation(5, tex.player[30], tex.player[31], tex.player[32], tex.player[33], tex.player[34], tex.player[35], 
				tex.player[36], tex.player[37], tex.player[38], tex.player[39]);
		playerIdleLeft = new Animation(10, tex.player[21], tex.player[22], tex.player[23], tex.player[24], tex.player[25], tex.player[26], 
				tex.player[27], tex.player[28], tex.player[29]);
		playerUpR = new Animation(10, tex.player[51], tex.player[50], tex.player[49], tex.player[48], tex.player[47], tex.player[46], 
				tex.player[45], tex.player[44], tex.player[43], tex.player[42], tex.player[41]);
		playerUpL = new Animation(10, tex.player[52], tex.player[53], tex.player[54], tex.player[55], tex.player[56], tex.player[57], 
				tex.player[58], tex.player[59], tex.player[60], tex.player[61], tex.player[62]);
		
		playerJumpUpR = new Animation(5, tex.player_jump[0], tex.player_jump[1], tex.player_jump[2], tex.player_jump[3], tex.player_jump[4],
										 tex.player_jump[3], tex.player_jump[2], tex.player_jump[1], tex.player_jump[0]);
		playerJumpUpL = new Animation(5, tex.player_jump[9], tex.player_jump[8], tex.player_jump[7], tex.player_jump[6], tex.player_jump[5],
										 tex.player_jump[6], tex.player_jump[7], tex.player_jump[8], tex.player_jump[9]);
	}


	
	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(velX > 0) {
			facing = 1;
		}
		else if(velX < 0) {
			facing = -1;
		}
		
		if(falling || jumping) {
			velY += gravity;
			if(velY > MAX_SPEED) {
				velY = MAX_SPEED;
			}
		}
		playerWalkRight.runAnimation();
		playerIdleRight.runAnimation();
		playerWalkLeft.runAnimation();
		playerIdleLeft.runAnimation();
		playerUpR.runAnimation();
		playerUpL.runAnimation();
		playerJumpUpR.runAnimation();
		playerJumpUpL.runAnimation();
		Collision(object);
	}
	
	private void Collision(LinkedList<GameObject> object) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBoundsTop().intersects(tempObject.getBound())){// checks for intersection with Blocks on the top
					y = tempObject.getY() + (height/2);
					velY = 0;
				}
			}
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBound().intersects(tempObject.getBound())){// checks for intersection with Blocks on the bottom
					y = tempObject.getY() - height;
					velY = 0;
					falling = false;
					jumping = false;
				}
				else {
					falling = true;
				}
			}
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBoundsLeft().intersects(tempObject.getBound())){// checks for intersection with Blocks on the left
					x = tempObject.getX() + width;
					velX = 0;
				}
			}
			
			if(tempObject.getId() == ObjectId.Block) {// tempObject becomes block for later collision checks
				if(getBoundsRight().intersects(tempObject.getBound())){// checks for intersection with Blocks on the right
					x = tempObject.getX() - width;
					velX = 0;
				}
			}
			
		}
	}// end of collision

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.setColor(Color.blue);
		//g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		//g.drawImage(tex.player[41], (int) x, (int) y, 32, 64, null);
		//g.drawImage(tex.player_jump[4], (int) x, (int) y, 32, 64, null);
		
		if(jumping == false) {
			if(up == 1) {
				if(facing == 1) {
					playerUpR.drawAnimation(g, (int)x, (int)y, 32, 64);
				}else {
					playerUpL.drawAnimation(g, (int)x, (int)y, 32, 64);
				}
			}else {
				if(velX > 0) {
					playerWalkRight.drawAnimation(g, (int)x, (int)y, 32, 64);
				}
				else if(velX == 0 && facing == 1){
					playerIdleRight.drawAnimation(g, (int) x, (int) y, 32, 64);
				}
				if(velX < 0) {
					playerWalkLeft.drawAnimation(g, (int)x, (int)y, 32, 64);
				}
				else if(velX == 0 && facing == -1){
					playerIdleLeft.drawAnimation(g, (int) x, (int) y, 32, 64);
				}
			}// end of up
		}else {
			if(facing == 1) {
				playerJumpUpR.drawAnimation(g, (int) x, (int) y, 32, 64);
			}else {
				playerJumpUpL.drawAnimation(g, (int) x, (int) y, 32, 64);
			}
		}// end of jumping
	
		
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.red);
//		hit boxes for player
//		g2d.draw(getBound());// bottom
//		g2d.draw(getBoundsRight());
//		g2d.draw(getBoundsLeft());
//		g2d.draw(getBoundsTop());
		
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
		public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x+width-7), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}

	
}// end of class
