package com.iridium.game;

import java.util.Random;

public class Spawn 
{
	private Handler handler;
	private HUD hud;
	private int scoreKeep=0;
	private Random r;
	
	public Spawn(Handler handler,HUD hud)
	{
		this.handler=handler;
		this.hud=hud;
		r=new Random();
	}
	public void tick()
	{
		scoreKeep++; 
		if(scoreKeep>300)
		{
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			/*
			 * Normal difficulty
			 */
			if(Game.diff==0)
			{
		if(hud.getLevel()==2)
		{
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					
		}
		else if(hud.getLevel()==3)
		{
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			
		}
		else if(hud.getLevel()==4)
		{
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			
		}
		else if(hud.getLevel()==5)
		{
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
		}
		else if(hud.getLevel()==10)
		{
			handler.clearEnemies();
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
			
		}
		else if(hud.getLevel()==13)
		{
			
			handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			
		}
		else if(hud.getLevel()==15)
		{
			handler.clearEnemies();
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
		}
		else if(hud.getLevel()==17)
		{
			handler.clearEnemies();
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
			handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
			
		}
		else if(hud.getLevel()==20)
		{
			handler.clearEnemies();
			handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
			handler.addObject(new SweepEnemy(-100,0,ID.SweepEnemy,handler));
			handler.addObject(new SweepEnemy(-200,0,ID.SweepEnemy,handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new SweepEnemy(-300,0,ID.SweepEnemy,handler));
			handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
		}
		else if(hud.getLevel()==25)
		{
			handler.clearEnemies();
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
		}
		else if(hud.getLevel()==32)
		{
			handler.clearEnemies();
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
			handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
			handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
			handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
		}
		else if(hud.getLevel()==36)
		{
			handler.clearEnemies();
			handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
			
		}
		else if(hud.getLevel()==40)
		{
			handler.clearEnemies();
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
			handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
		}
			}
			/*
			 * Hard difficulty
			 */
			else if(Game.diff==1)
			{

				if(hud.getLevel()==2)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
				}
				else if(hud.getLevel()==3)
				{
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
				}
				else if(hud.getLevel()==4)
				{
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
				}
				else if(hud.getLevel()==5)
				{
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.SmartEnemy,handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
				}
					
				else if(hud.getLevel()==7)
				{
					handler.clearEnemies();
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
				}
				else if(hud.getLevel()==10)
				{
					handler.clearEnemies();
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
				}
				else if(hud.getLevel()==12)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
				}
				else if(hud.getLevel()==15)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
				}
				else if(hud.getLevel()==18)
				{
					handler.clearEnemies();
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
				}
				else if(hud.getLevel()==22)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
				}
				else if(hud.getLevel()==26)
				{
					handler.clearEnemies();
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
				}
				else if(hud.getLevel()==31)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
				}
				else if(hud.getLevel()==37)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
				}
				else if(hud.getLevel()==43)
				{
					handler.clearEnemies();
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
				}
				else if(hud.getLevel()==47)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new Protection(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Protection, handler));
				}
				else if(hud.getLevel()==52)
				{
					handler.clearEnemies();
					handler.addObject(new Armor(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Armor, handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.FastEnemy, handler));
					handler.addObject(new BossEnemy(Game.WIDTH/2-43,-50,ID.BossEnemy,handler));
					handler.addObject(new SweepEnemy(-20,0,ID.SweepEnemy,handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new SweepEnemy(-100,0,ID.SweepEnemy,handler));
					handler.addObject(new SweepEnemy(-200,0,ID.SweepEnemy,handler));
					handler.addObject(new SweepEnemy(-300,0,ID.SweepEnemy,handler));
					handler.addObject(new SweepEnemy(-500,0,ID.SweepEnemy,handler));
					handler.addObject(new SweepEnemy(-700,0,ID.SweepEnemy,handler));
					handler.addObject(new Life(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.Life, handler));
					handler.addObject(new SweepEnemy(-1000,0,ID.SweepEnemy,handler));
					handler.addObject(new SweepEnemy(-1500,0,ID.SweepEnemy,handler));
				}
				
			}
		}
	}

}
