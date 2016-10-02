package ru.bochkarev.shape;

import ru.bochkarev.tools.Moveable;

public class Point implements Moveable
{
	private String name = "Точка";
	protected double x, y, z;
	private int id;
	private static int nextId = 1;

	{
		id = nextId++;
	}

	public Point(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point (Point p)
	{
		x = p.x;
		y = p.y;
		z = p.z;
	}

	public void move (Point p)
	{
		x = p.x;
		y = p.y;
		z = p.z;
	}

	public void symmetry ()
	{
		x *= -1;
		y *= -1;
		z *= -1;
	}

	public int getId() { return id; }

	public void setName (String n) { name = n; }
	public String getName() { return name; }

	public double distance ()
	{
		return Math.sqrt(x*x + y*y + z*z);
	}

	public String toString()
	{
		return "id = " + id + ", " + name + "(" + x + ";" + y + ";" + z + ")";
	}
}