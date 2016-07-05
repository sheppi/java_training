package com.epam.tasks.task8;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */
public class Worker {
    public static int calculate(Integer[] array, int k) {
        int result = 0;

        for (int i : array) {
            if (i%k == 0) {
                result += i;
            }
        }
        return result;
    }
}
