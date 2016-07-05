package com.epam.tasks.task10;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */
public class Worker {
    public static Integer[][] createMatrix(int n) {
        Integer[] array1 = new Integer[n];
        Integer[] array2 = new Integer[n];
        Integer[][] array3 = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            array1[i] = i + 1;
            array2[n - i - 1] = i + 1;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1){
                array3[i - 1] = array1;
            } else {
                array3[i - 1] = array2;
            }
        }

        return array3;
    }
}
