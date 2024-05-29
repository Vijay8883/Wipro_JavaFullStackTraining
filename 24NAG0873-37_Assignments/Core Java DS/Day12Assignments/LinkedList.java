package Day12Assignments;

public class LinkedList {
Node head;

class Node{

   int data;
    Node next;
      Node(int d) {
     data=d;
     next=null;
}

 }
void printMiddle() {
Node first=head;
Node second=head;

if(head!=null) {

while(second!=null && second.next!=null) {

second=second.next.next;

first=first.next;
}
System.out.println(first);

 }

 }
public void push(int new_data)
{
	Node new_node=new Node(new_data);
	new_node.next=head;
	head=new_node;
}

public void printList() {

Node tnode=head;

while(tnode!=null) {
	System.out.println(tnode.data);
     tnode=tnode.next;

}
System.out.println("Null");

}

public static void main(String[] args) {
	LinkedList ls=new LinkedList();

for(int i=5;i>0;--i) {

ls.push(i);

ls.printMiddle();
	
}
ls.printList();

}
}

