package com.epam.tasks.task6;

import com.epam.tasks.task6.Worker;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            System.out.println("Result = " + Worker.calculate(a,b,c));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Write 3 numbers, please");
        } catch (NumberFormatException e){
            System.out.println("Please, enter 3 numbers");
        }
    }
}
