package ru.bochkarev.tools;

import java.util.Comparator;
import ru.bochkarev.shape.*;

public class SortMode implements Comparator<Point>
{
	private int sortMode;
	private boolean upDown;
	public SortMode (int mode, boolean isUp)
	{
		sortMode = mode;
		upDown = isUp;
	}

	public int compare(Point p1, Point p2)
	{
		int res = 0;
		if (sortMode == 1)
		{
			if (p1.getId() > p2.getId()) res = 1;
			else res = -1;
		}
		else if (sortMode == 2)
		{
			res = p2.getName().compareTo(p1.getName());
		}
		else
		{
			if (p1.distance() > p2.distance()) res = 1;
			else res = -1;
		}

		if (upDown) res *= -1;
		return res;
	}
}