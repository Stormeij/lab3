package ru.bochkarev.shape;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class TestTriangle
{
	@Test
	public void testNullPointer(){
		Triangle t = new Triangle(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Assert.assertNotNull(t);
	}

	@Test
	public void testDistance(){
		Triangle t = new Triangle(1, 0, 0, 4, 5, 6, 7, 8, 9);
		Assert.assertTrue(t.distance() == 1.0);
	}

	@Test
	public void testCompareDateCreation(){

		Date date = new Date();

		Triangle tr1 = new Triangle(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Triangle tr2 = new Triangle(1, 0, 0, 4, 5, 6, 7, 5, 9);

		long t1 = tr1.compareDate();
		long t2 = tr2.compareDate();

		if(t1 < new Date().getTime()){
			Assert.fail("fail method compareDate()");
		}
		if(date.getTime() < t2){
			Assert.fail("fail method compareDate()");
		}
	}
}