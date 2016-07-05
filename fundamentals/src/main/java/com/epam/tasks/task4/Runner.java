package com.epam.tasks.task4;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            System.out.println(Checker.checker(a, b));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Write 2 coordinates, please");
        } catch (NumberFormatException e){
            System.out.println("Please, enter the correct coordinates as numbers");
        }
    }
}
