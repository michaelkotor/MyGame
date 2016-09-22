package ru.medev.bublershooter;

import java.awt.*;

public class Player 
{
	//Поле
	
	private double x;
	private double y;
	
	private double dx; //Кофицеэнт смешения
	private double dy;
	
	private int r;
	private Color color1;
	private Color color2;
	
	private int speed;
	private double health;
	
	public static boolean up;
	public static boolean down;
	public static boolean left;
	public static boolean right;
	
	public static boolean isFiring;
	public static boolean isFiring2;
	
	public static Recharge recharge;
	
	//Конструктор
	
	public Player()
	{
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGTH / 2;
		
		r = 50;
		
		speed = 15;
		health = 3;
		
		dx = 0;
		dy = 0;
		 
		color1 = Color.WHITE;
		
		up = false;
		down = false;
		left = false;
		right = false;
		
		isFiring = false;
		isFiring2 = false;
		
		recharge = new Recharge();
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
	
	public void hit()
	{
		health--;
		
	}
	
	public void update()
	{
		if(up && y > r)
		{
			dy = -speed;
		}
		if(down && y < GamePanel.HEIGTH - r - Statistics.HEIGHT)
		{
			dy = speed;
		}
		if(left && x > r)
		{
			dx = -speed;
		}
		if(right && x < GamePanel.WIDTH - r)
		{
			dx = speed;
		}
		if (up && left || up && right || down && left || down && right)
		{
			double angle = Math.toRadians(45);
			dy = dy * Math.sin(angle);
			dx = dx * Math.cos(angle);
		}
		
		y += dy;
		x += dx;
		
		dy = 0;
		dx = 0;
		
		if (isFiring)
		{
			if (recharge.numShot1 < 30)
			{
				GamePanel.bullets.add(new Bullet(1));
				recharge.numShot1++;
			}
			if (recharge.numShot1 == 30)
			{
				GamePanel.bullets.add(new Bullet(1));
				recharge.numShot1++;
				recharge.update1();
			}
		}
		if (isFiring2)
		{
			if (recharge.numShot2 < 2)
			{
				GamePanel.bullets.add(new Bullet(2));
				recharge.numShot2++;
			}
			if (recharge.numShot2 == 2)
			{
				GamePanel.bullets.add(new Bullet(2));
				recharge.numShot2++;
				recharge.update2();
			}
		}
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(color1);
		g.fillOval((int) (x - r), (int)(y - r), 2 * r, 2 * r);
		g.setStroke(new BasicStroke(3));
		g.setColor(color1.darker());
		g.drawOval((int) (x - r), (int)(y - r), 2 * r, 2 * r);
		g.setStroke(new BasicStroke(1));
	}
}