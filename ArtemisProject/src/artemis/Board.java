package artemis;

public class Board {
	
	private String systemOneDesc = "In the harsh environment of space, astronauts need new spacesuits to explore more of the surface than ever before. NASA’s advanced exploration extravehicular mobility unity or xEMU will support lunar surface expeditions and during launch and re-entry, astronauts will wear the Orion crew survival system suit.";
	private String systemTwoDesc = "NASA is upgrading all the launch facilities at Kennedy Space Center in Florida to support Artemis missions to the Moon and beyond.";
	private String systemThreeDesc = "NASA'S powerful new rocket will send humans and cargo to the Moon and beyond. The Space Launch System is designed to be flexible and evolvable and is the agency’s first deep space rocket since Saturn V.";
	private String systemFourDesc = "NASA worked with three American companies during an initial base period to design modern human landing systems. The agency picked SpaceX to move forward with their Starship HLS design for a crewed demonstration to the surface of the Moon. ";
	
	private Square squareOne = new Square("Mission Control", "Collect $40k", "", 40, 0, 0, 0, 0, 0, 0, -10, -10, -10);
	private Square squareTwo = new Square("Helmet", systemOneDesc, "Space Suit", 0, 50, 50, 75, 10, 15, 20, -1, -1, 0);
	private Square squareThree = new Square("Backpack", systemOneDesc, "Space Suit", 0, 50, 50, 75, 10, 15, 20, -1, -1, 0);
	private Square squareFour = new Square("Suit", systemOneDesc, "Space Suit", 0, 50, 50, 75, 10, 15, 20, -1, -1, 0);
	private Square squareFive = new Square("Scaffold Tower", systemTwoDesc, "Ground System", 0, 75, 75, 100, 15, 20, 25, -1, -1, 0);
	private Square squareSix = new Square("Bridge", systemTwoDesc, "Ground System", 0, 75, 75, 100, 15, 20, 25, -1, -1, 0);
	private Square squareSeven = new Square("Support Tracks", systemTwoDesc, "Ground System", 0, 75, 75, 100, 15, 20, 25, -1, -1, 0);
	private Square squareEight = new Square("Public Holiday", "Nothing can be done on this day", "", 0, 0, 0, 0, 0, 0, 0, -10, -10, -10);
	private Square squareNine = new Square("Fuel Tanks", systemThreeDesc, "Rocket", 0, 100, 100, 125, 40, 45, 50, -1, -1, 0);
	private Square squareTen = new Square("Hull", systemThreeDesc, "Rocket", 0, 100, 100, 125, 40, 45, 50, -1, -1, 0);
	private Square squareEleven = new Square("Solar Panels", systemFourDesc, "Lander", 0, 20, 20, 30, 5, 10, 15, -1, -1, 0);
	private Square squareTwelve = new Square("Main Body", systemFourDesc, "Lander", 0, 20, 20, 30, 5, 10, 15, -1, -1, 0);

	public Square[] boardSquares = {squareOne, squareTwo, squareThree, squareFour, squareFive, squareSix, squareSeven, squareEight, squareNine, squareTen, squareEleven, squareTwelve};
	
	public Board() {
		
		
	}
	
	
	
	
}
