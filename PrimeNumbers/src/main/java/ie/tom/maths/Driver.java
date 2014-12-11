package ie.tom.maths;

public class Driver {

	public static void main(String[] args) {
		DisplayPrime prime = new DisplayPrimeImpl();
		prime.display20line(50);
		prime.checkPrime(4);
		prime.checkPrime(3);
	}
}