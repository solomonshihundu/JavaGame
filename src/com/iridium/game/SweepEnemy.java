package com.iridium.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SweepEnemy extends GameObject
{
	private Handler handler;
	public SweepEnemy(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		this.handler=handler;
		velX=3;
			
	}

	
	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		if(x>Game.WIDTH/2+250)velX*=-1;
		if(x<-50)handler.removeObject(this);
		
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
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y,32,Game.HEIGHT);
		
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,Game.WIDTH);
	}

}

