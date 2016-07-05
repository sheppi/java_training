package com.epam.tasks.task1;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(Checker.execute(args[0]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nothing to check");
        }
    }
}
