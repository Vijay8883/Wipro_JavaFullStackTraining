package com.stack;

public class StackDemo {
	public static void main(String[] args)
	{
		StackUsingArrays s1=new StackUsingArrays();
		s1.push('a');
		s1.push('e');
		s1.push('i');
		s1.push('o');
		s1.push('u');
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		System.out.println(s1.isEmpty());
		
	}

}
