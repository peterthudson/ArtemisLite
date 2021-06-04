package artemis;

public class YearlyPlayerReport {
	
	private int year; //year of each loop of turns	
	
	private String playerName;
	private int playerBalance;
	
	public YearlyPlayerReport() {
		
	}
	
	public YearlyPlayerReport(int year, String playerName, int playerBalance) {
	
		setYear(year);
		setPlayerName(playerName);
		setPlayerBalance(playerBalance);
		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerBalance() {
		return playerBalance;
	}

	public void setPlayerBalance(int playerBalance) {
		this.playerBalance = playerBalance;
	}
}
