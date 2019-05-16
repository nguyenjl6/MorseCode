
/****************************************************************************
* Project 5
****************************************************************************
* The BSTNode class will have functions of a binary search tree that will sort based on comparing keys
*_____________________________________________________
* Johnny Nguyen
* April 30, 2019
* CMSC 256 Section 003
****************************************************************************/
public class BSTNode<K extends Comparable<K>,V> extends BinaryNode<K,V>{
	
	/**
	 * Default Constructor to set the values of the nodes to null
	 */
	public BSTNode() {
		super(null, null);
	}
	
	/**
	 * Parameterized constructors to set the key and value of the node
	 */
	public BSTNode(K aKey, V aValue) {
		super(aKey, aValue);
	}
	
	/**
	 *  Parameterized constructors to set the key, value, left child, and right child of the node
	 */
	public BSTNode(K aKey, V aValue, BinaryNode<K,V> aLeft, BinaryNode<K,V> aRight){
		super(aKey,aValue,aLeft,aRight);
	}

	/**
	 * Add a node to the tree based on the key and the value given by passing the current root
	 */
	public void add(K aKey, V aValue) {
		add(aKey,aValue,this);
	}
	
	/**
	 * Adds a node to the current rooted tree based on the comparators of the object.
	 */
	private void add(K aKey, V aValue, BinaryNode<K,V> root) {	
		
		BinaryNode<K,V> newNode = new BinaryNode<K,V>(aKey, aValue); // Create a node with the key and the value
		
		if(aKey.compareTo(root.key) < 0) { // Compare the key to the current root value
			if (root.left != null) { // if there is a left child of the current node, recursively call with a reference to the left child
				add(aKey, aValue, root.left);
			}
			else {
				root.left = newNode; // else add the new node as the left child of the current node
			}
		}
		
		else if(aKey.compareTo(root.key) > 0) { // Compare the key to the current root value
			
			if (root.right != null) { //If there is a right child of the current node, recursively call with a reference to the right child
				add(aKey, aValue, root.right);
			}
			else {
				root.right = newNode; // else add the new node as the right child of the current node
			}
		}
		else {
			throw new IllegalStateException("All keys must be unique"); // Throw an IllegalStateException if there is already a key in the tree
		}
	}
	
	/**
	 * Searches for the key in the tree
	 */
	public V search(K aKey) {
		return search(aKey,this);
	}
	
	/**
	 * Searches for the key in the tree of the current root, return the value if the key was found
	 */
	private V search(K aKey,BinaryNode<K,V> root) {
		
		if(root == null) { // If there is nothing in the tree, return null
			return null;
		}
		
		else if (aKey.compareTo(root.key) < 0) { // If the key is less than the current node, move left
			return search(aKey, root.left);
		}
		if(aKey.compareTo(root.key) > 0)  {
			return search(aKey, root.right); // If the key is greater than the current node, move right

		}
		else { 
			return root.value; // Once found, return the value of the key
		}
	}
	
	/**
	 * Remove a node from the tree given a key
	 */
	public V remove(K aKey) {
		return remove(aKey,this,null,true);
	}
	
	/**
	 * Remove the node in the tree given the key with references to the current node, parent node, and to check if the call moved left/right
	 */
	private V remove(K aKey, BinaryNode<K,V> root, BinaryNode<K,V> parent, boolean left) {
		//Use recursion to find the node being removed. If the node is not in the tree return null.
		//Recursive calls keep track of the current node, its parent, 
			//and if the current node is the left or right child of the parent. 
		if(aKey.compareTo(root.key) < 0) {
			if(root.left != null) {
				return remove(aKey, root.left, root, true);
			}
			else {
				return null;
			}
			
		}
		else if(aKey.compareTo(root.key) > 0) {
			if (root.right != null) {
				return remove(aKey, root.right, root, false);
			}
			else {
				return null;
			}
		}
		//This condition is only reached when the node to be removed is found. 
		else {
			//newChild is the node replacing the removed node. 
			//More formally, it is the new child of the removed nodes parent. 
				//Which child (left or right) is determined by the left parameter. 
			BinaryNode <K,V> newChild = null;
			//Here we implement our removal algorithms
			//In the following code the "root" is the node being removed
			//If the root has no children, the newChild is null
			if(root.left == null && root.right == null) {
				newChild = null;
			}
			//If the root has both a left and right child...
			else if(root.left != null && root.right != null) {
				
				BinaryNode<K, V> smallNode = root.right;
				BinaryNode<K, V> parentNode = root;

				//We find the smallest node in the removed nodes right subtree
				
				//If the root of the removed nodes right subtree is the smallest value in the subtree
					//Set the removed node's right child to its right grand-child. 

				if (smallNode.left == null) {
					root.right = smallNode.right;
				}

				//Else, find the smallest value in the removed nodes right subtree 
					//When the smallest node is found, take its right subtree and make it it's parents left child.
					//If the smallest node does not have a right subtree, then we make its parents left child null.
					//This is done to remove the smallest node from the tree (so it doesn't show up twice)

				else {
					
					while (smallNode.left != null) {
						parentNode = smallNode;
						smallNode = smallNode.left;
					}
				
					if (smallNode.right != null) {
						parentNode.left = smallNode.right;
					}
					else {
						parentNode.left = null;
					}
					
					
				}
				
				newChild = smallNode;

				//Make the newChild's children the children of the removed node
	
				newChild.right = root.right;
				newChild.left = root.left;
				
	
				
			}
			
			//If the root has a left child, make the new child the root's left child
			else if(root.left != null && root.right == null) {
				newChild = root.left;
			}
			//If the root has a right child, make the new child the roots' right child
			else if(root.right != null && root.left == null) {
				newChild = root.right;
			}
			
			//Edge case for handling the removal of the root
			if(parent == null) {
				if(newChild == null) {
					throw new IllegalStateException("Can't remove root from tree of height zero");
				}
				
				V toReturn = root.value;
				this.key = newChild.key; this.value = newChild.value; this.left = newChild.left; this.right = newChild.right;
				return toReturn;
			}
			
			//Replace the root (node being removed) with the new child. 
			//We have both a reference to the removed node's parent and a boolean indicating if the removed node is a 
				//left or right child
			if(left) {parent.left = newChild;}
			else {parent.right = newChild;}
			return root.value;
		}
		
		

	}

}