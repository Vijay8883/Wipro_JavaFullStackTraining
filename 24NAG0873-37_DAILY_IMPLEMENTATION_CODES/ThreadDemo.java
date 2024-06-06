package com.thread;

class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=3;i++)
		{
			System.out.println("Child Thread "+i);
		}
	}
}

public class ThreadDemo { 
	public static void main(String[] args) {
		MyThread t=new MyThread();
		t.start();
		for(int i=1;i<=3;i++)
		{
			System.out.println("Main Thread "+i);
		}
	}

}
