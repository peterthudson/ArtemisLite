package artemis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YearlyPlayerReportTest {
	
	int year, playerBalance; //year of each loop of turns	
	
	String playerName;
	
	YearlyPlayerReport playerReport = new YearlyPlayerReport();
	
	@BeforeEach
	void setUp() throws Exception {
		
		//YearlyPlayerReport vars
		year = 1990;
		playerBalance = 20;
		playerName = "Philip";
		
	}


	@Test
	void testYearlyPlayerReport() {
		
		YearlyPlayerReport playerReport = new YearlyPlayerReport();
		assertNotNull(playerReport);
	}

	@Test
	void testYearlyPlayerReportDefaultConstructor() {
		
		YearlyPlayerReport playerReport = new YearlyPlayerReport(year, playerName, playerBalance);
		assertNotNull(playerReport);
	}

	@Test
	void testSetYear() {
		
		playerReport.setYear(year);;
		assertEquals(year, playerReport.getYear());
		
	}

	@Test
	void testSetPlayerName() {
		
		playerReport.setPlayerName(playerName);;
		assertEquals(playerName, playerReport.getPlayerName());
	}

	@Test
	void testSetPlayerBalance() {
		
		playerReport.setPlayerBalance(playerBalance);;
		assertEquals(playerBalance, playerReport.getPlayerBalance());
		
	}

}
