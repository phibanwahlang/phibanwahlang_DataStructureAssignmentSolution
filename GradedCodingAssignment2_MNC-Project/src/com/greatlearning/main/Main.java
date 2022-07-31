package com.greatlearning.main;

class Node {
	  int item;
	  Node left, right;

	  public Node(int key) {
	  item = key;
	  left = right = null;
	  }
	}

public class Main {
	Node node;
	
	Main(){
		node = null;
	}
	void inOrder(Node node) {
	    if (node == null)
	      return;
	    
	    inOrder(node.left);

	    System.out.print(node.item + " ");

	    inOrder(node.right);
	  }
	
	public static void main(String[] args) {
		Main tree = new Main();
		tree.node=new Node(50);
		tree.node.left=new Node(30);
		tree.node.right=new Node(60);
		tree.node.left.left=new Node(10);
		tree.node.right.left=new Node(55);
		tree.inOrder(tree.node);
	}

}
