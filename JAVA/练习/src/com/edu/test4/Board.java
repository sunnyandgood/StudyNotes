package com.edu.test4;

import org.junit.Test;

public class Board {
	Shape[] shape = {new Circle(),new Circle(),new Circle(),
					 new Rect(),new Rect(),new Rect()};
//	shape[0] = new Circle();
	
	@Test
	public void refresh() {
		for(int i=0;i<6;i++) {
			shape[i].draw();
		}
	}
}
