/*File Name: GameDriver
	Author: Kristi Hicks
        KUID: 2795468
	Email Address: k443h544@ku.edu 
	Homework Assignment Number: Homework 3
	Description:  Initializes methods that belong to every HangMan game
	Last Changed: April 19th, 2015 */
public class HangMan extends GameDriver {
	
		private String secret_word; // Secret Word = big bang
		private char[] disguised_word; // Length of the disguised word
		private int guessCount=0; // Counts the number of guesses
		private int missesCount=0; // Counts the number of misses
		private int MAX_MISSES_ALLOWED=7; // The Max Misses the user has
		private char[] missedMarkers; // Length of the Misses
		public static HangMan hangman = new HangMan();
		private int gamesPlayed = 0; // Counts the number of games played
		public static void initialize(String word){ // Sets the disguised word to ??? ????
			hangman.secret_word = word;
			int length = hangman.secret_word.length();
			hangman.disguised_word = new char[length];
			for (int i = 0; i < length; i++){
				if (Character.isWhitespace(hangman.secret_word.charAt(i))){
					hangman.disguised_word[i] = ' ';
				}
				else {
					hangman.disguised_word[i] = '?';
				}
			}
			hangman.MAX_MISSES_ALLOWED = 7;
			hangman.missedMarkers = new char[hangman.MAX_MISSES_ALLOWED];
			for (int i = 0; i < hangman.MAX_MISSES_ALLOWED; i++){
				hangman.missedMarkers[i] = 'O';
			}
			hangman.guessCount = 0;
			hangman.missesCount = 0;
			hangman.gamesPlayed++;
		}
		public static boolean guessCharacter (char c){ // Returns the disguised word with the correct letter guesses 
			boolean isIn = false;
			for (int i = 0; i < hangman.secret_word.length(); i++){
				if (c == Character.toLowerCase(hangman.secret_word.charAt(i))){
					isIn = true;
					hangman.disguised_word[i] = c;
				}
			}
			return isIn;
		}
		public boolean isGameOver(){ // Returns if the games over or not
			boolean gameOver = false;
			boolean found = hangman.isFound();
			if (found == true){
				gameOver = true;
			}
			else if (hangman.missesCount == 7){
				gameOver = true;
			}
			return gameOver;
		}
		public boolean isFound(){ // Returns if the secret word is found
			boolean isFound = false;
			boolean isquestion = false;
			for (int i = 0; i < hangman.secret_word.length(); i++){
				if (hangman.disguised_word[i] == '?'){
					isquestion = true;
			
				}
			
			}
			if(isquestion == false){
				isFound = true;
			}
			return isFound;
		}
		public static String getDisguisedWord(){ // Displays the disguised word
			String word = "";
			for (int i = 0; i < hangman.secret_word.length(); i++){
				word = word + hangman.disguised_word[i];
			}
			return word;
		}
		public static int getGuessCount(){ // Tells the user how many guess they've done
			return hangman.guessCount;
		}
		public void setGuessCount(){
			hangman.guessCount++;
		}
		public void setMissesCount(){
			hangman.missesCount++;
			for (int i = 0; i < 7; i++){
				if (hangman.missesCount > i){
					hangman.missedMarkers[i] = 'X';
				}
			}
		}
		public int getMissesCount(){ // Tells the user how many misses they have
			return hangman.missesCount;
		}
		public static String getMissedMarker(){
			String missed = "";
			for (int i = 0; i < 7; i++){
				if (hangman.missedMarkers[i] == 'O'){
					missed = missed + "O";
				}
				else if (hangman.missedMarkers[i] == 'X'){
					missed = missed + "X";
				}
			}
			return missed;
		}
		int getGamesPlayed(){ // Tells the user how many games they've played
			return hangman.gamesPlayed;
		}
	}


