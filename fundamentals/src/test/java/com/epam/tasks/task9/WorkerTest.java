package com.epam.tasks.task9;

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
    private Integer[] nums1, nums2, expected;
    private int k;
    private static final double epsilon = 0.0001;

    public WorkerTest(Integer[] nums1, Integer[] nums2, Integer[] par) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.k = par[0];
        this.expected = Arrays.copyOfRange(par, 1, par.length);
    }

    @Parameterized.Parameters(name = "{index}:")
    public static Collection<Object[][]> data() {
        return Arrays.asList(new Integer[][][] {
                {{5, 6, 7, 8}, {5, 6, 7, 8}, {2, 5, 6, 5, 6, 7, 8, 7, 8}},
                {{94, 77, 17, 57, 64, 105, 126, 10}, {5, 6, 7, 8}, {3, 94, 77, 17, 5, 6, 7, 8, 57, 64, 105, 126, 10}},
                {{27, 42, 8796, 7788, 96, 15, 73}, {87, 6, 7, 13, 967, 67, 337, 9, 7, 11}, {107, 0}},
                {{94, 77, 17, 57, 64, 105, 126, 10}, {5, 6, 7, 8}, {0, 5, 6, 7, 8, 94, 77, 17, 57, 64, 105, 126, 10}},
        });
    }

    @Test
    public void combine() throws Exception {
        assertArrayEquals(expected, Worker.combine(nums1, nums2, k));
    }

}