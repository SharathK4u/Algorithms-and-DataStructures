package com.skdamoda.tree;
import java.io.*;

class Node{
    int key;
    Node left,right;
    
    Node(int key){
        this.key=key;
        left=right=null;
    }
}

class BinaryTree{
    Node root;
    
    BinaryTree(){
        root=null;
    }
    
    BinaryTree(int key){
        root=new Node(key);
    }
    
    void printPreOrder(Node node){
        if(node==null)
            return;
        System.out.println(node.key);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    
    int height(Node node){
        if(node==null){
            return 0;
        }
        else{
            int lheight=height(node.left);
            int rheight=height(node.right);
            
            lheight=lheight+1;
            rheight=rheight+1;
            
            if(lheight>rheight)
                return lheight;
            else
                return rheight;
        }
    }
    
    void printGivenLevel(Node node,int level){
        if(node==null){
            return;
        }
        if(level==1)
            System.out.println(node.key);
        else if(level>1)
            printGivenLevel(node.left,level-1);
            printGivenLevel(node.right,level-1);
            
    }
    void printLevelOrder(Node node){
        int height = height(node);
        for(int i=1;i<=height;i++)
            printGivenLevel(node,i);
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree(1);
        bt.root.left=new Node(2);
        bt.root.right=new Node(3);
        bt.root.left.left=new Node(4);
        bt.root.left.right=new Node(5);
        bt.printPreOrder(bt.root);
        
        System.out.println("The height is"+bt.height(bt.root));
        
        bt.printLevelOrder(bt.root);
    }
}