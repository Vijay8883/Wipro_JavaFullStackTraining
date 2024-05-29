package com.tree;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree(50);
		bst.insert(bst.root,20);
		bst.insert(70);
		bst.insert(10);
		bst.insert(25);
		bst.insert(60);
		bst.insert(90);
		bst.insert(80);
		bst.insert(75);
		bst.inOrder(bst.root);
		if(bst.search(bst.root,70)==null)
			System.out.println("Not found");
		else 
			System.out.println("found");
		bst.delete(bst.root, 70);
		bst.inOrder(bst.root);
	}

}
