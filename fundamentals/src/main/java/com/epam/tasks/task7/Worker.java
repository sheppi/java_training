package com.epam.tasks.task7;

import java.util.ArrayList;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class Worker {
    public static Double[] calculate(double a, double b, double c){
        Double[] result = new Double[((int) ((b-a)/c))+1];
        int j = 0;
        for (double i = a; i <= b; i+=c){
            result[j] = Math.pow(Math.sin(i),2) - Math.cos(i * 2);
            j++;
        }
        return result;
    }
}
