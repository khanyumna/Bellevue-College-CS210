// CS210 Assignment #4 "Birthdays"
// Summary: This program asks for the date and 2 people's birthdays; calculates which day of the year it falls on;
// then compares the two birthdays to see which one comes first or if they fall on the same date.
// Program is made using if/else if/else statements, methods, Scanner, and for loops.
// Name: Yumna Khan

import java.util.Scanner;

public class Birthdays {
	
	public static void main (String[] args) {
		
		//Asks user for date, converts it into the day of the year, prints result.
		Scanner today = new Scanner(System.in);
		System.out.print("Please enter today's date (month day): ");
		int todayMonth = today.nextInt();
		int todayDay = today.nextInt();
		int todayCount = countDays(todayMonth, todayDay);
		System.out.println("Today is " + todayMonth + "/" + todayDay + "/2022, day #" + todayCount + " of the year.\n");
		
		// Asks for Person #1 and Person #2's birthdays, calls method which counts the days till their birthdays.
		int firstBirthday = daysTillBirthday("Enter Person #1's birthday (month day): ", todayCount);
		int secondBirthday = daysTillBirthday("Enter Person #2's birthday (month day): ", todayCount);
		
		//Compares birthdays to see which birthday comes first, or if they share a birthday using if/else if/else statements.
		if (firstBirthday<secondBirthday) {
			System.out.println("Person #1's birthday is sooner!");
		}
		else if (firstBirthday>secondBirthday) {
			System.out.println("Person #2's birthday is sooner!");
		}
		else {
			System.out.println("You both share the same birthday! ^-^");
		}
		System.out.println();
		
		//Prints a fun fact about my birthday :)
		System.out.println("Did you know? 12/15 is National Cat Herder's Day! It is for people who can manage others and themselves no matter what comes their way!");
		System.out.println("Would you say you're a 'Cat Herder'?");
		}
	
	public static int countDays(int month, int day) {
		
		int totalDays = 0;
		//The 1's represent 31 days, the 8 represents 28 days, and the 0's represent 30 days. In order of appearance in the calendar.
		String months = "181010110101"; 
		//Cumulative sum algorithm. 'i' is the input given for the month. 
		for (int i=0; i<month-1; i++) {
			if (months.charAt(i)=='8') {
				totalDays += 28;
			}
			else if (months.charAt(i) == '0') {
				totalDays += 30;
			}
			else {
				totalDays +=  31;
			}
	}
		totalDays += day;
		return totalDays;
}
	public static int daysTillBirthday(String input, int todayCount) {
		
		Scanner birthday = new Scanner(System.in);
		//When method is called, the input is converted into the day of the year.
		System.out.print(input);
		int birthdayMonth = birthday.nextInt();
		int birthdayDay = birthday.nextInt();
		int birthdayCount = countDays(birthdayMonth, birthdayDay);
		System.out.println(birthdayMonth + "/" + birthdayDay + "/2022 falls on day #"+ birthdayCount + " of 365");
		int daysTill = 0;
		//Calculates how many days are left until the person's next birthday using if/else if statements.
		if (birthdayCount<todayCount) {
			daysTill = (365-(todayCount-birthdayCount));
			System.out.println("Their next birthday is in " + daysTill + " days(s).");
		}
		else if (birthdayCount>todayCount) {
			daysTill = birthdayCount-todayCount;
			System.out.println("Their next birthday is in " + daysTill + " days(s).");
		}
		if (birthdayCount == todayCount) {
			System.out.println("Their birthday is today! Happy birthday!!");
		}
		System.out.println();
		return daysTill;
		}
	}


