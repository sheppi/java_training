package com.epam.tasks.task5;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            System.out.println("Result = " + Worker.calculate(new Double[]{a, b, c}));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Write 3 numbers, please");
        } catch (NumberFormatException e){
            System.out.println("Please, enter the correct coordinates as numbers");
        }
    }
}
