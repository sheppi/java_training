package com.epam.tasks.task9;

/**
 * Created by Kirill_Kaluga on 7/7/2016.
 */
public class Worker {
    public static Integer[] combine(Integer[] array1, Integer[] array2, Integer k) {
        Integer[] result = new Integer[1];
        result[0] = 0;
        if(k>=0 && k <= array1.length){
            result = new Integer[array1.length + array2.length];
            System.arraycopy(array1, 0, result, 0, k);
            System.arraycopy(array2, 0, result, k, array2.length);
            System.arraycopy(array1, k, result, k + array2.length, array1.length - k);
        }
        return result;
    }
}
