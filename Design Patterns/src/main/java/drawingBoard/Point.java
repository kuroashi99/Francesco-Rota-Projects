package board;

import java.awt.Color;

public class Point {

	int x;
	int y;
	Color c;
	int dimension;
	
	public Point(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
		dimension = 10;
	}
}
