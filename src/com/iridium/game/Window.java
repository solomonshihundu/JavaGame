package com.iridium.game;

import java.awt.Dimension;

import javax.swing.JFrame;


public class Window extends JFrame
{
	private static final long serialVersionUID = -5317018518853269200L;

	public Window(int width,int height,String title,Game game)
	{
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(420,200);
		setPreferredSize(new Dimension(width,height));
		setMaximumSize(new Dimension(width,height));
		setMinimumSize(new Dimension(width,height));
		setResizable(false);
		setVisible(true);
		
		add(game);
		game.start();
	}
}
