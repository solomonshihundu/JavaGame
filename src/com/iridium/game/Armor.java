package com.iridium.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Armor extends GameObject
{
	private BufferedImage armorImage;
	private Handler handler;
	private int timmer=500;
	
	public Armor(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		this.handler=handler;
		velX=velY=2;
		
		SpriteSheet ss=new SpriteSheet(Game.ssheet1);
		armorImage=ss.grabImage(1,3,32,32);
		
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
		g.drawImage(armorImage, (int)x, (int)y, null);
		
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}

}

