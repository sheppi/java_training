package com.epam.tasks.task2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Calculator {
    public static double execute(String aS, String bS, String cS) {
        double result;
        try {
            double a = Double.parseDouble(aS);
            double b = Double.parseDouble(bS);
            double c = Double.parseDouble(cS);

            result = ((b + sqrt(pow(b, 2) + 4 * a * c)) / (2 * a)) - (pow(a, 3) * c) + (pow(b, -2));
        } catch (NumberFormatException e) {
            System.out.println("Write 3 numbers (double)");
            return 0;
        }
        return result;
    }
}
