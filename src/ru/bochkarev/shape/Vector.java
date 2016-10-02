package ru.bochkarev.shape;

public class Vector extends Point
{
	private double x1, y1, z1;
	private double len;

	public Vector (Point p1, Point p2)
	{
		super(p1);
		x1 = p2.x;
		y1 = p2.y;
		z1 = p2.z;
		this.setName("Вектор");
	}

	public Vector (double ... args)
	{
		super(args[0], args[1], args[2]);
		x1 = args[3];
		y1 = args[4];
		z1 = args[5];
		setName("Вектор");
	}	

	public double distance ()
	{
		double d1 = Math.sqrt(x*x + y*y + z*z);
		double d2 = Math.sqrt(x1*x1 + y1*y1 + z1*z1);
		if (d1 < d2) return d1;
		else return d2;
	}

	public void symmetry ()
	{
		x *= -1; x1 *= -1;
		y *= -1; y1 *= -1;
		z *= -1; z1 *= -1;
	}

	public double length(){
		return Math.sqrt((x1 - x)*(x1 - x) + (y1 - y)*(y1 - y) + (z1 - z)*(z1 - z));
	}

	public String toString()
	{
		return "id = " + super.getId() + ", " + getName() + "{{" + x + ";" + y + ";" + z + "},{" + x1 + ";" + y1 + ";" + z1 + "}}";
	}
}