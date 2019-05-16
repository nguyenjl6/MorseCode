import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MorseCharacterTest {

	
	@Test
	@GradedTest(name="Test instance variables", max_score=0.833) 
	public void InstanceVariablesTest() {
		MorseCharacter testMorseChar = new MorseCharacter();
		@SuppressWarnings("rawtypes")
		Class c = testMorseChar.getClass();
		try {
			c.getDeclaredField("character");

			assertEquals(
					"You must only have the instance variables specified. When looking at the number of instance variables we",
					1, c.getDeclaredFields().length);

			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("character").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("character").getModifiers()));

			assertEquals("You must make your first instance variable of type String.", (String.class),
					c.getDeclaredField("character").getType());

		} catch (NoSuchFieldException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	@GradedTest(name="Test default constructor", max_score=0.833) 
	public void DefaultConstructorTest() {
		MorseCharacter testMorseChar = new MorseCharacter();
		@SuppressWarnings("rawtypes")
		Class c = testMorseChar.getClass();
		try {
			Field first = c.getDeclaredField("character");
			first.setAccessible(true);
			String characterValue = (String) first.get(testMorseChar);
			assertEquals("When checking the value of character we","",characterValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	@GradedTest(name="Test parameterized constructor", max_score=0.833) 
	public void ParameterizedConstructorTest() {
		MorseCharacter testMorseChar = new MorseCharacter("-");
		@SuppressWarnings("rawtypes")
		Class c = testMorseChar.getClass();
		try {
			Field first = c.getDeclaredField("character");
			first.setAccessible(true);
			String characterValue = (String) first.get(testMorseChar);
			assertEquals("When checking the value of character we","-",characterValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test 
	@GradedTest(name="getCodeTest", max_score=0.833)
	public void getCodeTest() {
		MorseCharacter testMorseChar = createMorseCharacter("..-");
		assertEquals("","..-",testMorseChar.getCode());
	}
	
	@Test 
	@GradedTest(name="setCodeTest", max_score=0.833)
	public void setCodeTest() {
		MorseCharacter testMorseChar = createMorseCharacter("");
		testMorseChar.setCode("--.");
		
		@SuppressWarnings("rawtypes")
		Class c = testMorseChar.getClass();
		try {
			Field first = c.getDeclaredField("character");
			first.setAccessible(true);
			String characterValue = (String) first.get(testMorseChar);
			assertEquals("When checking the value of character we","--.",characterValue);

		} catch (Exception e) {
			fail(e.toString());
		}

	}

	@Test 
	@GradedTest(name="hashCodeTest", max_score=5.0)
	public void hashCodeTest() {
		MorseCharacter testMorseChar = createMorseCharacter("--..");
		assertEquals("","--..".hashCode(),testMorseChar.hashCode());
	}
	
	@Test
	@GradedTest(name="equalsTest", max_score=5.0)
	public void equalsTest() {
		MorseCharacter mc1 = createMorseCharacter("-.-");
		MorseCharacter mc2 = createMorseCharacter(".-.");
		MorseCharacter mc3 = createMorseCharacter("-.-");
		MorseCharacter mc4 = null;
		Object mc5 = "Test";
		
		assertEquals("When comparing two logically equlivant MorseCharacter objects using .equals(), we", true,
				mc1.equals(mc3));
		assertEquals("When comparing two logically different MorseCharacter objects using .equals(), we", false,
				mc1.equals(mc2));
		assertEquals("When comparing a MorseCharacter object to itself using .equals(), we", true,
				mc1.equals(mc1));
		assertEquals("When comparing a MorseCharacter object to null using .equals(), we", false,
				mc1.equals(mc4));
		assertEquals("When comparing a MorseCharacter object to a non DigitalMedia obejct using .equals(), we", false,
				mc1.equals(mc5));
		
		assertEquals(".equals(), must be symmetric", true,
				mc3.equals(mc1));
		
	}

	@Test
	@GradedTest(name="toStringTest", max_score=0.833)
	public void toStringTest() {
		MorseCharacter testMorseChar = createMorseCharacter("..--");
		assertEquals("","..--",testMorseChar.toString());
	}
	
	@Test
	@GradedTest(name="compareToTest0", max_score=0.91)
	public void compareToTest0() {
		MorseCharacter thisMorseChar = createMorseCharacter(".");
		MorseCharacter objMorseChar = createMorseCharacter("-");
		assertEquals("When comparing . to - we",-1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest1", max_score=0.91)
	public void compareToTest1() {
		MorseCharacter thisMorseChar = createMorseCharacter("-");
		MorseCharacter objMorseChar = createMorseCharacter(".");
		assertEquals("When comparing - to . we",1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest2", max_score=0.91)
	public void compareToTest2() {
		MorseCharacter thisMorseChar = createMorseCharacter("-");
		MorseCharacter objMorseChar = createMorseCharacter("-");
		assertEquals("When comparing - to - we",0,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest3", max_score=0.91)
	public void compareToTest3() {
		MorseCharacter thisMorseChar = createMorseCharacter(".");
		MorseCharacter objMorseChar = createMorseCharacter(".");
		assertEquals("When comparing - to - we",0,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest4", max_score=0.91)
	public void compareToTest4() {
		MorseCharacter thisMorseChar = createMorseCharacter("..-");
		MorseCharacter objMorseChar = createMorseCharacter("...");
		assertEquals("When comparing ..- to ... we",1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest5", max_score=0.91)
	public void compareToTest5() {
		MorseCharacter thisMorseChar = createMorseCharacter("--.");
		MorseCharacter objMorseChar = createMorseCharacter("---");
		assertEquals("When comparing --. to --- we",-1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest6", max_score=0.91)
	public void compareToTest6() {
		MorseCharacter thisMorseChar = createMorseCharacter("..");
		MorseCharacter objMorseChar = createMorseCharacter("...");
		assertEquals("When comparing .. to ... we",-1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest7", max_score=0.91)
	public void compareToTest7() {
		MorseCharacter thisMorseChar = createMorseCharacter(".-.");
		MorseCharacter objMorseChar = createMorseCharacter("..-");
		assertEquals("When comparing .-. to ..- we",1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest8", max_score=0.91)
	public void compareToTest8() {
		MorseCharacter thisMorseChar = createMorseCharacter("-.-");
		MorseCharacter objMorseChar = createMorseCharacter("--.");
		assertEquals("When comparing -.- to --. we",-1,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest9", max_score=0.91)
	public void compareToTest9() {
		MorseCharacter thisMorseChar = createMorseCharacter("..-");
		MorseCharacter objMorseChar = createMorseCharacter("..-");
		assertEquals("When comparing ..- to ..- we",0,thisMorseChar.compareTo(objMorseChar));
	}
	
	@Test
	@GradedTest(name="compareToTest10", max_score=0.91)
	public void compareToTest10() {
		MorseCharacter thisMorseChar = createMorseCharacter("---");
		MorseCharacter objMorseChar = createMorseCharacter("--");
		assertEquals("When comparing --- to -- we",1,thisMorseChar.compareTo(objMorseChar));
	}
	
	private MorseCharacter createMorseCharacter(String aCharacter) {
		//Create a BridgesDoublyLinkedList object, bind the created DLelement list to it, return it
		MorseCharacter myMorseCharacter = new MorseCharacter();
		@SuppressWarnings("rawtypes")
		Class c = myMorseCharacter.getClass();
		
		try {
			Field character = c.getDeclaredField("character");
			character.setAccessible(true);
			character.set(myMorseCharacter, aCharacter);
			
		} catch (Exception e) {
			fail(e.toString());
		}
		return myMorseCharacter;
	}
	
}
