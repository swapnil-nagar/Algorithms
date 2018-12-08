package Array;

/**
 * 
 * @author swnagar
 *
 *Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k < = 100, 0 < n < = 106, 0 < primes[i] < 1000.
 */
public class UglyNumber {
	
	public static void main (String args[]) {
		int n = 12;
		int[] primes =  {2, 7, 13, 19};
		int result = nthSuperUglyNumber(n, primes);
		System.out.println(result);
	}
	
	public static int nthSuperUglyNumber(int n, int[] primes) {
	    int[] times = new int[primes.length];
	    int[] result = new int[n];
	    result[0] = 1; // first is 1
	 
	    for (int i = 1; i < n; i++) {
	        int min = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++) {
	            min = Math.min(min, primes[j] * result[times[j]]);
	            System.out.println("i : "+ i + " j : "+ j + " = min : "+ min);
	        }
	 
	        result[i] = min;
            System.out.println("out i : "+ i + " = min : "+ min);
	 
	        for (int j = 0; j < times.length; j++) {
	            if (result[times[j]] * primes[j] == min) {

	                System.out.println("int if j : "+ j + " = min : "+ min);
	                times[j]++;
	            }
	        }
	    }
	 
	    return result[n - 1];
	}
}
