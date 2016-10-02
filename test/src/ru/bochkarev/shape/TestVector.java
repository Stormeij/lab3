package ru.bochkarev.shape;

import org.junit.Assert;
import org.junit.Test;

public class TestVector
{
	@Test
	public void testNullPointer()
	{
		Vector v = new Vector(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		Assert.assertNotNull(v);
	}

	@Test
	public void testLength(){
		Vector v = new Vector(1.0, 1.0, 1.0, 3.0, 1.0, 1.0);
		Assert.assertTrue(v.length() == 2.0);
	}

	@Test
	public void testInstanceOf(){
		Vector v = new Vector(1, 1, 1, 2, 2, 2);
		Assert.assertTrue(v instanceof Point);
	}
}