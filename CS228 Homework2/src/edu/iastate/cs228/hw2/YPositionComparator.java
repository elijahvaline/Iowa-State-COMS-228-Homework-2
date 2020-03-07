package edu.iastate.cs228.hw2;

import java.util.Comparator;

public class YPositionComparator implements Comparator<Point> {

	//returns 1 if p1 is smaller; returns -1 if p1 is bigger polar angle than p2
	//return 0 if:
	//o1.equals(02);
	//-1 if:
	// a) o1.x > o2.x
	// b) 01.x == o2.x and o1.y > o2.y 
	// 	else: return 1   
	@Override
	public int compare(Point o1, Point o2) {
		if (o1.equals(o2)) {
			return 0;
		}
		else if (o1.getY() > o2.getY()) {
			return -1;
		}
		else if (o1.getY() == o2.getY() && (o1.getX() > o2.getX())) {
			return -1;
		}
		return 1;
	}

}
