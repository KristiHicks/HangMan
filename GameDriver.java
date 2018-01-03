/*File Name: GameDriver
	Author: Kristi Hicks
        KUID: 2795468
	Email Address: k443h544@ku.edu 
	Homework Assignment Number: Homework 3
	Description:  Plays Hangman with the user. The user guesses letters to display the secret word and once they guess all the letters to the word they win the game.
	Last Changed: April 19th, 2015 */
import java.util.Scanner;

public class GameDriver {
		public static void main (String[] args){
			HangMan hangman = new HangMan();
			String secretword = "big bang"; // Sets the secret word
			HangMan.initialize(secretword); // Calls the method in the class HangMan
			char guess = ' ';
			String yesno = "";
			String placeholder = "";
			boolean newGame = true;
			boolean gameOver = false;
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to the Hangman Game!");
			System.out.println("----------------------------\n");
			while (newGame == true) {
				while (gameOver == false){
					System.out.println("Guess this: " + HangMan.getDisguisedWord()); // Calls the method in the class HangMan
					System.out.println("Guesses so far: " + HangMan.getGuessCount()); // Calls the method in the class HangMan
					System.out.println("Misses: " + HangMan.getMissedMarker()); // Calls the method in the class HangMan
					System.out.println("Enter your guess character: ");
					placeholder = input.next(); // User enters the letter they want
					placeholder = placeholder.toLowerCase(); // Changes letter to lower case
					guess = placeholder.charAt(0);
					if (HangMan.guessCharacter(guess) == true){
						System.out.println(guess + " is in the secret word!");
						HangMan.hangman.setGuessCount();
					}
					else {
						System.out.println(guess + " is not in the secret word. Death draws closer.");
						HangMan.hangman.setMissesCount(); // Calls the method in the class HangMan
						HangMan.hangman.setGuessCount(); // Calls the method in the class HangMan
					}
					System.out.println();
					gameOver = HangMan.hangman.isGameOver(); // Calls the method in the class HangMan
				}
				System.out.println("Game Over!");
				if (HangMan.hangman.isFound() == true){
					System.out.println("Congratulations! You guessed the secret word: " + secretword + " in " + HangMan.hangman.getGuessCount() + " guesses!");
				}
				else{
					System.out.println("You died. Next time, guess as if your life depended on it!");
				}
				System.out.println("Do you want to play again? (yes/no):");
				yesno = input.next(); // User enters if they want to play again
				yesno = yesno.toLowerCase(); // Changes input to lower case
				if (yesno.equals("yes")){
					
					System.out.println("Input a new secret word: ");
					secretword = input.next();
					HangMan.initialize(secretword); // Calls the method in the class HangMan to declare a new secret word
					gameOver = false;
					for(int i =0; i< 100; i++){
						System.out.println();
					}
				}
				else {
					newGame = false;
					System.out.println("Thanks for playing " + HangMan.hangman.getGamesPlayed() + " games of Hang Man!");
				}
			}
		}
}
