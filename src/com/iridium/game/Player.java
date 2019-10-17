package com.iridium.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.iridium.game.Game.MODE;

public class Player extends GameObject
{
	private Handler handler;
	private BufferedImage player_image_normal;
	private BufferedImage player_image_lethal;
	private Game game;
	private int timmer=300;
	
	public Player(float x,float y,ID id,Handler handler,Game game)
	{
		super(x,y,id);
		this.handler=handler;
		this.game=game;
		SpriteSheet ss=new SpriteSheet(Game.ssheet1);
		player_image_normal=ss.grabImage(1,2,32,32);
		player_image_lethal=ss.grabImage(2,3,32,32);
				
	}


	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		x=Game.clamp(x, 0, Game.WIDTH-38);
		y=Game.clamp(y, 0, Game.HEIGHT-61);
		collision();
		
		timmer--;
		
		if(timmer<=0)
		{
			timmer=300;
			Game.protect=false;
		}
		
	}


	public void render(Graphics g) 
	{
		if(game.playerMode==MODE.normal)
		{
		g.drawImage(player_image_normal, (int)x, (int)y,null);
		}
		else if(game.playerMode==MODE.lethal)
		{
				
			if(Game.protect)
			{
				g.setColor(Color.yellow);
				g.fillRoundRect((int)x-6,(int)y-6,43,43,25,25);
			}
			g.drawImage(player_image_lethal, (int)x, (int)y,null);
		}
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}
	public void collision()
	{
		/*
		 * Normal mode player
		 */
		if(game.playerMode==MODE.normal)
		{
			
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getID()==ID.BasicEnemy)
			{
		if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.HEALTH-=0.5;
				HUD.ARMOR-=2;
				}
				else
					HUD.HEALTH-=1;	
				}
			}
			if(temp.getID()==ID.FastEnemy)
			{
			if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.HEALTH-=1;
				HUD.ARMOR-=2;
				}
				else
					HUD.HEALTH-=2;	
				
			}
			}
			if(temp.getID()==ID.SmartEnemy)
			{
			if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.HEALTH-=1.5;
				HUD.ARMOR-=2;
				}
				else
					HUD.HEALTH-=2;	
				
			}
			}
			if(temp.getID()==ID.BossEnemy)
			{
			if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.HEALTH-=2;
				HUD.ARMOR-=4;
				}
				else
					HUD.HEALTH-=4;	
				
			}
			}
			if(temp.getID()==ID.BossBullet)
			{
			if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.ARMOR-=0.1;
				}
				else
					HUD.HEALTH-=0.5;	
				
			}
			}
			if(temp.getID()==ID.SweepEnemy)
			{
			if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.ARMOR-=3;
				HUD.HEALTH-=5;
				}
				else
					HUD.HEALTH-=10;	
				
			}
			}
			if(temp.getID()==ID.LethalEnemy)
			{
			if(getBounds().intersects(temp.getBounds()))
			{
				if(HUD.armored)
				{
				HUD.ARMOR-=0.1;
				}
				else
					HUD.HEALTH-=0.5;	
				
			}
			}
			if(temp.getID()==ID.Life)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.HEALTH=100;
					handler.removeObject(temp);
				}

				
			}
			if(temp.getID()==ID.Armor)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.ARMOR=100;
					handler.removeObject(temp);
					HUD.armored=true;
				}

				
			}
		}
	}
		
		/*
		 * Lethal player mode
		 */
		else if(game.playerMode==MODE.lethal)
		{
				
			for(int i=0;i<handler.object.size();i++)
			{
				GameObject temp=handler.object.get(i);
				if(temp.getID()==ID.BasicEnemy)
				{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.HEALTH-=1;
					HUD.ARMOR-=2;
				}
				}
				if(temp.getID()==ID.FastEnemy)
				{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.HEALTH-=2;
					HUD.ARMOR-=2;
				}
				}
				if(temp.getID()==ID.SmartEnemy)
				{
				if(getBounds().intersects(temp.getBounds()))
				{
					HUD.HEALTH-=3;
					HUD.ARMOR-=2;
				}
				}
				if(temp.getID()==ID.Life)
				{
					if(getBounds().intersects(temp.getBounds()))
					{
						HUD.HEALTH=100;
						handler.removeObject(temp);
					}

					
				}
				if(temp.getID()==ID.Armor)
				{
					if(getBounds().intersects(temp.getBounds()))
					{
						HUD.ARMOR=100;
						handler.removeObject(temp);
						HUD.armored=true;
					}

					
				}
				if(temp.getID()==ID.Protection)
				{
					if(getBounds().intersects(temp.getBounds()))
					{
						handler.removeObject(temp);
						Game.protect=true;
					}

					
				}
			}
		
			
			
		}
	}
	

}
