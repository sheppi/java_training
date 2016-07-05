package com.epam.tasks.task5;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
public class Worker {
    public static Double[] calculate(Double[] nums) {
        for (int i=0; i < nums.length; i++){
            if (nums[i] >= 0) {
                nums[i] = Math.pow(nums[i], 2);
            } else {
                nums[i] = Math.pow(nums[i], 4);
            }
        }
        return nums;
    }
}
