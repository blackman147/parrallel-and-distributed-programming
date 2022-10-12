package lab_3;
/**
 * CollectionPoint.java
 *
 * Student Name: Francis Ntoka
 * Student Number: 3092861
 */

import lab_3.Point;

import java.util.*;

class CollectionPoint{
	List<Point> list = new ArrayList<>();

	public synchronized void add(Point p){
		list.add(p);
	}
	
	public synchronized boolean search(Point p){
		for(Point point : list){
			if (point.equals(p)){
				return true;
			}
		}
		return false;
	}
	
	public synchronized List<Point> getAllX(int x){
		List<Point> newPoints = new ArrayList<>();
		for (Point point :list){
			if(point.x() == x){
				newPoints.add(point);
			}
		}
		return newPoints;
	}
	
	public synchronized void replace(Point p1, Point p2){
		int index =	list.indexOf(p1);
		if (index != -1) {
			list.set(index, p2);
		}
	}
	
	public String toString(){
		String string = "";
		for (Point points : list){
			string+=" "+points;
		}
		return string;
	}
}

