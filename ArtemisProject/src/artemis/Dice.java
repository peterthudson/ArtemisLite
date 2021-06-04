package artemis;

import java.util.Random;

public class Dice {

	//Variable to hold the size of the dice
	private final int DEFAULT_NUMBER_OF_SIDES = 6;
	private int noOfSides;
	
	//Constructors
	public Dice() {}
	
	public Dice(int sides) {
		setNoOfSides(sides);
	}

	//Getters and Setters
	public int getNoOfSides() {
		return noOfSides;
	}

	public void setNoOfSides(int noOfSides) {
		
		if(noOfSides < 2) {
			this.noOfSides = DEFAULT_NUMBER_OF_SIDES;
		} else {
			this.noOfSides = noOfSides;
		}
	}
	
	//Roll Dice Method
	public int rollDice() { 
		
		Random r = new Random();
		
		return (r.nextInt(this.noOfSides) + 1);
		
	}

}
