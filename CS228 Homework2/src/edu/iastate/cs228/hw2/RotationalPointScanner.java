package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * 
 * @author 
 *
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class sorts all the points in an array by polar angle with respect to a
 * reference point whose x and y coordinates are respectively the medians of the
 * x and y coordinates of the original points.
 * 
 * It records the employed sorting algorithm as well as the sorting time for
 * comparison.
 *
 */
public class RotationalPointScanner {
	private Point[] points;

	private Point medianCoordinatePoint; // point whose x and y coordinates are respectively the medians of
											// the x coordinates and y coordinates of those points in the array
											// points[].
	private Algorithm sortingAlgorithm;

	protected String outputFileName; // "select.txt", "insert.txt", "merge.txt", or "quick.txt"

	protected long scanTime; // execution time in nanoseconds.
	protected long time;

	private Scanner sc;
	private Scanner scan;

	private int x;
	private int y;

	/**
	 * This constructor accepts an array of points and one of the four sorting
	 * algorithms as input. Copy the points into the array points[]. Set
	 * outputFileName.
	 * 
	 * @param pts input array of points
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public RotationalPointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException {
		points = pts;
		sortingAlgorithm = algo;
		
		switch(sortingAlgorithm) {
		case SelectionSort:
			outputFileName = "select.txt";
			break;
		case InsertionSort:
			outputFileName = "insertion.txt";
			break;
		case QuickSort:
			outputFileName = "quick.txt";
			break;
		case MergeSort:
			outputFileName = "merge.txt";
			break;
		}
		
		
	}

	/**
	 * This constructor reads points from a file. Set outputFileName.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException if the input file contains an odd number of
	 *                                integers
	 */
	protected RotationalPointScanner(String inputFileName, Algorithm algo)
			throws FileNotFoundException, InputMismatchException {
		int x;
		int y;
		int length = 0;
		File f = new File(inputFileName);
		sc = new Scanner(f);
		scan = new Scanner(f);
		while (sc.hasNextInt()) {
			sc.nextInt();
			sc.nextInt();
			length++;
		}

		points = new Point[length];

		for (int i = 0; i < points.length; i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			points[i] = new Point(x, y);
			
		}
		sortingAlgorithm = algo;
		
		switch(sortingAlgorithm) {
		case SelectionSort:
			outputFileName = "select.txt";
			break;
		case InsertionSort:
			outputFileName = "insertion.txt";
			break;
		case QuickSort:
			outputFileName = "quick.txt";
			break;
		case MergeSort:
			outputFileName = "merge.txt";
			break;
		}

	}

	/**
	 * Carry out three rounds of sorting using the algorithm designated by
	 * sortingAlgorithm as follows:
	 * 
	 * a) Sort points[] by the x-coordinate to get the median x-coordinate. b) Sort
	 * points[] again by the y-coordinate to get the median y-coordinate. c)
	 * Construct medianCoordinatePoint using the obtained median x- and
	 * y-coordinates. d) Sort points[] again by the polar angle with respect to
	 * medianCoordinatePoint.
	 * 
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter,
	 * InsertionSorter, MergeSorter, or QuickSorter to carry out sorting. Copy the
	 * sorting result back onto the array points[] by calling the method getPoints()
	 * in AbstractSorter.
	 * 
	 * @param algo
	 * @return
	 */
	public void scan() {
		// TODO
		AbstractSorter aSorter;

		switch (sortingAlgorithm) {
		case QuickSort:
			time = System.nanoTime();
			aSorter = new QuickSorter(points);
			aSorter.setComparator(0);
			x = aSorter.getMedian().getX();
			aSorter.setComparator(1);
			y = aSorter.getMedian().getY();
			medianCoordinatePoint = new Point(x, y);
			aSorter.setComparator(2);
			scanTime = System.nanoTime() - time;
			draw();
			break;
		case MergeSort:
			time = System.nanoTime();
			aSorter = new MergeSorter(points);
			aSorter.setComparator(0);
			x = aSorter.getMedian().getX();
			aSorter.setComparator(1);
			y = aSorter.getMedian().getY();
			medianCoordinatePoint = new Point(x, y);
			aSorter.setComparator(2);
			scanTime = System.nanoTime() - time;
			draw();
			break;
		case SelectionSort:
			time = System.nanoTime();
			aSorter = new SelectionSorter(points);
			aSorter.setComparator(0);
			x = aSorter.getMedian().getX();
			aSorter.setComparator(1);
			y = aSorter.getMedian().getY();
			medianCoordinatePoint = new Point(x, y);
			aSorter.setComparator(2);
			scanTime = System.nanoTime() - time;
			draw();
			break;
		case InsertionSort:
			time = System.nanoTime();
			aSorter = new InsertionSorter(points);
			aSorter.setComparator(0);
			x = aSorter.getMedian().getX();
			aSorter.setComparator(1);
			y = aSorter.getMedian().getY();
			medianCoordinatePoint = new Point(x, y);
			aSorter.setComparator(2);
			scanTime = System.nanoTime() - time;
			draw();
			break;

		}

		// create an object to be referenced by aSorter according to sortingAlgorithm.
		// for each of the three
		// rounds of sorting, have aSorter do the following:
		//
		// a) call setComparator() with an argument 0, 1, or 2. in case it is 2, must
		// have made
		// the call setReferencePoint(medianCoordinatePoint) already.
		//
		// b) call sort().
		//
		// sum up the times spent on the three sorting rounds and set the instance
		// variable scanTime.

	}

	/**
	 * Outputs performance statistics in the format:
	 * 
	 * <sorting algorithm> <size> <time>
	 * 
	 * For instance,
	 * 
	 * selection sort 1000 9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description.
	 */
	public String stats() {
		String algo = "";
		switch (sortingAlgorithm) {
		case InsertionSort:
			algo = "InsertionSort";
			break;
		
		case MergeSort:
			algo = "MergeSort";
			break;
		case QuickSort:
			algo = "QuickSort";
			break;
		case SelectionSort:
			algo = "SelectionSort";
			break;
		}
		return  algo + " " + points.length + " " + scanTime;
		// TODO
	}

	/**
	 * Write points[] after a call to scan(). When printed, the points will appear
	 * in order of polar angle with respect to medianCoordinatePoint with every
	 * point occupying a separate line. The x and y coordinates of the point are
	 * displayed on the same line with exactly one blank space in between.
	 */
	@Override
	public String toString() {
		String returner = "";
		for (int i = 0; i< points.length; i++) {
			returner += points[i].toString() + " ";
		}
		return returner;
		
	}

	/**
	 * 
	 * This method, called after scanning, writes point data into a file by
	 * outputFileName. The format of data in the file is the same as printed out
	 * from toString(). The file can help you verify the full correctness of a
	 * sorting result and debug the underlying algorithm.
	 * 
	 * @throws FileNotFoundException
	 */
	public void writePointsToFile() throws FileNotFoundException {
		File outFile = new File(outputFileName);
		PrintWriter out = new PrintWriter(outFile);
		out.print(this.toString());
		out.close();
	}

	/**
	 * This method is called after each scan for visually check whether the result
	 * is correct. You just need to generate a list of points and a list of
	 * segments, depending on the value of sortByAngle, as detailed in Section 4.1.
	 * Then create a Plot object to call the method myFrame().
	 */
	public void draw() {
		int numSegs = points.length*2;  // number of segments to draw

		// Based on Section 4.1, generate the line segments to draw for display of the
		// sorting result.
		// Assign their number to numSegs, and store them in segments[] in the order.
		Segment[] segments = new Segment[numSegs];
		

		int j = 0;
		for (int i = 0; i < points.length; i++) {

			if (i == points.length - 1) {
				segments[j] = new Segment(points[i], points[0]);
			} else {
				segments[j] = new Segment(points[i], points[i + 1]);
			}
			j++;
		}
		for (int i = 0;  i< points.length; i++) {
			segments[j] = new Segment(medianCoordinatePoint, points[i]);
			j++;
		}

		String sort = null;

		switch (sortingAlgorithm) {
		case SelectionSort:
			sort = "SelectionSort";
			break;
		case InsertionSort:
			sort = "InsertionSort";
			break;
		case MergeSort:
			sort = "Mergesort";
			break;
		case QuickSort:
			sort = "Quicksort";
			break;
		default:
			break;
		}

		// The following statement creates a window to display the sorting result.
		Plot.myFrame(points, segments, sort);
		

	}

}
