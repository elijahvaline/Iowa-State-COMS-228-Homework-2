package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;

public class Tester {

	public static void main(String[] args) throws InputMismatchException, FileNotFoundException {

			Point[] x;
			Random r = new Random();
			x = CompareSorters.generateRandomPoints(10, r);
			RotationalPointScanner rot = new RotationalPointScanner(x, Algorithm.MergeSort);
			rot.scan();
			System.out.println(rot.stats());
//			rot.scan();
//			System.out.println(rot.stats());

		

	}

}
