import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BSTNodeTest {
	
	@Test
	@GradedTest(name="Test add 8 tree (10)", max_score=0.625)
	public void testAddT0() {
		Integer[] givenKeys = {10};
		String[] givenValues = {"10"};
		
		Integer[] expectedKeys = {10,8,null};
		String[] expectedValues = {"10","8",null};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(8, "8");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}

	@Test
	@GradedTest(name="Test add 16 tree (10,8)", max_score=0.625)
	public void testAddT1() {
		Integer[] givenKeys = {10,8,null};
		String[] givenValues = {"10","8",null};
		
		Integer[] expectedKeys = {10,8,16};
		String[] expectedValues = {"10","8","16"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(16, "16");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Test add 5 tree (10,8,16)", max_score=0.625)
	public void testAddT2() {
		Integer[] givenKeys = {10,8,16};
		String[] givenValues = {"10","8","16"};
		
		Integer[] expectedKeys = {10,8,16,5,null};
		String[] expectedValues = {"10","8","16","5",null};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(5, "5");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Test add 9 tree (10,8,16,5)", max_score=0.625)
	public void testAddT3() {
		Integer[] givenKeys = {10,8,16,5,null};
		String[] givenValues = {"10","8","16","5",null};
		
		Integer[] expectedKeys = {10,8,16,5,9};
		String[] expectedValues = {"10","8","16","5","9"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(9, "9");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Test add 13 tree (10,8,16,5,9)", max_score=0.625)
	public void testAddT4() {
		Integer[] givenKeys = {10,8,16,5,9};
		String[] givenValues = {"10","8","16","5","9"};
		
		Integer[] expectedKeys = {10,8,16,5,9,13,null};
		String[] expectedValues = {"10","8","16","5","9","13",null};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(13, "13");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Test add 20 tree (10,8,16,5,9,13)", max_score=0.625)
	public void testAddT5() {
		Integer[] givenKeys = {10,8,16,5,9,13,null};
		String[] givenValues = {"10","8","16","5","9","13",null};
		
		Integer[] expectedKeys = {10,8,16,5,9,13,20};
		String[] expectedValues = {"10","8","16","5","9","13","20"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(20, "20");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}

	@Test
	@GradedTest(name="Test add 7 tree (10,8,16,5,9,13,20)", max_score=0.625)
	public void testAddT6() {
		Integer[] givenKeys = {10,8,16,5,9,13,20};
		String[] givenValues = {"10","8","16","5","9","13","20"};
		
		Integer[] expectedKeys = {10,8,16,5,9,13,20,null,7};
		String[] expectedValues = {"10","8","16","5","9","13","20",null,"7"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(7, "7");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Test add 28 tree (10,8,16,5,9,13,20,null,7)", max_score=0.625)
	public void testAddT7() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7"};
		
		Integer[] expectedKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] expectedValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.add(28, "28");
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}

	
	@Test
	@GradedTest(name="Test search 28 tree (10,8,16,5,9,13,20,null,7,null,null,null,null,null,28)", max_score=1.25)
	public void testSearchT0() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		assertEquals("28",root.search(28));
	}
	
	@Test
	@GradedTest(name="Test search 7 tree (10,8,16,5,9,13,20,null,7,null,null,null,null,null,28)", max_score=1.25)
	public void testSearchT1() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		assertEquals("7",root.search(7));
	}
	
	@Test
	@GradedTest(name="Test search 10 tree (10,8,16,5,9,13,20,null,7,null,null,null,null,null,28)", max_score=1.25)
	public void testSearchT2() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		assertEquals("10",root.search(10));
	}
	
	@Test
	@GradedTest(name="Test search 50 tree (10,8,16,5,9,13,20,null,7,null,null,null,null,null,28)", max_score=1.25)
	public void testSearchT3() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		assertEquals(null,root.search(50));
	}

	@Test
	@GradedTest(name="Remove node with no children (13)", max_score=0.833)
	public void testRemoveT0() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		Integer[] expectedKeys = {10,8,16,5,9,null,20,null,7,null,null,null,null,null,28};
		String[] expectedValues = {"10","8","16","5","9",null,"20",null,"7",null,null,null,null,null,"28"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.remove(13);
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	   
	@Test
	@GradedTest(name="Remove node with no children (7)", max_score=0.833)
	public void testRemoveT1() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		Integer[] expectedKeys = {10,8,16,5,9,13,20,null,null,null,null,null,null,null,28};
		String[] expectedValues = {"10","8","16","5","9","13","20",null,null,null,null,null,null,null,"28"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.remove(7);
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}

	@Test
	@GradedTest(name="Remove node with one right child (20)", max_score=0.833)
	public void testRemoveT2() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		Integer[] expectedKeys = {10,8,16,5,9,13,28,null,7,null,null,null,null,null,null};
		String[] expectedValues = {"10","8","16","5","9","13","28",null,"7",null,null,null,null,null,null};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.remove(20);
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Remove node with one left child (3 no 7)", max_score=0.833)
	public void testRemoveT3() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,3,null,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20","3",null,null,null,null,null,null,"28"};
		
		Integer[] expectedKeys = {10,8,16,3,9,13,20,null,null,null,null,null,null,null,28};
		String[] expectedValues = {"10","8","16","3","9","13","20",null,null,null,null,null,null,null,"28"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.remove(5);
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Remove node with two children (8)", max_score=0.833)
	public void testRemoveT4() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		Integer[] expectedKeys = {10,9,16,5,null,13,20,null,7,null,null,null,null,null,28};
		String[] expectedValues = {"10","9","16","5",null,"13","20",null,"7",null,null,null,null,null,"28"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.remove(8);
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	@Test
	@GradedTest(name="Remove node with two children (10)", max_score=0.833)
	public void testRemoveT5() {
		Integer[] givenKeys = {10,8,16,5,9,13,20,null,7,null,null,null,null,null,28};
		String[] givenValues = {"10","8","16","5","9","13","20",null,"7",null,null,null,null,null,"28"};
		
		Integer[] expectedKeys = {13,8,16,5,9,null,20,null,7,null,null,null,null,null,28};
		String[] expectedValues = {"13","8","16","5","9",null,"20",null,"7",null,null,null,null,null,"28"};

		BSTNode<Integer,String> root = createList(givenKeys,givenValues);
		root.remove(10);
		validateTreeState(createList(expectedKeys,expectedValues),root);
	}
	
	
	private <K extends Comparable<K>,V> BSTNode<K,V> createList(K[] keys, V[] values) {
		if(keys.length != values.length) {
			throw new IllegalStateException();
		}
		//Create nodes and link them
		BSTNode<K,V> root = null;
		BinaryNode<K,V> currentNode = null;
		if(keys.length > 0) {
			root = new BSTNode<K,V>(keys[0],values[0]);
			LinkedList<BinaryNode<K,V>> queue = new LinkedList<BinaryNode<K,V>>();
			queue.add(root);
			
			for(int i = 1; i < keys.length; i = i + 2) {
				currentNode = queue.removeFirst();
				BinaryNode<K,V> leftChild = (keys[i] == null) ? null : new BinaryNode<K,V>(keys[i],values[i]);
				BinaryNode<K,V> rightChild = (keys[i+1] == null) ? null : new BinaryNode<K,V>(keys[i+1],values[i+1]);
				if(currentNode != null) {
					currentNode.left = leftChild;
					currentNode.right = rightChild;
					queue.add(leftChild);
					queue.add(rightChild);
				}
			}
		}
		return root;
	}

	private <K extends Comparable<K>,V> void validateTreeState(BSTNode<K,V> expected, BSTNode<K,V> actual) {
		BinaryNode<K,V> currentNode = null;
		ArrayList<BinaryNode<K,V>> expectedTree = new ArrayList<BinaryNode<K,V>>();
		ArrayList<BinaryNode<K,V>> actualTree = new ArrayList<BinaryNode<K,V>>();
		LinkedList<BinaryNode<K,V>> queue = new LinkedList<BinaryNode<K,V>>();
		queue.add(expected);
		

		while(!queue.isEmpty()){
			currentNode = queue.removeFirst();
			expectedTree.add(currentNode);
			if(currentNode != null) {
				BinaryNode<K,V> leftChild = currentNode.left;
				BinaryNode<K,V> rightChild = currentNode.right;
				if(leftChild  != null) {queue.add(leftChild);}
				if(rightChild != null) {queue.add(rightChild);}
			}
		}
		
		queue.add(actual);
		while(!queue.isEmpty()){
			currentNode = queue.removeFirst();
			actualTree.add(currentNode);
			if(currentNode != null) {
				BinaryNode<K,V> leftChild = currentNode.left;
				BinaryNode<K,V> rightChild = currentNode.right;
				if(leftChild  != null) {queue.add(leftChild);}
				if(rightChild != null) {queue.add(rightChild);}
			}
		}
		
		//Queues should be same size 
		assertEquals("When checking the number of nodes in the tree, we",expectedTree.size(),actualTree.size());
		for(int i = 0; i < actualTree.size(); i++) {
			assertEquals("When checking a given nodes key, we", expectedTree.get(i).key,actualTree.get(i).key);
			assertEquals("When checking the value of node with key "+ expectedTree.get(i).key + ", we", expectedTree.get(i).value,actualTree.get(i).value);
			assertEquals("When checking the left child of node with key "+ expectedTree.get(i).key + ", we", expectedTree.get(i).left,actualTree.get(i).left);
			assertEquals("When checking the right child of node with key "+ expectedTree.get(i).key + ", we", expectedTree.get(i).right,actualTree.get(i).right);
		}
		
	}
	

	   
	
	
}
