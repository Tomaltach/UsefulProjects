package ie.tom.maths;

import java.util.Arrays;

public class CalculatePrime {
	// will contain true or false values for the first 10,000 integers
	boolean[] primes;
	
	public CalculatePrime(int range) {
		primes = new boolean[range];
	}
	public boolean[] fillSieve() {
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0]=primes[1] = false; // we know 0 and 1 are not prime.
		for(int i=2;i<primes.length;i++) {
			// if the number is prime, then go through all its multiples and make their values false.
			if(primes[i]) {
				for(int j=2; i*j<primes.length; j++) {
					primes[i*j] = false;
				}
			}
		}
		return primes;
	}
	public boolean isPrime(int number) {
		boolean[] p = fillSieve();
		return p[number];
	}
}