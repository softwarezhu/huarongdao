package com.piggy;

import java.util.Arrays;

/**
 * Created by coco on 16/8/13.
 */
public class Maps {
    protected int[] maps;
    public int cols;
    public int rows;

    public Maps(int[] maps, int rows, int cols) {
        this.maps = maps;
        this.rows = rows;
        this.cols = cols;
    }

    public Maps(Maps other) {
        this.maps = other.maps.clone();
        this.rows = other.rows;
        this.cols = other.cols;
    }

    public int get(Point position)
    {
        return get(position.x, position.y);
    }

    public int get(int x, int y)
    {
        return maps[y*cols+x];
    }

    public void set(Point position, int val)
    {
        set(position.x, position.y, val);
    }

    public void set(int x, int y, int val) {
        maps[y*cols+x] = val;
    }

    public void swap(Point src, Point dst)
    {
        int val = get(dst);
        set(dst, get(src));
        set(src, val);
    }

    public boolean equals(Maps other)
    {
        return Arrays.equals(maps, other.maps);
    }

    public Point[] emptyPoints()
    {
        Point[] points = new Point[2];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (get(j, i) == 0) {
                    points[index] = new Point(j, i);
                    index++;
                }
            }
        }

        return points;
    }

    public String hashKeys()
    {
        StringBuffer buffer = new StringBuffer();
        for (int i : maps) {
            buffer.append(i);
        }
        return buffer.toString();
    }

    public void print()
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(get(j, i)+" ");
            }
            System.out.println();
        }
    }
}
