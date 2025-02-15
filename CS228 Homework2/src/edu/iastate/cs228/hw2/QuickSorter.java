package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;
import java.util.Random;


/**
 *  
 * @author
 *
 */

/**
 * 
 * This class implements the version of the quicksort algorithm presented in the lecture.   
 *
 */

public class QuickSorter extends AbstractSorter
{
	
	// Other private instance variables if you need ... 
		
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *   
	 * @param pts   input array of integers
	 */
	public QuickSorter(Point[] pts)
	{
	super(pts);
	super.algorithm = "Quick Sorter";
	}
		

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.  
	 * 
	 */
	@Override 
	public void sort()
	{
	
		quickSortRec(0, points.length-1);
	
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last)
	{
	       if (first < last) 
	        { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int partitionPoint = partition(first, last); 

	            quickSortRec(first, partitionPoint-1); 
	            quickSortRec(partitionPoint+1, last); 
	        }
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last)
	{
		Point pivot = points[last];  
        int i = (first-1); // index of smaller element 
        for (int j=first; j<last; j++) 
        { 
            if (pointComparator.compare(points[j], pivot)== 1) 
            { 
                i++; 
                swap(i,j);
            } 
        } 
        swap(i+1, last);
        return i+1; 
	}	
		


	
	// Other private methods in case you need ...
}
