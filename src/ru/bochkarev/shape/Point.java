package ru.bochkarev.shape;

import java.util.*;
import ru.bochkarev.tools.Moveable;

public class Point implements Moveable
{
	private String name = "Точка";
	protected double x, y, z;
	private int id;
	private static int nextId = 1;
	private Calendar calendar;

	{
		id = nextId++;
	}

	public Point(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		calendar = Calendar.getInstance();
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

	public final String getDate(){
		return calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR) + " " +calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
	}

	public long compareDate(){
		return calendar.getTime().getTime();
	}

	public String toString()
	{
		return "id = " + id + ", " + name + "(" + x + ";" + y + ";" + z + "), " + getDate();
	}
}