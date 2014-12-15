package ie.tom.maths;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DisplayPrime prime = new DisplayPrimeImpl();
		System.out.println("Enter the range you want to check: ");
		String input = scanner.nextLine();
		int range = 0;
		try {
			range = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			System.out.println("ERROR! Must enter a number!");
		}
		prime.display20line(range);
		prime.checkPrime(4);
		prime.checkPrime(3);
		
		scanner.close();
	}
}