// CS210 Assignment #2 "Space Needle"
// Description- This code produces a figure of the Space Needle using methods, for loops, nested for loops, expressions,
// and a class constant which allows it to change size.
// Yumna Khan

public class SpaceNeedle {
	public static final int SIZE=4;
	public static void main(String[] args) {
		drawSpaceNeedle();
	}
// Calls all the methods to draw Space Needle.
	public static void drawSpaceNeedle() {
		drawNeedle();
		drawTopHalf();
		drawQuoteLine();
		drawBottomHalf();
		drawNeedle();
		drawPercentLines();
		drawTopHalf();
		drawQuoteLine();
}
// Draws the needle of the Space Needle, also serves as the "skinny" part of the Space Needle's body.
	public static void drawNeedle() {
		for (int line=1; line<=SIZE; line++) {
			for (int spaces=1; spaces<= (SIZE*3); spaces++){
			System.out.print(" ");
			}
			System.out.println("||");
		}
	}
// Draws the "section breaker" between the top and bottom of the Space Needle.
	public static void drawQuoteLine() {
		System.out.print("|");
		for (int i=1; i<=(SIZE*6); i++) {
			System.out.print("\"");
		}
		System.out.print("|");
		System.out.println();
	}
// Draws the thick body of the Space Needle.
	public static void drawPercentLines() {
		for (int line=1; line<=(SIZE*4); line++) {
			for (int spaces=1; spaces<=((SIZE*2)+1); spaces++) {
				System.out.print(" ");
			}
			System.out.print("|");
			for (int i=1; i<=(SIZE-2); i++) {
				System.out.print("%");
			}
			System.out.print("||");
			for (int percents=1; percents<=(SIZE-2); percents++) {
				System.out.print("%");
			}
			System.out.println("|");
		}
	}
/// Draws the top part of the main portion of the Space Needle. 
	public static void drawTopHalf() {
			for (int line=1; line<=SIZE; line++) {
				for (int spaces=1; spaces<= (SIZE*3)-(line*3); spaces++) {
					System.out.print(" ");
				}
				System.out.print("__/");
				for (int i=1; i<=(line*3-3); i++) {
					System.out.print(":");
				}
				System.out.print("||");
				for (int i=1; i<=(line*3-3); i++) {
					System.out.print(":");
			}
			System.out.println("\\__");
		}
	}
//Draws the bottom half of the main portion of the Space Needle.
	public static void drawBottomHalf() {
		for (int line=1; line<=(SIZE); line++) {
			for (int spaces=0; spaces<=(line*2-3); spaces++) {
				System.out.print(" ");
		}
			System.out.print("\\_");
			for (int i=1; i<=((SIZE*3)+1)-(line*2); i++) {
				System.out.print("/\\");
			}
			System.out.println("_/");
	}
}
}



