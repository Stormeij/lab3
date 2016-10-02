package ru.bochkarev.lab3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

import ru.bochkarev.shape.*;
import ru.bochkarev.tools.SortMode;

public class Lab3
{
	static List<Point> list = new ArrayList<>();
	static InputStreamReader in;
	static BufferedReader reader;
	static String buffer;

	public static void main (String [] args) throws IOException
	{
		list.add(new Point(1.0, 3.0, 9.0));
		list.add(new Vector(1.0, 9.0, 0.0, 2.0, 6.0, 7.0));
		list.add(new Triangle(1.0, -3.0, -1.0, 3.0, 2.0, 1.0, 3.0, 0.0, 8.0));
		list.add(new Vector(4.0, 3.0, 9.0, 5.0, 5.0, 7.0));
		list.add(new Point(1.0, 3.0, 9.0));
		list.add(new Point(1.0, 3.0, 9.0));

		in = new InputStreamReader(System.in);
		reader = new BufferedReader(in);

		while (true)
		{
			System.out.println("Опции:");
			System.out.println(" 1 - Добавить объект");
			System.out.println(" 2 - Сортировка объектов");
			System.out.println(" 3 - Показать список");
			System.out.println(" 4 - Удалить объект");
			System.out.println(" 5 - Симметрия");
			System.out.println(" 6 - Перемещение");
			System.out.println(" 0 - Завершить");
			System.out.print("Ввод > ");
			buffer = reader.readLine();
			if (buffer.equals("0")) break;
			else if (buffer.equals("1")) NewObject();
			else if (buffer.equals("2")) Sort();
			else if (buffer.equals("3")) PrintList();
			else if (buffer.equals("4")) RemoveObject();
			else if (buffer.equals("5"))
			{
				for (Point p : list)
					p.symmetry();
				PrintList();
			}
			else if (buffer.equals("6"))
			{
				System.out.println("Переместить в точку:");
				System.out.print("x = ");
				buffer = reader.readLine();
				int x = Integer.parseInt(buffer);
				System.out.print("y = ");
				buffer = reader.readLine();
				int y = Integer.parseInt(buffer);
				System.out.print("z = ");
				buffer = reader.readLine();
				int z = Integer.parseInt(buffer);
				Point p = new Point(x, y, z);
				for (Point point : list)
					point.move(p);
				PrintList();
			}
		}
	}

	static void NewObject() throws IOException
	{
		int n;
		double [] coords;
		System.out.println("\t0 - Назад");
		System.out.println("\t1 - Точка");
		System.out.println("\t2 - Вектор");
		System.out.println("\t3 - Треугольник");
		System.out.println("\t4 - Четырехугольник");

		System.out.print("Ввод > ");
		buffer = reader.readLine();
		if (buffer.equals("0")) return;
		else
		{
			int index = 0;
			n = Integer.parseInt(buffer);
			coords = new double [n * 3];
			String str;
			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (j == 0 || j == 3 || j == 6 || j == 9) System.out.print("x" + i + " = ");
					if (j == 1 || j == 4 || j == 7 || j == 10) System.out.print("y" + i + " = ");
					if (j == 2 || j == 5 || j == 8 || j == 11) System.out.print("z" + i + " = ");
					str = reader.readLine();
					coords[index++] = Double.parseDouble(str);
				}
			}
		}

		System.out.println("Место вставки");
		System.out.println(" 1 - В начало списка");
		System.out.println(" 2 - В середину списка");
		System.out.println(" 3 - В конец списка");
		System.out.print("Ввод > ");
		buffer = reader.readLine();
		if (buffer.equals("1"))
		{
			List<Point> tempList = new ArrayList<>();
			if (n == 1) tempList.add(new Point(coords[0], coords[1], coords[2]));
			if (n == 2) tempList.add(new Vector(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]));
			if (n == 3) tempList.add(new Triangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8]));
			if (n == 4) tempList.add(new Quadrangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8], coords[9], coords[10], coords[11]));
			for (Point p : list)
			{
				tempList.add(p);
			}
			list = tempList;
			tempList = null;
		}
		else if (buffer.equals("2"))
		{
			List<Point> tempList = new ArrayList<>();
			System.out.print("Позиция: ");
			buffer = reader.readLine();
			int pos = Integer.parseInt(buffer);
			if (pos < list.size())
			{
				for (int i = 0; i < pos-1; i++)
				{
					tempList.add(list.get(i));
				}
				if (n == 1) tempList.add(new Point(coords[0], coords[1], coords[2]));
				if (n == 2) tempList.add(new Vector(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]));
				if (n == 3) tempList.add(new Triangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8]));
				if (n == 4) tempList.add(new Quadrangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8], coords[9], coords[10], coords[11]));
				for (int i = pos-1; i < list.size(); i++)
				{
					tempList.add(list.get(i));
				}
				list = tempList;
				tempList = null;
			}
			else
			{
				if (n == 1) list.add(new Point(coords[0], coords[1], coords[2]));
				if (n == 2) list.add(new Vector(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]));
				if (n == 3) list.add(new Triangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8]));
				if (n == 4) list.add(new Quadrangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8], coords[9], coords[10], coords[11]));
			}
		}
		else
		{
			if (n == 1) list.add(new Point(coords[0], coords[1], coords[2]));
			if (n == 2) list.add(new Vector(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]));
			if (n == 3) list.add(new Triangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8]));
			if (n == 4) list.add(new Quadrangle(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5], coords[6], coords[7], coords[8], coords[9], coords[10], coords[11]));
		}
	}

	static void PrintList ()
	{
		System.out.println("Вывод списка объектов:");
		for (Point p : list)
		{
			System.out.println(" " + p);
		}
	}

	static void RemoveObject() throws IOException
	{
		System.out.println("Удаление по идентификатору");
		System.out.println(" 0 - Отмена");
		System.out.print("Ввод > ");
		buffer = reader.readLine();
		int id = Integer.parseInt(buffer);
		int indexRemove = -1;
		boolean currentId = false;
		for (Point p : list)
		{
			if (p.getId() == id)
			{
				indexRemove = list.indexOf(p);
			}
		}

		if (indexRemove == -1)
		{
			System.out.println("Объекта с таким идентификатором нет");
			return;
		}
		list.remove(indexRemove);

	}

	static void Sort() throws IOException
	{
		int mode = 1;
		System.out.println("Сортировка");
		System.out.println("\t0 - Назад");
		System.out.println("\t1 - По возрастанию id");
		System.out.println("\t2 - По убыванию id");
		System.out.println("\t3 - По имени (возрастание)");
		System.out.println("\t4 - По имени (убывание)");
		System.out.println("\t5 - По удаленности от начала координат (возрастание)");
		System.out.println("\t6 - По удаленности от начала координат (убывание)");

		System.out.print("Ввод > ");
		buffer = reader.readLine();
		if (buffer.equals("0")) return;
		// else if (buffer.equals("1") || buffer.equals("2")) mode = 1;
		else if (buffer.equals("3") || buffer.equals("4")) mode = 2;
		else if (buffer.equals("5") || buffer.equals("6")) mode = 3;
		boolean sortUp = (buffer.equals("2") || buffer.equals("4") || buffer.equals("6"));

		Collections.sort(list, new SortMode(mode, sortUp));
		PrintList();
	}
}