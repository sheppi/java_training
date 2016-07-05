package com.epam.tasks.task6;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class Worker {
    public static double calculate(double a, double b, double c){
        if (a <= b) {
            if (b <= c) {
                return a + c;
            } else {
                return a + b;
            }
        } else {
            if (a < c) {
                return b + c;
            } else {
                return a + b;
            }
        }
    }
}
