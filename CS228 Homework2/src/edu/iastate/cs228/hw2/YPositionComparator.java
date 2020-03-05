package edu.iastate.cs228.hw2;

import java.util.Comparator;

public class YPositionComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		if (o1.getY() > o2.getY()) {
			return -1;
		} else if (o1.getY() < o2.getY()) {
			return 1;
		} else {
			return 0;
		}

	}

}
