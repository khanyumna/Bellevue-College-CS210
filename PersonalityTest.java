// CS210 Assignment #7 "Personality Test"
// Summary: This program reads a file where characters type a string of A's and B's to determine their Keirsey personality
// type. There were 70 questions which were divided into 10 groups of 7, and there were four categories
// of questions. This program counts the A's and B's, sorts them into 4 categories, finds the percent of how many times
// the character typed "B", then uses that percent to determine their final type. The four categories determine if the character is
// introverted/extroverted, sensing/intuitive, thinking/feeling, and judging/perceiving. 
// Yumna Khan

import java.util.*;
import java.io.*;

public class PersonalityTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		//Initializing Scanner to read the file, printing introduction.
		Scanner readFile = new Scanner(new File("personality.txt"));
		System.out.println("** This program reports the results for Keirsey Personality Test **");
		System.out.println();
		boolean running = true; //To start/stop the while loop.
		
		while (running) {
			
			if (readFile.hasNextLine()) {
				
				String name = readFile.nextLine();
				System.out.println(name + ":");
				
				if (readFile.hasNextLine()) {
					String answers = readFile.nextLine();
					answers = answers.toLowerCase(); //Turning answers to lowercase for ease of translation.
					//Initializing arrays.
					int[] aCount = new int[4];
					int[] bCount = new int[4];
					int[] bPercent = new int[4];
					char[] type = new char[4];
					
					//Method calls. Arrays retain memory because they are objects (reference semantics).
					readAnswers(aCount, bCount, answers);
					givePercent(aCount, bCount, bPercent);
					giveType(bPercent, type);
					printResults(aCount, bCount, bPercent, type);
					System.out.println();
					}	
				}
			
			else {
				running = false; //If that file does not have nextLine, while loop stops running.
			} 
		} 
	}
	
	//This method reads the string of A's and B's the characters have under their name, and sorts it into 
	//the counts of A's and the counts of B's across the 4 categories.
	public static void readAnswers(int aCount[], int bCount[], String answers) {
		
		//For loop to check through each letter in the string.
		for (int i = 0; i < answers.length(); i++) {
			char ans = answers.charAt(i);
			
			if (i%7 == 0) { //Since there are 10 groups of 7, i%7=0 would give the first character of the string. 
				//Relates to the first category (I/E) of questions, so the index 0 is incremented depending on answer.
				if (ans == 'a') { 
					aCount[0]++;
				}
				else if (ans == 'b') {
					bCount[0]++;
				}
			}
			
			else if (i%7 == 1 || i % 7 == 2) { //Same logic as above, but this would give the second or third character of the string.
				//Second category of answers (S/N).
				if (ans == 'a') {
					aCount[1]++;
				}
				else if (ans == 'b') { 
					bCount[1]++;
				}
			}
			
			else if (i%7 == 3 || i%7 == 4) { //Same logic as above, with the fourth and fifth character.
				//Third category of answers (T/F).
				if (ans == 'a') {
					aCount[2]++;
				}
				else if (ans == 'b') {
					bCount[2]++;
				}
				
			}
			else if (i%7 == 5 || i%7 == 6) { //Same logic as above, with the sixth and seventh character.
				//Fourth category of answers (J/P).
				if (ans == 'a') {
					aCount[3]++;
				}
				else if (ans == 'b') {
					bCount[3]++;
				}
			}
		}
	}
	//This method gives the percent of B answers the character had.
	public static void givePercent(int aCount[], int bCount[], int bPercent[]) {
		//For loop runs for each index of array bPercent[]
		for (int index = 0; index < 4; index++) {
			bPercent[index] = (int) Math.round((100 * bCount[index])/ (aCount[index]+bCount[index]));
		//The count of B at each index (the 4 categories) over the number of A's and B's entered multiplied with 100 gives the percent.
		//Rounds the value.
		}
	}
	
	//This method uses the percent of B answers given from the last method and determines what personality type the character is.
	//If the percent of B answers are greater than or less than 50, they are given a certain letter to represent that (the 4 categories),
	//if it is equal to 50, the letter is "X".
	public static void giveType(int bPercent[], char type[]) {
		//Checks the first category (I/E).
		if (bPercent[0] > 50) {
			type[0] = 'I';
		}
		else if (bPercent[0] == 50) {
			type[0] = 'X';
		}
		else {
			type[0] = 'E';
		}
		//Checks the second category (N/S).
		if (bPercent[1] > 50) {
			type[1] = 'N';
		}
		else if (bPercent[1] == 50) {
			type[1] = 'X';
		}
		else {
			type[1] = 'S';
		}
		//Checks the third category (F/T).
		if (bPercent[2] > 50) {
			type[2] = 'F';
		}
		else if (bPercent[2] == 50) {
			type[2] = 'X';
		}
		else {
			type[2] = 'T';
		}
		//Checks the fourth category (P/J).
		if (bPercent[3] > 50) {
			type[3] = 'P';
		}
		else if (bPercent[0] == 50) {
			type[3] = 'X';
		}
		else {
			type[3] = 'J';
		}
	}
	
	//This method prints the amount of A's and B's in the answer string, the percent of B answers in each category,
	//and the type of the character that have been determined over the past methods.
	public static void printResults(int aCount[], int bCount[], int bPercent[], char type[]) {
		//Using a for loop to print out the number of A and B answers for each category.
		System.out.print("answers: [");
		for (int index = 0; index < 4; index++) { //Loops through each category, which corresponds with the indexes of aCount[] and bCount[].
			System.out.print(aCount[index] + "A-");
			System.out.print(bCount[index] + "B");
			if (index != 3) {
				System.out.print(", "); //Fence post to make sure the right amount of commas are used.
			}
		}
		System.out.print("]");
		
		System.out.println();
		System.out.println("percent B: " + Arrays.toString(bPercent)); //Prints array that shows the percent of B answers over the categories.
		System.out.print("type: ");
		for (int index = 0; index < 4; index++) { //Prints out individual characters of the array to print the type properly. Ex: INFJ 
			System.out.print(type[index]);        //instead of [I, N, F, J].
		} System.out.println();
	}
}