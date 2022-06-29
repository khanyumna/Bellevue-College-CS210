// CS210 Assignment #1 - This code draws two rockets side by side.
// Yumna Khan

public class Chapter1Ex11 {
	public static void main(String[] args) {
		drawCones();
		drawPlusLine();
		drawBox();
		drawBox();
		drawPlusLine();
		drawUnitedStates();
		drawPlusLine();
		drawBox();
		drawBox();
		drawPlusLine();
		drawCones();
	}

	public static void drawCones() {
		System.out.println("   /\\       /\\");
		System.out.println("  /  \\     /  \\");
		System.out.println(" /    \\   /    \\");
	}

	public static void drawPlusLine() {
		System.out.println("+------+ +------+");
	}

	public static void drawBox() {
		System.out.println("|      | |      |");
	}

	public static void drawUnitedStates() {
		System.out.println("|United| |United|");
		System.out.println("|States| |States|");
	}
}