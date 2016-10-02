package ru.bochkarev.shape;

import org.junit.Test;
import org.junit.Assert;

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
}