package com.iridium.game;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class AudioPlayer 
{
	public static Map<String,Sound> soundMap=new HashMap<String,Sound>();
	public static Map<String,Music> musicMap=new HashMap<String,Music>();
	
	public static void load()
	{
		try {
			soundMap.put("menuSound",new Sound("Res/buttonsound.ogg"));
			musicMap.put("music",new Music("Res/background_Music5.ogg"));
			
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static Sound getSound(String key)
	{
		return soundMap.get(key);
	}
	public static Music getMusic(String key)
	{
		return musicMap.get(key);
	}

}
