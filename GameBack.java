package ru.medev.bublershooter;

import java.awt.*;

public class GameBack 
{
	//Поля
	
	private Color color;
	
	//Констркторы
	
	public GameBack()
	{
		color = Color.RED;
	}
	
	//Функции
	
	public void update()
	{
		
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(color);
		
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGTH);
	}
	
}