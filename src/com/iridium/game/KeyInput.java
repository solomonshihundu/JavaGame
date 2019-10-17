package com.iridium.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Handler handler;
	private boolean keyDown[]=new boolean[4];
	private Game game;
	
	public KeyInput(Handler handler,Game game)
	{
		this.handler=handler;
		this.game=game;
		
		keyDown[0]= false;
		keyDown[1]= false;
		keyDown[2]= false;
		keyDown[3]= false;
	}
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getID()==ID.Player)
			{
				if(key==KeyEvent.VK_UP){temp.setVelY(-Game.speed);keyDown[0]=true;}
				if(key==KeyEvent.VK_DOWN){temp.setVelY(Game.speed);keyDown[1]=true;}
				if(key==KeyEvent.VK_LEFT){temp.setVelX(-Game.speed);keyDown[2]=true;}
				if(key==KeyEvent.VK_RIGHT){temp.setVelX(Game.speed);keyDown[3]=true;}
			}
		}
		
		if(key==KeyEvent.VK_ESCAPE)
		{
			game.gameState=Game.STATE.menu;
			game.reset();
		}
		
		if(key==KeyEvent.VK_SPACE)
		{	
			AudioPlayer.getSound("menuSound").play();
			if(game.gameState==Game.STATE.game)
			{
			if(Game.paused)
			{
				Game.paused=false;
			}
			else Game.paused=true;
		    }
		
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
       int key=e.getKeyCode();
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getID()==ID.Player)
			{
				if(key==KeyEvent.VK_UP){keyDown[0]=false;}
				if(key==KeyEvent.VK_DOWN){keyDown[1]=false;}
				if(key==KeyEvent.VK_LEFT){keyDown[2]=false;}
				if(key==KeyEvent.VK_RIGHT){keyDown[3]=false;}

				if(!keyDown[0]&&!keyDown[1])
				{
					temp.setVelY(0);
				}
				if(!keyDown[2]&&!keyDown[3])
				{
					temp.setVelX(0);
				}
			}
			
		}
	
	}

}
