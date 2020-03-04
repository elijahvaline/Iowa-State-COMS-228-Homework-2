package edu.iastate.cs228.hw2;

import java.util.Comparator;

public class PositionComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		if (o1.getX() > o2.getX()) {
			return 1;
		} else if (o1.getX() < o2.getX()) {
			return -1;
		} else {
			return 0;
		}
	}

}
