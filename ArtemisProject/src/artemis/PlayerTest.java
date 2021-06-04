package artemis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	
	
	int validBalance, validPlayerPosition;
	String validName;
	Player player = new Player();
	
	
	
	


	@BeforeEach
	void setUp() throws Exception {
		
		//player vars
		validBalance = 20;
		validPlayerPosition = 7;
		validName= "Philip";
		
	}

	@Test
	void testPlayerDefaultConstructor() {
		
		Player player = new Player();
		assertNotNull(player);
	}

	@Test
	void testPlayerConstructor() {
		Player player = new Player(validName, validBalance, validPlayerPosition);
		assertNotNull(player);
	}


	@Test
	void testSetPlayerName() {
		
		player.setPlayerName(validName);
		assertEquals(validName, player.getPlayerName());
	}

	

	@Test
	void testValidBalance() {
		
		player.setBalance(validBalance);
		assertEquals(20, player.getBalance());
	}

	@Test
	void testValidPosition() {
		player.setPosition(validPlayerPosition);
		assertEquals(validPlayerPosition, player.getPosition());
		
	}

	

}
