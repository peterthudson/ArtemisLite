package artemis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YearlySystemReportTest {
	
	YearlySystemReport systemReport = new YearlySystemReport();
	
	int year, squareOwner, squareDevLevel;
	String squareName, squareSystem, playerName;
	
	@BeforeEach
	void setUp() throws Exception {
	
	year = 2000; //year of each loop of turns	
	squareName = "Helmet";
	squareSystem = "Space Suit";
	squareOwner = 1;
	squareDevLevel = 2;
	playerName = "philip";
	
	}

	@Test
	void testSetYear() {
		
		systemReport.setYear(year);;
		assertEquals(year, systemReport.getYear());
		
	}

	@Test
	void testSetSqOneName() {
		
		systemReport.setSqOneName(squareName);
		assertEquals(squareName, systemReport.getSqOneName());
	}

	@Test
	void testSetSqOneSystem() {
		
		systemReport.setSqOneSystem(squareName);
		assertEquals(squareName, systemReport.getSqOneSystem());
	}

	@Test
	void testSetSqOneOwner() {
		
		systemReport.setSqOneOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqOneOwner());
		
	}

	@Test
	void testSetSqOneDevLevel() {
		
		systemReport.setSqOneDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqOneDevLevel());
	}
	
	//system two name

	@Test
	void testSetSqTwoName() {
		
		systemReport.setSqTwoName(squareName);
		assertEquals(squareName, systemReport.getSqTwoName());
	}

	@Test
	void testSetSqTwoSystem() {
		
		systemReport.setSqTwoSystem(squareName);
		assertEquals(squareName, systemReport.getSqTwoSystem());
	}

	@Test
	void testSetSqTwoOwner() {
		
		systemReport.setSqTwoOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqTwoOwner());
		
	}

	@Test
	void testSetSqTwoDevLevel() {
		
		systemReport.setSqTwoDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqTwoDevLevel());
	}
	
	//system two name

	@Test
	void testSetSqThreeName() {
		
		systemReport.setSqThreeName(squareName);
		assertEquals(squareName, systemReport.getSqThreeName());
	}

	@Test
	void testSetSqThreeSystem() {
		
		systemReport.setSqThreeSystem(squareName);
		assertEquals(squareName, systemReport.getSqThreeSystem());
	}

	@Test
	void testSetSqThreeOwner() {
		
		systemReport.setSqThreeOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqThreeOwner());
		
	}

	@Test
	void testSetSqThreeDevLevel() {
		
		systemReport.setSqThreeDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqThreeDevLevel());
		
	}
	
	//system two name

	@Test
	void testSetSqFourName() {
		
		systemReport.setSqFourName(squareName);
		assertEquals(squareName, systemReport.getSqFourName());
	}

	@Test
	void testSetSqFourSystem() {
		
		systemReport.setSqFourSystem(squareName);
		assertEquals(squareName, systemReport.getSqFourSystem());
	}

	@Test
	void testSetSqFourOwner() {
		
		systemReport.setSqFourOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqFourOwner());
	}

	@Test
	void testSetSqFourDevLevel() {
		
		systemReport.setSqFourDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqFourDevLevel());
		
	}

	@Test
	void testSetSqFiveName() {
		
		systemReport.setSqFiveName(squareName);
		assertEquals(squareName, systemReport.getSqFiveName());
	}

	@Test
	void testSetSqFiveSystem() {
		
		systemReport.setSqFiveSystem(squareName);
		assertEquals(squareName, systemReport.getSqFiveSystem());
	}

	@Test
	void testSetSqFiveOwner() {
		
		systemReport.setSqFiveOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqFiveOwner());
	}

	@Test
	void testSetSqFiveDevLevel() {
		
		systemReport.setSqFiveDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqFiveDevLevel());
	}

	@Test
	void testSetSqSixName() {
		
		systemReport.setSqSixName(squareName);
		assertEquals(squareName, systemReport.getSqSixName());
	}

	@Test
	void testSetSqSixSystem() {
		
		systemReport.setSqSixSystem(squareName);
		assertEquals(squareName, systemReport.getSqSixSystem());
	}

	@Test
	void testSetSqSixOwner() {
		
		systemReport.setSqSixOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqSixOwner());
	}

	@Test
	void testSetSqSixDevLevel() {
		
		systemReport.setSqSixDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqSixDevLevel());
	}

	@Test
	void testSetSqSevenName() {
		
		systemReport.setSqSevenName(squareName);
		assertEquals(squareName, systemReport.getSqSevenName());
	}

	@Test
	void testSetSqSevenSystem() {
		
		systemReport.setSqSevenSystem(squareName);
		assertEquals(squareName, systemReport.getSqSevenSystem());
	}

	@Test
	void testSetSqSevenOwner() {
		
		systemReport.setSqSevenOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqSevenOwner());
	}

	@Test
	void testSetSqSevenDevLevel() {
		
		systemReport.setSqSevenDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqSevenDevLevel());
	}

	@Test
	void testSetSqEightName() {
		
		systemReport.setSqEightName(squareName);
		assertEquals(squareName, systemReport.getSqEightName());
	}

	@Test
	void testSetSqEightSystem() {
		
		systemReport.setSqEightSystem(squareName);
		assertEquals(squareName, systemReport.getSqEightSystem());
	}

	@Test
	void testSetSqEightOwner() {
		
		systemReport.setSqEightOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqEightOwner());
		
	}

	@Test
	void testSetSqEightDevLevel() {
		
		systemReport.setSqEightDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqEightDevLevel());
	}

	@Test
	void testSetSqNineName() {
		
		systemReport.setSqNineName(squareName);
		assertEquals(squareName, systemReport.getSqNineName());
	}

	@Test
	void testSetSqNineSystem() {
		
		systemReport.setSqNineSystem(squareName);
		assertEquals(squareName, systemReport.getSqNineSystem());
	}

	@Test
	void testSetSqNineOwner() {
		
		systemReport.setSqNineOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqNineOwner());
		
	}

	@Test
	void testSetSqNineDevLevel() {
		
		systemReport.setSqNineDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqNineDevLevel());
	}

	@Test
	void testSetSqTenName() {
		
		systemReport.setSqTenName(squareName);
		assertEquals(squareName, systemReport.getSqTenName());
	}

	@Test
	void testSetSqTenSystem() {
		
		systemReport.setSqTenSystem(squareName);
		assertEquals(squareName, systemReport.getSqTenSystem());
	}

	@Test
	void testSetSqTenOwner() {
		
		systemReport.setSqTenOwner(squareOwner);
		assertEquals(squareOwner, systemReport.getSqTenOwner());
	}

	@Test
	void testSetSqTenDevLevel() {
		
		systemReport.setSqTenDevLevel(squareDevLevel);
		assertEquals(squareDevLevel, systemReport.getSqTenDevLevel());
	}

	@Test
	void testYearlySystemReportDefaultConstrcutor() {
		
		YearlySystemReport systemReport  = new YearlySystemReport ();
		assertNotNull(systemReport);

	}

	@Test
	void testYearlySystemReportConstructor() {
		YearlySystemReport systemReport  = new YearlySystemReport (year, squareOwner, squareDevLevel, squareOwner, squareDevLevel, 
																		 squareOwner, squareDevLevel, squareOwner, squareDevLevel, 
																		 squareOwner, squareDevLevel, squareOwner, squareDevLevel, 
																		 squareOwner, squareDevLevel, squareOwner, squareDevLevel, 
																		 squareOwner, squareDevLevel, squareOwner, squareDevLevel);
		assertNotNull(systemReport);
	}



}
