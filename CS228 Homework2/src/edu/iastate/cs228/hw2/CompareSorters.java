package edu.iastate.cs228.hw2;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class CompareSorters {


	/**
	 * Repeatedly take integer sequences either randomly generated or read from
	 * files. Use them as coordinates to construct points. Scan these points with
	 * respect to their median coordinate point four times, each time using a
	 * different sorting algorithm.
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException {

		// TODO
		//
		// Conducts multiple rounds of comparison of four sorting algorithms. Within
		// each round,
		// set up scanning as follows:
		//
		// a) If asked to scan random points, calls generateRandomPoints() to initialize
		// an array
		// of random points.
		//
		// b) Reassigns to the array scanners[] (declared below) the references to four
		// new
		// RotationalPointScanner objects, which are created using four different values
		// of the Algorithm type: SelectionSort, InsertionSort, MergeSort and QuickSort.
		//
		//
		int key = 0;
		int points;
		int trial = 1;
		boolean running = true;
		String fileName = "";

		RotationalPointScanner[] scanners = new RotationalPointScanner[4];
		Scanner sc = new Scanner(System.in);
		System.out.println("Performances of Four Sorting Algorithms in Point Scanning");
		System.out.println("keys: 1 (random integers) 2 (file input) 3 (exit)");

		while (running == true) {
			
			System.out.print("Trial " + trial + ":");
			key = sc.nextInt();
			
			switch (key) {
			case 1:
				
				System.out.print("Enter number of random points:");
				points = sc.nextInt();
				Point[] ps = new Point[points];
				ps = generateRandomPoints(points, new Random());
				System.out.println("Algorithm size time (ns)");
				System.out.println("----------------------------------");

				scanners[0] = new RotationalPointScanner(ps, Algorithm.SelectionSort);
				scanners[0].scan();
				System.out.println(scanners[0].stats());

				scanners[1] = new RotationalPointScanner(ps, Algorithm.InsertionSort);
				scanners[1].scan();
				System.out.println(scanners[1].stats());

				scanners[2] = new RotationalPointScanner(ps, Algorithm.QuickSort);
				scanners[2].scan();
				System.out.println(scanners[2].stats());

				scanners[3] = new RotationalPointScanner(ps, Algorithm.MergeSort);
				scanners[3].scan();
				System.out.println(scanners[3].stats());

				break;
			case 2:
				System.out.println("Points from a file");
				System.out.print("File name:");
				fileName = sc.next();
				System.out.println("Algorithm size time (ns)");
				System.out.println("----------------------------------");

				scanners[0] = new RotationalPointScanner(fileName, Algorithm.SelectionSort);
				scanners[0].scan();
				System.out.println(scanners[0].stats());

				scanners[1] = new RotationalPointScanner(fileName, Algorithm.InsertionSort);
				scanners[1].scan();
				System.out.println(scanners[1].stats());

				scanners[2] = new RotationalPointScanner(fileName, Algorithm.QuickSort);
				scanners[2].scan();
				System.out.println(scanners[2].stats());

				scanners[3] = new RotationalPointScanner(fileName, Algorithm.MergeSort);
				scanners[3].scan();
				System.out.println(scanners[3].stats());
				
				break;
			case 3:
				running = false;
				break;

			}
			
			trial++;
			System.out.println("----------------------------------");
			
		}

		// For each input of points, do the following.
		//
		// a) Initialize the array scanners[].
		//
		// b) Iterate through the array scanners[], and have every scanner call the
		// scan() and draw()
		// methods in the RotationalPointScanner class. You can visualize the result of
		// each scan.
		// (Windows have to be closed manually before rerun.)
		//
		// c) After all four scans are done for the input, print out the statistics
		// table (cf. Section 2).
		//
		// A sample scenario is given in Section 2 of the project description.

	}

	/**
	 * This method generates a given number of random points. The coordinates of
	 * these points are pseudo-random numbers within the range [-50,50] � [-50,50].
	 * Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing.
	 * 
	 * @param numPts number of points
	 * @param rand   Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException {
		int i;
		int x;
		int y;
		int highest = 0;

		Point[] returner = new Point[numPts];

		for (i = 0; i < numPts; i++) {

			x = rand.nextInt(101) - 50;
			y = rand.nextInt(101) - 50;
			returner[i] = new Point(x, y);

		}
		return returner;
	}

}
