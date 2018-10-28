package com.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Objects.Block;
import com.Objects.Player;
import com.framework.GameObject;
import com.framework.KeyInput;
import com.framework.ObjectId;
import com.framework.Texture;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	
	private BufferedImage level = null, background = null;
	
	//object
	Handler handler;
	Camera cam;
	static Texture tex;

	private void init() {// Initializer
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level.png");//loading the level
		background = loader.loadImage("/IceCave.png");
		
		handler = new Handler();
		
		cam = new Camera(0,0);
		
		LoadImageLevel(level);

		//handler.addObject(new Player(100, 100, handler, ObjectId.Player)); OG level is being called on from the handler class
		//handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
	}

	public synchronized void start() {
		if(running) {// prevents start from being called twice and creating more threads
			return;
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		init();//Initializes everything
		this.requestFocus();
		System.out.println("thread has begun");
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime= now;
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}// end of run

	private void tick() {// ticks is number of updates
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ObjectId.Player)
				cam.tick(handler.object.get(i));
		}
		
	}

	private void render() {// graphical stuff

		BufferStrategy bs = this.getBufferStrategy();// "this" is a canvas method
		if(bs == null) { // bs is defaulted to null
			this.createBufferStrategy(3);// buffer strategy is important because it sets a limit to the speed the computer can render an images
			return;//by setting the number 3 we are triple buffering creating three images if the computer has enough time and simply replacing them as needed
		}// three is a bit over kill most computers have a hard time doing that if they even can

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
 		/////////////////////////////////// 
		//draw between comment lines
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY());// begin of cam everything inbetween is effected by the cam
		
		for(int xx = 0; xx < background.getWidth() * 5; xx += background.getWidth()) {
			g.drawImage(background, xx, 0, this);
			g.drawImage(background, xx, 358, this);
		}
			
			handler.render(g);// renders objects
		
		g2d.translate(-cam.getX(), -cam.getY());// end of cam
		///////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	private void LoadImageLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) &0xff;// gets RGB values
				int green = (pixel >> 8) &0xff;
				int blue = (pixel) &0xff;
				
				if(red == 255 && green == 255 && blue == 255) handler.addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));//255,255,255 = white
				if(red == 0 && green == 0 && blue == 255) handler.addObject(new Player(xx*32, yy*32, handler, ObjectId.Player));//0,0,255 = blue
			}
		}
	}// end of load image
	
	public static Texture getInstance() {
		return tex;
	}
	
	public static void main(String args[]){
			new window(1000, 600, "Saber", new Game());
		
		
	}// end of main

}// end of class
