import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CharacterConverterTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	File INPUT_FILE; 
	
	@Before
	public void initialize() {
		try {
			INPUT_FILE = tempFolder.newFile("codeFile.txt");
			PrintWriter out = new PrintWriter(INPUT_FILE);
			out.println("E .\n" + 
					"A .-\n" + 
					"B -...\n" + 
					"C -.-.\n" + 
					"D -..\n" + 
					"F ..-.\n" + 
					"G --.\n" + 
					"H ....\n" + 
					"I ..\n" + 
					"J .---\n" + 
					"K -.-\n" + 
					"L .-..\n" + 
					"M --\n" + 
					"N -.\n" + 
					"O ---\n" + 
					"P .--.\n" + 
					"Q --.-\n" + 
					"R .-.\n" + 
					"S ...\n" + 
					"T -\n" + 
					"U ..-\n" + 
					"V ...-\n" + 
					"W .--\n" + 
					"X -..-\n" + 
					"Y -.--\n" + 
					"Z --..\n" + 
					"1 .----\n" + 
					"2 ..---\n" + 
					"3 ...--\n" + 
					"4 ....-\n" + 
					"5 .....\n" + 
					"6 -....\n" + 
					"7 --...\n" + 
					"8 ---..\n" + 
					"9 ----.\n" + 
					"0 -----\n" + 
					"' .----.\n" + 
					"_ ..--.-\n" + 
					"? ..--..\n" + 
					"- -....-\n" + 
					": -.-.-.\n" + 
					". --..--\n" + 
					"; ---...\n" + 
					"! .-.-.-\n" + 
					", ----");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@GradedTest(name="Test parameterized constructor", max_score=10.0) 
	public void ParameterizedConstructorTest() {
		new CharacterConverter(INPUT_FILE);
	}
	
	@Test
	@GradedTest(name="Convert E to Morse Code", max_score=2.0) 
	public void convertFromEnglishSingleCharacterTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertFromEnglish("E");
		assertEquals("When converting from E to Morse code we",".",result);
	}
	
	@Test
	@GradedTest(name="Convert X to Morse Code", max_score=2.0) 
	public void convertFromEnglishSingleCharacterTest2() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertFromEnglish("X");
		assertEquals("When converting from X to Morse code we","-..-",result);
	}
	
	@Test
	@GradedTest(name="Convert HELLO to Morse Code", max_score=2.0) 
	public void convertFromEnglishMultipleCharacterTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertFromEnglish("HELLO");
		assertEquals("When converting from HELLO to Morse code we",".... . .-.. .-.. ---",result);
	}
	
	@Test
	@GradedTest(name="Convert WORLD to Morse Code", max_score=2.0) 
	public void convertFromEnglishMultipleCharacterTest2() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertFromEnglish("WORLD");
		assertEquals("When converting from WORLD to Morse code we",".-- --- .-. .-.. -..",result);
	}

	@Test
	@GradedTest(name="Convert DAN_THE_DANCER to Morse Code", max_score=2.0) 
	public void convertFromEnglishMultipleWordTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertFromEnglish("DAN_THE_DANCER");
		assertEquals("When converting from DAN_THE_DANCER to Morse code we","-.. .- -. ..--.- - .... . ..--.- -.. .- -. -.-. . .-.",result);
	}
	
	@Test
	@GradedTest(name="Convert - to English", max_score=2.0) 
	public void convertToEnglishSingleCharacterTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertToEnglish("-");
		assertEquals("When converting from - to English we","T",result);
	}
	
	@Test
	@GradedTest(name="Convert --.. to English", max_score=2.0) 
	public void convertToEnglishSingleCharacterTest2() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertToEnglish("--..");
		assertEquals("When converting from --.. to English we","Z",result);
	}
	
	@Test
	@GradedTest(name="Convert - .- -- . to English", max_score=2.0) 
	public void convertToEnglishMultipleCharacterTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertToEnglish("- .- -- .");
		assertEquals("When converting from - .- -- . to English we","TAME",result);
	}
	
	@Test
	@GradedTest(name="Convert .. -- .--. .- .-.. .- to English", max_score=2.0) 
	public void convertToEnglishMultipleCharacterTest2() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertToEnglish(".. -- .--. .- .-.. .-");
		assertEquals("When converting from .. -- .--. .- .-.. .- to English we","IMPALA",result);
	}

	@Test
	@GradedTest(name="Convert ..-. . . .-.. ... ..--.- .-.. .. -.- . ..--.- .-- . ..--.- --- -. .-.. -.-- ..--.- --. --- ..--.- -... .- -.-. -.- .-- .- .-. -.. ... to English", max_score=2.0) 
	public void convertToEnglishMultipleWordTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String result = testCharacterConverter.convertToEnglish("..-. . . .-.. ... ..--.- .-.. .. -.- . ..--.- .-- . ..--.- --- -. .-.. -.-- ..--.- --. --- ..--.- -... .- -.-. -.- .-- .- .-. -.. ...");
		assertEquals("When converting from ..-. . . .-.. ... ..--.- .-.. .. -.- . ..--.- .-- . ..--.- --- -. .-.. -.-- ..--.- --. --- ..--.- -... .- -.-. -.- .-- .- .-. -.. ... to Morse code we","FEELS_LIKE_WE_ONLY_GO_BACKWARDS",result);
	}

	@Test
	@GradedTest(name="getSymbolAlphabetTest", max_score=5.0) 
	public void getSymbolAlphabetTest() {
		CharacterConverter testCharacterConverter = new CharacterConverter(INPUT_FILE);
		String[] expected = {".", "..", "...", "....", ".....", "....-", "...-", "...--", "..-", "..-.", "..--..", "..--.-", "..---", ".-", ".-.", ".-..", ".-.-.-", ".--", ".--.", ".---", ".----", ".----.", "-", "-.", "-..", "-...", "-....", "-....-", "-..-", "-.-", "-.-.", "-.-.-.", "-.--", "--", "--.", "--..", "--...", "--..--", "--.-", "---", "---..", "---...", "----", "----.", "-----"};
		ArrayList<MorseCharacter> temp = testCharacterConverter.getSymbolAlphabet();
		ArrayList<String> stringResult = new ArrayList<String>();
		for(MorseCharacter achar : temp) {
			stringResult.add(achar.toString());
		}
		String[] result = {};
		result = stringResult.toArray(result);
				
		assertArrayEquals("",expected,result);
	}
	
	@Test
	@GradedTest(name="Test visualize method", max_score=5.0) 
	public void visualizeTest() {
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));

		new CharacterConverter(INPUT_FILE).visualize();

		final String standardOutput = myOut.toString();
		assertTrue(standardOutput.contains("http://bridges-cs.herokuapp.com/"));
	}
	
}
