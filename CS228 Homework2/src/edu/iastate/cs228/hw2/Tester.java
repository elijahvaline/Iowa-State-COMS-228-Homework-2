package edu.iastate.cs228.hw2;

import java.util.Comparator;
import java.util.Random;

public class Tester {

	public static void main(String[] args) {

			Point[] x = new Point[500];
			Random r = new Random();
			x = CompareSorters.generateRandomPoints(x.length, r);
			System.out.println("\n");
			RotationalPointScanner rot = new RotationalPointScanner(x, Algorithm.InsertionSort);
			rot.scan();

	}

}
