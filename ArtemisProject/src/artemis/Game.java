package artemis;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Board gameBoard = new Board();
		
		int endGameReasonCode = 0;
		int currentYear = 2000;
		int turnCounter = 1;
		boolean continuePlay = true;
		boolean inputError;
		
		ArrayList <YearlyPlayerReport> playerHistory = new ArrayList <YearlyPlayerReport>();
		ArrayList <YearlySystemReport> systemHistory = new ArrayList <YearlySystemReport>();
		
		//Display Game Rules and have the user press a button to continue
		displayRules();
		System.out.println("Press Enter to Continue...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		//Create the Dice
		Dice dieOne = new Dice(6);
		Dice dieTwo = new Dice(6);
		
		//Ask the number of players
		int numberOfPlayers = askHowManyPlayers(scanner);
		
		//Enter player names
		String playerName = "";
		boolean playerNameError;
		
		Player[] gamePlayers = new Player[numberOfPlayers];
		
		for (int i = 0 ; i < numberOfPlayers ; i++) {
			
			do {
				playerNameError = false;
				playerName = askPlayerNames(scanner, i);
				
				switch (i) {
					case (0) : {
						break;
					}
					
					case (1) : {
						if (playerName.compareTo(gamePlayers[0].getPlayerName()) == 0) {
							System.out.println("Duplicate names are not allowed.");
							playerNameError = true;
						}
						break;
					}
					
					case (2) : {
						if ((playerName.compareTo(gamePlayers[0].getPlayerName()) == 0) || (playerName.compareTo(gamePlayers[1].getPlayerName()) == 0)) {
							System.out.println("Duplicate names are not allowed.");
							playerNameError = true;
						}
						break;
					}
					
					case (3) : {
						if ((playerName.compareTo(gamePlayers[0].getPlayerName()) == 0) || (playerName.compareTo(gamePlayers[1].getPlayerName()) == 0) || (playerName.compareTo(gamePlayers[2].getPlayerName()) == 0)) {
							System.out.println("Duplicate names are not allowed.");
							playerNameError = true;
						}
						break;
					}
				}
				
			} while (playerNameError);
			
			gamePlayers[i] = new Player(playerName, 10, 0);
			
		}
		
		//Choose who goes first
		Random r = new Random();
		
		int currentPlayer = r.nextInt(numberOfPlayers);
		
		System.out.println("The player chosen randomly to go first is " + gamePlayers[currentPlayer].getPlayerName());
		
		//Start the turn
		do {
			
			inputError = false;
			
			//Roll the dice
			System.out.println();
			System.out.println(gamePlayers[currentPlayer].getPlayerName() + ", Press Enter to Roll the Dice...");
			scanner.nextLine();
			int dieOneValue = dieOne.rollDice();
			int dieTwoValue = dieTwo.rollDice();
			int diceTotal = dieOneValue + dieTwoValue;
			
			//Move the player
			int currentSquare = gamePlayers[currentPlayer].getPosition();
			int newPosition = currentSquare + diceTotal;
			
			if (newPosition > 11) {
				newPosition -= 12;
			}
			
			//Check to see if their dice roll will cause them to pass Mission Control and update their balance
			if ((currentSquare + diceTotal) > 12) {
				gamePlayers[currentPlayer].setBalance(gamePlayers[currentPlayer].getBalance() + gameBoard.boardSquares[0].getBalanceIncrease());
			}
			
			//Check to see if the player has landed on Mission Control and update their balance
			if (newPosition == 0) {
				gamePlayers[currentPlayer].setBalance(gamePlayers[currentPlayer].getBalance() + gameBoard.boardSquares[0].getBalanceIncrease());
			}
			
			//Set the current Player's position to the index of the square they've landed on
			gamePlayers[currentPlayer].setPosition(newPosition);
			
			//Gather information about the square that they've landed on
			String newSquareName = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getSquareName(); //The name of the square that the player landed on
			String newSquareDesc = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getSquareDesc(); //The description of the square that the player landed on
			String newSquareSystem = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getSystemName(); //The name of the system associated with the square that the player landed on
			int newSquareBalanceIncrease = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getBalanceIncrease(); //The amount added to the balance on the player who passes or lands on the square
			int newSquareContractPrice = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getContractPrice(); //The price to take the contract of the square the player has landed on
			int newSquareDevCostOne = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getDevCostOne(); //The price to partially develop the current square
			int newSquareDevCostTwo = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getDevCostTwo(); //The price to fully develop the current square
			int newSquarePenaltyCostOne = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getPenaltyCostOne(); //The price the player would have to pay if the current square is owned by another player and not developed
			int newSquarePenaltyCostTwo = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getPenaltyCostTwo(); //The price the player would have to pay if the current square is owned by another player and partially developed
			int newSquarePenaltyCostThree = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getPenaltyCostThree(); //The price the player would have to pay if the current square is owned by another player and fully developed
			int newSquareOwner = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getOwner(); //The owner of the square that the player has landed on
			int newSquarePlaceholder = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getPlaceholder(); //The player who owns systems related to the square that the current player has landed on
			int newSquareDevLevel = gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()].getDevLevel(); //The development level of the square the player has landed on
			
			//Display the Beginning of Turn Report
			String currentPlayerName = gamePlayers[currentPlayer].getPlayerName();
			int currentBalance = gamePlayers[currentPlayer].getBalance();
			String currentSystemName = gameBoard.boardSquares[newPosition].getSystemName();
			String currentComponentName = gameBoard.boardSquares[newPosition].getSquareName();

			System.out.println("--- Turn Report ----------------------------------------------------------------");
			System.out.println();
			System.out.println("   Current Player:    " + currentPlayerName);
			System.out.println("   Current Funds:     $" + currentBalance + "K");
			System.out.println();
			System.out.println("   You rolled a " + dieOneValue + " and a " + dieTwoValue + " to move " + diceTotal + " spaces");
			
			if (newPosition == 0) {
				System.out.println("   You have landed on the Misison Control Square. Collect $" + newSquareBalanceIncrease + "K.");
			} else if (newPosition == 7) {
				System.out.println("   You have landed on the Bank Holiday Square. Your scientsts have the day off.");
			} else {
				System.out.println("   Landed on the " + currentComponentName + " which is part of the " + currentSystemName + "system.");
			}

			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println();
			
			if (newSquareOwner != -10) { //If the current square is not one of the special squares
				
				if (newSquareOwner == -1){ //If the current square is not owned by anyone
					
					if ((newSquarePlaceholder == currentPlayer) || (newSquarePlaceholder == -1)) { //If the current square belongs to a system that is not being held by another player
						
						if (newSquareContractPrice < gamePlayers[currentPlayer].getBalance()) { //The player can afford to buy it

							
							
							do {
								

								
								try {
									
									int userChoice;
									do {
										System.out.println(
												"Do you want to take the contract on this component and system?");
										System.out.println("1. Yes");
										System.out.println("2. No");

										userChoice = scanner.nextInt();
										scanner.nextLine();

										if (userChoice == 1) {
											//Deduct the contract price from their balance
											gamePlayers[currentPlayer].setBalance(
													gamePlayers[currentPlayer].getBalance() - newSquareContractPrice);

											//Set the owner of the component to the current player
											gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()]
													.setOwner(currentPlayer);
											gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()]
													.setPlaceholder(currentPlayer);

											//Set the placeholder on the other components of the system to the current player
											String currentSquareSystem = gameBoard.boardSquares[gamePlayers[currentPlayer]
													.getPosition()].getSystemName();

											for (int i = 0; i < 12; i++) {

												if (gameBoard.boardSquares[i].getSystemName()
														.compareTo(currentSquareSystem) == 0) {

													gameBoard.boardSquares[i].setPlaceholder(currentPlayer);

												}

											}

										} else if (userChoice == 2) {

											//offer to other players
											int userSellChoice;

											do {

												do {
													//Ask who they want to offer it to
													System.out.println(
															"Other players who would like to take this contract can do so. Who would like to take it?");
													//Display a list of the players
													for (int i = 0; i < gamePlayers.length; i++) {
														System.out.println(
																(i + 1) + ". " + gamePlayers[i].getPlayerName());
													}
													System.out.println((gamePlayers.length + 1) + ". Cancel");
													//Read their choice
													userSellChoice = scanner.nextInt();
													scanner.nextLine();

													if ((userSellChoice < 1)
															|| (userSellChoice > (gamePlayers.length + 1))) {

														System.out.println("Invalid Choice");
													}

												} while ((userSellChoice < 1)
														|| (userSellChoice > (gamePlayers.length + 1)));

												//If the user chooses cancel, break out of the do loop
												if (userSellChoice == (gamePlayers.length + 1)) {

													break;

												}

												//Check if the selected player can afford it
												if (gamePlayers[(userSellChoice - 1)]
														.getBalance() < newSquareContractPrice) {

													System.out.println(gamePlayers[(userSellChoice - 1)].getPlayerName()
															+ " cannot afford this component");
													userSellChoice = -1;
												} else {

													//if ((userSellChoice > 1) && (userSellChoice <= numberOfPlayers)) {
													//Deduct the contract price from the new owner's balance
													gamePlayers[(userSellChoice - 1)]
															.setBalance(gamePlayers[(userSellChoice - 1)].getBalance()
																	- newSquareContractPrice);
													//Set the owner of the current square to the new owner
													gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()]
															.setOwner(userSellChoice - 1);
													//Set the placeholder for the components of the system to the new owner
													for (int i = 0; i < 12; i++) {

														if (gameBoard.boardSquares[i].getSystemName()
																.compareTo(newSquareSystem) == 0) {

															gameBoard.boardSquares[i]
																	.setPlaceholder(userSellChoice - 1);

														}

													}
													System.out.println(gamePlayers[userSellChoice - 1].getPlayerName()
															+ " is now in charge of this system and this component");
													//}

												}

											} while ((userSellChoice < 1) || (userSellChoice > numberOfPlayers));
										}

									} while ((userChoice != 1) && (userChoice != 2));

								} catch (Exception e) {

									System.out.println("\nInvalid Input. Try Again.\n");
									inputError = true;
									scanner.nextLine();
								} 
								
							} while (inputError);
							
						} else { //The player cannot afford to buy it
							
							//CHECK THAT ANYONE CAN AFFORD IT THEN OFFER IT FOR SALE
							boolean canAfford = false;
							
							for (int i = 0 ; i < gamePlayers.length ; i++) {
								
								if (gamePlayers[i].getBalance() > newSquareContractPrice) {
									canAfford = true;
								}
								
							}
							
							if (!canAfford) {
								System.out.println("No one can afford to take this contract");
							} else {
								
								//offer to other players
								int userSellChoice;
								
								do {
									
									inputError = false;
									
									try {
										
										do {

											do {
												//Ask who they want to offer it to
												System.out.println(
														"You cannot afford to take this contract but other players can. Who would like to take it?");
												//Display a list of the players
												for (int i = 0; i < gamePlayers.length; i++) {
													System.out.println((i + 1) + ". " + gamePlayers[i].getPlayerName());
												}
												System.out.println((gamePlayers.length + 1) + ". Cancel");
												//Read their choice
												userSellChoice = scanner.nextInt();
												scanner.nextLine();

												if ((userSellChoice < 1)
														|| (userSellChoice > (gamePlayers.length + 1))) {

													System.out.println("Invalid Choice");
												}

											} while ((userSellChoice < 1)
													|| (userSellChoice > (gamePlayers.length + 1)));

											//If the user chooses cancel, break out of the do loop
											if (userSellChoice == (gamePlayers.length + 1)) {

												break;

											}

											//Check if the selected player can afford it
											if (gamePlayers[(userSellChoice - 1)]
													.getBalance() < newSquareContractPrice) {

												System.out.println(gamePlayers[(userSellChoice - 1)].getPlayerName()
														+ " cannot afford this component");
												userSellChoice = -1;
											} else {

												//if ((userSellChoice > 1) && (userSellChoice < numberOfPlayers)) {
												//Deduct the contract price from the new owner's balance
												gamePlayers[(userSellChoice - 1)]
														.setBalance(gamePlayers[(userSellChoice - 1)].getBalance()
																- newSquareContractPrice);
												//Set the owner of the current square to the new owner
												gameBoard.boardSquares[gamePlayers[currentPlayer].getPosition()]
														.setOwner(userSellChoice - 1);
												//Set the placeholder for the components of the system to the new owner
												for (int i = 0; i < 12; i++) {

													if (gameBoard.boardSquares[i].getSystemName()
															.compareTo(newSquareSystem) == 0) {

														gameBoard.boardSquares[i].setPlaceholder(userSellChoice - 1);

													}

												}
												System.out.println(gamePlayers[userSellChoice - 1].getPlayerName()
														+ " is now in charge of this system and this component");
												//}

											}

										} while ((userSellChoice < 1) || (userSellChoice > numberOfPlayers));

									} catch (Exception e) {
										
										System.out.println("\nInvalid Input. Try Again.\n");
										inputError = true;
										scanner.nextLine();
									} 
									
								} while (inputError);
								
							}
							
						}
						
					} else { //If the current square belongs to a system that is being held by another player
						System.out.println("This system is has been contracted to another player but this compenent has not been contracted by them");
					}
					
				} else { //If the current square is owned by another player, the user must pay tax
					
					if (newSquareOwner != currentPlayer) {
						int taxes = 0;
						
						switch (newSquareDevLevel) {

							case (0): {
								taxes = newSquarePenaltyCostOne;
								break;
							}
							case (1): {
								taxes = newSquarePenaltyCostTwo;
								break;
							}
							case (2): {
								taxes = newSquarePenaltyCostThree;
								break;
							}
						}
						
						/*
						System.out.println();
						System.out.println("newSquareOwner: " + newSquareOwner);
						System.out.println("currentPlayer : " + currentPlayer);
						System.out.println("taxes         : " + taxes);
						System.out.println("penalty One   : " + newSquarePenaltyCostOne);
						System.out.println("penalty Two   : " + newSquarePenaltyCostTwo);
						System.out.println("penalty Three : " + newSquarePenaltyCostThree);
						System.out.println();
						*/
						
						do {
							
							inputError = false;
							
							try {
								System.out.println("This system is under the control of "
										+ gamePlayers[newSquareOwner].getPlayerName());
								System.out.println("They can choose to request $" + taxes + "K in contribution tax");
								int taxesChoice;
								do {

									System.out.println(gamePlayers[newSquareOwner].getPlayerName()
											+ ", Do you want to request this contribution tax be paid?");
									System.out.println("1. Yes");
									System.out.println("2. No");
									taxesChoice = scanner.nextInt();
									scanner.nextLine();

									if ((taxesChoice != 1) && (taxesChoice != 2)) {

										System.out.println("Invalid Input");

									} else if (taxesChoice == 1) {

										if (taxes > gamePlayers[currentPlayer].getBalance()) {

											do {

												System.out.println("This will bankrupt "
														+ gamePlayers[currentPlayer].getPlayerName()
														+ ", ending the game. Are you sure?");
												System.out.println("1. Yes");
												System.out.println("2. No");
												taxesChoice = scanner.nextInt();
												scanner.nextLine();

												if ((taxesChoice != 1) && (taxesChoice != 2)) {

													System.out.println("Invalid Input");

												} else if (taxesChoice == 1) {

													gamePlayers[currentPlayer].setBalance(
															gamePlayers[currentPlayer].getBalance() - taxes);
													gamePlayers[newSquareOwner].setBalance(
															gamePlayers[newSquareOwner].getBalance() + taxes);
													continuePlay = false;
													endGameReasonCode = 1;
												}

											} while ((taxesChoice != 1) && (taxesChoice != 2));

										} else {

											gamePlayers[currentPlayer]
													.setBalance(gamePlayers[currentPlayer].getBalance() - taxes);
											gamePlayers[newSquareOwner]
													.setBalance(gamePlayers[newSquareOwner].getBalance() + taxes);

										}

									}

								} while ((taxesChoice != 1) && (taxesChoice != 2));

							} catch (Exception e) {
								
								System.out.println("\nInvalid Input. Try Again.\n");
								inputError = true;
								scanner.nextLine();
								
							} 
						} while (inputError);
					}
					
				}
				
			} else { //If the current square is one of the special squares
				
				System.out.println();
				
				/*
				if (gamePlayers[currentPlayer].getPosition() == 0) {
					System.out.println("You have landed on Mission Control");
				} else if (gamePlayers[currentPlayer].getPosition() == 7){
					System.out.println("Today is a public holiday, no work will be done today");
				}
				*/
			}
			
			int turnMenuChoice;
			
			do {
				
				inputError = false;
				try {
					do {
						//Display turn menu
						System.out.println(
								"--- Turn Menu ------------------------------------------------------------------");
						System.out.println(
								"                       |                                                      ");
						System.out.println("   Current Player      |   " + gamePlayers[currentPlayer].getPlayerName());
						System.out.println(
								"                       |                                                      ");
						System.out.println(
								"   1. Develop System   |   Develop components of a system you control         ");
						System.out.println(
								"   2. End Turn         |   End your turn                                      ");
						System.out.println(
								"   3. Quit Game        |   Quit the game                                      ");
						System.out.println(
								"                       |                                                      ");
						System.out.println(
								"--------------------------------------------------------------------------------");

						turnMenuChoice = scanner.nextInt();

						if (turnMenuChoice == 1) {

							if (gamePlayers[currentPlayer].getPosition() != 7) {
								int devMenuChoice;
								int devCost = 0;
								do {

									String devMenuComponent;
									String devMenuSystem;
									int devMenuDevLevel;
									String DevMenuContractor;
									String DevMenuPlaceholder;
									int upgradeCost;
									int menuLabel = 1;

									System.out.printf(
											"--- Development Menu -----------------------------------------------------------------------------\n");
									System.out.printf("\n");
									System.out.printf("   %-17s%s\n", "Player Name      : ",
											gamePlayers[currentPlayer].getPlayerName());
									System.out.printf("   %-17s%-3d%s\n", "Player Balance   : $",
											gamePlayers[currentPlayer].getBalance(), "K");
									System.out.printf("\n");
									System.out.printf("   %-20s%-15s%-13s%-17s%-20s%-10s", "COMPONENT", "SYSTEM",
											"DEV LEVEL", "CONTRACTOR", "CONTRACT HELD BY", "UPGRADE COST\n");
									System.out.printf("\n");

									for (int i = 0; i < 12; i++) {

										if ((i != 0) && (i != 7)) {

											devMenuComponent = gameBoard.boardSquares[i].getSquareName();
											devMenuSystem = gameBoard.boardSquares[i].getSystemName();
											devMenuDevLevel = gameBoard.boardSquares[i].getDevLevel();

											if (gameBoard.boardSquares[i].getOwner() == -1) {
												DevMenuContractor = "None";
											} else {
												DevMenuContractor = gamePlayers[gameBoard.boardSquares[i].getOwner()]
														.getPlayerName();
											}

											if ((gameBoard.boardSquares[i].getPlaceholder() == -1)
													&& (gameBoard.boardSquares[i].getOwner() == -1)) { //The system is not owned by anyone
												DevMenuPlaceholder = "None";
											} else if ((gameBoard.boardSquares[i].getPlaceholder() != -1)
													&& (gameBoard.boardSquares[i].getOwner() == -1)) { //Someone owns an associated component but not this one
												DevMenuPlaceholder = gamePlayers[gameBoard.boardSquares[i]
														.getPlaceholder()].getPlayerName();
											} else {
												DevMenuPlaceholder = gamePlayers[gameBoard.boardSquares[i].getOwner()]
														.getPlayerName();
											}

											switch (gameBoard.boardSquares[i].getDevLevel()) {

											case (0): {
												upgradeCost = gameBoard.boardSquares[i].getDevCostOne();
												System.out.printf("   %2d%s%-16s%-15s%-4s%-9d%-17s%-20s%s%d%s\n",
														menuLabel++, ". ", devMenuComponent, devMenuSystem, "Lvl ",
														devMenuDevLevel, DevMenuContractor, DevMenuPlaceholder, "$",
														upgradeCost, "K");
												break;
											}

											case (1): {
												upgradeCost = gameBoard.boardSquares[i].getDevCostTwo();
												System.out.printf("   %2d%s%-16s%-15s%-4s%-9d%-17s%-20s%s%d%s\n",
														menuLabel++, ". ", devMenuComponent, devMenuSystem, "Lvl ",
														devMenuDevLevel, DevMenuContractor, DevMenuPlaceholder, "$",
														upgradeCost, "K");
												break;
											}

											case (2): {
												upgradeCost = 0;
												System.out.printf("   %2d%s%-16s%-15s%-4s%-9d%-17s%-20s%s\n",
														menuLabel++, ". ", devMenuComponent, devMenuSystem, "Lvl ",
														devMenuDevLevel, DevMenuContractor, DevMenuPlaceholder,
														"Fully Developed");
												break;
											}
											}

										}
									}

									System.out.printf("%s", "\n   11. Cancel\n");
									System.out.printf(
											"--------------------------------------------------------------------------------------------------\n");

									devMenuChoice = scanner.nextInt();
									scanner.nextLine();

									switch (devMenuChoice) {

									case (1): { //Helmet

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[1].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[1].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[1].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[1].getDevLevel() != 2)
												&& (gameBoard.boardSquares[1].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[1]
														.setDevLevel(gameBoard.boardSquares[1].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (2): { //Backpack

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[2].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[2].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[2].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[2].getDevLevel() != 2)
												&& (gameBoard.boardSquares[2].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[2]
														.setDevLevel(gameBoard.boardSquares[2].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (3): { //Suit

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[3].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[3].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[3].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[3].getDevLevel() != 2)
												&& (gameBoard.boardSquares[3].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[3]
														.setDevLevel(gameBoard.boardSquares[3].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (4): { //Scaffold Tower

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[4].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[4].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[4].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[4].getDevLevel() != 2)
												&& (gameBoard.boardSquares[4].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[4]
														.setDevLevel(gameBoard.boardSquares[4].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (5): { //Bridge

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[5].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[5].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[5].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[5].getDevLevel() != 2)
												&& (gameBoard.boardSquares[5].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[5]
														.setDevLevel(gameBoard.boardSquares[5].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (6): { //Support Tracks

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[6].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[6].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[6].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[6].getDevLevel() != 2)
												&& (gameBoard.boardSquares[6].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[6]
														.setDevLevel(gameBoard.boardSquares[6].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (7): { //Fuel Tanks

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[8].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[8].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[8].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[8].getDevLevel() != 2)
												&& (gameBoard.boardSquares[8].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[8]
														.setDevLevel(gameBoard.boardSquares[8].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (8): { //Hull

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[9].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[9].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[9].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[9].getDevLevel() != 2)
												&& (gameBoard.boardSquares[9].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[9]
														.setDevLevel(gameBoard.boardSquares[9].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (9): { //Solar Panels

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[10].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[10].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[10].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[10].getDevLevel() != 2)
												&& (gameBoard.boardSquares[10].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[10]
														.setDevLevel(gameBoard.boardSquares[10].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (10): { //Main Body

										//Find out what the dev cost is going to be
										switch (gameBoard.boardSquares[11].getDevLevel()) {
										case (0): {
											devCost = gameBoard.boardSquares[11].getDevCostOne();
											break;
										}
										case (1): {
											devCost = gameBoard.boardSquares[11].getDevCostTwo();
											break;
										}
										}

										//Offer to let the player develop the component if they can afford it and if they are the owner
										if ((gameBoard.boardSquares[11].getDevLevel() != 2)
												&& (gameBoard.boardSquares[11].getOwner() == currentPlayer)) {

											if (gamePlayers[currentPlayer].getBalance() >= devCost) {

												gameBoard.boardSquares[11]
														.setDevLevel(gameBoard.boardSquares[11].getDevLevel() + 1);
												gamePlayers[currentPlayer]
														.setBalance(gamePlayers[currentPlayer].getBalance() - devCost);

											} else {

												System.out.println("You cannot afford to develop that component");
											}

										} else {
											System.out.println(
													"This component is either owned by another player or already fully developed and cannot be developed any further");
										}

										break;
									}

									case (11): {
										break;
									}

									default: {
										System.out.println("Invalid Entry");
										break;
									}

									}

								} while (devMenuChoice != 11);

							} else {
								scanner.nextLine();
								System.out.println(
										"It's a bank holiday. All your scientists are off work. No systems can be developed.");
								System.out.println();
								System.out.println("Press Enter to continue...");
								scanner.nextLine();
							}

						} else if (turnMenuChoice == 2) {
							scanner.nextLine();
							break;

						} else if (turnMenuChoice == 3) {
							scanner.nextLine();
							continuePlay = false;
							endGameReasonCode = 2;
						} else {
							System.out.println("Invalid Selection");
						}

					} while ((turnMenuChoice != 2) && (turnMenuChoice != 3));

				} catch (Exception e) {
					
					System.out.println("\nInvalid Input. Try Again.\n");
					inputError = true;
					scanner.nextLine();
				} 
				
			} while (inputError);
			
			
			//When everyone has had a turn, generate yearly report data
			if (turnCounter == numberOfPlayers) {
				for (int i = 0 ; i < numberOfPlayers ; i++) {
					YearlyPlayerReport playerState = new YearlyPlayerReport(currentYear, gamePlayers[i].getPlayerName(), gamePlayers[i].getBalance());
					playerHistory.add(playerState);
				}

				YearlySystemReport systemState = new YearlySystemReport(currentYear, gameBoard.boardSquares[1].getOwner(), gameBoard.boardSquares[1].getDevLevel(), 
						gameBoard.boardSquares[2].getOwner(), gameBoard.boardSquares[2].getDevLevel(), 
						gameBoard.boardSquares[3].getOwner(), gameBoard.boardSquares[3].getDevLevel(),
						gameBoard.boardSquares[4].getOwner(), gameBoard.boardSquares[4].getDevLevel(),
						gameBoard.boardSquares[5].getOwner(), gameBoard.boardSquares[5].getDevLevel(),
						gameBoard.boardSquares[6].getOwner(), gameBoard.boardSquares[6].getDevLevel(),
						gameBoard.boardSquares[8].getOwner(), gameBoard.boardSquares[8].getDevLevel(),
						gameBoard.boardSquares[9].getOwner(), gameBoard.boardSquares[9].getDevLevel(),
						gameBoard.boardSquares[10].getOwner(), gameBoard.boardSquares[10].getDevLevel(),
						gameBoard.boardSquares[11].getOwner(), gameBoard.boardSquares[11].getDevLevel());

				systemHistory.add(systemState);
				currentYear++;
				turnCounter = 1;
			} else {
				turnCounter++;
			}
			
			//Check to see if the game is over or if the next player should get a turn
			int fullDevCount = 0;
			for (int i = 0 ; i < 12 ; i++) {
				
				if ((i != 0) || (i != 7)) {
					
					if (gameBoard.boardSquares[i].getDevLevel() == 2) {
						
						fullDevCount++;
					}
				}
			}
			
			if (fullDevCount == 10) {
				continuePlay = false;
				endGameReasonCode = 3;
			} else if ((currentPlayer+1 == numberOfPlayers)) {
				currentPlayer = 0;
			} else {
				currentPlayer++;
			}
			
		} while (continuePlay);
		
		endGame(endGameReasonCode, gamePlayers, playerHistory, systemHistory, scanner, currentYear, currentPlayer, gameBoard, numberOfPlayers);
		

		/* DISPLAY STATE OF BOARD AND PLAYERS FOR TESTING PURPOSES
		for (int i = 0 ; i < 12 ; i++) {
			
			System.out.println("Component Name: " + gameBoard.boardSquares[i].getSquareName());
			System.out.println("Description: " + gameBoard.boardSquares[i].getSquareDesc());
			System.out.println("System Name: " + gameBoard.boardSquares[i].getSystemName());
			System.out.println("Balance Increase: $" + gameBoard.boardSquares[i].getBalanceIncrease() + "K");
			System.out.println("Contract Price: $" + gameBoard.boardSquares[i].getContractPrice() + "K");
			System.out.println("Partial Dev Cost: $" + gameBoard.boardSquares[i].getDevCostOne() + "K");
			System.out.println("Full Dev Cost: $" + gameBoard.boardSquares[i].getDevCostTwo() + "K");
			System.out.println("Penalty No Dev: $" + gameBoard.boardSquares[i].getPenaltyCostOne() + "K");
			System.out.println("Penalty Partial Dev: $" + gameBoard.boardSquares[i].getPenaltyCostTwo() + "K");
			System.out.println("Penalty Full Dev: $" + gameBoard.boardSquares[i].getPenaltyCostThree() + "K");
			System.out.println("Owner: " + gameBoard.boardSquares[i].getOwner());
			System.out.println("Placeholder: " + gameBoard.boardSquares[i].getPlaceholder());
			System.out.println("Dev Level: " + gameBoard.boardSquares[i].getDevLevel());
			System.out.println();
			
		}
		

		for (int i = 0 ; i < gamePlayers.length ; i++) {
			
			System.out.println("Name: " + gamePlayers[i].getPlayerName());
			System.out.println("Balance: $" + gamePlayers[i].getBalance() + "K");
			System.out.println("Position: " + gamePlayers[i].getPosition());
			
		}
		
		*/
		
		
	}

	public static void displayRules() {
		
		System.out.println("                          _                 _       _      _ _       ");
		System.out.println("               /\\        | |               (_)     | |    (_) |      ");
		System.out.println("              /  \\   _ __| |_ ___ _ __ ___  _ ___  | |     _| |_ ___ ");
		System.out.println("             / /\\ \\ | '__| __/ _ \\ '_ ` _ \\| / __| | |    | | __/ _ \\");
		System.out.println("            / ____ \\| |  | ||  __/ | | | | | \\__ \\ | |____| | ||  __/");
		System.out.println("           /_/    \\_\\_|   \\__\\___|_| |_| |_|_|___/ |______|_|\\__\\___|");
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("                    HUMANITY'S RETURN TO THE MOON HAS BEGUN");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("                                            . ");
		System.out.println("                                           .'.");
		System.out.println("                                           |o|");
		System.out.println("                                          .'o'.");
		System.out.println("                                          |.-.|");
		System.out.println("                                          '   '");
		System.out.println("                                           ( )");
		System.out.println("                                            )");
		System.out.println("                                           ( )");
		System.out.println();
		System.out.println("                                       ____");
		System.out.println("                                  .-'\"\"p 8o\"\"`-.");
		System.out.println("                               .-'8888P'Y.`Y[ ' `-.");
		System.out.println("                             ,']88888b.J8oo_      '`.");
		System.out.println("                           ,' ,88888888888[\"        Y`.");
		System.out.println("                          /   8888888888P            Y8\\");
		System.out.println("                         /    Y8888888P'             ]88\\");
		System.out.println("                        :     `Y88'   P              `888:");
		System.out.println("                        :       Y8.oP '- >            Y88:");
		System.out.println("                        |          `Yb  __             `'|");
		System.out.println("                        :            `'d8888bo.          :");
		System.out.println("                        :             d88888888ooo.      ;");
		System.out.println("                         \\            Y88888888888P     /");
		System.out.println("                          \\            `Y88888888P     /");
		System.out.println("                           `.            d88888P'    ,'");
		System.out.println("                             `.          888PP'    ,'");
		System.out.println("                               `-.      d8P'    ,-'");
		System.out.println("                                  `-.,,_'__,,.-'");
		System.out.println("");
		System.out.println("--- Objective ---");
		System.out.println("The year is 2000, the goal is to send a manned team to the moon by the year 2050.");
		System.out.println("To accomplish this, players will have to work cooperatively to construct and develop ");
		System.out.println("the systems of the Artemis rocket.");
		System.out.println("");
		System.out.println("--- Rules ---");
		System.out.println("- Each player can take out the contracts on one (or more) of the systems that make up");
		System.out.println("  the Artemis rocket. Each system is comprised of a number of components.");
		System.out.println("");
		System.out.println("- Once a player takes the contract for a component, only they can take the contracts on");
		System.out.println("  the remaining components of that system.");
		System.out.println("");
		System.out.println("- If a player lands on a component who's contract has already been taken by another player,");
		System.out.println("  that player can choose to charge a tax, the amount being based on how developed the");
		System.out.println("  component is.");
		System.out.println("");
		System.out.println("- All components must be developed to level 2 for the game to end successfully.");
		System.out.println("");
		System.out.println("- If a player is bankrupted, the game is over.");
		System.out.println("");
		System.out.println("- If any player quits, the game is over.");
		System.out.println("");
		System.out.println("Good Luck");
		System.out.println();
	}
	
	public static int askHowManyPlayers(Scanner scanner) {
		
		int userInput = 0;
		boolean error;
		
		do {
			
			error = false;
			
			try {
				System.out.println("How many players are there? (Must be a number between 1-4)");
				userInput = scanner.nextInt();
				
				if ((userInput < 1) || (userInput > 4)) {
					System.out.println("The number of players must be between 1 and 4");
					error = true;
				}
				
			} catch (InputMismatchException e) { //Stop the user entering an invalid character
				System.out.println("Invalid Input. Try Again.");
				error = true;
				scanner.nextLine();
			}
			
		} while (error);
		
		return userInput;

	}
	
	public static String askPlayerNames(Scanner scanner, int playerNo) {

		String playerName = "";
		
		do {
			
			System.out.println();
			System.out.println("What is Player " + (playerNo+1) + "'s name?");
			playerName = scanner.next();
			scanner.nextLine();
			
			if (playerName.length() > 20) {
				System.out.println("Name is too long. Must be fewer than 20 characters");
			}
			
			
			
		} while (playerName.length() > 20);
		
		
		return playerName;
	}

	public static void endGame(int endGameReasonCode, Player gamePlayers[], ArrayList <YearlyPlayerReport> playerHistory, ArrayList <YearlySystemReport> systemHistory, Scanner scanner, int year, int currentPlayer, Board gameBoard, int numPlayers) {
		
		int endgameMenuChoice;
		
		/*
		 * End Codes:
		 * 1 - A player is bankrupt
		 * 2 - A user has chosen to end the game
		 * 3 - the Project is complete
		 */
		
		switch (endGameReasonCode) {
		
			case (1) : {
				String bankruptPlayer = "";
				
				for (int i = 0 ; i < gamePlayers.length ; i++) {
					if (gamePlayers[i].getBalance() <= 0) {
						bankruptPlayer = gamePlayers[i].getPlayerName();
					}
				}
				
				endGameOneHeadlines(scanner, year, bankruptPlayer);
				
				//DISPLAY FINAL YEAR REPORT
				endGameReport(scanner, year, gameBoard, gamePlayers);
				
				break;
			}
			
			case (2) : {
				
				String endingPlayer = gamePlayers[currentPlayer].getPlayerName();
				
				endGameTwoHeadlines(scanner, year, endingPlayer);
				
				//DISPLAY FINAL YEAR REPORT
				endGameReport(scanner, year, gameBoard, gamePlayers);
				
				break;
			}
			
			case (3) : {
				System.out.println("The project has come to an end");
				
				String SpaceSuitCompletedBy = gamePlayers[gameBoard.boardSquares[1].getOwner()].getPlayerName();
				String GroundSystemCompletedBy = gamePlayers[gameBoard.boardSquares[4].getOwner()].getPlayerName();		
				String RocketCompletedBy = gamePlayers[gameBoard.boardSquares[8].getOwner()].getPlayerName();		
				String LanderCompletedBy = gamePlayers[gameBoard.boardSquares[10].getOwner()].getPlayerName();
				
				endGameThreeHeadlines(scanner, year, SpaceSuitCompletedBy, GroundSystemCompletedBy, RocketCompletedBy, LanderCompletedBy);
				
				//DISPLAY FINAL YEAR REPORT
				endGameReport(scanner, year, gameBoard, gamePlayers);
				
				break;
			}
		
		}
		
		boolean repeatMenu = true;
		boolean inputError;
		
		do {
			
			inputError = false;
			
			try {
				do {
					System.out
							.println("--- Endgame Menu -------------------------------------------------------------");
					System.out
							.println("                       |                                                      ");
					System.out
							.println("   1. Player Report    |   See a year by year breakdown of player info        ");
					System.out
							.println("   2. System Report    |   See a year by year breakdown of system info        ");
					System.out
							.println("   3. Quit Game        |   Quit the game                                      ");
					System.out
							.println("                       |                                                      ");
					System.out
							.println("------------------------------------------------------------------------------");

					endgameMenuChoice = scanner.nextInt();
					scanner.nextLine();

					switch (endgameMenuChoice) {

					case (1): {

						int counter = 0;
						System.out.printf("%-8s%-20s%-6s\n", "YEAR", "PLAYER NAME", "BALANCE");

						for (YearlyPlayerReport p : playerHistory) {

							System.out.printf("%-8d%-20s$%4d%s\n", p.getYear(), p.getPlayerName(), p.getPlayerBalance(),
									"K");
							counter++;

							if (counter == numPlayers) {
								System.out.println();
								counter = 0;
							}

						}

						System.out.println("\nPress enter to return to the menu...");
						scanner.nextLine();
						break;
					}

					case (2): {

						System.out.printf("%-8s%-15s%-20s%-20s%-15s\n", "YEAR", "SYSTEM", "COMPONENT", "OWNER",
								"DEVELOPMENT LEVEL");

						for (YearlySystemReport s : systemHistory) {

							s.finalReport(gamePlayers);
						}

						System.out.println("\nPress enter to return to the menu...");
						scanner.nextLine();
						break;
					}

					case (3): {

						System.out.println("       !                              ");
						System.out.println("       !                              ");
						System.out.println("       ^                              ");
						System.out.println("      / \\                              ");
						System.out.println(
								"     /___\\         _______ _                 _                                ");
						System.out.println(
								"    |=   =|       |__   __| |               | |                             ");
						System.out.println(
								"    |     |          | |  | |__   __ _ _ __ | | _____                         ");
						System.out.println(
								"    |     |          | |  | '_ \\ / _` | '_ \\| |/ / __|                       ");
						System.out.println(
								"    |     |          | |  | | | | (_| | | | |   <\\__ \\                        ");
						System.out.println(
								"    |     |        __|_|_ |_| |_|\\__,_|_| |_|_|\\_\\___/                        ");
						System.out.println("    |     |       |  ____|                        ");
						System.out.println(
								"    |     |       | |__ ___  _ __                                             ");
						System.out.println("    |     |       |  __/ _ \\| '__|                        ");
						System.out.println("    |     |       | | | (_) | |                          ");
						System.out.println("   /|##!##|\\      |_|__\\___/|_|         _                          ");
						System.out.println("  / |##!##| \\     |  __ \\| |           (_)                          ");
						System.out.println(" /  |##!##|  \\    | |__) | | __ _ _   _ _ _ __   __ _    ");
						System.out.println(
								"|  / ^ | ^ \\  |   |  ___/| |/ _` | | | | | '_ \\ / _` |                            ");
						System.out.println(
								"| /  ( | )  \\ |   | |    | | (_| | |_| | | | | | (_| |                            ");
						System.out.println(
								"|/   ( | )   \\|   |_|    |_|\\__,_|\\__, |_|_| |_|\\__, |                            ");
						System.out.println(
								"    ((   ))                       __/ |         __/ |                       ");
						System.out.println(
								"   ((  :  ))                     |___/         |___/                         ");
						System.out.println("   ((  :  ))                              ");
						System.out.println("    ((   ))                              ");
						System.out.println("     (( ))                              ");
						System.out.println("      ( )                              ");
						System.out.println("       .                              ");
						System.out.println("       .                              ");

						repeatMenu = false;

						break;
					}

					}

				} while (repeatMenu);

			} catch (Exception e) {
				
				System.out.println("\nInvalid Input. Try Again.\n");
				inputError = true;
				scanner.nextLine();
				
			} 
			
		} while (inputError);
	}
	
	public static void endGameOneHeadlines(Scanner scanner, int year, String player) {
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("  _____           _           _     _    _       _ _           _            ");
		System.out.println(" |  __ \\         (_)         | |   | |  | |     | | |         | |          ");
		System.out.println(" | |__) | __ ___  _  ___  ___| |_  | |__| | __ _| | |_ ___  __| |           ");
		System.out.println(" |  ___/ '__/ _ \\| |/ _ \\/ __| __| |  __  |/ _` | | __/ _ \\/ _` |        ");
		System.out.println(" | |   | | | (_) | |  __/ (__| |_  | |  | | (_| | | ||  __/ (_| |           ");
		System.out.println(" |_|   |_|  \\___/| |\\___|\\___|\\__| |_|  |_|\\__,_|_|\\__\\___|\\__,_|   ");
		System.out.println("                _/ |                                                        ");
		System.out.println("               |__/                                                         ");
		System.out.println("------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In the year %d, %s, a major investor in Project Artemis declared\n", year, player);
		System.out.printf("bankruptcy, putting the future of the whole project into jeopardy.\n");
		System.out.printf("Remaining investors vowed to continue with the project once new\n");
		System.out.printf("sources of funding had been secured.");

		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("                _                 _        ____                 _        _              ");
		System.out.println("     /\\        | |               (_)      / __ \\               | |      | |             ");
		System.out.println("    /  \\   _ __| |_ ___ _ __ ___  _ ___  | |  | |_   _____ _ __| |_ __ _| | _____ _ __  ");
		System.out.println("   / /\\ \\ | '__| __/ _ \\ '_ ` _ \\| / __| | |  | \\ \\ / / _ \\ '__| __/ _` | |/ / _ \\ '_ \\ ");
		System.out.println("  / ____ \\| |  | ||  __/ | | | | | \\__ \\ | |__| |\\ V /  __/ |  | || (_| |   <  __/ | | |");
		System.out.println(" /_/    \\_\\_|   \\__\\___|_| |_| |_|_|___/  \\____/  \\_/ \\___|_|   \\__\\__,_|_|\\_\\___|_| |_|");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, a conglomerate of European companies announced that they had completed development\n", (year+1));
		System.out.printf("on their own rocket and lander system that would be able to put people on the moon and\n");
		System.out.printf("planned to launch that year. This along with continueing funding problems put the future\n");
		System.out.printf("of the Artemis project into doubt.");
		
		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                _                 _        _____                                     _ ");
		System.out.println("     /\\        | |               (_)      / ____|                                   | |");
		System.out.println("    /  \\   _ __| |_ ___ _ __ ___  _ ___  | (___   ___ _ __ __ _ _ __  _ __   ___  __| |");
		System.out.println("   / /\\ \\ | '__| __/ _ \\ '_ ` _ \\| / __|  \\___ \\ / __| '__/ _` | '_ \\| '_ \\ / _ \\/ _` |");
		System.out.println("  / ____ \\| |  | ||  __/ | | | | | \\__ \\  ____) | (__| | | (_| | |_) | |_) |  __/ (_| |");
		System.out.println(" /_/    \\_\\_|   \\__\\___|_| |_| |_|_|___/ |_____/ \\___|_|  \\__,_| .__/| .__/ \\___|\\__,_|");
		System.out.println("                                                               | |   | |               ");
		System.out.println("                                                               |_|   |_|               ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, the European conglomerate celebrated their success in landing humans on the moon\n", (year+2));
		System.out.printf("for the first time in decades. Having not been able to secure more funding for the project\n");
		System.out.printf("and with little to no progress made on development of system components, the project was\n");
		System.out.printf("quietly cancelled and all developed systems either scrapped or repurposed for other projects");
		
		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
	}

	public static void endGameTwoHeadlines(Scanner scanner, int year, String endingPlayer) {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("  _____                     _               _____       _ _        ____        _   ");
		System.out.println(" |_   _|                   | |             |  __ \\     | | |      / __ \\      | |  ");
		System.out.println("   | |  _ ____   _____  ___| |_ ___  _ __  | |__) |   _| | |___  | |  | |_   _| |_");
		System.out.println("   | | | '_ \\ \\ / / _ \\/ __| __/ _ \\| '__| |  ___/ | | | | / __| | |  | | | | | __|");
		System.out.println("  _| |_| | | \\ V /  __/\\__ \\ || (_) | |    | |   | |_| | | \\__ \\ | |__| | |_| | |_ ");
		System.out.println(" |_____|_| |_|\\_/ \\___||___/\\__\\___/|_|    |_|    \\__,_|_|_|___/  \\____/ \\__,_|\\__|");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, NASA's Project Artemis was dealt a major blow when one of its primary investors,\n", year);
		System.out.printf("%s announced that they were pulling all funding for the project and ending all activies\n", endingPlayer);
		System.out.printf("in relation to systems developement. In reaction to this announcement, the project's\n");
		System.out.printf("remaining investors petitioned the government to contribute the lost funds and\n");
		System.out.printf("materials so that the project faced minimal delays. The government aggreed to make\n");
		System.out.printf("up the funding shortfall while the remaining investors attempted to secure a replacement\n");
		System.out.printf("investor");
		
		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("  ______               _ _               _____       _ _          _ ");
		System.out.println(" |  ____|             | (_)             |  __ \\     | | |        | |");
		System.out.println(" | |__ _   _ _ __   __| |_ _ __   __ _  | |__) |   _| | | ___  __| |");
		System.out.println(" |  __| | | | '_ \\ / _` | | '_ \\ / _` | |  ___/ | | | | |/ _ \\/ _` |");
		System.out.println(" | |  | |_| | | | | (_| | | | | | (_| | | |   | |_| | | |  __/ (_| |");
		System.out.println(" |_|   \\__,_|_| |_|\\__,_|_|_| |_|\\__, | |_|    \\__,_|_|_|\\___|\\__,_|");
		System.out.println("                                  __/ |                             ");
		System.out.println("                                 |___/                              ");
		System.out.println("---------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, NASA's struggling Artemis project faced another major setback\n", (year+1));
		System.out.printf("when the government announced that it would no longer be contributing\n");
		System.out.printf("extra funding for the project citing a lack of effort on the part of the\n");
		System.out.printf("other major investors in finding a replacement for %s who pulled out of\n", endingPlayer);
		System.out.printf("the project in %d. The remaining investors vowed to continue\n", (year));
		System.out.printf("development of the project but warned that the reduced funding would affect\n");
		System.out.printf("the previously proposed schedule");
		
		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                _                 _        _____                                     _ ");
		System.out.println("     /\\        | |               (_)      / ____|                                   | |");
		System.out.println("    /  \\   _ __| |_ ___ _ __ ___  _ ___  | (___   ___ _ __ __ _ _ __  _ __   ___  __| |");
		System.out.println("   / /\\ \\ | '__| __/ _ \\ '_ ` _ \\| / __|  \\___ \\ / __| '__/ _` | '_ \\| '_ \\ / _ \\/ _` |");
		System.out.println("  / ____ \\| |  | ||  __/ | | | | | \\__ \\  ____) | (__| | | (_| | |_) | |_) |  __/ (_| |");
		System.out.println(" /_/    \\_\\_|   \\__\\___|_| |_| |_|_|___/ |_____/ \\___|_|  \\__,_| .__/| .__/ \\___|\\__,_|");
		System.out.println("                                                               | |   | |               ");
		System.out.println("                                                               |_|   |_|               ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, remaining investors announced that they were pulling out of NASA's Artemis\n", (year+2));
		System.out.printf("project. Having not been able to secure the required funding and facing competition from\n");
		System.out.printf("other lunar projects which were outpacing them, the government officially scrapped the\n");
		System.out.printf("project and reallocated resources to remaining projects to support other lunar operations.");
		
		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
		
	}

	public static void endGameThreeHeadlines(Scanner scanner, int year, String SpaceSuitCompletedBy, String groundSystemCompletedBy, String rocketCompletedBy, String landerCompletedBy) {
		
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("                _                 _        _____                      _      _           _ ");
		System.out.println("     /\\        | |               (_)      / ____|                    | |    | |         | |");
		System.out.println("    /  \\   _ __| |_ ___ _ __ ___  _ ___  | |     ___  _ __ ___  _ __ | | ___| |_ ___  __| |");
		System.out.println("   / /\\ \\ | '__| __/ _ \\ '_ ` _ \\| / __| | |    / _ \\| '_ ` _ \\| '_ \\| |/ _ \\ __/ _ \\/ _` |");
		System.out.println("  / ____ \\| |  | ||  __/ | | | | | \\__ \\ | |___| (_) | | | | | | |_) | |  __/ ||  __/ (_| |");
		System.out.println(" /_/    \\_\\_|   \\__\\___|_| |_| |_|_|___/  \\_____\\___/|_| |_| |_| .__/|_|\\___|\\__\\___|\\__,_|");
		System.out.println("                                                               | |                         ");
		System.out.println("                                                               |_|                         ");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, NASA announced in a joint press conference with investors that it had completed\n", year);
		System.out.printf("development of its Artemis rocket system and planned to begin primary testing that year with\n");
		System.out.printf("a plan to launch mid-%d, ", (year+1));
		if((year + 1) < 2050) {
			System.out.printf("%d years ahead of the planned 2050 target.\nStock prices of all the investors rose significantly on the announcement.\n", (2050-(year+1)));
		} else if ((year+1) == 2050) {
			System.out.printf("meeting its planned target of 2050.\nStock prices of all the investors rose modestly on the announcement.\n");
		} else {
			System.out.printf("missing its planned 2050 target by %d years.\nDespite this, stock prices of all the investors rose slightly on the announcement.\n", ((year+1)-2050));
		}
		System.out.printf("As detailed in the conference: \n");
		System.out.printf("- The Space Suit system was completed by %s\n", SpaceSuitCompletedBy);
		System.out.printf("- The Ground Systems by %s\n", groundSystemCompletedBy);
		System.out.printf("- The Rocket system by %s\n", rocketCompletedBy);
		System.out.printf("- The Lander system by %s\n", landerCompletedBy);
		
		System.out.println("\n\nPress Enter to continue...");
		scanner.nextLine();
		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("                _                 _       _                     _     ");
		System.out.println("     /\\        | |               (_)     | |                   | |    ");
		System.out.println("    /  \\   _ __| |_ ___ _ __ ___  _ ___  | |     __ _ _ __   __| |___ ");
		System.out.println("   / /\\ \\ | '__| __/ _ \\ '_ ` _ \\| / __| | |    / _` | '_ \\ / _` / __|");
		System.out.println("  / ____ \\| |  | ||  __/ | | | | | \\__ \\ | |___| (_| | | | | (_| \\__ \\");
		System.out.println(" /_/    \\_\\_|   \\__\\___|_| |_| |_|_|___/ |______\\__,_|_| |_|\\__,_|___/");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println();
		System.out.printf("In %d, NASA celebrated the successful launch of the Artemis rocket and the\n", (year+1));
		System.out.printf("successful landing of the Artemis lander on the moon. Thanks to the systems\n");
		System.out.printf("developed by investors, the launch and landing went smoothly with no faults.\n");
		System.out.printf("NASA announced that with this first major step, separate plans could go ahead\n");
		System.out.printf("to set up a scientific research base on the surface of the moon in the future.\n");
		
		System.out.println("\nPress Enter to continue...");
		scanner.nextLine();
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("  _   _           _      _____ _                    __  __                ");
		System.out.println(" | \\ | |         | |    / ____| |                  |  \\/  |               ");
		System.out.println(" |  \\| | _____  _| |_  | (___ | |_ ___  _ __       | \\  / | __ _ _ __ ___ ");
		System.out.println(" | . ` |/ _ \\ \\/ / __|  \\___ \\| __/ _ \\| '_ \\      | |\\/| |/ _` | '__/ __|");
		System.out.println(" | |\\  |  __/>  <| |_   ____) | || (_) | |_) |  _  | |  | | (_| | |  \\__ \\");
		System.out.println(" |_| \\_|\\___/_/\\_\\\\__| |_____/ \\__\\___/| .__/  ( ) |_|  |_|\\__,_|_|  |___/");
		System.out.println("                                       | |     |/                         ");
		System.out.println("                                       |_|                                ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("After the success of the initial Artemis project in %d, NASA announced in %d\n", (year+1), (year+2));
		System.out.printf("the next phase of the Artemis project, sending a group of humans to land on\n");
		System.out.printf("Mars. All investors of the initial project announced that they would be supporting\n");
		System.out.printf("the Mars effort after NASA proposed a 2080 target date.\n");
		
		System.out.println("\nPress Enter to continue...");
		scanner.nextLine();
	}

	public static void endGameReport(Scanner scanner, int year, Board gameBoard, Player[] gamePlayers) {
		
		System.out.printf("--- End Game Report ------------------------------------------------------------\n");
		System.out.printf("Project Ended in %d\n\n", year);
		System.out.printf("Players\n");
		System.out.printf("%-20s%-6s\n","PLAYER NAME","ENDING BALANCE");
		for (int i = 0 ; i < gamePlayers.length ; i++) {
			System.out.printf("%-20s$%-4d%s\n", gamePlayers[i].getPlayerName(), gamePlayers[i].getBalance(),"K");
		}
		System.out.printf("\n%-15s%-20s%-20s%-15s\n", "SYSTEM","COMPONENT","OWNER","DEVELOPMENT LEVEL");
		for (int i = 0 ; i < 12 ; i++) {
			
			if ((i != 0) && (i != 7)) {
				
				String systemName = gameBoard.boardSquares[i].getSystemName();
				String squareName = gameBoard.boardSquares[i].getSquareName();
				
				String owner = "";
				if (gameBoard.boardSquares[i].getOwner() == -1) {
					owner = "None";
				} else {
					owner = gamePlayers[gameBoard.boardSquares[i].getOwner()].getPlayerName();
				}
				
				int devLevel = gameBoard.boardSquares[i].getDevLevel();
				
				System.out.printf("%-15s%-20s%-20s%-15d\n", systemName, squareName, owner, devLevel);
			}
			
		}
		
		System.out.printf("--------------------------------------------------------------------------------\n");
		System.out.printf("\nPress Enter to continue...");
		scanner.nextLine();
	
	}
}
