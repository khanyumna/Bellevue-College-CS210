// CS210 Assignment #4 "Word Count"
// Summary: This program counts the words in a given string using if-else statements, for loops, and character methods.
// Name: Yumna Khan

public class WordCount {
	
	public static void main (String[] args) {
		System.out.println(wordCount("hello"));
		System.out.println(wordCount("how are you?"));
		System.out.println(wordCount("   how are you?"));
		System.out.println(wordCount("how are you?   "));
		System.out.println(wordCount("how are you ?"));
		System.out.println(wordCount("I am 3 years old"));
		System.out.println(wordCount("3 x 4 = 12"));
		System.out.println(wordCount("Characters !@#$%^&"));
		System.out.println(wordCount("   "));
		
	}
	public static int wordCount(String inputString) {
		String str = inputString;
		int wordcount=0;
		
		//For loop that iterates for the number of characters in a string
		for (int i=0; i<str.length(); i++) {
			
			//If the first character of a string is not a space, add 1 to wordcount
			if((str.charAt(0) != ' ' && i == 0)) {
				wordcount++;
				}
			
			//Else if character is not a space and the character before it is a space, add 1 to wordcount
			else if ((str.charAt(i) != ' ' && (str.charAt(i-1) == ' '))){ 
				wordcount++; 
			}
		}
		return wordcount;
	}
}
