package com.iridium.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iridium.game.Game.MODE;

public class Shop extends MouseAdapter
{
	private HUD hud;
	public static int B1=500;
	public static int B2=1000;
	public static int B3=3000;
	public static int B4=10000;
	public Game game;
	
	public Shop(HUD hud,Game game)
	{
		this.hud=hud;
		this.game=game;
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.CYAN);
		g.setFont(new Font("TimeNewRoman",Font.ITALIC,18));

		g.setColor(Color.CYAN);
		g.drawRect(15, 50, 140, 100);
		g.drawString("Life Refill", 45,80);
		g.drawString("$ "+B1, 55,130);
		if(hud.getScore()<B1)
		{
			g.setColor(new Color(255,255,255,100));
			g.fillRect(15, 50, 140, 100);
		}
		
		g.setColor(Color.CYAN);
		g.drawRect(185, 50, 140, 100);
		g.drawString("Armor Refill",205,80);
		g.drawString("$ "+B2, 230,130);
		if(hud.getScore()<B2)
		{
			g.setColor(new Color(255,255,255,100));
			g.fillRect(185, 50, 140, 100);
		}
		
		g.setColor(Color.CYAN);
		g.drawRect(352, 50, 140, 100);
		g.drawString("Speed Upgrade", 360,80);
		g.drawString("$ "+B3, 390,130);
		if(hud.getScore()<B3)
		{
			g.setColor(new Color(255,255,255,100));
			g.fillRect(352, 50, 140, 100);
		}
		
		g.setColor(Color.CYAN);
		g.drawRect(517, 50, 140, 100);
		g.drawString("Player Upgrade", 521,80);
		g.drawString("$ "+B4, 550,130);
		if(hud.getScore()<B4)
		{
			g.setColor(new Color(255,255,255,100));
			g.fillRect(517, 50, 140, 100);
		}

		
		g.setColor(Color.CYAN);
		g.setFont(new Font("Algerian",Font.BOLD,20));
		g.drawRect(500, 440,170, 30);
		g.drawString("Back To Game", 505, 462);
		g.drawString("cash $$ "+hud.getScore(),280,250);
	}
	public void mousePressed(MouseEvent e)
	{
		int mx=e.getX();
		int my=e.getY();
		
		//B1
		if(mouseOver(mx,my,15, 50, 140, 100))
		{
			if(hud.getScore()>B1)
			{
				AudioPlayer.getSound("menuSound").play();
			HUD.HEALTH=100;
			hud.setScore(hud.getScore()-B1);
			}
		}
		
		//B2
		if(mouseOver(mx,my,185, 50, 140, 100))
		{
			if(hud.getScore()>B2)
			{
			if(HUD.armored)
			{
				AudioPlayer.getSound("menuSound").play();
				
				HUD.ARMOR=100;
				hud.setScore(hud.getScore()-B2);
				B2+=500;
			}
			}
			
		}
		
		//B3
		if(mouseOver(mx,my,352, 50, 140, 100))
		{
			if(hud.getScore()>B3)
			{
				AudioPlayer.getSound("menuSound").play();
			
			Game.speed+=3;
			hud.setScore(hud.getScore()-B3);
			B3+=1000;
			}
		}
		
		//B4
		if(mouseOver(mx,my,517, 50, 140, 100))
		{
			if(hud.getScore()>B4)
			{
				AudioPlayer.getSound("menuSound").play();
			
			game.playerMode=MODE.lethal;
			hud.setScore(hud.getScore()-B4);
			B4+=2000;
			}
		}
		
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public boolean mouseOver(int mx,int my,int x,int y,int width,int height)
	{
		if(mx>x&&mx<x+width)
		{
			if(my>y&&my<y+height)
			{
				return true;
			}
			else return false;
		}
		else return false;
		
	}


}
