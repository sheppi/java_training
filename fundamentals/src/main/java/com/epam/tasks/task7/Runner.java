package com.epam.tasks.task7;

/**
 * Created by Kirill_Kaluga on 7/1/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            StringBuilder answer = new StringBuilder("|\t\tx\t\t|\t\ty\t\t|\n");
            Double[] result = Worker.calculate(a,b,c);
            for (int i=0; i < result.length; i++){
                answer.append("|\t\t" + (a + i*((b-a)/c) + "\t\t|\t\t" + result[i] + "\t\t|\n"));
            }
            System.out.println(answer.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Write 3 numbers, please");
        } catch (NumberFormatException e){
            System.out.println("Please, enter 3 numbers");
        }
    }

}
