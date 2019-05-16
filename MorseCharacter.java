/****************************************************************************
* Project 5
****************************************************************************
* The MorseCharacter class will store morse codes of a character
*_____________________________________________________
* Johnny Nguyen
* April 30, 2019
* CMSC 256 Section 003
****************************************************************************/
public class MorseCharacter<E> implements Comparable<E>{
	private String character; // morse code of the character


	/**
	 * Default constructor that sets the code of the object to an empty string
	 */
	public MorseCharacter() {
		character = "";
	}
	

	/**
	 * Parameterized constructor to set the morse code of the object
	 */
	public MorseCharacter(String code) {
		this.character = code;
	}
	

	/**
	 * Returns the current morse code in the object
	 */
	public String getCode() {
		return character;
	}
	

	/**
	 * Sets the given code of the morse code object
	 */
	public void setCode(String code) {
		this.character = code;
	}
	

	/**
	 * Return the hash code of the morse code
	 */
	public int hashCode() {
		int hashValue = 0;
		for(int i = 0; i < character.length(); i++ ) {
			hashValue = (hashValue * 31 + character.charAt(i));
			}
		return hashValue;
	}
	

	/**
	 * Check to see if an object is the same as the current morse code object
	 */
	public boolean equals(Object o) {
		if(o == this) { // Check to see if they hold the same value, return true if so
			return true;
		}
		if (!(o instanceof MorseCharacter)) { // Check to see if the object is an instance of MorseCharacter
			return false;
		}
		MorseCharacter comparedObject = (MorseCharacter) o; // Cast the object to MorseCharacter
		
		return this.character.equals(comparedObject.getCode()); //Return the comparison of both codes of the Morse codes
	}

	/**
	 * Return the string representation of the morse code
	 */
	public String toString() {
		return character;
	}


	/**
	 * Compare a morse code object to the current morse code, return 1 if greater, -1, if less, 0 if equal
	 */
	@Override
	public int compareTo(E o) {


		MorseCharacter object = (MorseCharacter) o; // Cast the object to a MorseCharacter
		
		if (this.getCode().compareTo(object.getCode()) > 0 ) { // Compare the two object lexicographically, if it's greater than, then return -1
			if (this.getCode().length() > object.getCode().length() ) { // Second comparison for length, if the length is greater than the object, return 1
				return 1;
			}
			return -1;
		}
		
		else if (this.getCode().compareTo(object.getCode()) < 0) { // Compare the two object lexicographically, if it's less than, return 1
			if (this.getCode().length() < object.getCode().length()) { // Second comparison for length, if the length is less than the object, return -1
				return -1;
			}
			return 1;
		}
		else {
			return 0; // Return 0 if they are equal
		}

	

	
	}
}
