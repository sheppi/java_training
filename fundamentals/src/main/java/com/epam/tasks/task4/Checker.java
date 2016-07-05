package com.epam.tasks.task4;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Checker {
    public static boolean checker(double x, double y) {
        if ((x <= 2 && y <= 4 && x >= -2 && y >= 0) ||          //top
                (x >= -4 && y >= -3 && x <= 4 && y <= 0)) {     //bottom
            return true;
        } else {
            return false;
        }
    }
}
