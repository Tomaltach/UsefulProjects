package ie.tom.primes;

public class DisplayPrimeImpl implements DisplayPrime {
	ConsoleColor con = new ConsoleColor();

	public void display10Line(int range) {
		CalculatePrime prime = new CalculatePrime(range);
		boolean[] primes = prime.fillSieve();
		for(int i=0; i<range; i++) {
			print(primes[i], i);
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}
	public void display20Line(int range) {
		CalculatePrime prime = new CalculatePrime(range);
		boolean[] primes = prime.fillSieve();
		for(int i=0; i<range; i++) {
			print(primes[i], i);
			if((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}
	public void display10LinePrimeOnly(int range) {
		CalculatePrime prime = new CalculatePrime(range);
		boolean[] primes = prime.fillSieve();
		int count = 0;
		for(int i=0; i<range; i++) {
			printPrimeOnly(primes[i], i);
			if(primes[i] == true) {
				count++;
			}
			if(count == 10) {
				System.out.println();
				count = 0;
			}
		}
	}
	public void checkPrime(int number) {
		CalculatePrime prime = new CalculatePrime(number+10);
		boolean check = prime.isPrime(number);
		print(check, number);
	}
	private void print(boolean check, int number) {
		if(check == true) {
			System.out.print("\u001b[1;31m" + number + "*\u001b[0m, "); // http://www.mihai-nita.net/eclipse
			//System.out.print(number + "*, ");
		} else {
			System.out.print(number + ", ");
		}
	}
	private void printPrimeOnly(boolean check, int number) {
		if(check == true) {
			System.out.print(number + ", ");
		}
	}
}