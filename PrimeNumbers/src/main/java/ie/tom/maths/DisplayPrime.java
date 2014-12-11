package ie.tom.maths;

import java.util.LinkedList;
import java.util.Queue;

public class DisplayPrime {
	Queue<Integer> prime = new LinkedList<Integer>();
	
	public void display10line(int range, int[] primes) {
		load(primes);
		for(int i=0; i<range; i++) {
			if(!prime.isEmpty()) {
				if(i+1 == prime.peek()) {
					System.out.print(prime.remove() + ", ");
				} else {
					System.out.print(i+1 + ", ");
				}			
			} else {
				System.out.print(i+1 + ", ");
			}
		}
	}
	private void load(int[] primes) {
		for(int i=0; i<primes.length; i++) {
			prime.add(primes[i]);
		}
	}
}