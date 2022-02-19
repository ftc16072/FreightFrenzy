package org.firstinspires.ftc.teamcode.ftc16072.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class QQDeque {
    Deque<Double> internalDeque = new ArrayDeque<Double>();
    int maxSize;

    public QQDeque(int maxSize) {
        this.maxSize = maxSize;

    }


    public void add(double num) {
        if (internalDeque.size() >= maxSize) {
            internalDeque.removeFirst();
        }
        internalDeque.addLast(num);
    }

    public double average() {
        double sum = 0;
        for (double i : internalDeque) {
            sum += i;
        }
        return sum / internalDeque.size();
    }

}
