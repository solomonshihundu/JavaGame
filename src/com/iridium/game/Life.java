package com.iridium.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Life extends GameObject
{
	private BufferedImage lifeImage;
	private Handler handler;
	private int timmer=500;
	
	public Life(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		this.handler=handler;
		velX=velY=3;
		
		SpriteSheet ss=new SpriteSheet(Game.ssheet1);
		lifeImage=ss.grabImage(2,2,30,30);
		
	}

	
	public void tick() 
	{
		x+=velX;
		y+=velY;
		
		if(x<0||x>Game.WIDTH-30)velX*=-1;
		if(y<0||y>Game.HEIGHT-30)velY*=-1;
		
		timmer--;
		if(timmer<=0)
		{
			handler.removeObject(this);
		}
		
		
	}

	
	public void render(Graphics g) 
	{
		g.drawImage(lifeImage, (int)x, (int)y, null);
		
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,30,30);
	}

}
