package com.iridium.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable
{	
	private static final long serialVersionUID = 4365461053712686094L;

	public static final int WIDTH=680,HEIGHT=WIDTH/12*9;
	
	private Thread thread;
	private boolean running=false;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	public static boolean paused=false;
	public static boolean protect=false;
	public static int diff=0;
	public static BufferedImage ssheet1;
	public static BufferedImage ssheet2;
	public static int speed=5;
	private Random r=new Random();
	public enum STATE
	{
		menu,
		game,
		help,
		end,
		select,
		shop
		
	};
	public enum MODE
	{
		normal,
		lethal
	};
	
	public STATE gameState=STATE.menu;
	public MODE playerMode=MODE.normal;

	public Game()
	{
		
		handler=new Handler();
		
		this.addKeyListener(new KeyInput(handler,this));
	   
		hud=new HUD(); 
		shop=new Shop(hud,this);
		spawner=new Spawn(handler,hud);
		menu=new Menu(this,handler,hud);
		this.addMouseListener(menu); 
		this.addMouseListener(shop);
		AudioPlayer.load();
				
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH,HEIGHT,"ORIGIN",this);
		
		BufferedImageLoader loader=new BufferedImageLoader();
		ssheet1=loader.loadImage("/gameobjects.png");
		ssheet2=loader.loadImage("/bossenemy.png");
		
		if(diff==0)
		{
			handler.addObject(new Player((Game.WIDTH/2)-16,(Game.HEIGHT/2)-16,ID.Player,handler,this));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
		}
		else if(diff==1)
		{
			handler.addObject(new Player((Game.WIDTH/2)-16,(Game.HEIGHT/2)-16,ID.Player,handler,this));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			
		}
		
	}
	public synchronized void start()
	{
		thread=new Thread(this);
		thread.start();
		running=true;
		
	}
	public synchronized void stop()
	{
		try
		{
		thread.join();
		running=false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		this.requestFocus();
		long lastTime=System.nanoTime();
		double delta = 0;
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		long timer=System.currentTimeMillis();
		
		while(running)
		{
			long now=System.nanoTime();
			delta+=((now-lastTime)/ns);
			lastTime=now;
			while(delta>=1)
			{
			tick();
			delta--;
			}
			
		if(running)
			render();
			
			
		if(System.currentTimeMillis()-timer>1000)
		{
			timer+=1000;

		}
		}
		stop();
	}
	private void render()
	{
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g=bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0,WIDTH, HEIGHT);
		
		if(gameState==STATE.game)
		{
		handler.render(g);
		hud.render(g);
		
		if(paused)
		{
			g.setColor(Color.green);
			g.setFont(new Font("Algerian",Font.BOLD,30));
			g.drawString("Game Paused",235,210);
			
			g.setFont(new Font("Algerian",Font.BOLD,20));
			g.drawRect(502, 440,150, 30);
			g.drawString("Enter Shop", 515, 462);
		}
		}
		else if(gameState==STATE.shop)
		{
			shop.render(g);
		}
		else if(gameState==STATE.menu||gameState==STATE.help||gameState==STATE.end||gameState==STATE.select)
		{
			menu.render(g);
		}
		g.dispose();
		bs.show();
		
		
		
	}
	private void tick()
	{		
		if(!paused)
		{
			handler.tick();	
		if(gameState==STATE.game)
		{
			hud.tick();
			spawner.tick();
			
			if(HUD.HEALTH<=0)
			{
				HUD.HEALTH=100;
				gameState=STATE.end;
				
			}

		}
		else if(gameState==STATE.menu)
		{
			menu.tick();
		}
		}
	}
	public static void main(String args[])
	{
		new Game();
	}
	public static float clamp(float var,float min,float max)
	{
		if(var<min)
		{
			return min;
		}
		else if(var>max)
		{
			return max;
		}
		else
			return var;
		
	}
	public void reset()
	{
		hud.setScore(0);
		hud.setLevel(1);
		HUD.HEALTH=100;
		HUD.ARMOR=0;
		playerMode=MODE.normal;
	    speed=5;
		handler.clearEnemies();
		
		Shop.B1=500;
		Shop.B2=1000;
		Shop.B3=3000;
		Shop.B4=10000;
	}


}
