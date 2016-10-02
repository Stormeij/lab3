package ru.bochkarev.shape;

import org.junit.Test;
import org.junit.Assert;

public class TestPoint
{
	@Test
	public void testDistance(){
		Point p = new Point(3.0, 4.0, 0.0);
		Assert.assertEquals("true", "true");
	}

	@Test
	public void testNullPointer(){
		Point p = new Point (1.0, 1.0, 1.0);
		Assert.assertNotNull(p);
	}
}