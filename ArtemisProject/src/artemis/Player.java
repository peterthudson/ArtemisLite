package artemis;

public class Player {
	
	private String playerName; //Variable to hold player name
	private int balance; //Variable to hold player balance
	private int position; //Variable to hold player position
	
	
	//Default Constructor
	public Player() {}
	
	//Constructor
	public Player(String playerName, int balance, int position) {
		this.setPlayerName(playerName);
		this.setBalance(balance);
		this.setPosition(position);
	}
	
	//Getter for player name
	public String getPlayerName() {
		return playerName;
	}
	
	//Setter for player name
	public void setPlayerName(String playerName) {		
		this.playerName = playerName;		
	}

	//Getter for player balance
	public int getBalance() {
		return balance;
	}

	//Setter for player balance
	public void setBalance(int balance) {
		this.balance = balance;
	}

	//Getter for player position
	public int getPosition() {
		return position;
	}

	//Setter for player position
	public void setPosition(int position) {
		this.position = position;
	}
}


