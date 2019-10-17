package com.iridium.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject
{	
	private BufferedImage fastImage;
	private Handler handler;
	
	public FastEnemy(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		this.handler=handler;
		velX=velY=7;
		SpriteSheet ss=new SpriteSheet(Game.ssheet1);
		fastImage=ss.grabImage(3, 1, 8,8);
	}

	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		if(x<0||x>Game.WIDTH-30)velX*=-1;
		if(y<0||y>Game.HEIGHT-30)velY*=-1;
		
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
		g.drawImage(fastImage, (int)x, (int)y,null);
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,8,8);
	}

}

