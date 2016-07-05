package com.epam.tasks.task9;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */
public class Runner {
    public static void main(String[] args) {
        Integer[] mas1 = {27, 42, 8796, 7788, 96, 15, 73};
        Integer[] mas2 = {87, 6, 7, 13, 967, 67, 337, 9, 7, 11};
        Integer[] result = Worker.combine(mas1, mas2, 2);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
