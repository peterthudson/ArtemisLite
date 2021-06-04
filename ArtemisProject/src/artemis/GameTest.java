package artemis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class GameTest {
	
			

	//valid number of player 1-4
	int validNumberPlayersUpper, validNumberPlayersMid, validNumberPlayersLower, invalidNumberPlayersUpper, invalidNumberPlayersLower,invalidNumberPlayersZero , userInput;
			
	//Valid player name 1-20
	String validPlayerNameUpper, validPlayerNameMid, validPlayerNameLower, invalidPlayerNameUpper,  invalidPlayerNameLower;
			
	//exception messages Vars
	String invalidNumberOfPlayersMessage, invalidPlayerNameMessage;
			
			
	@BeforeEach
	void setUp() throws Exception {
		
		//number of player vars
		userInput = 0;
		validNumberPlayersUpper = 4;
		validNumberPlayersMid = 3;
		validNumberPlayersLower = 1; 
		invalidNumberPlayersUpper = 5;
		invalidNumberPlayersZero = 0;
		invalidNumberPlayersLower = -1;
		
		//player name vars
		validPlayerNameUpper = "qwertyuiopasdfghjklz"; //20
		validPlayerNameMid = "qwertyuiop"; //10
		validPlayerNameLower = "q"; //1
		invalidPlayerNameUpper =  "qwertyuiopasdfghjklzx"; //21
		invalidPlayerNameLower = ""; //none
		
		//Exception messages
		invalidNumberOfPlayersMessage = "Invalid Input. Try Again.";
		invalidPlayerNameMessage = "Name is too long. Must be fewer than 20 characters";
		
		//Game game = new Game();
		
		
	}
	
	@Rule 
	public ExpectedException inputMismatchException = ExpectedException.none();

	@Test
	 void testInvalidAskHowManyPlayers() {
		
	userInput = 65;
	inputMismatchException.expect(InputMismatchException.class);
	inputMismatchException.expectMessage(invalidNumberOfPlayersMessage);
	
	userInput = invalidNumberPlayersLower;
	inputMismatchException.expect(InputMismatchException.class);
	inputMismatchException.expectMessage(invalidNumberOfPlayersMessage);
	
	userInput = invalidNumberPlayersZero;
	inputMismatchException.expect(InputMismatchException.class);
	inputMismatchException.expectMessage(invalidNumberOfPlayersMessage);
		
	}
	
	@Test
	 void testValidAskHowManyPlayers() {
		
		userInput = validNumberPlayersUpper;
		
	}

	@Test
	void testAskPlayerNames() {
		//valid player name 1-20
				
	}

}
