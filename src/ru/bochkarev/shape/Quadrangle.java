package ru.bochkarev.shape;

public class Quadrangle extends Point
{
	private double x1, y1, z1;
	private double x2, y2, z2;
	private double x3, y3, z3;
	private double area;

	public Quadrangle (Point p, Point p1, Point p2, Point p3)
	{
		super(p);
		x1 = p1.x;
		y1 = p1.y;
		z1 = p1.z;

		x2 = p2.x;
		y2 = p2.y;
		z2 = p2.z;

		x3 = p3.x;
		y3 = p3.y;
		z3 = p3.z;

		this.setName("Четырехугольник");
	}

	public Quadrangle (double ... args)
	{
		super (args[0], args[1], args[2]);
		x1 = args[3];
		y1 = args[4];
		z1 = args[5];
		x2 = args[6];
		y2 = args[7];
		z2 = args[8];
		x3 = args[9];
		y3 = args[10];
		z3 = args[11];
		setName("Четырехугольник");
	}

	public double distance ()
	{
		double d1 = Math.sqrt(x*x + y*y + z*z);
		double d2 = Math.sqrt(x1*x1 + y1*y1 + z1*z1);
		double d3 = Math.sqrt(x2*x2 + y2*y2 + z2*z2);
		double d4 = Math.sqrt(x3*x3 + y3*y3 + z3*z3);
		double min;
		if (d1 < d2) min = d1;
		else min = d2;

		if (min > d3) min = d3;
		
		if (min > d4) return d4;
		else return min;
	}

	public void symmetry ()
	{
		x *= -1; x1 *= -1; x2 *= -1; x3 *= -1;
		y *= -1; y1 *= -1; y2 *= -1; y3 *= -1;
		z *= -1; z1 *= -1; z2 *= -1; z3 *= -1;
	}
	public String toString()
	{
		return "id = " + getId() + ", " + getName() + "((" + x + "," + y + "," + z + 
		"),(" + x1 + "," + y1 + "," + z1 + "),(" + x2 + "," + y2 + "," + z2 + "),(" + x3 + "," + y3 + "," + z3 +"))";
	}
}