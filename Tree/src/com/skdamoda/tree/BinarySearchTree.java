package com.skdamoda.tree;

class Node{
	int key;
	Node left,right;
	Node(int key){
		this.key=key;
		left=right=null;
	}
}

public class BinarySearchTree {
	
	Node root;

	BinarySearchTree(){
		root=null;
	}
	BinarySearchTree(int key){
		root=new Node(key);
	}
	
	private void insert(Node root,Node child) {
		if (root==null) {
			root= child;
		}
		else if(root.key>child.key) {
			if(root.left!=null)
				insert(root.left,child);
			else
				root.left=child;
		}
		else {
			if(root.right!=null)
				insert(root.right,child);
			else
				root.right=child;
		}
	}
	
	public void printInOrder(Node root) {
		if(root!=null) {
		printInOrder(root.left);
		System.out.println(root.key);
		printInOrder(root.right);
		}
	}
	
	public boolean search(Node root,Node node) {
		if(root==null)
			return false;
		else if(root.key==node.key)
			return true;
		else if(root.key>node.key) {
			return search(root.left,node);
		}
		else if(root.key<node.key) {
			return search(root.right,node);
		}
		return false;
	}
	
	public static void main(String [] args) {
		BinarySearchTree bst = new BinarySearchTree(10);
		bst.insert(bst.root, new Node(5));
		bst.insert(bst.root, new Node(6));
		bst.insert(bst.root, new Node(1));
		bst.insert(bst.root, new Node(2));
		bst.insert(bst.root, new Node(8));
		bst.insert(bst.root, new Node(9));
		bst.insert(bst.root, new Node(7));
		bst.insert(bst.root, new Node(3));
		bst.insert(bst.root, new Node(4));
		bst.printInOrder(bst.root);
		int searchKey=11;
		System.out.println("The value"+searchKey+" is present in the tree"+bst.search(bst.root, new Node(searchKey)));
		
	}
	
	
}
