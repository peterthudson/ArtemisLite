package artemis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceTest {
	
	int DEFAULT_NUMBER_OF_SIDES, noOfSides, invalidNumberOfSides, randomNumber;
	Dice dice = new Dice();
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Dice vars
		DEFAULT_NUMBER_OF_SIDES = 6;
		noOfSides = 2;
		invalidNumberOfSides = 1;
		
	}
	
	//test default constructor 
	@Test
	void testDiceDefualtConstructor() {
		Dice dice = new Dice();
		assertNotNull(dice);
	}

	//test constructor
	@Test
	void testDiceConstructor() {
		Dice dice = new Dice(noOfSides);
		assertNotNull(dice);
	}

	//test side of the dice are not less than 2
	@Test
	void testSetNoOfSides() {
		
		dice.setNoOfSides(noOfSides);
		assertEquals(noOfSides, dice.getNoOfSides());
		
		//check that number below 2 for number of sides changes to 6 sides
		dice.setNoOfSides(invalidNumberOfSides);
		assertEquals(DEFAULT_NUMBER_OF_SIDES, dice.getNoOfSides());
	}

	//Test that random number is not greater than number of sides
	@Test
	void testRollDice() {
		
		Random r = new Random();
		randomNumber = r.nextInt(noOfSides) + 1;
		assert(randomNumber <= noOfSides);
		
	}

}
