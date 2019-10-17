package com.iridium.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BossEnemyBullets extends GameObject
{
	private Random r;
	private Handler handler;
	private BufferedImage bulletImage;
	
	public BossEnemyBullets(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		r=new Random();
		this.handler=handler;
		velX=(r.nextInt(5- -5)+ -5);
	    velY=6;
		SpriteSheet ss=new SpriteSheet(Game.ssheet1);
		bulletImage=ss.grabImage(4, 2, 16, 16);
	}
	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		if(y>Game.HEIGHT) handler.removeObject(this);
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);

			if(temp.getID()==ID.Player)
			{
		if(getBounds().intersects(temp.getBounds()))
		{
			if(Game.protect)
			{
			handler.removeObject(this);
			}
		}
			}
		}
		
		
	}
	public void render(Graphics g) 
	{
		g.drawImage(bulletImage, (int)x, (int)y, null);
		
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}

}
