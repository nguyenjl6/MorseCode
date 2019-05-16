
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;
/****************************************************************************
* Project 5
****************************************************************************
* The CharacterConverter will be able to decode and encode morse code messages and perform a visualization of the tree.
*_____________________________________________________
* Johnny Nguyen
* April 30, 2019
* CMSC 256 Section 003
****************************************************************************/

public class CharacterConverter{
	private static File morseCode = new File("C:\\Users\\yaizu\\Documents\\Project 5\\src\\CODEFILE.DAT"); // Default File to read in codes
	private BSTNode morseTree = new BSTNode(new MorseCharacter(), ""); // initialize decode tree
	private BSTNode letterTree = new BSTNode("", new MorseCharacter()); // initialize encode tree
	private BSTNode root; // create root by natural sorting of morse code chaacters
	
	/**
	 * Default constructor that calls on the parameterized constructor to put in the default file
	 */
public CharacterConverter() {
		this(morseCode);
	}
	
	/**
	 * Parameterized constructor that takes in a file of letters and their corresponding morse codes
	 */
public CharacterConverter(File aConversionFile) {
		try {
			Scanner reader = new Scanner(aConversionFile); // Create scanner object to read the input file
			String code = "";
			String letter = "";
			root = new BSTNode(new MorseCharacter("Root") , "root"); // initalize root
			
			// Runs through the file and add nodes to trees
			while(reader.hasNext()) {
				letter = reader.next();
				code = reader.next();
				MorseCharacter morseKey = new MorseCharacter(code);
				morseTree.add(morseKey, letter);
				letterTree.add(letter, morseKey);
				sortTree(morseKey, letter, root);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * The method will receive a string of letters and converts them to morse code characters
	 */
public String convertFromEnglish(String anInput) {
		String[] input = anInput.split(""); // splits the string by individual characters
		String output = "";
		int counter = 0;
		while (counter < anInput.length()) {
			output += letterTree.search(input[counter]) + " "; // search the character's morse code and add it to the string
			counter++;
		}
		
		return output.trim();
		
	}

	/**
	 * The method will receive a string of morse codes and converts them to english
	 */
public String convertToEnglish(String anInput) {
		String[] input = anInput.split(" "); // splits the morse codes by spaces
		String output = "";
		int counter = 0;
		while (counter < input.length) {
			MorseCharacter key = new MorseCharacter(input[counter]); // create a MorseCharacter object to hold the code
			output += morseTree.search(key); // search based on the key provided
			counter++;
		}
		return output;
		
	}

	/**
	 *  The method will return an ordered array list of type Morse Character ordered from least to greatest based on the natural
	 *  ordering of morse codes
	 */
public ArrayList<MorseCharacter> getSymbolAlphabet() {
		ArrayList<MorseCharacter> returnArray = new ArrayList<>();
		BSTNode current = root; // Create a reference to the root of the sorted tree
		current.order = current.order.PRE; // Change the traversal to a pre order traversal
		Iterator<BSTNode> preIterator = current.iterator(); // Create an iterator object to run through the nodes in the tree

		while (preIterator.hasNext()) {
			MorseCharacter n = (MorseCharacter) preIterator.next().key; 
			if (!n.getCode().equals("Empty")) { // Avoid empty nodes in the tree because of the order of morse codes
			returnArray.add(n);
			}
		}
		
		returnArray.remove(0); // Remove the default root
		
		return returnArray;
	}

	/**
	 * Create a visualization of the natural ordered tree
	 */
public void visualize() {
		
		Bridges bridges = new Bridges(0, "nguyenjl6", "1016735602304"); // input user data
		bridges.setTitle("CMSC 256 Project 4 Johnny Nguyen"); // set the title of the visualization
		bridges.setDataStructure(root); // create the data structure of the visualization
		try { 
			bridges.visualize();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (RateLimitException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will create the sorted natural ordering of the rooted tree
	 */
private void sortTree(MorseCharacter key, String letter, BSTNode root) {
		String code = key.getCode();  
		BSTNode next = root; // Create the node to traverse through the tree
		BSTNode current = root; // initalize the node to keep track of the traversal node
		
		for (int i = 0; i < code.length(); i ++) { 
			
			current = next; // create a reference to the traversal node in order to prevent null pointers
			
			if (code.charAt(i) == '.') { // traverse to the left if the next character is a '.'
				
				next = (BSTNode) next.left;
				
				if(next == null) {
					next = new BSTNode(new MorseCharacter("Empty"), ""); // if the left child of the current node is null, then create an empty node 
				}
				
				current.left = next; // set the left child of the current node to the traversal node
			}
			
			else if(code.charAt(i) == '-') { // traverse to the right if the next character is a '-'
				
				next = (BSTNode) next.right; 
				
				if (next == null) { 
					next = new BSTNode(new MorseCharacter("Empty"), ""); // if the right child of the current node is null, then create an empty node
				}
				
				current.right = next; // set the right child of the current node to the traversal node
			}
			
		}
		// Once the the end of the index of the length of the code is found by the traversal node, set the traversal node values to the parameterized values
		next.key = key;
		next.value = letter;
		
	}


} // end class
