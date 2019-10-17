package com.iridium.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iridium.game.Game.STATE;

public class Menu extends MouseAdapter
{
	private Game game;
	private HUD hud;
	
	public Menu(Game game,Handler handler,HUD hud)
	{
		this.game=game;		
		this.hud=hud;
		
	
	}
	public void mousePressed(MouseEvent e)
	{
		int mx=e.getX();
		int my=e.getY();
		
		if(game.gameState==Game.STATE.menu)
		{
		//play
		if(mouseOver(mx,my,230,110,200,50))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState=STATE.select;
				
		}
		
		//help
		if(mouseOver(mx,my,230,210,200,50))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState=STATE.help;

			
		}
		
		//quit
		if(mouseOver(mx,my,230,310,200,50))
		{
			AudioPlayer.getSound("menuSound").play();
			System.exit(0);
			
		}
		
		
		}
		
		//select menu
		else if(game.gameState==STATE.select)
			{
				//normal
				if(mouseOver(mx,my,230,110,200,50))
				{
					AudioPlayer.getSound("menuSound").play();
					game.gameState=STATE.game;
					Game.diff=0;
				}
				
				//hard
				if(mouseOver(mx,my,230,210,200,50))
				{
					AudioPlayer.getSound("menuSound").play();
					game.gameState=STATE.game;
					Game.diff=1;
				}
				
				//back
				if(mouseOver(mx,my,230,310,200,50))
				{
					AudioPlayer.getSound("menuSound").play();
					game.gameState=STATE.menu;
				}

			}
		
		else if(game.gameState==Game.STATE.help)
		{
		//back from help
		if(mouseOver(mx,my,255,389,150,40))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState=Game.STATE.menu;
			
		}
		}
		else if(game.gameState==Game.STATE.end)
		{
		//try again
		if(mouseOver(mx,my,240,410,150,40))
		{
			AudioPlayer.getSound("menuSound").play();
			game.gameState=Game.STATE.game;
			game.reset();

		}
		}
		else if(game.gameState==STATE.game)
		{
			//conditions to enter shop
			if(mouseOver(mx,my,502, 440,150, 30))
			{
			if(Game.paused)
			{
				game.gameState=STATE.shop;
			}
			}
		}
		else if(game.gameState==STATE.shop)
		{
			//conditions to leave shop
			if(mouseOver(mx,my,502, 440,150, 30))
			{
				game.gameState=STATE.game;
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
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		if(game.gameState==Game.STATE.menu)
		{
		g.setColor(Color.yellow);
		g.setFont(new Font("Algerian",Font.BOLD,40));
		g.drawString("STAR GATE",220,75);
		
		g.setFont(new Font("Algerian",Font.BOLD,35));
		g.drawRect(230,110,200,50);
		g.drawString("PLAY",280, 148);
		
		g.drawRect(230,210,200,50);
		g.drawString("HELP",280, 248);
		
		g.drawRect(230,310,200,50);
		g.drawString("QUIT",280, 348);
		}
		else if(game.gameState==Game.STATE.help)
		{
			g.setColor(Color.cyan);
			g.setFont(new Font("Algerian",Font.BOLD,40));
			g.drawString("HELP",270,75);
			g.setFont(new Font("TimesNewRoman",Font.ITALIC,20));
			g.drawString("-> Use arrow keys to move player",80,120);
			g.setFont(new Font("Algerian",Font.PLAIN,30));
			g.drawRect(255,389,150,40);
			g.drawString("BACK",300, 420);
		}
		else if(game.gameState==Game.STATE.end)
		{
			g.setColor(new Color(20,20,20));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.setColor(Color.RED);
			g.setFont(new Font("Algerian",Font.BOLD,40));
			g.drawString("GAME OVER",220,75);
			g.setFont(new Font("TimesNewRoman",Font.ITALIC,20));
			g.drawString("YOU LOST !!!",280,175);
			g.drawString("Score : "+hud.getScore(),275,220);
			
			g.drawRect(250,410,155,40);
			g.drawString("Try Again", 280, 438);
		
		}
		else if(game.gameState==Game.STATE.select)
		{
			g.setColor(Color.yellow);
			g.setFont(new Font("Algerian",Font.ITALIC,30));
			g.drawString("DIFFICULTY",250,75);
			
			g.setFont(new Font("Algerian",Font.BOLD,35));
			g.drawRect(230,110,200,50);
			g.drawString("normal",260, 148);
			
			g.drawRect(230,210,200,50);
			g.drawString("hard",280, 248);
			
			g.drawRect(230,310,200,50);
			g.drawString("back",280, 348);
		
		}
	}

}
