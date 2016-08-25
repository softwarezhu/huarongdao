package com.piggy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * Created by coco on 16/8/12.
 */
public class Game {
    protected int maps[];
    protected int rows;
    protected int cols;

    protected Snapshot root;
    ArrayList<Snapshot> list;

    HashSet<String> collections = new HashSet<>();

    protected Point endPosition1;
    protected Point endPosition2;

    public Game(int maps[], int rows, int cols, Point endPosition1, Point endPosition2) {
        this.maps = maps;
        this.rows = rows;
        this.cols = cols;

        this.endPosition1 = endPosition1;
        this.endPosition2 = endPosition2;

    }

    public Snapshot find()
    {
        Snapshot node;
        String key;
        ArrayList<Snapshot> nexts;

        root = new Snapshot(maps, rows, cols);
        list = new ArrayList<Snapshot>();
        list.add(root);
        key = root.getHashKey();
        collections.add(key);

        while (!list.isEmpty()) {
            node = list.remove(0);

            nexts = node.nexts();

            for (Snapshot next : nexts) {
                key = next.getHashKey();
                if (collections.contains(key)) {
                    continue;
                }
                collections.add(key);

                node.add(next);
                list.add(next);

                if (next.isEnd(endPosition1, endPosition2)) {
                    return next;
                }
            }

        }


        return null;
    }
}
