public class Tree2 extends Tree{
	//Tree traversal algorithms
	//1. Preorder
	public void preOrderTraversal(int p) {
		//recursive approach: current parent node + all left child nodes + all right child nodes
		System.out.print(T[p] + " ");		
		if(hasLeftChild(p)) {
			preOrderTraversal(2*p+1);
		}
		if(hasRightChild(p)) {
			preOrderTraversal(2*p+2);
		}
	}
	
	//2. Inorder
	public void inOrderTraversal(int p) {
		//recursive approach: left child node + parent node + right child node
		 if (hasLeftChild(p))
	        {
	            inOrderTraversal(2*p+1);
	        }

	        System.out.print(T[p] + " ");

	        if (hasRightChild(p))
	        {
	            inOrderTraversal(2*p+2);
	        }
	}
	
	//3. Postorder
	public void postOrderTraversal(int p) {
		//recursive approach: all left child nodes + all right child nodes + current parent node		
		 if (hasLeftChild(p))
	        {
	            postOrderTraversal(2*p+1);

	        }

	        if (hasRightChild(p))
	        {
	            postOrderTraversal(2*p+2);
	        }

	        System.out.print(T[p] + " ");
	}
	
	//4. Breadth-first
	public void breadthFirstTraversal(int p) {
		System.out.print(T[p] + " ");
		if(hasLeftChild(p)) {
			breadthFirstTraversal(2*p+1);
			
			
		}
		if(hasRightChild(p)) {
			breadthFirstTraversal((2*p)+2);
		}
		}


	}