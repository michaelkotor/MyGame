package ru.medev.bublershooter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Listeners implements KeyListener, MouseMotionListener, MouseListener
{
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP)
		{
			Player.up = true;
		}
		if (key == KeyEvent.VK_DOWN)
		{
			Player.down = true;
		}
		if (key == KeyEvent.VK_LEFT)
		{
			Player.left = true;
		}
		if (key == KeyEvent.VK_RIGHT)
		{
			Player.right = true;
		}
		if (key == KeyEvent.VK_SPACE)
		{
			Player.isFiring = true;
		}
		if (key == KeyEvent.VK_V)
		{
			Player.isFiring2 = true;
		}
		if (key == KeyEvent.VK_ESCAPE)
		{
			GamePanel.state = GamePanel.STATES.MENU;
		}
	}
	
	public void keyTyped(KeyEvent e) 
	{

	}
	// keyReleased
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP)
		{
			Player.up = false;
		}
		if (key == KeyEvent.VK_DOWN)
		{
			Player.down = false;
		}
		if (key == KeyEvent.VK_LEFT)
		{
			Player.left = false;
		}
		if (key == KeyEvent.VK_RIGHT)
		{
			Player.right = false;
		}
		if (key == KeyEvent.VK_SPACE)
		{
			Player.isFiring = false;
		}
		if (key == KeyEvent.VK_V)
		{
			Player.isFiring2 = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.player.isFiring = true;
			GamePanel.leftMouse = true;
		}
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			GamePanel.player.isFiring2 = true;
			GamePanel.rigthMouse = true;
		}
		
	}

	public void mouseReleased(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			GamePanel.player.isFiring = false;
			GamePanel.leftMouse = false;
		}
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			GamePanel.player.isFiring2 = false;
			GamePanel.rigthMouse = false;
		}
		
	}

	public void mouseDragged(MouseEvent e) 
	{
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();
	}
	
	public void mouseMoved(MouseEvent e) 
	{
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();
	}
}