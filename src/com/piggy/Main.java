package com.piggy;

import java.util.*;
/**
 * Created by coco on 16/8/12.
 */
public class Main {
    public static void main(String args[])
    {

        int maps[] = {
                4, 6, 7, 4,
                5, 8, 9, 5,
                4, 2, 3, 4,
                5, 1, 1, 5,
                1, 0, 0, 1
        };

        Game game = new Game(maps, 5, 4, new Point(1, 4), new Point(2, 4));
        Snapshot snapshot = game.find();
        Stack<Snapshot> stack = new Stack<Snapshot>();
        while (snapshot != null) {
            stack.add(snapshot);
            snapshot = snapshot.parent;
        }

        int steps = 0;
        while (!stack.empty()) {
            Snapshot temp = stack.pop();
            System.out.println("----------------");
            temp.print();

            steps++;
        }

        System.out.println("total step: "+steps);
    }
}
