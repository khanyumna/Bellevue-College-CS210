// CS210 Assignment #6 "Baby Names"
// Summary: This program asks the user for name and then prints the rank of that name for each decade (out of 1000 names).
// To work, the program needs a name from the user, then it searches for the name in a file called "names.txt", then
// the program lists the rankings. If the name isn't found, the program prints that the name wasn't found.
// The program also makes a file with the name's data if it is found. I made this program using file-reading, token-based
// processing, while  loops, methods, and parameters for the most part :). I did not do the part where the program draws 
// a graph. 
// Yumna Khan

import java.io.*;
import java.util.*;

public class BabyNames {
	
	public static void main (String[] args) throws FileNotFoundException {
		
			Scanner allNames = new Scanner(new File("names.txt")); //Creating file.
			System.out.println("** Popularity of a baby name since year 1920 **");
			System.out.print("name?: ");
			Scanner input = new Scanner(System.in); // Initializing Scanner
			String userName = input.next(); 
			boolean hasName = false; // Boolean to start and stop while loop. 
			userName = userName.substring(0,1).toUpperCase() + userName.substring(1).toLowerCase(); //The first letter is made upper case, while the rest are made lower case. 
			
			while (hasName == false) { //Runs as long as the method doesn't return a "true" value.
				hasName = checkName(hasName, allNames, userName); //Calling method check name, returns boolean value.
			}
			// readFile(userName); // Look at readFile method for explanation.
	}
	
	public static boolean checkName(boolean hasName, Scanner allNames, String userName) throws FileNotFoundException {
		//Method that checks for the name. Main portion of the program.
		if (allNames.hasNext()) {
			String nextName = allNames.next(); //Assigning nextName to the next string in "names.txt". This will run over every string, checking if it matches with the name entered.
			
			if (nextName.equals(userName)) { //The name entered by the user has been found!
				
				PrintStream printfile = new PrintStream(new File (userName)); //Initializing PrintStream
				printfile.println(userName + ", "); //Printing the name in the file. It is outside the method because it would print repeatedly otherwise.
				
				for (int year = 1920; year < 2000; year += 10) { //For every decade, prints the ranking of the name.
					int given = allNames.nextInt();
					System.out.println(year + ": " + given);
					writeFile(userName, printfile, year, given); //This method is printing data in the file for this name.
				}
				//Fence post algorithm to make sure everything is printing properly in the console and file. 
				// Since in the file, the 2000 decade should not have a comma at the end like the previous decades do.
				int lastGiven = allNames.nextInt(); 
				System.out.println("2000: " + lastGiven);
				writeFile(userName, printfile, 2000, lastGiven);
				hasName = true; 
			}
		}
		
		else { //The name entered by user was not found in "names.txt".
			System.out.println("name not found.");
			hasName = true; 
		}
		return hasName; //Returns this value that causes the while loop to end. "hasName" has been set to true in the if/else statements.
	}

	public static String writeFile(String userName, PrintStream printfile, int year, int given) {
		//This method accurately names the file, then adds all the data values of it.
		String file_name;
		file_name = userName + ".txt"; //Naming the file.
		String data= year + ": " + given; //Making the string for the data.
		
		if (year != 2000) { //For every decade that is not 2000, it adds a comma at the end.
			data = data+ ",";
		}
		
		printfile.println(data); 
		return file_name; //Returns the file name in the right format ("name.txt").
	}
	
	// Prints the file in console. Only works for names that are in the names.txt file.
    // Commenting this method out so you can see how I made sure that my file looked correct :).
	/*public static void readFile(String file_name) throws FileNotFoundException {
		Scanner read = new Scanner(new File(file_name));
		while (read.hasNext()) {
			String data = read.nextLine();
			System.out.println(data);
		} 
	} */ // Prints the file in console. Only works for names that are in the names.txt file.
	     // Commenting this method out so you can see how I made sure that my file looked correct :).
}

