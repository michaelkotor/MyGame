package ru.medev.bublershooter;

import java.awt.*;
public class Bullet 
{
	//Поле
	private double x;
	private double y;
	private int r;
	
	private int rank;
	
	private double bulletDX;
	private double bulletDY;
	
	private double distX;
	private double distY;
	private double dist;
	
	private double speed;
	 
	private Color color;
	
	//Конструктор
	
	public Bullet(int rank)
	{
		switch (rank)
		{
			case 1:
			{
				x = GamePanel.player.getX();
				y = GamePanel.player.getY();
						
				r = 3;
						
				speed = 30;
						
				distX = GamePanel.mouseX - x;
				distY = GamePanel.mouseY - y;
				dist = Math.sqrt(distX * distX + distY * distY);
					
				bulletDX = (distX / dist) * speed;
				bulletDY = (distY / dist) * speed;
						
				color = Color.WHITE;
				break;
			}
			case 2:
			{
				x = GamePanel.player.getX();
				y = GamePanel.player.getY();
						
				r = 15;
						
				speed = 3;
						
				distX = GamePanel.mouseX - x;
				distY = GamePanel.mouseY - y;
				dist = Math.sqrt(distX * distX + distY * distY);
						
				bulletDX = (distX / dist) * speed;
				bulletDY = (distY / dist) * speed;
						
				color = Color.WHITE;
				break;
			}
		}
	} 
	 
	//Методы
	
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
		if (y < 0 || y > GamePanel.HEIGTH || x < 0 || x > GamePanel.HEIGTH)
		{
			return true;
		}
		return false;
	}
	
	public void update()
	{
		y += bulletDY;
		x += bulletDX;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(color);
		g.fillOval((int) x, (int) y, 2 * r, 2 * r);
	}
	
}
