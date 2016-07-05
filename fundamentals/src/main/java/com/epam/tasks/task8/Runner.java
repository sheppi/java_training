package com.epam.tasks.task8;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            int k = Integer.parseInt(args[0]);
            Integer[] array = {94, 77, 17, 57, 64, 105, 126, 10};
            System.out.println(Worker.calculate(array, k));
        } catch (NumberFormatException e){

        } catch (ArrayIndexOutOfBoundsException e) {

        }


    }
}
