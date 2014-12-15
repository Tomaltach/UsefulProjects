package ie.tom.maths;

public class DisplayPrimeImpl implements DisplayPrime {
	ConsoleColor con = new ConsoleColor();
	
	public void display20line(int range) {
		CalculatePrime prime = new CalculatePrime(range);
		boolean[] primes = prime.fillSieve();
		for(int i=0; i<range; i++) {
			//System.out.println(con.ANSI_RED + "This text is red!" + con.ANSI_RESET);
			print(primes[i], i);
		}
	}
	public void checkPrime(int number) {
		CalculatePrime prime = new CalculatePrime(number+10);
		boolean check = prime.isPrime(number);
		println(check, number);
	}
	private void print(boolean check, int number) {
		if(check == true) {
			System.out.print(number + "*, ");
		} else {
			System.out.print(number + ", ");
		}
	}
	private void println(boolean check, int number) {
		if(check == true) {
			System.out.print("\n" + number + "*, ");
		} else {
			System.out.print("\n" + number + ", ");
		}
	}
}