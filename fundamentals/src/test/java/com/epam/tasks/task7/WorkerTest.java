package com.epam.tasks.task7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 7/1/2016.
 */
@RunWith(value = Parameterized.class)
public class WorkerTest {
    private Double[] nums, expected;
    private static final double epsilon = 0.0001;

    public WorkerTest(Double[] nums, Double[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:")
    public static Collection data() {
        return Arrays.asList(new Double[][][] {
                {{1., 1., 1.}, {1.1242202548207136}},
                {{0., 10., 8.}, {-1.0, 1.936489220485077}},
                {{-6., 4., 2.5}, {-0.7657809380987382, -0.630853381514957, 1.1242202548207136, 1.9849887449006682, 0.7182500507129203}},
        });
    }

    @Test
    public void calculate_testing() {
        assertArrayEquals(expected, Worker.calculate(nums[0], nums[1], nums[2]));
    }

}