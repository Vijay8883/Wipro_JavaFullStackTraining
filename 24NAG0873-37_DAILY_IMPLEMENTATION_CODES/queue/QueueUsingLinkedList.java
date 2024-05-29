package com.queue;

public class QueueUsingLinkedList {
class Node{
	int data;
	Node next;
	Node(int val)
	{
		data=val;
		next=null;
	}
	
}
Node front,rear;
QueueUsingLinkedList()
{
	front=null;
	rear=null;
}
public void enqueue(int val)
{
	Node newNode=new Node(val);
	if(front==null)
		front=newNode;
	else
		rear.next=newNode;
	rear=newNode;
	
}
public int dequeue()
{
	if(front==null)
	throw new IndexOutOfBoundsException("Queue is empty");
	int temp=front.data;
	front=front.next;
	if(front==null)
		rear=null;
	return temp;
		
}
public boolean isEmpty()
{
	return front==null;
	
	}
public int elementAtFront()
{
	if(front==null)
	
	throw new IndexOutOfBoundsException("Queue is empty");
	return front.data;
}
}
