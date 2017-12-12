import java.util.Scanner;
import java.lang.System;

public class Game {
	
	public static void main(String arg[]) {
		System.out.println("Game explanation: \n" + 
				"Player and computer start with 50 health points. \n" + 
				"Whoever wins the first round of rock paper scissors gains the upper hand. \n" + 
				"If the one with the upper hand guesses the opponents move correctly then the one without the upperhand loses 15 health points. \n" + 
				"If the one with the upper hand incorrectly guesses the opponents move then the one without the upperhand gains 5 health points. \n" + 
				"Both players play till one ends up with 0 or less health points. \n" +
				"1 = Rock \n" + "2 = Paper \n" + "3 = Scissors \n");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.next();
		Player computer = new Player("computer");
		Player player1 = new Player(name);
		while(computer.Health > 0 && player1.Health > 0) {
			firstHand(player1, computer);
		}
		if(computer.Health <= 0 || player1.Health <= 0)
			if(computer.Health <= 0) {
				System.out.println(player1.playerName + " wins");
				sc.close();
			}else {
				System.out.println("computer wins");
 			}	
}

	private static void firstHand(Player player1, Player computer) {
		Scanner hand = new Scanner(System.in);
		System.out.println("Pick a hand:");
		int input = hand.nextInt();
			int min = 1;
 			int max = 3;
			int computerHand;
			computerHand = min + (int)(Math.random() * ((max - min) +1));
			
			int rock = 1;
			int paper = 2;
			int scissors = 3;
			
			if (input < 1 || input > 3) {
				System.out.println("Wrong input");
				System.out.print("Try again");
				input = hand.nextInt();
			}
			
			if (input == rock) {
				if (computerHand == rock) {
					System.out.println("Draw");
					firstHand(player1, computer);
 				} else if (computerHand == paper) {
					System.out.println("Computer has the upperhand!");
					computer.upperHand = true;
					player1.upperHand = false;
					nextHand(player1, computer);
 				} else if (computerHand == scissors) {
					System.out.println("You have the upperhand!");
					player1.upperHand = true;
					computer.upperHand = false;
					nextHand(player1, computer);
 				}
			} else if ( input == paper) {
				if (computerHand == rock) {
					System.out.println("You have the upperhand!");
					player1.upperHand = true;
					computer.upperHand = false;
					nextHand(player1, computer);
 				} else if (computerHand == paper) {
					System.out.println("Draw!");
					firstHand(player1, computer);
 				} else if (computerHand == scissors) {
					System.out.println("Computer has the upperhand!");
					computer.upperHand = true;
					player1.upperHand = false;
					nextHand(player1, computer);
 				}
			} else if ( input == scissors) {
				if (computerHand == rock) {
					System.out.println("Computer has the upperhand!");
					computer.upperHand = true;
					player1.upperHand = false;
					nextHand(player1, computer);
 				} else if (computerHand == paper) {
					System.out.println("You have the upperhand!");
					player1.upperHand = true;
					computer.upperHand = false;
					nextHand(player1, computer);
				} else if (computerHand == scissors) {
					System.out.println("Draw!");
					firstHand(player1, computer);
 				}
			}		
	}

	private static void nextHand(Player player1, Player computer) {
		Scanner hand = new Scanner(System.in);
		int secondInput;
 		int min = 1;
		int max = 3;
		int computerHand;
		computerHand = min + (int)(Math.random() * ((max - min) +1));

		System.out.println("Choose again");
		secondInput = hand.nextInt();
 		computerHand = min + (int)(Math.random() * ((max - min) +1));
		if (computer.upperHand) {
			if (secondInput == computerHand) {
				player1.Health -= 15;
				System.out.println(player1.playerName + " loses 15 health" );
				System.out.println(player1.playerName + " Health:" + player1.Health);
				computer.upperHand = false;
			} else {
				player1.Health += 5;
				System.out.println(player1.playerName + " gains 5 health" );
				System.out.println(player1.playerName + " Health:" + player1.Health);
				computer.upperHand = false;
			}
		}else if (player1.upperHand) {
			if(secondInput == computerHand) {
				computer.Health -= 15;
				System.out.println("computer" + " loses 15 health" );
				System.out.println("computer" + " Health:" + computer.Health);
				player1.upperHand = false;
				computer.upperHand = false;
			}else {
				computer.Health +=5;
				System.out.println("computer" + " gains 5 health" );
				System.out.println("computer" + " Health:" + computer.Health);
				player1.upperHand = false;
				computer.upperHand = false;
			}
		}
	}
		 
}
	