// CS210 Assignment #8 "Rational Number"
// Summary: In this assignment, my job was to create a class called RationalNumber with methods 
// which can accomplish many things such as adding, subtracting, dividing, and multiplying two rational 
// numbers, as well as turning a rational number into a string. There were many things to keep in mind
// such as zero denominators, negative numbers, whole numbers, and common denominators. These methods help reduce
// redundancy and make it overall easier to work with rational numbers while coding.
// Yumna Khan

//This is the class header, where I declared private variables for the numerator and denominator.
public class RationalNumber { 
	private int myNumerator;
	private int myDenominator;
	
	//This method creates a new rational number.
	public RationalNumber(int numerator, int denominator) { 
		myNumerator = numerator;                             
		myDenominator = denominator;
	 }
	 
	 //This method creates the rational number 0/1.
	 public RationalNumber() { 
		 myNumerator = 0;
		 myDenominator = 1;
	 }
	 
	//This method accesses, or returns, the denominator by returning it so it can be used in other methods.
	 public int getDenominator() { 
		 return myDenominator;
	 }
	 
	//This method accesses the numerator by returning it so it can be used in other methods.
	 public int getNumerator() { 
		 return myNumerator;
		  }
	 
	 //This method makes it so that the rational number can be printed out with the format "numerator/denominator".
	 //With accounting for zero denominators, zero numerators, negative numbers, and whole numbers.
	 public String toString() {
		 String makeString = ""; 
		 
		 if (myDenominator == 0) { //Just in case the denominator is zero, the string says that it is invalid. 
			 makeString = "invalid";
		 }
		 
		 else if (myNumerator == 0) { //If the numerator is 0, then the string is 0.
			 makeString = "0";
		 }
		 
		 //If the numerator and denominator are negative, the rational is turned positive by multiplying both by -1. (Ex: -1/-3 turns into 1/3)
		 //Or, if the denominator is negative, the denominator is turned positive while the numerator is turned negative when multiplied
		 //by -1, which makes sure it prints in the right format. (Ex: -1/3, instead of 1/-3)
		 else if ((myNumerator < 0 && myDenominator < 0) || myDenominator < 0) { 
			 makeString = (myNumerator * -1) + "/" + (myDenominator * -1);
		 }
		 
		 else if (myDenominator == 1) { //If the denominator is 1, it means it is a whole number, thus the string contains only the numerator. (Ex: 5/1 is 5)
			 makeString = "" + myNumerator;
		 }
		 
		 else { //If none of the special conditions are met, the string contains just "numerator/denominator". (Ex: 1/3 is just 1/3)
			 makeString = myNumerator + "/" + myDenominator;
		 }
		 
		 return makeString;
	 }
	 //This method adds two rational numbers together.
	 public RationalNumber add(RationalNumber other) {
		 int addNumerator;
		 int addDenominator;
		 
		 //If the denominators are the same, add the numerators together and keep the denominator the same.
		 if (myDenominator == other.getDenominator()) { 
			 addNumerator = myNumerator + other.getNumerator();
			 addDenominator = myDenominator;
		 }
		 
		 //For when the denominators are not the same, multiply the denominators to get a common denominator.
		 //For the numerator, cross multiply: the numerator is multiplied with the other denominator, and the other numerator is 
		 //multiplied with the denominator. Then the numerators are added.
		 else { 
			 addDenominator = myDenominator * other.getDenominator();
			 addNumerator = (myNumerator * other.getDenominator()) + (other.getNumerator() * myDenominator);
		 }
		 
		 RationalNumber addedResult = new RationalNumber(addNumerator, addDenominator); //The result is turned into a new rational number.
		 return addedResult;
	 }
	 
	 //This method subtracts from another rational number.
	 public RationalNumber subtract(RationalNumber other) {
		 int subtractNumerator;
		 int subtractDenominator;
		 
		 if (myDenominator == other.getDenominator()) { //If the denominators are the same, subtract the numerators and keep the denominator the same.
			 subtractNumerator = myNumerator - other.getNumerator();
			 subtractDenominator = myDenominator;
		 }
		 
		 //If the denominators are different, multiply the denominators together to make a common denominator.
		 //For the numerators, cross multiply: multiply the numerator with the other denominator, and the other numerator with the denominator.
		 //Then subtract the two values and assign it to the subtracted numerator.
		 else {
			 subtractDenominator = myDenominator * other.getDenominator();
			 subtractNumerator = (myNumerator * other.getDenominator()) - (other.getNumerator() * myDenominator);
		 }
		 
		 RationalNumber subtractedResult = new RationalNumber(subtractNumerator, subtractDenominator); //The result is turned into a new rational number.
		 return subtractedResult;
	 }
	 
	 //This method multiplies two rational numbers together. 
	 public RationalNumber multiply(RationalNumber other) {
		 //Multiply the numerators.
		 int multiplyNumerator = myNumerator * other.getNumerator();
		 
		 //Multiply the denominators.
		 int multiplyDenominator = myDenominator * other.getDenominator();
		 
		 //The result is turned into a new rational number.
		 RationalNumber multipliedResult = new RationalNumber(multiplyNumerator, multiplyDenominator);
		 return multipliedResult;
	 }
	 //This method divides two rational numbers.
	 public RationalNumber divide(RationalNumber other) {
		 //The rule for dividing rational numbers as I learned was "keep, change, flip".
		 //The numerator is multiplied with the other denominator.
		 int divideNumerator = myNumerator * other.getDenominator();
		 
		 //The denominator is multiplied with the other numerator.
		 int divideDenominator = myDenominator * other.getNumerator();
		 
		 //The result is turned into a new rational number.
		 RationalNumber dividedResult = new RationalNumber(divideNumerator, divideDenominator);
		 return dividedResult;
	 }
}