package com.epam.tasks.task5;

import com.epam.tasks.task5.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Kirill_Kaluga on 6/30/2016.
 */
@RunWith(value = Parameterized.class)
public class WorkerTest {
    private Double[] nums, expected;
    private static final double epsilon = 0.00001;

    public WorkerTest(Double[] nums, Double[] expected) {
        this.nums = nums;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:")
    public static Collection data() {
        return Arrays.asList(new Double[][][] {
                {{1., 1., 1.}, {1., 1., 1.}},
                {{0., 10., 8.}, {0., 100., 64.}},
                {{-6., 4., 1.}, {1296., 16., 1.}},
                {{Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}},
        });
    }

    @Test
    public void calculate_testing() {
        assertArrayEquals(expected, Worker.calculate(nums));
    }

}