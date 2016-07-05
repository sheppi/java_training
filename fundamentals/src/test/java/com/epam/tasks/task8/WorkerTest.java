package com.epam.tasks.task8;

import com.epam.tasks.task2.Calculator;
import com.epam.tasks.task7.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */
@RunWith(value = Parameterized.class)
public class WorkerTest {
    private Integer[] nums;
    private int expected, k;
    private static final double epsilon = 0.0001;

    public WorkerTest(Integer[] nums, Integer[] par) {
        this.nums = nums;
        this.k = par[0];
        this.expected = par[1];
    }

    @Parameterized.Parameters(name = "{index}:")
    public static Collection<Object[][]> data() {
        return Arrays.asList(new Integer[][][] {
                {{5, 6, 7, 8}, {2, 14}},
                {{94, 77, 17, 57, 64, 105, 126, 10}, {3, 288}},
                {{94, 77, 17, 57, 64, 105, 126, 10}, {107, 0}}
        });
    }

    @Test
    public void calculate_testing() {
        assertEquals(expected, Worker.calculate(nums, k));
    }


}