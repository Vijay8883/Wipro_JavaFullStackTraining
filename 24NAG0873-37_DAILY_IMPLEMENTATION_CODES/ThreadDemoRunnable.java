package com.thread;
class MyRunnable implements Runnable
{
	public void run()
	{
		for(int i=1;i<=3;i++)
		{
			System.out.println("Child Thread "+i);
		}
	}
}
public class ThreadDemoRunnable {
public static void main(String[] args) {
	MyRunnable r=new MyRunnable();
	Thread t=new Thread(r);
	t.start();
	for(int i=1;i<=3;i++)
	{
		System.out.println("Main Thread "+i);
	}
	
}
}
