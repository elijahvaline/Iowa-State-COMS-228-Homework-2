package edu.iastate.cs228.hw2;

import java.util.Comparator;
import java.util.Random;

public class Tester {

	public static void main(String[] args) {
		
		Point[] x = new Point[5];
		Random r = new Random();
		x = CompareSorters.generateRandomPoints(x.length, r);
		System.out.println("\n");
		SelectionSorter s = new SelectionSorter(x);
		s.setComparator(0);

		
		
		for (int i = 0; i < 5; i++) {
			System.out.println(s.points[i].toString());	
		}
		
		
		
		
		

	}

}
