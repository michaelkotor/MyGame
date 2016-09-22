package ru.medev.bublershooter;

import java.util.Timer;

public class Recharge 
{
	//Поле
	
	public int numShot1;
	public int numShot2;
	
	 public static Timer timer = new Timer();

	//Конструктор
	
	public Recharge()
	{
		numShot1 = 0;
		numShot2 = 0;
	}
	
	//Функции
	public void update1()
	{
		new Thread(new Runnable() {
            public void run() {
                while(true) { //бесконечно крутим
                    try {
                        Thread.sleep(4000); // 4 секунды в милисекундах
                        numShot1 = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
	}
	public void update2()
	{
		new Thread(new Runnable() {
            public void run() {
                while(true) { //бесконечно крутим
                    try {
                        Thread.sleep(15000); // 4 секунды в милисекундах
                        numShot2 = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
	}
}
