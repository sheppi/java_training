package com.epam.tasks.task3;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class SpecialCalculator {
    public static double calculatePerimeter(double a, double b) {
        double result;

        double c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));

        result = a + b + c;

        return result;
    }

    public static double calculateSquare(double a, double b) {
        double result;

        result = (a * b) / 2;

        return result;
    }
}
