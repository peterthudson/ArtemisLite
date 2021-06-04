package artemis;

public class Square {

	private String squareName; //The name of the square
	private String squareDesc; //The description for the square
	private String systemName; //The name of the associated system if there is one
	private int balanceIncrease; //The amount that the players balance is increased by when they land on the square
	private int contractPrice; //The amount it costs to take the contract
	private int devCostOne; //The amount it costs to partial develop an element
	private int devCostTwo; //The amount it costs to fully develop an element
	private int penaltyCostOne; //The penalty for landing on an element which has not been developed
	private int penaltyCostTwo; //The penalty for landing on an element which has been partially developed
	private int penaltyCostThree; //The penalty for landing on an element which has been fully developed
	private int owner; //The owner of the square
	private int placeholder; //The person who owns the other components of a system
	private int devLevel; //The current development level of the square
	
	//Constructor
	public Square(String squareName, String squareDesc, String systemName, int balanceIncrease, int contractPrice,
			int devCostOne, int devCostTwo, int penaltyCostOne, int penaltyCostTwo, int penaltyCostThree, int owner,
			int placeholder, int devLevel) {
		setSquareName(squareName);
		setSquareDesc(squareDesc);
		setSystemName(systemName);
		setBalanceIncrease(balanceIncrease);
		setContractPrice(contractPrice);
		setDevCostOne(devCostOne);
		setDevCostTwo(devCostTwo);
		setPenaltyCostOne(penaltyCostOne);
		setPenaltyCostTwo(penaltyCostTwo);
		setPenaltyCostThree(penaltyCostThree);
		setOwner(owner);
		setPlaceholder(placeholder);
		setDevLevel(devLevel);
	}

	public String getSquareName() {
		return squareName;
	}

	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}

	public String getSquareDesc() {
		return squareDesc;
	}

	public void setSquareDesc(String squareDesc) {
		this.squareDesc = squareDesc;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public int getBalanceIncrease() {
		return balanceIncrease;
	}

	public void setBalanceIncrease(int balanceIncrease) {
		this.balanceIncrease = balanceIncrease;
	}

	public int getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}

	public int getDevCostOne() {
		return devCostOne;
	}

	public void setDevCostOne(int devCostOne) {
		this.devCostOne = devCostOne;
	}

	public int getDevCostTwo() {
		return devCostTwo;
	}

	public void setDevCostTwo(int devCostTwo) {
		this.devCostTwo = devCostTwo;
	}

	public int getPenaltyCostOne() {
		return penaltyCostOne;
	}

	public void setPenaltyCostOne(int penaltyCostOne) {
		this.penaltyCostOne = penaltyCostOne;
	}

	public int getPenaltyCostTwo() {
		return penaltyCostTwo;
	}

	public void setPenaltyCostTwo(int penaltyCostTwo) {
		this.penaltyCostTwo = penaltyCostTwo;
	}

	public int getPenaltyCostThree() {
		return penaltyCostThree;
	}

	public void setPenaltyCostThree(int penaltyCostThree) {
		this.penaltyCostThree = penaltyCostThree;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getPlaceholder() {
		return placeholder;
	}
	
	public void setPlaceholder(int placeholder) {
		this.placeholder = placeholder;
	}

	public int getDevLevel() {
		return devLevel;
	}

	public void setDevLevel(int devLevel) {
		this.devLevel = devLevel;
	}
	
	
	
	
}
