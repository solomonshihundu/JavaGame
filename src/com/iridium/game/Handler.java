package com.iridium.game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler
{
	LinkedList<GameObject>object=new LinkedList<GameObject>();
	
	public void tick()
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp=object.get(i);
			temp.tick();
			
		}
		
	}
	public void render(Graphics g)
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp=object.get(i);
			temp.render(g);
			
		}	
	}
	public void addObject(GameObject myObject)
	{
		this.object.add(myObject);
	}
	public void removeObject(GameObject myObject)
	{
		this.object.remove(myObject);
	}
	public void clearEnemies()
	{
		for(int c=0;c<50;c++)
		{
		for(int i=0;i<object.size();i++)
		{
			GameObject temp =object.get(i);
			if(temp.getID()!=ID.Player)
			{
				removeObject(temp);
			}
		}
		}
	}

}
