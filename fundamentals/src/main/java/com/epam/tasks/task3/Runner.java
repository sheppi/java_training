package com.epam.tasks.task3;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Runner {
    public static void main(String[] args) {
        if (args.length > 1){
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                System.out.println("Perimeter = " + SpecialCalculator.calculatePerimeter(a, b));
                System.out.println("Square = " + SpecialCalculator.calculateSquare(a, b));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Write length of 2 sides!!!");
            } catch (NumberFormatException e){
                System.out.println("Please, enter the numbers");
            }
        }
    }
}
