// Java program to construct a tree using inorder
// and postorder traversals

/* A binary tree node has data, pointer to left
child and a pointer to right child */
class Node 
{
	int data;
	Node left, right;

	public Node(int data) 
	{
		this.data = data;
		left = right = null;
	}
}

// Class Index created to implement pass by reference of Index
class Index 
{
	int index;
}

class BinaryTree 
{
	/* Recursive function to construct binary of size n
	from Inorder traversal in[] and Preorder traversal


	/* This funtcion is here just to test */
	void preOrder(Node node) 
	{
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
		
		
	}
	Node buildUtil(int [] in, int [] pre, int startInd,int endInd,Index pIndex){
	    if(startInd>endInd)
	        return null;
	    Node node = new Node(pre[pIndex.index]);
	    pIndex.index++;
	    if(startInd==endInd){
	        return node;
	    }
	    int iIndex=findIndex(in,startInd,endInd,node.data);
	    node.left=buildUtil(in,pre,startInd,iIndex-1,pIndex);
	    node.right=buildUtil(in,pre,iIndex+1,endInd,pIndex);
	    return node;
	}
	
	int findIndex(int [] in, int start,int end, int value){
	    int i;
	    for(i=start;i<end;i++){
	        if(in[i]==value)
	            break;
	    }
	    return i;
	}
	
	Node buildTree(int [] in, int [] pre, int n){
	    Index pIndex = new Index();
	    pIndex.index=0;
	    return buildUtil(in,pre,0,n-1,pIndex);
	}

	public static void main(String[] args) 
	{
		BinaryTree tree = new BinaryTree();
		int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
		int pre[] = new int[]{1,2,4,8,5,3,6,7};
		int n = in.length;
		Node root = tree.buildTree(in, pre, n);
		System.out.println("PostOrder of the constructed tree : ");
		tree.preOrder(root);
	}
}

// This code has been contributed by Mayank Jaiswal(mayank_24)
