package com.stack;

public class StackUsingArrays {
	char[] s=new char[10];
	int tos;
	StackUsingArrays()
	{
		tos=-1;
	}
	void push(char item)
	{
		if(tos==9)
		{
			System.out.println("Stack is Full");
		}
		else
		{
			s[++tos]=item;
	
		}
	}
	char pop()
	{
		if(tos>=0)
		{
		return s[tos--];
			
		}
			else
			{
				System.out.println("Stack is empty");
		        return 0;
			}
	}
	char peek()
	{
		return s[tos];
	}

boolean isEmpty()
{
	return tos==-1;
}
}
