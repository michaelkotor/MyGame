package ru.medev.bublershooter;

import java.util.Timer;

public class Recharge 
{
	//����
	
	public int numShot1;
	public int numShot2;
	
	 public static Timer timer = new Timer();

	//�����������
	
	public Recharge()
	{
		numShot1 = 0;
		numShot2 = 0;
	}
	
	//�������
	public void update1()
	{
		new Thread(new Runnable() {
            public void run() {
                while(true) { //���������� ������
                    try {
                        Thread.sleep(4000); // 4 ������� � ������������
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
                while(true) { //���������� ������
                    try {
                        Thread.sleep(15000); // 4 ������� � ������������
                        numShot2 = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
	}
}
