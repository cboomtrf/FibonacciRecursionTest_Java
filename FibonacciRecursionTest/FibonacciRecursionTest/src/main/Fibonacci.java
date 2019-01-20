package main;

import java.util.Scanner;

/**
 * 1 1 2 3 5 8
 * Fibonacci is the sum of its preceding two parts.
 * 2 = n-1 + n-2
 * 
 * This class contains a recursive method that prints the 
 * fibonacci sequence until a certain n.
 * 
 * fib(0) = 0;
 * fib(1) = 1;
 * fib(index) = fib(index - 2) + fib(index - 1); index >= 2
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Fibonacci {
	
	 Scanner input = new Scanner(System.in);
	 static long index;
     static long max;
	
	public Fibonacci() {
		super();
	}
	
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		index = fib.requestFibIndex();
		long fibonacciAtIndex = fib.computeFibonacci(index);
		System.out.println(fibonacciAtIndex);
		System.out.println("------------");
		max = fib.requestFibMax();
		fib.printFib(0, 1, max);
	}
	
	/**
	 * SOLUTION 1
	 * Print fibonacci sequence from the start (n1 = 0, n2 = 1) 
	 * to the maximum fibonacci value of a long max variable.
	 * @param n1
	 * @param n2
	 * @param max
	 */
	public void printFib(int n1, int n2, long max) {
		if (n1 < 0) {
			throw new IllegalArgumentException("number should not be negative.");
		} else if (n1 <= max) {
			System.out.print(n1 + " ");
			printFib(n2, (n1+n2), max);
		}
	}
	
	/**
	 * SOLUTION 2 - Method 1
	 * Method 1 is used to set the begin-numbers and call the recursive method.
	 */
	public static void fibo(int maxVal) {
		int n1 = 0;
		int n2 = 1;
		sequence(n1, n2, maxVal);
	}
	
	/**
	 * SOLUTION 2 - Method 2
	 * Method 2 is recursive and used to print.
	 * @param n1
	 * @param n2
	 * @param max
	 */
	private static void sequence(int n1, int n2, int max) {
		int n3 = n2 + n1;
		if (n1 == 0) {
			System.out.println(n2 + " ");
		}
		if (n3 <= max) {
			System.out.println(n3 + " ");
			sequence(n2, n3, max);
		}
	}
	
	/**
	 * SOLUTION 3
	 * Give 0,1.
	 * Return n1.
	 */
	public static void printFib3(int n0, int n1, int maxVal) {
		System.out.println(n0 + " " + n1);
		if (n0 > max) {
			return;
		} 
		
		System.out.println(n0);
		n0 += n1;
		n1 = n0;
		
		printFib3(n1, n0+n1, maxVal);
	}
	
	/**
	 * SOLUTION 4
	 * Give 0,1.
	 * Return n1.
	 */
	public int printFib2(int n0, int n1, int maxStep, int step) {
		System.out.println(n0 + " " + n1);
		if (step < maxStep) {
			return printFib2(n1, n0+n1, maxStep, step+1);
		} else {
			return n1;
		}
	}
	
	/**
	 * Compute fibonacci value for an index long variable.
	 * This may also be used to print recursively.
	 * dmv 1++.
	 * @param index
	 * @return
	 */
	public long computeFibonacci(long index) throws IllegalArgumentException {
		if (index<0) {
			throw new IllegalArgumentException("index should not be negative.");
		} else if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return computeFibonacci(index - 1) + computeFibonacci(index - 2);
		}
	}
	
	public long requestFibIndex() {
		System.out.print("Enter an index for a Fibonacci number: ");
		int index = input.nextInt();
		
		return index;
	}

	public long requestFibMax() {
		System.out.print("Enter a value of a maximum Fibonacci number: ");
		int value = input.nextInt();
		
		return value;
	}
	
}
