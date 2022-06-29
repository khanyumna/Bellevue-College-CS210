// CS210 Assignment #5 "Guessing Game"
// Summary: This is a game where the program chooses a number from 1-100, and the user has to guess what the number is.
// the program tells the user if their guess is too high or too low. Once the user guesses the number correctly, the 
// program asks the user if it wants to play again. If the user says yes, the program runs again. If not, the program
// prints out the overall stats of the user. 
// Yumna Khan

import java.util.*;

public class GuessingGame {
	
	public static void main (String[] args) {

		//Initializing Scanner and Random, calling the game.
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		theGame(s, rand);
	}

	public static void theGame(Scanner s, Random rand) { //Method for the game.
		// Initializing variables.
		boolean game = true;
		int tries = 0;
		int total_tries = 0;
		int total_games = 1;
		int best_game = 1000; //Most likely, the user will not need more than 1000 tries to win.
		String play_again = "";
		
		//Outer do/while loop that proceeds with inside statements while game is "true" (player is playing).
		do {
			int number = rand.nextInt(100)+1; //Random number from 1-100 (inclusive)
			System.out.println("I'm thinking of a number between 1 to 100...");
			System.out.print("Your guess?: ");
			int user = s.nextInt();
			tries++;
				
			// (Inner while loop) While the user doesn't enter a number equal to the random number, the program tells the user if 
			// the number they entered is higher or lower than the correct number. It then asks for another guess and increments 
			// the number of tries.
			while (user!= number) {
					
				if (user > number) {
					System.out.println("It's lower.");
				}
				
				else if (user < number) {
					System.out.println("It's higher.");
				}
				tries++;
				System.out.print("Your guess?:");
				user = s.nextInt();
				
				} // Inner while loop ends when user guesses the right number.
			
				total_tries += tries; //Total tries is calculated for each game.
				if (tries <= best_game) { //Checks if the tries taken for one game is less than previous game. Keeps lowest
					best_game = tries;    // number of tries.
				}
				
				System.out.println("You guessed it in "+ tries + " tries!");
				//Asks user to play again. 
				System.out.print("Play again?: ");
				play_again = s.next();
				System.out.println();
				
				if (play_again.startsWith("Y") || play_again.startsWith("y")) {
					game = true; //Game is true here, so the game runs again. 
					total_games += 1; 
				}
				
				else {
					game = false; // Game is false here, so game stops running and exits outside do/while loop.
				}
			} while (game);
			// Game is not running anymore (outside do/while loop).
	
			//Prints statistics of user.
			System.out.println();
			System.out.println("Your overall stats: ");
			System.out.println("Total games: " + total_games);
			System.out.println("Total guesses: " + total_tries);
			System.out.printf("Guesses/Game: %.1f\n", (double)total_tries/total_games); //Using printf statement in case of roundoff error.
			System.out.println("Your best game took " + best_game + " tries.");
		}
	}
