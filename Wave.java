package ru.medev.bublershooter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Wave {
	
	//Поле
	
	private int waveNumber;
	
	private int waveMultiplier;
	
	private long waveTimer;
	private long waveDelay;
	private long waveTimerDiff;

	private String waveText;
	
	//Конструктор
	
	public Wave()
	{
		waveNumber = 1;
		
		waveMultiplier = 5;
		waveDelay = 5000;
		waveTimer = 0;
		waveTimerDiff = 0;
		
		waveText = "yrhtwegr -";
	}
	
	//Функци
	
	private void CreateEmenies() 
	{
		int enemyCount = 4 ;
		if (waveNumber < 4)
		{
			while (enemyCount > 0)
			{
				int rank = 2;
				int type = 1;
				GamePanel.enemies.add(new Enemy(1, 1));
				GamePanel.enemies.add(new Enemy(1, 2));
				enemyCount -= type * rank;
			}
		}
		enemyCount++;
	}
	
	public void update()
	{
		if (GamePanel.bullets.size() == 0 && waveTimer == 0)
		{
			waveTimer = System.nanoTime();
		}
		if (waveTimer > 0)
		{
			waveTimerDiff += (System.nanoTime() - waveTimer) / 1000000;
			waveTimer = System.nanoTime();
		}
		if (waveTimerDiff > waveDelay)
		{
			CreateEmenies();
			waveTimer = 0;
			waveTimerDiff = 0;
		}
	}

	public boolean showWave ()
	{
		if (waveTimer != 0)
		{
			return true;
		}
		else return false;
	}
	
	public void draw(Graphics g)
	{
		double divider = waveDelay / 180;
		double alpha = waveTimerDiff / divider;
		
		alpha = 255 * Math.sin(Math.toRadians(alpha));
		if (alpha < 0)
		{
			alpha = 0;
		}
		if (alpha > 255) {
			alpha = 255;
		}
		String s = " - " + waveNumber + "ая" + waveText;
		long length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.setFont(new Font("consolas", Font.PLAIN, 20));
		g.setColor(new Color(255, 255, 255, (int)alpha));
		g.drawString(s, (GamePanel.WIDTH  +(int) length)/ 2, GamePanel.HEIGTH / 2);
	}
	
}
