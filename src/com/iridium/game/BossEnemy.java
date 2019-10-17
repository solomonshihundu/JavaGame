package com.iridium.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BossEnemy extends GameObject
{
	private int timmer1=20;
	private int timmer2=20;
	private Handler handler;
	private Random r=new Random();
	private BufferedImage bossImage;
	
	public BossEnemy(float x,float y,ID id,Handler handler)
	{
		super(x,y,id);
		this.handler=handler;
		SpriteSheet ss=new SpriteSheet(Game.ssheet2);
		velY=3;
		velX=0;
		bossImage=ss.grabImage(1,1,90,90);
	}

	
	public void tick() 
	{
		x+=velX;
		y+=velY;

		if(timmer1<=0)
		{
			velY=0;
		}
		else timmer1--;
		
		if(timmer1<=0)timmer2--;
		{
			if(timmer2<=0)
			{
				if(velX==0)velX=4;
				
				if(velX>0) 
					velX+=0.005f;
				else if(velX<0)
					velX-=0.005f;
				
				velX=Game.clamp(velX, -10,10);
				int spawn=r.nextInt(10);
				
				if(Game.diff==0)
				{
				if(spawn==0)
				{
					handler.addObject(new BossEnemyBullets(x+42,y+65,ID.BossBullet,handler));
				}
				}
				else if(Game.diff==1)
				{
				if(spawn==0||spawn==5)
				{
					handler.addObject(new BossEnemyBullets(x+42,y+65,ID.BossBullet,handler));
				}
				}
			}
		}
			
		if(x<=0||x>=Game.WIDTH-90)velX*=-1;
		
				
	}

	
	public void render(Graphics g) 
	{
		g.drawImage(bossImage,(int)x,(int)y, null);
	}


	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,96,96);
	}

}
