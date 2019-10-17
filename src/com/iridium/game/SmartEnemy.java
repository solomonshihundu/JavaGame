package com.iridium.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject
{
	private GameObject player;
	private BufferedImage smartImage;
	private Handler handler;
	
	public SmartEnemy(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		this.handler=handler;
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getID()==ID.Player)
			{
				player=handler.object.get(i);
			}
		}
		SpriteSheet ss=new SpriteSheet(Game.ssheet1);
		smartImage=ss.grabImage(4,1, 20, 20);
		
	}

	
	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		float diffX=x-player.getX()-16;
		float diffY=y-player.getY()-16;
		float distance=(float)Math.sqrt(Math.pow((x-player.getX()),2)+Math.pow((y-player.getY()), 2));
		
		velX=((-1/distance)*diffX);
		velY=((-1/distance)*diffY);
		
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
		g.drawImage(smartImage, (int)x, (int)y, null);
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,16,16);
	}

}

