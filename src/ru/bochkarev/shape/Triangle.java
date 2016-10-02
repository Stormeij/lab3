package ru.bochkarev.shape;

public class Triangle extends Point
{
	private double x1, y1, z1;
	private double x2, y2, z2;
	private double area;

	public Triangle (Point p, Point p1, Point p2)
	{
		super(p);
		x1 = p1.x;
		y1 = p1.y;
		z1 = p1.z;

		x2 = p2.x;
		y2 = p2.y;
		z2 = p2.z;

		this.setName("Треугольник");
	}

	public Triangle (double ... args)
	{
		super (args[0], args[1], args[2]);
		x1 = args[3];
		y1 = args[4];
		z1 = args[5];
		x2 = args[6];
		y2 = args[7];
		z2 = args[8];
		setName("Треугольник");
	}

	public double distance ()
	{
		double d1 = Math.sqrt(x*x + y*y + z*z);
		double d2 = Math.sqrt(x1*x1 + y1*y1 + z1*z1);
		double d3 = Math.sqrt(x2*x2 + y2*y2 + z2*z2);
		double min;
		if (d1 < d2) min = d1;
		else min = d2;

		if (min > d3) return d3;
		else return min;
	}

	public void symmetry ()
	{
		x *= -1; x1 *= -1; x2 *= -1;
		y *= -1; y1 *= -1; y2 *= -1;
		z *= -1; z1 *= -1; z2 *= -1;
	}

	public String toString()
	{
		return "id = " + getId() + ", " + getName() + "((" + x + "," + y + "," + z + "),(" + x1 + "," + y1 + "," + z1 + "),(" + x2 + "," + y2 + "," + z2 + "))";
	}
}