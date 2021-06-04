package artemis;

public class YearlySystemReport {
	
	private int year; //year of each loop of turns	
	
	//The current state of Helmet Control
	private String sqOneName = "Helmet";
	private String sqOneSystem = "Space Suit";
	private int sqOneOwner;
	private int sqOneDevLevel;
	
	//The current state of Backpack component
	private String sqTwoName = "Backpack"; 
	private String sqTwoSystem = "Space Suit";
	private int sqTwoOwner;
	private int sqTwoDevLevel;
	
	//The current state of Suit component
	private String sqThreeName = "Suit";
	private String sqThreeSystem = "Space Suit";
	private int sqThreeOwner;
	private int sqThreeDevLevel;
	
	//The current state of Scaffold Tower component
	private String sqFourName = "Scaffold Tower";
	private String sqFourSystem = "Ground System";
	private int sqFourOwner;
	private int sqFourDevLevel;
	
	//The current state of Bridge component
	private String sqFiveName = "Bridge";
	private String sqFiveSystem = "Ground System";
	private int sqFiveOwner;
	private int sqFiveDevLevel;
	
	//The current state of Support Tracks component
	private String sqSixName = "Support Tracks";
	private String sqSixSystem = "Ground System";
	private int sqSixOwner;
	private int sqSixDevLevel;
	
	//The current state of Fuel Tanks component
	private String sqSevenName = "Fuel Tanks";
	private String sqSevenSystem = "Rocket";
	private int sqSevenOwner;
	private int sqSevenDevLevel;
	
	//The current state of Hull component
	private String sqEightName = "Hull";
	private String sqEightSystem = "Rocket";
	private int sqEightOwner;
	private int sqEightDevLevel;
	
	//The current state of Solar Panels component
	private String sqNineName = "Solar Panels";
	private String sqNineSystem = "Lander";
	private int sqNineOwner;
	private int sqNineDevLevel;
	
	//The current state of Main Body component
	private String sqTenName = "Main Body";
	private String sqTenSystem = "Lander";
	private int sqTenOwner;
	private int sqTenDevLevel;
	
	//Getters and Setters
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSqOneName() {
		return sqOneName;
	}
	public void setSqOneName(String sqOneName) {
		this.sqOneName = sqOneName;
	}
	public String getSqOneSystem() {
		return sqOneSystem;
	}
	public void setSqOneSystem(String sqOneSystem) {
		this.sqOneSystem = sqOneSystem;
	}
	public int getSqOneOwner() {
		return sqOneOwner;
	}
	public void setSqOneOwner(int sqOneOwner) {
		this.sqOneOwner = sqOneOwner;
	}
	public int getSqOneDevLevel() {
		return sqOneDevLevel;
	}
	public void setSqOneDevLevel(int sqOneDevLevel) {
		this.sqOneDevLevel = sqOneDevLevel;
	}
	public String getSqTwoName() {
		return sqTwoName;
	}
	public void setSqTwoName(String sqTwoName) {
		this.sqTwoName = sqTwoName;
	}
	public String getSqTwoSystem() {
		return sqTwoSystem;
	}
	public void setSqTwoSystem(String sqTwoSystem) {
		this.sqTwoSystem = sqTwoSystem;
	}
	public int getSqTwoOwner() {
		return sqTwoOwner;
	}
	public void setSqTwoOwner(int sqTwoOwner) {
		this.sqTwoOwner = sqTwoOwner;
	}
	public int getSqTwoDevLevel() {
		return sqTwoDevLevel;
	}
	public void setSqTwoDevLevel(int sqTwoDevLevel) {
		this.sqTwoDevLevel = sqTwoDevLevel;
	}
	public String getSqThreeName() {
		return sqThreeName;
	}
	public void setSqThreeName(String sqThreeName) {
		this.sqThreeName = sqThreeName;
	}
	public String getSqThreeSystem() {
		return sqThreeSystem;
	}
	public void setSqThreeSystem(String sqThreeSystem) {
		this.sqThreeSystem = sqThreeSystem;
	}
	public int getSqThreeOwner() {
		return sqThreeOwner;
	}
	public void setSqThreeOwner(int sqThreeOwner) {
		this.sqThreeOwner = sqThreeOwner;
	}
	public int getSqThreeDevLevel() {
		return sqThreeDevLevel;
	}
	public void setSqThreeDevLevel(int sqThreeDevLevel) {
		this.sqThreeDevLevel = sqThreeDevLevel;
	}
	public String getSqFourName() {
		return sqFourName;
	}
	public void setSqFourName(String sqFourName) {
		this.sqFourName = sqFourName;
	}
	public String getSqFourSystem() {
		return sqFourSystem;
	}
	public void setSqFourSystem(String sqFourSystem) {
		this.sqFourSystem = sqFourSystem;
	}
	public int getSqFourOwner() {
		return sqFourOwner;
	}
	public void setSqFourOwner(int sqFourOwner) {
		this.sqFourOwner = sqFourOwner;
	}
	public int getSqFourDevLevel() {
		return sqFourDevLevel;
	}
	public void setSqFourDevLevel(int sqFourDevLevel) {
		this.sqFourDevLevel = sqFourDevLevel;
	}
	public String getSqFiveName() {
		return sqFiveName;
	}
	public void setSqFiveName(String sqFiveName) {
		this.sqFiveName = sqFiveName;
	}
	public String getSqFiveSystem() {
		return sqFiveSystem;
	}
	public void setSqFiveSystem(String sqFiveSystem) {
		this.sqFiveSystem = sqFiveSystem;
	}
	public int getSqFiveOwner() {
		return sqFiveOwner;
	}
	public void setSqFiveOwner(int sqFiveOwner) {
		this.sqFiveOwner = sqFiveOwner;
	}
	public int getSqFiveDevLevel() {
		return sqFiveDevLevel;
	}
	public void setSqFiveDevLevel(int sqFiveDevLevel) {
		this.sqFiveDevLevel = sqFiveDevLevel;
	}
	public String getSqSixName() {
		return sqSixName;
	}
	public void setSqSixName(String sqSixName) {
		this.sqSixName = sqSixName;
	}
	public String getSqSixSystem() {
		return sqSixSystem;
	}
	public void setSqSixSystem(String sqSixSystem) {
		this.sqSixSystem = sqSixSystem;
	}
	public int getSqSixOwner() {
		return sqSixOwner;
	}
	public void setSqSixOwner(int sqSixOwner) {
		this.sqSixOwner = sqSixOwner;
	}
	public int getSqSixDevLevel() {
		return sqSixDevLevel;
	}
	public void setSqSixDevLevel(int sqSixDevLevel) {
		this.sqSixDevLevel = sqSixDevLevel;
	}
	public String getSqSevenName() {
		return sqSevenName;
	}
	public void setSqSevenName(String sqSevenName) {
		this.sqSevenName = sqSevenName;
	}
	public String getSqSevenSystem() {
		return sqSevenSystem;
	}
	public void setSqSevenSystem(String sqSevenSystem) {
		this.sqSevenSystem = sqSevenSystem;
	}
	public int getSqSevenOwner() {
		return sqSevenOwner;
	}
	public void setSqSevenOwner(int sqSevenOwner) {
		this.sqSevenOwner = sqSevenOwner;
	}
	public int getSqSevenDevLevel() {
		return sqSevenDevLevel;
	}
	public void setSqSevenDevLevel(int sqSevenDevLevel) {
		this.sqSevenDevLevel = sqSevenDevLevel;
	}
	public String getSqEightName() {
		return sqEightName;
	}
	public void setSqEightName(String sqEightName) {
		this.sqEightName = sqEightName;
	}
	public String getSqEightSystem() {
		return sqEightSystem;
	}
	public void setSqEightSystem(String sqEightSystem) {
		this.sqEightSystem = sqEightSystem;
	}
	public int getSqEightOwner() {
		return sqEightOwner;
	}
	public void setSqEightOwner(int sqEightOwner) {
		this.sqEightOwner = sqEightOwner;
	}
	public int getSqEightDevLevel() {
		return sqEightDevLevel;
	}
	public void setSqEightDevLevel(int sqEightDevLevel) {
		this.sqEightDevLevel = sqEightDevLevel;
	}
	public String getSqNineName() {
		return sqNineName;
	}
	public void setSqNineName(String sqNineName) {
		this.sqNineName = sqNineName;
	}
	public String getSqNineSystem() {
		return sqNineSystem;
	}
	public void setSqNineSystem(String sqNineSystem) {
		this.sqNineSystem = sqNineSystem;
	}
	public int getSqNineOwner() {
		return sqNineOwner;
	}
	public void setSqNineOwner(int sqNineOwner) {
		this.sqNineOwner = sqNineOwner;
	}
	public int getSqNineDevLevel() {
		return sqNineDevLevel;
	}
	public void setSqNineDevLevel(int sqNineDevLevel) {
		this.sqNineDevLevel = sqNineDevLevel;
	}
	public String getSqTenName() {
		return sqTenName;
	}
	public void setSqTenName(String sqTenName) {
		this.sqTenName = sqTenName;
	}
	public String getSqTenSystem() {
		return sqTenSystem;
	}
	public void setSqTenSystem(String sqTenSystem) {
		this.sqTenSystem = sqTenSystem;
	}
	public int getSqTenOwner() {
		return sqTenOwner;
	}
	public void setSqTenOwner(int sqTenOwner) {
		this.sqTenOwner = sqTenOwner;
	}
	public int getSqTenDevLevel() {
		return sqTenDevLevel;
	}
	public void setSqTenDevLevel(int sqTenDevLevel) {
		this.sqTenDevLevel = sqTenDevLevel;
	}

	//Constructors
	public YearlySystemReport() {}
	
	public YearlySystemReport(int year, int sqOneOwner, int sqOneDevLevel, int sqTwoOwner, int sqTwoDevLevel,
			int sqThreeOwner, int sqThreeDevLevel, int sqFourOwner, int sqFourDevLevel, int sqFiveOwner,
			int sqFiveDevLevel, int sqSixOwner, int sqSixDevLevel, int sqSevenOwner, int sqSevenDevLevel,
			int sqEightOwner, int sqEightDevLevel, int sqNineOwner, int sqNineDevLevel, int sqTenOwner,
			int sqTenDevLevel) {
		super();
		setYear(year);
		setSqOneOwner(sqOneOwner);
		setSqOneDevLevel(sqOneDevLevel);
		setSqTwoOwner(sqTwoOwner);
		setSqTwoDevLevel(sqTwoDevLevel);
		setSqThreeOwner(sqThreeOwner);
		setSqThreeDevLevel(sqThreeDevLevel);
		setSqFourOwner(sqFourOwner);
		setSqFourDevLevel(sqFourDevLevel);
		setSqFiveOwner(sqFiveOwner);
		setSqFiveDevLevel(sqFiveDevLevel);
		setSqSixOwner(sqSixOwner);
		setSqSixDevLevel(sqSixDevLevel);
		setSqSevenOwner(sqSevenOwner);
		setSqSevenDevLevel(sqSevenDevLevel);
		setSqEightOwner(sqEightOwner);
		setSqEightDevLevel(sqEightDevLevel);
		setSqNineOwner(sqNineOwner);
		setSqNineDevLevel(sqNineDevLevel);
		setSqTenOwner(sqTenOwner);
		setSqTenDevLevel(sqTenDevLevel);
	}
	
	public void finalReport(Player[] players) {
	
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqOneSystem(), getSqOneName(), ((getSqOneOwner() == -1) ? "None" : players[getSqOneOwner()].getPlayerName()), getSqOneDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqTwoSystem(), getSqTwoName(), ((getSqTwoOwner() == -1) ? "None" : players[getSqTwoOwner()].getPlayerName()), getSqTwoDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqThreeSystem(), getSqThreeName(), ((getSqThreeOwner() == -1) ? "None" : players[getSqThreeOwner()].getPlayerName()), getSqThreeDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqFourSystem(), getSqFourName(), ((getSqFourOwner() == -1) ? "None" : players[getSqFourOwner()].getPlayerName()), getSqFourDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqFiveSystem(), getSqFiveName(), ((getSqFiveOwner() == -1) ? "None" : players[getSqFiveOwner()].getPlayerName()), getSqFiveDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqSixSystem(), getSqSixName(), ((getSqSixOwner() == -1) ? "None" : players[getSqSixOwner()].getPlayerName()), getSqSixDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqSevenSystem(), getSqSevenName(), ((getSqSevenOwner() == -1) ? "None" : players[getSqSevenOwner()].getPlayerName()), getSqSevenDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqEightSystem(), getSqEightName(), ((getSqEightOwner() == -1) ? "None" : players[getSqEightOwner()].getPlayerName()), getSqEightDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqNineSystem(), getSqNineName(), ((getSqNineOwner() == -1) ? "None" : players[getSqNineOwner()].getPlayerName()), getSqNineDevLevel());
		System.out.printf("%-8s%-15s%-20s%-20s%-15s\n",getYear(), getSqTenSystem(), getSqTenName(), ((getSqTenOwner() == -1) ? "None" : players[getSqTenOwner()].getPlayerName()), getSqTenDevLevel());
		System.out.println("");
	}
}