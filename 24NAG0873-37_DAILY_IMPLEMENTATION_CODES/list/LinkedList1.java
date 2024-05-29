package com.list;
import java.util.Iterator;
 
/*
* Linked List
*
* Insert at Beginning
* Display
* Insert at any pos
* Delete at any pos
*
* generics
*/
public class LinkedList1<T>  {
	Node head;
	
	class Node{
		T data;
		Node next;	
		Node(T val){
			data = val;
			next = null;
		}
	}
	LinkedList1(){
		head = null;
	}
	public void insertAtBeginning(T val){
		Node newNode = new Node(val);
		//when list empty
		if(head==null)
			head = newNode;
		else { //list is not empty
			newNode.next = head;	
			head = newNode;
		}	
		
	}
	
	public void display() {
		Node temp = head; //start from head
		while(temp != null) { //null implies end of list
			System.out.print( temp.data );
			temp = temp.next; //jump
		}
		
	}
	public void insertAtPos(int pos,T val) {
		if(pos==0)
		{
			insertAtBeginning(val);
			return;
		}
		
		Node newNode = new Node(val);
		Node temp = head;
		for(int i=1;i<=pos-1;i++) { //jump to prev node
			temp = temp.next;
			if(temp==null)
				throw new IndexOutOfBoundsException("Invalid Pos " + pos);
		}
		//reassign pointers
				newNode.next = temp.next;
				temp.next = newNode;
		
}
	
	
public void deleteAtPos(int pos) {
		
		if(head==null)
			throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
	
		if(pos==0) {
			head = head.next;
			return;
		}
		
		Node temp = head;
		Node prev = null;
		
		//jump till node to be deleted
		for(int i=1;i<=pos;i++) {
			prev = temp; //keep track of prev node
			temp = temp.next; //jump to next node
		}
		
		prev.next = temp.next; //reassign pointers
	}
 
public void deleteAtBeginning() {
	
	if(head==null)
		throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
 
	head = head.next;
}
}