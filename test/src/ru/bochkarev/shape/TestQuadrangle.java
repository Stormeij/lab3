package ru.bochkarev.shape;

import org.junit.Test;
import org.junit.Assert;

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
}