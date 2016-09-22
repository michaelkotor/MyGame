package ru.medev.bublershooter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Statistics extends GamePanel
{
	//Поле
	
	private int NumberOfBulletsUsed;
	private int NumberOfBulletsGotIn;
	private double Percent;
	private Color color;
	public static double HEIGHT1;
	
	//Конструктор
	
	public Statistics()
	{
		NumberOfBulletsUsed = 0;
		NumberOfBulletsGotIn = 0;
		Percent = 0;
		color =  Color.WHITE;
		HEIGHT1 = 200;
	}
	
	//Функции
	
	public double GetPercent(double NumberOfBulletsUsed, double NumberOfBulletsGotIn)
	{
		return NumberOfBulletsUsed / NumberOfBulletsGotIn * 100;
		
	}
	
	public void update()
	{
		NumberOfBulletsUsed = bullets.size();
	}

	public void draw(Graphics2D g) 
	{
		g.setColor(color);
		g.fillRect(0, GamePanel.WIDTH - (int)HEIGHT, GamePanel.WIDTH, (int)HEIGHT);
		//System.out.println(Player.time_1);
	}
	
	
}
