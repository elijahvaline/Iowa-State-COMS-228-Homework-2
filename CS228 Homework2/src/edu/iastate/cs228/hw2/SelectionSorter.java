package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import java.util.Comparator;
import java.util.InputMismatchException;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements selection sort.
 *
 */

public class SelectionSorter extends AbstractSorter {
	// Other private instance variables if you need ...

	/**
	 * Constructor takes an array of points. It invokes the superclass constructor,
	 * and also set the instance variables algorithm in the superclass.
	 * 
	 * @param pts
	 */
	public SelectionSorter(Point[] pts) {
		super(pts);
		super.algorithm = "Selection Sort";

	}

	/**
	 * Apply selection sort on the array points[] of the parent class
	 * AbstractSorter.
	 * 
	 */
	@Override
	public void sort() {
		// Find the minimum element in unsorted array
		int n = points.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			int compare;
			for (int j = i + 1; j < n; j++) {

				compare = pointComparator.compare(points[min_idx], points[j]);
				if (compare == 1) {
					min_idx = j;
				}
			}
			Point temp = points[min_idx];
			points[min_idx] = points[i];
			points[i] = temp;

		}

	}
}
