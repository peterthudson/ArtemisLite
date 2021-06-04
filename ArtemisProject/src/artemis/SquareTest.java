package artemis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareTest {
	
	String validSquareName, validSquareDesc, validSystemName;
	int validBalanceIncrease, validContractPrice, validDevCost, validPenaltyCost, validOwner, validPlaceholder, validLevel;
	
	Square square = new Square(validSquareName, validSquareDesc, validSystemName, validBalanceIncrease, validContractPrice, validDevCost, validDevCost, validPenaltyCost, validPenaltyCost, validPenaltyCost, validOwner, validPlaceholder, validLevel);
	
	@BeforeEach
	void setUp() throws Exception {
		
		//Square String vars
		validSquareName = "suit";
		validSquareDesc = "This is a space suit";
		validSystemName = "Lander";
		
		//Square int vars
		validBalanceIncrease = 10;
		validContractPrice = 50; 
		validDevCost = 20; 
		validPenaltyCost = 5;
		validOwner = 1;
		validPlaceholder = -1;
		validLevel = -1;
		
	}
	
	//Test constructor
	@Test
	void testSquareConstructor() {
		
		Square square = new Square(validSquareName, validSquareDesc, validSystemName, validBalanceIncrease, validContractPrice, validDevCost, validDevCost, validPenaltyCost, validPenaltyCost, validPenaltyCost, validOwner, validPlaceholder, validLevel);
		assertNotNull(square);
	}

	@Test
	void testSetSquareName() {
		
		square.setSquareName(validSquareName);
		assertEquals(validSquareName, square.getSquareName());
	
	}

	@Test
	void testSetSquareDesc() {
		square.setSquareDesc(validSquareDesc);
		assertEquals(validSquareDesc, square.getSquareDesc());
	}

	@Test
	void testSetSystemName() {
		
		square.setSystemName(validSystemName);
		assertEquals(validSystemName, square.getSystemName());
	}

	@Test
	void testSetBalanceIncrease() {
		
		square.setBalanceIncrease(validBalanceIncrease);
		assertEquals(validBalanceIncrease, square.getBalanceIncrease());
	}

	@Test
	void testSetContractPrice() {
		
		square.setContractPrice(validContractPrice);
		assertEquals(validContractPrice, square.getContractPrice());
	}

	@Test
	void testSetDevCostOne() {
		
		square.setDevCostOne(validDevCost);
		assertEquals(validDevCost, square.getDevCostOne());
	}

	@Test
	void testSetDevCostTwo() {
		
		square.setDevCostTwo(validDevCost);
		assertEquals(validDevCost, square.getDevCostTwo());
	}

	@Test
	void testSetPenaltyCostOne() {
		
		square.setPenaltyCostOne(validPenaltyCost);
		assertEquals(validPenaltyCost, square.getPenaltyCostOne());
	}

	@Test
	void testSetPenaltyCostTwo() {
		
		square.setPenaltyCostTwo(validPenaltyCost);
		assertEquals(validPenaltyCost, square.getPenaltyCostTwo());
	}

	@Test
	void testSetPenaltyCostThree() {
		
		square.setPenaltyCostThree(validPenaltyCost);
		assertEquals(validPenaltyCost, square.getPenaltyCostThree());
	}

	@Test
	void testSetOwner() {
		square.setOwner(validOwner);
		assertEquals(validOwner, square.getOwner());
	}

	@Test
	void testSetPlaceholder() {
		
		square.setPlaceholder(validPlaceholder);
		assertEquals(validPlaceholder, square.getPlaceholder());
	}

	@Test
	void testSetDevLevel() {
		square.setDevLevel(validLevel);
		assertEquals(validLevel, square.getDevLevel());
	}

}
