package ru.medev.bublershooter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics2D;

public class Enemy 
{
	//Поле
	
	private double x;
	private double y;
	private int r;
	
	private double speed;
	private double dx;
	private double dy;
	
	private double health;
	
	private Color color;
	
	private int type;
	private int rank;
	
	//Конструктор
	
	public Enemy(int type, int rank)
	{
		this.type = type;
		this.rank = rank;
		
		switch(type)
		{
			case 1:
			{
				
				switch(rank)
				{
					case 1:
					{						
						x = Math.random() * GamePanel.WIDTH;
						y = 0;
						
						r = 5;
						
						speed = 5;
						
						color = Color.BLACK;
						health = 1;
						
						double angle = Math.toRadians(Math.random() * 360);
						
						dx = Math.sin(angle) * speed;
						dy = Math.cos(angle) * speed;
						break;
					}
					case 2:
					{
						x = Math.random() * GamePanel.WIDTH;
						y = 0;
						
						r = 25;
						
						speed = 15;
						
						color = Color.BLUE;
						health = 20;
						
						double angle = Math.toRadians(Math.random() * 360);
						
						dx = Math.sin(angle) * speed;
						dy = Math.cos(angle) * speed;
						break;
					}
				}
			}
			/*case 2:
			{
				
			}*/
		}
	}
	
	//Функции
	
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public int getR()
	{
		return r;
	}
	
	public boolean remove()
	{
		if (health <= 0)
		{
			return true;
		}
		return false;
	}
	
	public void hit()
	{
		health--;
	}
	
	public void update ()
	{
		x += dx;
		y += dy;
		
		if (x < 0 && dx < 0)
		{
			dx = -dx;
		}
		if (x > GamePanel.WIDTH && dx < GamePanel.HEIGTH)
		{
			dx = -dx;
		}
		if (y < 0 && dy < 0)
		{
			dy = -dy;
		}
		if (y > GamePanel.HEIGTH - Statistics.HEIGHT && dy < GamePanel.HEIGTH - Statistics.HEIGHT)
		{
			dy = -dy;
		}
	}
	public void draw (Graphics2D g)
	{
		g.setColor(color);
		g.fillOval((int)(x - r), (int)(y - r), 2 * r, 2 * r);
		g.setStroke(new BasicStroke(3));
		g.setColor(color.darker());
		g.drawOval((int)(x - r), (int)(y - r), 2 * r, 2 * r);
		g.setStroke(new BasicStroke(1));
	}
}
