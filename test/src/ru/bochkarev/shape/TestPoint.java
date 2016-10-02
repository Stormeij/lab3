package ru.bochkarev.shape;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class TestPoint
{
	@Test
	public void testDistance(){
		Point p = new Point(3.0, 4.0, 0.0);
		Assert.assertTrue(p.distance() == 5.0);
	}

	@Test
	public void testNullPointer(){
		Point p = new Point (1.0, 1.0, 1.0);
		Assert.assertNotNull(p);
	}

	@Test
	public void testCompareDateCreation(){

		Date date = new Date();

		Point p1 = new Point(1.0, 1.0, 1.0);
		Point p2 = new Point(2.0, 2.0, 2.0);

		long t1 = p1.compareDate();
		long t2 = p2.compareDate();

		if(t1 < new Date().getTime()){
			Assert.fail("fail method compareDate()");
		}
		if(date.getTime() < t2){
			Assert.fail("fail method compareDate()");
		}
	}
}