// -------------------------------------------------------------------------
/**
 * This class contains only two static methods that search for points on the
 * same line in three arrays of integers.
 *
 * @author
 * @version 03/10/16 17:10:35
 */
class Collinear {

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in
	 * arrays a1, a2, a3. This method is static, thus it can be called as
	 * Collinear.countCollinear(a1,a2,a3)
	 * 
	 * @param a1:
	 *            An UNSORTED array of integers. Each integer a1[i] represents
	 *            the point (a1[i], 1) on the plain.
	 * @param a2:
	 *            An UNSORTED array of integers. Each integer a2[i] represents
	 *            the point (a2[i], 2) on the plain.
	 * @param a3:
	 *            An UNSORTED array of integers. Each integer a3[i] represents
	 *            the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a
	 *         horizontal line.
	 *
	 *         Array a1, a2 and a3 contain points on the horizontal line y=1,
	 *         y=2 and y=3, respectively. A non-horizontal line will have to
	 *         cross all three of these lines. Thus we are looking for 3 points,
	 *         each in a1, a2, a3 which lie on the same line.
	 *
	 *         Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e.,
	 *         they are on the same line) if
	 * 
	 *         x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0
	 *
	 *         In our case y1=1, y2=2, y3=3.
	 *
	 *         You should implement this using a BRUTE FORCE approach (check all
	 *         possible combinations of numbers from a1, a2, a3)
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Experimental Performance:
	 *         ------------------------- 
	 *          Write the running time of the algorithm when run with the following input
	 *         sizes
	 * 
	 *         Input Size N 	Running Time (sec) (T(N))
	 *         ------------------------------------------
	 *         1000 			0.317 
	 *         2000 			2.385
	 *         4000 			14.788
	 *         
	 *           Workings:
	 *           ---------
	 *         
	 *         		 log(N) 			log(T(N))
	 *        		 ------------------------------------ 
	 *        		 9.96578	 		-1.65745 
	 *        		 10.96578			 1.25399
	 *        		 11.96578			 3.88636
	 *        	
	 *        		 slope = 2.778
	 *        
	 *        		 lg(T(N)) = 2.778 lg N + lg a
	 *        		= T(N) = aN^2.778
	 *        
	 *        		Solve for a:
	 *        		------------
	 *        		 T(4000) = a(4000)^2.778 = 14.788
	 *        				   a = 14.788 / ((4000)^2.778)
	 *        				   a = 1.457x10^-9
	 *				Running time for N:
	 *				-------------------
	 *				 T(N) = 1.457x10^-9 N^2.778
	 *
	 *         Assuming that the running time of your algorithm is of the form
	 *         aN^b, estimate 'b' and 'a' by fitting a line to the experimental
	 *         points:
	 *
	 *         b = 2.778 
	 *         a = 1.457x10^-9
	 *
	 *         What running time do you predict using your results for input
	 *         size 5000? 
	 *         What is the actual running time you get with such an
	 *         input? 
	 *         What is the error in percentage?
	 *
	 *         Error = ( (Actual time) - (Predicted time) ) * 100 / (Predicted time)
	 *         		 = 		(28.735)   - 	(27.491)		* 100 / 	27.491 = 4.525
	 *
	 *         Input Size N 	Predicted Running Time (sec) 	Actual Running Time(sec) 	Error (%)
	 *         -------------------------------------------------------------------------------------- 
	 *         5000 			27.491 						 	28.735					  	4.525%
	 * 
	 *         Approximate Mathematical Performance:
	 *         -------------------------
	 *
	 *         Using an appropriate cost model, give the performance of your
	 *         algorithm. Explain your answer.
	 *
	 *         Performance: ~N^3
	 *
	 *         Explanation: By counting only some operations, in this case array accesses, we can
	 *         		see that countCollinear, using a brute-force implementation, has an order of growth
	 *         		of N^3. 
	 */
	static int countCollinear(int[] a1, int[] a2, int[] a3) {
		int y1 = 1, y2 = 2, y3 = 3, count = 0;
		int p= y2-y3; 
		int q= y3-y1; 
		int r= y1-y2;
				
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				for (int k = 0; k < a3.length; k++) {
					if (a1[i] * p + a2[j] * q + a3[k] * r == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in
	 * arrays a1, a2, a3. This method is static, thus it can be called as
	 * Collinear.countCollinearFast(a1,a2,a3)
	 * 
	 * @param a1:
	 *            An UNSORTED array of integers. Each integer a1[i] represents
	 *            the point (a1[i], 1) on the plain.
	 * @param a2:
	 *            An UNSORTED array of integers. Each integer a2[i] represents
	 *            the point (a2[i], 2) on the plain.
	 * @param a3:
	 *            An UNSORTED array of integers. Each integer a3[i] represents
	 *            the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a
	 *         horizontal line.
	 *
	 *         In this implementation you should make non-trivial use of
	 *         InsertionSort and Binary Search. The performance of this method
	 *         should be much better than that of the above method.
	 *
	 *         Experimental Performance:
	 *         ------------------------- 
	 *         Measure the running time of the algorithm when run with the following input
	 *         sizes
	 * 
	 *         Input Size N 	Running Time (sec)
	 *         ------------------------------------ 
	 *         1000 			0.035 
	 *         2000 			0.144
	 *         4000 			0.618
	 *         5000 			1.044
	 *
	 *
	 *         Compare Implementations:
	 *         ------------------------ 
	 *         Show the speedup achieved by this method, using the times you got from
	 *         your experiments.
	 *
	 *         Input Size N 	Speedup = (time of countCollinear)/(time of countCollinearFast)
	 *         --------------------------------------------------------------------------------- 
	 *         1000 			= (0.317)/(0.035) = 9.057
	 *         2000 			= (2.385)/(0.144) = 16.563
	 *         4000 			= (14.788)/(0.618) = 23.929
	 *         5000 			= (28.735)/(1.044) = 27.524
	 *
	 *
	 *         Approximate Mathematical Performance:
	 *         -------------------------------------
	 *
	 *         Using an appropriate cost model, give the performance of your
	 *         algorithm. Explain your answer.
	 *
	 *         Performance: N^2 logN
	 *
	 *         Explanation: Counting only some operations, in this case array accesses, the running time is 
	 *         		approximately N^2. Binary search then takes approximately logN time
	 *
	 *
	 */
	static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
		sort(a3);
		int y1 = 1, y2 = 2, y3 = 3, count = 0;
		int p= y2-y3; 
		int q= y3-y1; 
		
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a2.length; j++) {
				int calculatedValue = a1[i] * p + a2[j] * q;
				if (binarySearch(a3, calculatedValue)) {
					count++;
				}
			}
		}
		return count;
	}

	// ----------------------------------------------------------
	/**
	 * Sorts an array of integers according to InsertionSort. This method is
	 * static, thus it can be called as Collinear.sort(a)
	 * 
	 * @param a:
	 *            An UNSORTED array of integers.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Approximate Mathematical Performance:
	 *         ------------------------------------- 
	 *         Using an appropriate cost model, give the performance of your algorithm. 
	 *         Explain your answer.
	 *
	 *         Performance: 
	 *         			with input size of n:
	 *         				Best Case T(n) ~ 3n
	 *         				Worst Case T(n) ~ (5/2)n^2
	 *         				Average Case T(n) ~ (3/4)n^2
	 *
	 *         Explanation: 
	 *         	In the best case (an already sorted array), the order of growth is linear (n). 
	 *         	In the worst case (an array in reverse order), the order of growth is quadratic (n^2)
	 *         	In the average case, the order of growth is closer to that of the worst case, n^2.  
	 *
	 */
	static void sort(int[] a) {
		int insertIndex, insertValue;

		for (int i = 1; i < a.length; i++) {
			insertValue = a[i];
			insertIndex = i;

			while ((insertIndex > 0) && (a[insertIndex - 1] > insertValue)) {
				a[insertIndex] = a[insertIndex - 1];
				insertIndex--;
			}
			a[insertIndex] = insertValue;
		}
	}

	// ----------------------------------------------------------
	/**
	 * Searches for an integer inside an array of integers. This method is
	 * static, thus it can be called as Collinear.binarySearch(a,x)
	 * 
	 * @param a:
	 *            A array of integers SORTED in ascending order.
	 * @param x:
	 *            An integer.
	 * @return true if 'x' is contained in 'a'; false otherwise.
	 *
	 *         ----------------------------------------------------------
	 *
	 *         Approximate Mathematical Performance:
	 *         ------------------------------------- 
	 *         Using an appropriate cost model, give the performance of your algorithm. 
	 *         Explain your answer.
	 *
	 *         Performance: ~logN
	 *
	 *         Explanation: By counting only some operations, such as the number of compares, we can see that binary search 
	 *         		uses at most 1 + logN compares to search a sorted array of size N.
	 *         		Using tilde notation, this approximates to an order of growth of logN. 
	 *         		Programs with logarithmic running time are only slightly slower than those with constant running time. 
	 *         		Every time the program goes around the innermost loop, the problem is halved.
	 *
	 */
	
	static boolean binarySearch(int[] a, int x) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (x < a[mid])
				hi = mid - 1;
			else if (x > a[mid])
				lo = mid + 1;
			else
				return true;
		}
		return false;
	}
}