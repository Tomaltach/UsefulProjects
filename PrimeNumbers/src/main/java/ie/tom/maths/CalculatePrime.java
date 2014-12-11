package ie.tom.maths;

public class CalculatePrime {
	DisplayPrime display = new DisplayPrime();
	
	public void init() {
		int[] primes = {2,3,5,7};
		display.display10line(20, primes);
	}
}