package com.queue;

public class QueueDemo {

	public static void main(String[] args) {
		QueueUsingLinkedList q=new QueueUsingLinkedList();
		q.enqueue(5);
		q.enqueue(8);
		q.enqueue(9);
		System.out.println("dequeued "+q.dequeue() );
		System.out.println("dequeued "+q.dequeue() );
		System.out.println("dequeued "+q.dequeue() );
		q.enqueue(5);
		q.enqueue(8);
		System.out.println("dequeued "+q.dequeue() );
		System.out.println("dequeued "+q.dequeue() );
		

	}

}
