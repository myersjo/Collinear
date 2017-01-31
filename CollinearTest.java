import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 * Test class for Collinear.java
 *
 * @author
 * @version 03/10/16 17:10:35
 */
@RunWith(JUnit4.class)
public class CollinearTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new Collinear();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the two methods work for empty arrays
	 */
	@Test
	public void testEmpty() {
		int expectedResult = 0;

		assertEquals("countCollinear failed with 3 empty arrays", expectedResult,
				Collinear.countCollinear(new int[0], new int[0], new int[0]));
		assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult,
				Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleFalse() {
		int[] a3 = { 15 };
		int[] a2 = { 5 };
		int[] a1 = { 10 };

		int expectedResult = 0;

		assertEquals("countCollinear({10}, {5}, {15})", expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleTrue() {
		int[] a3 = { 15, 5 };
		int[] a2 = { 5 };
		int[] a1 = { 10, 15, 5 };

		int expectedResult = 1;

		assertEquals(
				"countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",
				expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3)
				+ ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	// ----------------------------------------------------------
	/**
	 * Check for correct result in multi-element arrays
	 * 	Expected Results:
	 * x1: 5 x2: 15 x3: 25
	 * x1: 24 x2: 13 x3: 2
	 * x1: 19 x2: 13 x3: 7
	 * x1: 22 x2: 15 x3: 8
	 * x1: 59 x2: 33 x3: 7
	 * Total Collinear:5
	 */
	@Test
	public void testCount() {
		int[] a1 = { 5, 17, 24, 43, 19, 22, 59 };
		int[] a2 = { 15, 3, 33, 47, 66, 71, 13 };
		int[] a3 = { 25, 2, 8, 26, 7, 84, 32, 90 };
		
		int expectedResult = 5;
		
		assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",
				expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3)
		+ ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}
	
	/**
	 * Test counts for both methods are equal with the same input
	 */
	@Test
	@Ignore
	public void testCountsEqual() {
		
		In inputA1 = new In("./r02000-1.txt");
		int[] a1 = inputA1.readAllInts();
		inputA1.close();
		In inputA2 = new In("./r02000-2.txt");
		int[] a2 = inputA2.readAllInts();
		inputA2.close();
		In inputA3 = new In("./r02000-3.txt");
		int[] a3 = inputA3.readAllInts();
		inputA3.close();
		
		assertEquals("countCollinear + countCollinearFast", Collinear.countCollinear(a1, a2, a3), Collinear.countCollinearFast(a1, a2, a3) );
	}
	
	/**
	 * Verify true is returned when a match is found in the given sorted array for the given value
	 */
	@Test 
	public void testBinarySearchTrue() {
		int[] a3 = {25, 2, 8, 26, 7, 84, 32, 90};
		Collinear.sort(a3);
		assertTrue("binary search; match found", Collinear.binarySearch(a3, 8));
	}
	
	/**
	 * Verify false is returned when a match is not found in the given sorted array for the given vlaue
	 */
	@Test 
	public void testBinarySearchFalse() {
		int[] a3 = {25, 2, 8, 26, 7, 84, 32, 90};
		Collinear.sort(a3);
		assertFalse("binary search; match not found", Collinear.binarySearch(a3, 99));
	}
	
	// TODO: add more tests here. Each line of code and ech decision in
	// Collinear.java should
	// be executed at least once from at least one test.

	// ----------------------------------------------------------
	/**
	 * Main Method. Use this main method to create the experiments needed to
	 * answer the experimental performance questions of this assignment.
	 *
	 * You should read the lecture notes and/or book to understand how to
	 * correctly implement the main methods. You can use any of the provided
	 * classes to read from files, and time your code.
	 *
	 */
	public static void main(String[] args) {
//		In inputA1 = new In("./r05000-1.txt");
//		int[] a1 = inputA1.readAllInts();
//		In inputA2 = new In("./r05000-2.txt");
//		int[] a2 = inputA2.readAllInts();
//		In inputA3 = new In("./r05000-3.txt");
//		int[] a3 = inputA3.readAllInts();
		
//		System.out.println(a1.length + " " + a2.length + " " + a3.length);
//		
//		Stopwatch countStopwatch = new Stopwatch();
//		int count = Collinear.countCollinear(a1, a2, a3);
//		System.out.println("countCollinear: " + count + " Time: " + countStopwatch.elapsedTime());
//		
//		Stopwatch fastCountStopwatch = new Stopwatch();
//		int fastCount = Collinear.countCollinearFast(a1, a2, a3);
//		System.out.println("countCollinearFast: " + fastCount + " Time: " + fastCountStopwatch.elapsedTime());
		
//		int[] fileSizes = {1,2,4};
//		
//		for (int size : fileSizes) {
//			In inputA1 = new In("./r0"+size+"000-1.txt");
//			int[] a1 = inputA1.readAllInts();
//			In inputA2 = new In("./r0"+size+"000-2.txt");
//			int[] a2 = inputA2.readAllInts();
//			In inputA3 = new In("./r0"+size+"000-3.txt");
//			int[] a3 = inputA3.readAllInts();
//			
//			System.out.println(a1.length + " " + a2.length + " " + a3.length);
//			
//			Stopwatch countStopwatch = new Stopwatch();
//			int count = Collinear.countCollinear(a1, a2, a3);
//			System.out.println("countCollinear: " + count + " Time: " + countStopwatch.elapsedTime());
//			
//			Stopwatch fastCountStopwatch = new Stopwatch();
//			int fastCount = Collinear.countCollinearFast(a1, a2, a3);
//			System.out.println("countCollinearFast: " + fastCount + " Time: " + fastCountStopwatch.elapsedTime());
//		}
		printCountAndRunTime();
	}
	
	public static void printCountAndRunTime() {
		int[] fileSizes = {1,2,4,5};
		
		for (int size : fileSizes) {
			In inputA1 = new In("./r0"+size+"000-1.txt");
			int[] a1 = inputA1.readAllInts();
			In inputA2 = new In("./r0"+size+"000-2.txt");
			int[] a2 = inputA2.readAllInts();
			In inputA3 = new In("./r0"+size+"000-3.txt");
			int[] a3 = inputA3.readAllInts();
			
//			System.out.println(a1.length + " " + a2.length + " " + a3.length);
			
			Stopwatch countStopwatch = new Stopwatch();
			int count = Collinear.countCollinear(a1, a2, a3);
			System.out.println(a1.length + " Slow:\t Count: " + count + "\t Time: " + countStopwatch.elapsedTime() + "\t|");
			
			Stopwatch fastCountStopwatch = new Stopwatch();
			int fastCount = Collinear.countCollinearFast(a1, a2, a3);
			System.out.println(a1.length + " Fast:\t Count: " + fastCount + "\t Time: " + fastCountStopwatch.elapsedTime() + "\t|");
			
			System.out.println("------------------------------------------------");
		}
	}

}
