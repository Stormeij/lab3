package ru.bochkarev.shape;

import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class TestQuadrangle
{
	@Test
	public void testNullPointer(){
		Quadrangle q = new Quadrangle(1 ,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		Assert.assertNotNull(q);
	}

	@Test
	public void testDistance(){
		Triangle t = new Triangle(3, 4, 0, 4, 5, 6, 7, 8, 9);
		Assert.assertTrue(t.distance() == 5.0);
	}

	@Test
	public void testCompareDateCreation(){

		Date date = new Date();

		Quadrangle q1 = new Quadrangle(1 ,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		Quadrangle q2 = new Quadrangle(1 ,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

		long t1 = q1.compareDate();
		long t2 = q2.compareDate();

		if(t1 < new Date().getTime()){
			Assert.fail("fail method compareDate()");
		}
		if(date.getTime() < t2){
			Assert.fail("fail method compareDate()");
		}
	}
}