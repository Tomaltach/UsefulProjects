package ie.tom.primes;

import java.util.Scanner;

public class PrimeTest {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		System.out.print("Prime Test Class");
		
		testDisplay10Line();
		testDisplay20Line();
		testCheckPrime();
		
		scanner.close();
	}
	private static void testDisplay10Line() {
		DisplayPrime prime = new DisplayPrimeImpl();
		System.out.print("\nEnter the range you want to check: ");
		String input = scanner.nextLine();
		int range = 0;
		try {
			range = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			System.out.println("ERROR! Must enter a number!");
		}
		prime.display10Line(range);
	}
	private static void testDisplay20Line() {
		DisplayPrime prime = new DisplayPrimeImpl();
		System.out.print("\nEnter the range you want to check: ");
		String input = scanner.nextLine();
		int range = 0;
		try {
			range = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			System.out.println("ERROR! Must enter a number!");
		}
		prime.display20Line(range);
	}
	private static void testCheckPrime() {
		DisplayPrime prime = new DisplayPrimeImpl();
		System.out.print("\nEnter the number you want to check: ");
		String input = scanner.nextLine();
		int range = 0;
		try {
			range = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			System.out.println("ERROR! Must enter a number!");
		}
		prime.checkPrime(range);
	}
}