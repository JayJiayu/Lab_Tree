import java.util.Arrays;

public class Tree {
	// default tree's capacity
	protected final int treeCapacity = 64;
	protected int size = 0;
	// array to keep tree data
	protected int[] T;

	public Tree() {
		T = new int[treeCapacity];
		// fill array with -1
		Arrays.fill(T, -1);
	}

	public Tree(int tSize) {
		T = new int[tSize];
		// fill array with -1
		Arrays.fill(T, -1);
	}

	//is current node a root?
	public boolean isRoot(int p) {
		if (p==0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean hasLeftChild(int p) {
		//is node p=i has a left child?
		if( T[(2*p)+1]> -1 ) {
			return true;// p has left child
		}
		else {
			return false;// p has no left child
		}
	}

	public boolean hasRightChild(int p) {
		//is node p has a right child?
		if(T[(2*p)+2] > -1) {// p has right child
			return true;
		}
		else {
			return false;
		}
	}

	public int getsize() {// getter method
		//return tree's size
		return size;
	}

	public boolean isEmpty() {
		//is tree empty?
		if(size ==0) {// no data
			return true;
		}
		else {
			return false;
		}
	}

	public int getElement(int p) {
		// is node p existed?
		if(T[p]>-1) {
			return T[p];
		}
		else {
			return -999;//no data
		}
	}
	
	public boolean isInternal(int p) {
		// if either left or right child node exists
		if(hasLeftChild(p)||hasRightChild(p)) {// p has some children
			// p is the internal node
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isLeaf(int p) {// p has no children
		// left and right child nodes are blank (-1)
		if(hasLeftChild(p)||hasRightChild(p)) {// p  has children
			return false;// p is not a leaf node
		}
		else {
			// p has no children ==> p is a leaf node
			return true;
		}
	}
	
	public int getParent(int p) {
		//return value of parent node of node p
		if(isRoot(p)) {// p has no parent
			return -999;
		}
		else {
			// (i-1)/2 is location of the parent
			return T[(p-1)/2];
		}

	}
	
	// print all nodes' positions
	public void printAllPositions() {
		System.out.print("\nAll positions are : ");
		for (int i = 0; i < T.length; i++) {// access all element of array
			if(T[i]>-1) {
				System.out.print(i+" ");//show index /address of the node
			}		
		}
		System.out.println();
	}

	// print all nodes' elements (Breadth-First)
	public void printAllElements() {
		System.out.print("\nAll elements are : ");
		for (int i = 0; i < T.length; i++) {// access all element of array
			if(T[i]>-1) {
				System.out.print(T[i]+" ");//show index /address of the node
			}		
		}
		System.out.println();
	}

	public void addRoot(int element) {
		if(size==0) {//Tree is empty
			T[0] = element;
			System.out.println("+++++ Root of T was added");
			size++;
		}
		else {
			System.out.println("Tree is not empty");
		}
	}

	public void addChild(int p, int element) {
		//add left or right
		if(element<T[p]) {// left child
			if(hasLeftChild(p)) {// p already has left child?
				// compare value to the left child
				addChild((2*p)+1,element);// call itself				
			}
			else {// p has no left child
				T[(2*p)+1]=element;
				size++;
				System.out.println("+++++ Left of "+p+" was added!!!");
			}
		}
		else {//right child
			if(hasRightChild(p)) {// p already has left child?
				// compare value to the right child
				addChild((2*p)+2,element);// call itself				
			}
			else {// p has no right child
				T[(2*p)+2]=element;
				size++;
				System.out.println("+++++ Right of "+p+" was added!!!");
			}
		}

	}

	public int getLeftChild(int p) {
		// has left child?
		if(hasLeftChild(p)) {
			return T[(2*p)+1];
		}
		else {
			return -999;
		}
	}

	public int getRightChild(int p) {
		// has right child?
		if(hasRightChild(p)) {
			return T[(2*p)+2];
		}
		else {
			return -999;
		}
	}

	public int getSibling(int p) {
		// p is not a root 
		if(isRoot(p)) {
			return -999;
		}
		else if(p%2==1){// p is left child, then find a right child of the same parent
			// has a value
			if(T[p+1]>-1) {// node  is not empty
				return T[p+1];
			}			
		}
		else if(p%2==0) {// p is right child, then find a left child of the same parent
			return T[p-1];
		}		
		return -999;
	}
}
