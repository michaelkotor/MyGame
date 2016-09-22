package ru.medev.bublershooter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Menu
{
	//Поле
	
	private int buttonWidth;
	private int buttonHeigth;
	private Color color1;
	
	private String s;
	
	private int transp = 0;
	
	//Конструктор
	
	public Menu()
	{
		buttonWidth = 300;
		buttonHeigth = 150;
		
		color1 = Color.WHITE;
		
		s = "Play";
	}
	
	//Функции
	
	public void update()
	{
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2 &&
				GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2 &&
				GamePanel.mouseY > GamePanel.HEIGTH / 2 - buttonHeigth / 2 &&
				GamePanel.mouseY < GamePanel.HEIGTH / 2 + buttonHeigth / 2)
		{
			transp = 60;
			if (GamePanel.leftMouse)
			{
				GamePanel.state = GamePanel.STATES.PLAY;
			}
		}
		else
		{
			transp = 0;
		}
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(color1);
		g.setStroke(new BasicStroke(3));
		g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2, 
				GamePanel.HEIGTH / 2 - buttonHeigth / 2, buttonWidth, buttonHeigth);
		g.setColor(new Color(255, 255, 255, transp));
		g.fillRect(GamePanel.WIDTH / 2 - buttonWidth / 2, 
				GamePanel.HEIGTH / 2 - buttonHeigth / 2, buttonWidth, buttonHeigth);
		g.setStroke(new BasicStroke(1));
		g.setColor(color1);
		g.setFont(new Font("Consolas", Font.BOLD, 40));
		long length = (int)(g.getFontMetrics().getStringBounds(s, g).getWidth());
		g.drawString(s, (int)(GamePanel.WIDTH / 2 - length / 2), (int)(GamePanel.HEIGTH / 2 + buttonHeigth / 4));
	}
}
